package collections;

public abstract class Cordas {
    protected String marca;
    protected String modelo;
    protected String cor;
    protected byte numDeCordas;
    protected String tipoMadeiraTampo;
    protected String tipoMadeiraBraco;

    
    public String exibirSistemadeAfinacao(byte numDeCordas){
        return "Utilizando o sistema de solfejo";
    }

}
