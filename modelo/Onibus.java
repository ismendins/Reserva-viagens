package reservavoos.modelo;

import java.util.ArrayList;

public abstract class Onibus {
    protected String numero;
    protected String data;
    protected String hora;
    protected String destino;
    protected String origem;
    protected ArrayList<Onibus> listaOnibus = new ArrayList<>();

    public Onibus(String numero, String data, String destino, String hora, String origem) {
        this.numero = numero;
        this.data = data;
        this.destino = destino;
        this.hora = hora;
        this.origem = origem;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public ArrayList<Onibus> getListaOnibus() {
        return listaOnibus;
    }

    public void setListaOnibus(ArrayList<Onibus> listaOnibus) {
        this.listaOnibus = listaOnibus;
    }
    public String toString () {
        return "Viagem (" + numero + ")" + " - Desembarque dia: " + data + " ás " + hora + " | "+ "Destino: " +destino + " | " + "Origem: " + origem;
    }
}
