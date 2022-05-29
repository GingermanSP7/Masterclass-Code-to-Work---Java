package Lezione_1.Modulo2.src.Esercizio1;

public class Cerchio {
    private float diametro;
    private Colore col;

    private float pow(float base, int n){
        float ris = 1;
        for(int i=1;i<=n;i++){
            ris = ris * base;
        }
        return ris;
    }

    private float getRaggio(){
        return this.diametro/2;
    }

    Cerchio(int diametro){
        this.diametro = diametro;
        col = new Nero();
    }

    public float getDiametro() {
        System.out.println("Diametro: "+this.diametro);
        return diametro;
    }

    public void setDiametro(float diametro) {
        if(diametro < 0){
            System.out.println("Impossibile impostare un diametro negativo al cerchio");
            return;
        }
        this.diametro = diametro;
    }

    public float getCirconferenza(){
        float circonferenza = 3.14f * this.diametro;
        System.out.println("Circonferenza: "+circonferenza);
        return circonferenza;
    }  

    public float getArea(){
        float area = pow(getRaggio(),2) * 3.14f;
        System.out.println("Area: "+area);
        return area; 
    }

    public void setColore(int rosso, int verde, int blue){
        if(rosso == 255 && verde == 255 && blue == 255){
            col = new Bianco();
            return;
        }
        else if(rosso == 0 && verde == 0 && blue == 0){
            col = new Nero();
            return;
        }
        col = new Colore(rosso, verde, blue);
    }
}
