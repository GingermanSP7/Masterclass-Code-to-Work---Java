package Lezione_1.Modulo2.src.Esercizio3.SerieA;

public class Giocatore {
    private String id_gioc;
    private String nome;
    private String cognome;

    public Giocatore(String id_gioc, String nome, String cognome) {
        this.id_gioc = id_gioc;
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getId_gioc() {
        return id_gioc;
    }

    public void setId_gioc(String id_gioc) {
        this.id_gioc = id_gioc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
