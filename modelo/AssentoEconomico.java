package reservavoos.modelo;

public class AssentoEconomico extends Assento{
    private boolean refeicaoGratuita;
    private boolean acessoInternet;

    public boolean isRefeicaoGratuita() {
        return refeicaoGratuita;
    }

    public void setRefeicaoGratuita(boolean refeicaoGratuita) {
        this.refeicaoGratuita = refeicaoGratuita;
    }

    public boolean isAcessoInternet() {
        return acessoInternet;
    }

    public void setAcessoInternet(boolean acessoInternet) {
        this.acessoInternet = acessoInternet;
    }
}
