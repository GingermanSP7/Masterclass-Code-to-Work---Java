package Esercizio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
    * Esercizio Libreria versione 2 🛵
    Scrivere un programma Java che permetta di creare e gestire
    una biblioteca. La classe Biblioteca dovrà permettere la gestione di un
    archivio di libri. 
    Ogni Libro ha un codice (univoco), un titolo, una sinossi e un Autore.

    Ogni Autore possiede un codice (univoco), un nome, un cognome e una lista di Libri scritti

    Realizzare i metodi della classe Biblioteca che permettano le seguenti azioni:
    - inserimento di un Libro
    - cancellazione di un Libro
    - ricerca di un Libro a partire da codice, titolo o Autore
    - stampa di “titolo: sinossi” di tutti i titoli di un determinato Autore, ordinati 
    in ordine lessicografico ascendente (in base al titolo) usando "\n" come carattere separatore

    Suggerimento: Effettuare l’override dei metodi equals, hashcode e toString dove necessario
 */

public class Libreria2 {
    private Map<Integer,Libro> libreria;        
    private Map<Autore,Libro> libreria_aut;       
    private Map<String,Libro> libreria_titolo;

    Libreria2(){
        libreria = new TreeMap<>();
        libreria_aut = new TreeMap<>();
        libreria_titolo = new TreeMap<>();
    }

    public void insertLibro(Libro l){
        libreria.put(l.getCodice(), l);
        libreria_aut.put(l.getAutore(), l);
        libreria_titolo.put(l.getTitolo(),l);
    }

    public void removeLibro(Libro l){
        libreria.remove(l.getCodice(), l);
        libreria_aut.remove(l.getAutore(),l);
        libreria_titolo.remove(l.getTitolo(),l);
    }

    public Libro searchLibro_codice(Integer id){        
        if(libreria.get(id) != null) return libreria.get(id);    
        return null;
    }

    public Libro searchLibro_autore(Autore a){
        if(libreria_aut.get(a) != null) return libreria_aut.get(a);
        return null;
    }

    public Libro searchLibro_titolo(String titolo){
        if(libreria_titolo.get(titolo) != null) return libreria_titolo.get(titolo);
        return null;
    }

    public void stampaSinossi(Autore a){
        Map<String,String> libro_sinossi = new TreeMap<>();
        List<Libro> l = new ArrayList<>();

        if(libreria_aut.get(a) != null) l = a.getL();
        for (Libro libro : l) {
            libro_sinossi.put(libro.getTitolo(), libro.getSinossi());
        }

        System.out.println();
        for (Map.Entry<String, String> entry : libro_sinossi.entrySet()) {
            System.out.println(entry.getKey() + ": "+ entry.getValue());
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        // provare a inserire dei libri e autori e vedere se i metodi funzionano
        Autore a1 = new Autore(11, "J.K", "Rowling", null);
        Autore a2 = new Autore(12, "Claudio", "De Sio Cesari", null);
        Autore a3 = new Autore(13, "Marco", "Rossi", null);
        
        
        Libro l1 = new Libro(1, "Harry Potter",a1, "Pippo, Pluto e Paperino");
        Libro l2 = new Libro(2, "Il Nuovo Java",a2, "Lunedì, Martedì, Mercoledì");
        Libro l3 = new Libro(3, "Java 9",a2, "Giovedì, Venerdì, Sabato");
        Libro l4 = new Libro(4, "Zanna Gialla",a3, "Mela, Pera, Fragola");
        Libro l5 = new Libro(5, "Harry Fotter",a1, "Ho finito la fantasia");
        //Libro l6 = new Libro(6, "AAAH",a3, "public static void main");

        
        Libreria2 lib = new Libreria2();

        lib.insertLibro(l1);
        lib.insertLibro(l2);
        lib.insertLibro(l3);
        lib.insertLibro(l4);
        lib.insertLibro(l5);

        List<Libro> jk = new ArrayList<>();
        jk.add(l1);
        jk.add(l5);
        a1.setL(jk);

        List<Libro> cc = new ArrayList<>();
        cc.add(l2);
        cc.add(l3);
        a2.setL(cc);

        List<Libro> mr = new ArrayList<>();
        mr.add(l4);
        a3.setL(mr);

        lib.stampaSinossi(a1);
        System.out.println("----------------------");
        System.out.println(lib.searchLibro_codice(5).getTitolo() + " " + lib.searchLibro_codice(5).getSinossi());
        //System.out.println(lib.searchLibro_autore(a2)); //da sistemare
    }
}
