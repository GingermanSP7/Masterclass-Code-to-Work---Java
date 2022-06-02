package Esercizio5;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
     * Esercizio TinderLike 🛵

    Scrivere un programma per gestire gli interessi in comune tra le persone. 
    In particolare, deve essere possibile gestire una quantità potenzialmente 
    infinita di utenti, ognuno con i propri interessi (a ciascun utente può essere
    associato uno o più interessi). 
    Ogni interesse ha un codice e un testo. 

    Devono essere possibili le seguenti operazioni:
    - inserire un utente e i suoi interessi
    - cancellare un utente (e i suoi interessi associati)
    - dato un utente u1, ottenere l'utente u2 con più interessi in comune con u1
    - PLUS 🏍:ottenere gli utenti più simili (ossia con più interessi in comune)
 */

public class TinderLike{
    
    private Set<Utente> utenti;

    TinderLike(){
        utenti = new HashSet<>();
    }

    public void addUtente(Utente u, Set<Interesse> i){
        if(utenti.isEmpty() || !utenti.contains(u)){
            utenti.add(u);
            u.setInteressi(i);
            return;
        }
        else if(utenti.contains(u)){
            Set<Interesse> tmp = u.getInteressi();
            tmp.addAll(i);
            u.setInteressi(tmp);         
        }
        return;
    }

    public void removeUtente(Utente u){
        if(utenti.contains(u)){
            u.removeInteressi();
            utenti.remove(u);
        }
    }

    public Utente interesseComune(Utente u){
        Utente c = null;
        int max = 0;
        for (Utente utente : utenti) {
            int count = 0;
            if(utente.equals(u)) continue;
            Set<Interesse> tmp = new HashSet<>();
            tmp.addAll(utente.getInteressi());
            tmp.retainAll(u.getInteressi());
            for (Interesse interesse : tmp) {
                count++;
            }
            if(count > max){
                max = count;
                c = utente;
            }
        }
        return c;
    }

    public Map<Integer,Utente> utentiConPiuInteressi() throws ExceptionNessunUtente{
        Map<Integer,Utente> utentiComune = new TreeMap<>(Collections.reverseOrder());
        if(utenti.size() == 0) throw new ExceptionNessunUtente();
        for (Utente i : utenti) {
            int num_interessi = 0;
            Set<Interesse> tmp = new HashSet<>();
            tmp.addAll(i.getInteressi());
            for (Utente j : utenti) {
                if(j.equals(i)) continue;
                Set<Interesse> tmp2 = new HashSet<>();
                tmp2.addAll(tmp);
                tmp2.retainAll(j.getInteressi());
                num_interessi += tmp2.size();
            }
            utentiComune.put(num_interessi, i);
        }
        return utentiComune;
    }

    public void toString(Utente a, Utente b){
        System.out.println("Lutente che ha più interessi in comune con "+a.getNome() + " " + a.getCognome() + " è: "+ b.getCodice() + ", "+ b.getNome() + " " + b.getCognome());
    }

    public static void main(String[] args) throws ExceptionNessunUtente {
        Utente u1 = new Utente("Mario", "Rossi", "123a");
        Utente u2 = new Utente("Pippo", "Catania", "142c");
        Utente u3 = new Utente("Luca", "Gnaccacani", "15er");
        Utente u4 = new Utente("Michele", "Rosa", "33wq");
        Utente u5 = new Utente("Angelo", "Pappalardo", "91qp");

        Interesse i1 = new Interesse("1", "Calcio");
        Interesse i2 = new Interesse("2", "Pallavolo");
        Interesse i3 = new Interesse("3", "Basket");
        Interesse i4 = new Interesse("4", "Formula1");
        Interesse i5 = new Interesse("5", "MotoGP");
        Interesse i6 = new Interesse("6", "Tennis");
        Interesse i7 = new Interesse("7", "Nuoto");
        Interesse i8 = new Interesse("8", "Scii");

        TinderLike t = new TinderLike();

        Set<Interesse> interesse_u1 = new HashSet<>();
        interesse_u1.add(i1);
        interesse_u1.add(i2);
        interesse_u1.add(i4);

        Set<Interesse> interesse_u2 = new HashSet<>();
        interesse_u2.add(i7);
        interesse_u2.add(i5);
        interesse_u2.add(i8);
        interesse_u2.add(i3);

        Set<Interesse> interesse_u3 = new HashSet<>();
        interesse_u3.add(i4);
        interesse_u3.add(i2);
        interesse_u3.add(i1);
        interesse_u3.add(i3);
        interesse_u3.add(i8);
        interesse_u3.add(i6);

        Set<Interesse> interesse_u4 = new HashSet<>();
        interesse_u4.add(i7);
        interesse_u4.add(i3);
        interesse_u4.add(i1);
        interesse_u4.add(i8);
        interesse_u4.add(i6);

        Set<Interesse> interesse_u5 = new HashSet<>();
        interesse_u5.add(i4);
        interesse_u5.add(i6);
        interesse_u5.add(i7);
        interesse_u5.add(i1);
        interesse_u5.add(i2);

        t.addUtente(u1, interesse_u1);
        t.addUtente(u2, interesse_u2);
        t.addUtente(u3, interesse_u3);
        t.addUtente(u4, interesse_u4);
        t.addUtente(u5, interesse_u5);

        Utente uComune = t.interesseComune(u1);
        t.toString(u1,uComune);

        Map<Integer,Utente> classificaInteressi = new TreeMap<>();
        classificaInteressi = t.utentiConPiuInteressi();
        System.out.println("CLASSIFICA UTENTI CON PIU' INTERSSI IN COMUNE:");
        for (Map.Entry<Integer,Utente> mappa : classificaInteressi.entrySet()) {
            System.out.println(mappa.getValue().getNome() + " " + mappa.getValue().getCognome() + ": "+mappa.getKey());
        }
    }
}