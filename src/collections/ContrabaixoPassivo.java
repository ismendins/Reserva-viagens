package collections;

public class ContrabaixoPassivo extends Cordas implements Eletrico, Passivo {

    @Override
    public String exibirSistemadeAfinacao(byte numDeCordas) {
        // TODO Auto-generated method stub
        return super.exibirSistemadeAfinacao(numDeCordas);
    }

    @Override
    public String mudarTonalidade() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mudarTonalidade'");
    }

    @Override
    public int numeroDeCaptadores() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'numeroDeCaptadores'");
    }

    @Override
    public boolean possuiTraste() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'possuiTraste'");
    }

}
