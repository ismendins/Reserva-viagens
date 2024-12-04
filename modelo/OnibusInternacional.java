package reservavoos.modelo;

public class OnibusInternacional extends Onibus implements Viagens{

    private String pais;
    private String passaporte;

    public OnibusInternacional(String numero, String data, String hora, String destino, String origem) {
        super(numero, data, hora, destino, origem);
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    @Override
    public String exibirRota() {
        return "O ônibus segue a seguinte rota: Embarque em " + origem + "com chegada final em " + destino + " e possíveis paradas para desembarque e descanso no caminho.";
    }
}
