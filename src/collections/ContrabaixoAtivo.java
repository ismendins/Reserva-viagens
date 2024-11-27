package collections;

public class ContrabaixoAtivo extends Cordas implements Eletrico, Ativo {

    @Override
    public String exibirSistemadeAfinacao(byte numDeCordas) {
        if(numDeCordas == 4){
            return "Afinação estabelecida como E – A – D – G";
        }
        else if (numDeCordas == 6){
            return "B – E – A – D – G";
        }
        return "B – E – A – D – G – C";
    }

    @Override
    public int numeroDeCaptadores() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean possuiTraste() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String exibirBateria() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String recarregar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int voltagem() {
        // TODO Auto-generated method stub
        return 0;
    }

}
