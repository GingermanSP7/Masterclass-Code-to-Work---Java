package Esercizio1;
public class Colore {
    private int rosso;
    private int verde;
    private int blue;

    Colore(int rosso, int verde, int blue){
        setRosso(rosso);
        setVerde(verde);
        setBlue(blue);
    }

    public int getRosso() {
        return rosso;
    }

    public void setRosso(int rosso) {
        if(rosso > 255 || rosso < 0){
            System.out.println("Valore non valido (Rosso)!");
            return;
        }
        this.rosso = rosso;
    }

    public int getVerde() {
        return verde;
    }

    public void setVerde(int verde) {
        if(verde > 255 || verde < 0){
            System.out.println("Valore non valido (Verde)!");
            return;
        }
        this.verde = verde;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        if(blue > 255 || blue < 0){
            System.out.println("Valore non valido (Blue)!");
            return;
        }
        this.blue = blue;
    }    
}

class Nero extends Colore{
    Nero(){
        super(0,0,0);
    }
}

class Bianco extends Colore{
    Bianco(){
        super(255,255,255);
    }
}