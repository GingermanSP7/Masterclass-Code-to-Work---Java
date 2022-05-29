package Lezione_1.Modulo2.src.Esercizio4;

public class Stock {
    private String nome;
    private Double prezzo;
    private Giorno g;

    public Stock(String nome, Double prezzo, Giorno g) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.g = g;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Giorno getG() {
        return g;
    }

    public void setG(Giorno g) {
        this.g = g;
    }

        
}
