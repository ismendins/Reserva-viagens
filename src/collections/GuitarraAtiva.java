package collections;

public class GuitarraAtiva extends Cordas implements Eletrico, Ativo {

    @Override
    public String exibirSistemadeAfinacao(byte numDeCordas) {
        
        return super.exibirSistemadeAfinacao(numDeCordas);
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
