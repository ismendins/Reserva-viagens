package reservavoos.modelo;

public class OnibusIntermunicipalEstadual extends Onibus implements Viagens {
    public OnibusIntermunicipalEstadual(String numero, String data, String hora, String destino, String origem) {
        super(numero, data, hora, destino, origem);
        }
    @Override
    public String exibirRota() {
        return "O ônibus segue a seguinte rota: Embarque em " + origem + "com chegada final em " + destino + " e possíveis paradas para desembarque e descanso no caminho.";
    }

    }
