package Lezione_1.Modulo2.src.Esercizio3.SerieA;

public class Squadra {
    private String id;
    private String nome;
    private Giocatore rosaG[];
    private int punteggio;
    private int gol_fatti;
    private int gol_subiti;

    Squadra(String id, String nome, Giocatore rosaG[]){
        this.id = id;
        this.nome = nome;
        this.rosaG = rosaG;
        punteggio = 0;
        gol_fatti = 0;
        gol_subiti = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id.equals("") || id.equals(" ") || id.equals(null)){
            System.out.println("Valore ID non valido");
            return;
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Giocatore[] getRosaG() {
        return rosaG;
    }

    public void setRosaG(Giocatore[] rosaG) {
        this.rosaG = rosaG;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        if(punteggio < 0) return;
        this.punteggio = punteggio;
    }

    public int getGol_fatti() {
        return gol_fatti;
    }

    public void setGol_fatti(int gol_fatti) {
        if(gol_fatti < 0) return;
        this.gol_fatti = gol_fatti;
    }

    public int getGol_subiti() {
        return gol_subiti;
    }

    public void setGol_subiti(int gol_subiti) {
        if(gol_subiti < 0) return;
        this.gol_subiti = gol_subiti;
    }

    
}
