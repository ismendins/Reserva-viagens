package reservavoos.modelo;

public class VooNacional extends Voo implements Viagens{
    public VooNacional(String numero, String data, String hora, String destino, String origem) {
        super(numero, data, hora, destino, origem);
    }
    @Override
    public String exibirRota() {
        return "O voo segue a seguinte rota: Embarque em " + origem + "com chegada final em " + destino + " e possíveis escalas no caminho.";

    }

}
