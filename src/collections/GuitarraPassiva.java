package collections;

public class GuitarraPassiva extends Cordas implements Eletrico, Passivo {

    @Override
    public String exibirSistemadeAfinacao(byte numDeCordas) {
        // TODO Auto-generated method stub
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
    public String mudarTonalidade() {
        // TODO Auto-generated method stub
        return null;
    }

}
