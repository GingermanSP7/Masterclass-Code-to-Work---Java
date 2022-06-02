package Esercizio5;

public class ExceptionNessunUtente extends Exception{
    ExceptionNessunUtente(){
        super("Nessun Utente nell'insieme Utenti ");
    }

    public String toString(){
        return getMessage() + getCause();
    }
}
