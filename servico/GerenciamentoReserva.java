package reservavoos.servico;

import reservavoos.Cliente;
import reservavoos.Reserva;
import reservavoos.modelo.Voo;
import reservavoos.modelo.VooInternacional;
import reservavoos.modelo.*;

import java.io.*;
import java.util.*;

public class GerenciamentoReserva{
    private ArrayList<Reserva> listareserva = new ArrayList<>();
    private Map<String, Reserva> mapaReservaPorCpf = new HashMap<>();
    private final String arquivoReservasTxt = "servico/reservas.txt";
    private final Scanner scanner = new Scanner(System.in);

    public GerenciamentoReserva() {
        carregarReservasTXT();
    }

    public void salvarReservasTXT() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoReservasTxt))) {
            for (Reserva reserva : listareserva) {
                writer.write(converterReservaParaLinha(reserva));
                writer.newLine();
            }
            System.out.println("Reservas salvas em formato TXT.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar reservas no formato TXT: " + e.getMessage());
        }
    }

    public void carregarReservasTXT() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoReservasTxt))) {
            listareserva.clear();
            String linha;
            while ((linha = reader.readLine()) != null) {
                Reserva reserva = parseLinhaParaReserva(linha);
                if (reserva != null) {
                    listareserva.add(reserva);
                }
            }
            System.out.println("Reservas carregadas do arquivo TXT.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo TXT não encontrado. Criando um novo.");
            listareserva = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Erro ao carregar reservas do arquivo TXT: " + e.getMessage());
        }
    }

    private String converterReservaParaLinha(Reserva reserva) {
        return reserva.getCliente().getNome() + ";" +
                reserva.getCliente().getCpf() + ";" +
                reserva.getCliente().getEmail() + ";" +
                reserva.getVoo().getNumero() + ";" +
                reserva.getVoo().getOrigem() + ";" +
                reserva.getVoo().getDestino() + ";" +
                reserva.getVoo().getData() + ";" +
                reserva.getVoo().getHora() + ";" +
                (reserva.getAssento() instanceof AssentoExecutivo ? "Executivo" : "Economico");
    }

    private Reserva parseLinhaParaReserva(String linha) {
        try {
            String[] partes = linha.split(";");
            Cliente cliente = new Cliente(partes[0], partes[1], partes[2]);
            Voo voo = new VooNacional(partes[3], partes[4], partes[5], partes[6], partes[7]);
            Assento assento = partes[8].equals("Executivo") ? new AssentoExecutivo() : new AssentoEconomico();
            return new Reserva(cliente, voo, assento);
        } catch (Exception e) {
            System.out.println("Erro ao interpretar linha do arquivo TXT: " + linha);
            return null;
        }
    }

    public void cadastrar() {
        System.out.println("Cadastro de Reserva");
        System.out.println("Informe o nome completo:");
        String nome = scanner.nextLine();
        System.out.println("Informe o CPF:");
        String cpf = scanner.nextLine();
        System.out.println("Informe o email:");
        String email = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf, email);

        System.out.println("Selecione o tipo de voo ou viagem de ônibus:");
        System.out.println("1. Voo Internacional");
        System.out.println("2. Voo Nacional");
        System.out.println("3. Ônibus Intermunicipal/Interestadual");
        System.out.println("4. Ônibus Internacional");
        int tipoViagem = scanner.nextInt();
        scanner.nextLine();

        Voo voo = null;
        Onibus onibus = null;
        if (tipoViagem == 1) {
            System.out.println("Informe o número do voo:");
            String numero = scanner.nextLine();
            System.out.println("Informe o país de origem:");
            String origem = scanner.nextLine();
            System.out.println("Informe o país de destino:");
            String destino = scanner.nextLine();
            System.out.println("Informe a data do voo:");
            String data = scanner.nextLine();
            System.out.println("Informe a hora do voo:");
            String hora = scanner.nextLine();
            voo = new VooInternacional(numero, origem, destino, data, hora);
        } else if (tipoViagem == 2) {
            System.out.println("Informe o número do voo:");
            String numero = scanner.nextLine();
            System.out.println("Informe a cidade de origem:");
            String origem = scanner.nextLine();
            System.out.println("Informe a cidade de destino:");
            String destino = scanner.nextLine();
            System.out.println("Informe a data do voo:");
            String data = scanner.nextLine();
            System.out.println("Informe a hora do voo:");
            String hora = scanner.nextLine();
            voo = new VooNacional(numero, origem, destino, data, hora);
        }
        else if (tipoViagem == 3) {
            System.out.println("Informe o número da viagem:");
            String numero = scanner.nextLine();
            System.out.println("Informe o país de origem:");
            String origem = scanner.nextLine();
            System.out.println("Informe o país de destino:");
            String destino = scanner.nextLine();
            System.out.println("Informe a data da viagem:");
            String data = scanner.nextLine();
            System.out.println("Informe a hora da viagem:");
            String hora = scanner.nextLine();
            onibus = new OnibusInternacional(numero, origem, destino, data, hora);
        } else if (tipoViagem == 4) {
            System.out.println("Informe o número do voo:");
            String numero = scanner.nextLine();
            System.out.println("Informe a cidade de origem:");
            String origem = scanner.nextLine();
            System.out.println("Informe a cidade de destino:");
            String destino = scanner.nextLine();
            System.out.println("Informe a data do voo:");
            String data = scanner.nextLine();
            System.out.println("Informe a hora do voo:");
            String hora = scanner.nextLine();
            onibus = new OnibusIntermunicipalEstadual(numero, origem, destino, data, hora);
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        System.out.println("Selecione o tipo de assento:");
        System.out.println("1. Assento Executivo");
        System.out.println("2. Assento Economico");
        int tipoAssento = scanner.nextInt();
        scanner.nextLine();

        Assento assento;
        if (tipoAssento == 1) {
            System.out.println("Informe o número do assento:");
            String numeroAssento = scanner.nextLine();
            assento = new AssentoExecutivo();
        } else if (tipoAssento == 2) {
            System.out.println("Informe o número do assento:");
            String numeroAssento = scanner.nextLine();
            assento = new AssentoEconomico();
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        Reserva reserva = new Reserva(cliente, voo, assento);
        listareserva.add(reserva);
        salvarReservasTXT();
        System.out.println("Reserva cadastrada com sucesso!");
    }

    public void editarPeloNome() {
        try {
            System.out.println("Informe o nome para editar a reserva:");
            String nomeBusca = scanner.nextLine();
            Reserva edicao = null;

            for (Reserva c : listareserva) {
                if (c.getCliente().getNome().equals(nomeBusca)) {
                    edicao = c;
                    break;
                }
            }

            if (edicao == null) {
                System.out.println("Reserva não encontrada.");
                return;
            }
            System.out.println("Informe o novo nome do cliente:");
            String nomeNovo = scanner.nextLine();
            edicao.getCliente().setNome(nomeNovo);
            System.out.println("Reserva editada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao editar a reserva: " + e.getMessage());
        }
    }

    public void listar() {
        try {
            System.out.println("Listagem de Reservas:");
            for (Reserva i : listareserva) {
                System.out.println("Dados do Cliente: " + i.getCliente().toString() +
                        " /n Dados do Voo: " + i.getVoo().toString() +
                        " Dados do Assento: " + i.getAssento().toString());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar reservas: " + e.getMessage());
        }
    }

    public void deletar() {
        try {
            System.out.println("Informe o CPF para excluir a reserva:");
            String cpfNovo = scanner.nextLine();
            Reserva apagar = null;

            for (Reserva d : listareserva) {
                if (d.getCliente().getCpf().equals(cpfNovo)) {
                    apagar = d;
                    break;
                }
            }
            if (apagar == null) {
                System.out.println("Reserva não encontrada.");
                return;
            }
            listareserva.remove(apagar);
            System.out.println("Reserva excluída com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir reserva: " + e.getMessage());
        }
    }

    public void buscarReservaPorCpf() {
        try {
            System.out.println("Informe o CPF para buscar:");
            String cpfNovo = scanner.nextLine();
            Reserva busca = null;

            for (Reserva b : listareserva) {
                if (b.getCliente().getCpf().equals(cpfNovo)) {
                    busca = b;
                    break;
                }
            }
            if (busca == null) {
                System.out.println("Reserva não encontrada.");
                return;
            }
            System.out.println("Info. do CPF: (" + busca.getCliente().getCpf() + "): " + busca.getCliente().toString());

        } catch (Exception e) {
            System.out.println("Erro ao buscar reserva: " + e.getMessage());
        }
    }

}
