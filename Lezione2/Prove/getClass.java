package Lezione2.Prove;

public class getClass{

    @Override
    public String toString(){
        return "Vaffanculo";
    }


    public static void main(String[] args) {
        getClass c = new getClass();
        // System.out.println(c.getClass());
        System.out.println(c.toString());
    }
}