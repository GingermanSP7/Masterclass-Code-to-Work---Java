package Lezione2.Prove.Collection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProvaList{
    public static void main(String[] args) {
        List<String>lista = new ArrayList<>();
        List<String> lista2 = new LinkedList<>();

        lista2.add("Pippo");
        lista2.add("Pluto");
        lista2.add("Paperino");
        lista2.add("Topolino");
        lista2.add("Ciccio");

        System.out.println(lista2.get(3));
    }
}