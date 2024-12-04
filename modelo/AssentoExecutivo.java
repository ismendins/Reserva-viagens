package reservavoos.modelo;

public class AssentoExecutivo extends Assento{
    private boolean assentoReclinavel;
    private boolean servicoDeBordo;

    public boolean isAssentoReclinavel() {
        return assentoReclinavel;
    }

    public void setAssentoReclinavel(boolean assentoReclinavel) {
        this.assentoReclinavel = assentoReclinavel;
    }

    public boolean isServicoDeBordo() {
        return servicoDeBordo;
    }

    public void setServicoDeBordo(boolean servicoDeBordo) {
        this.servicoDeBordo = servicoDeBordo;
    }
}
