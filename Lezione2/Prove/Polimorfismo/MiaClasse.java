package Lezione2.Prove.Polimorfismo;

public class MiaClasse implements Interfaccia {
    public void metodoAstratto(){
        System.out.println(" metodo Interfaccia");
    }

    public void metodoDellaClasse(){
        System.out.println("metodo MiaClasse");
    }

    public static void main(String[] args) {
        Interfaccia x = new MiaClasse();  //x è un riferimento all'interfaccia, però è un'istanza di MiaClasse
        x.metodoAstratto();
        //x.metodoDellaClasse();  //ma non possiamo chiamare i metodi della classe perchè x è un tipo Interfaccia
    }
}
