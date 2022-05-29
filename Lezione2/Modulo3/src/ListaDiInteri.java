import java.util.ArrayList;
import java.util.List;

public class ListaDiInteri implements Lista<Integer> {

    private List<Integer> l;

    public ListaDiInteri() {
        l = new ArrayList<Integer>();
    }

    @Override
    public Integer get(int i) { 
        return l.get(i);
    }

    @Override
    public boolean contains(Object o) {
        if(!(o instanceof Integer)) return false;
        Integer e = (Integer) o;
        return l.contains(e);
    }

    @Override
    public int size() {
        return l.size();
    }

    @Override
    public void add(Object o) {
        if(!(o instanceof Integer)) return;
        Integer e = (Integer) o;
        l.add(e);
    }

    @Override
    public boolean remove(int i) {
        Integer elem = l.get(i);
        return l.remove(elem);
    }

    @Override
    public void clear() {
        l.clear();       
    }
    
    public static void main(String[] args) {
        ListaDiInteri l = new ListaDiInteri();
        MiaStringa str = new MiaStringa();

        for(int i=1;i<=10;i++){
            l.add(i);
        }

        System.out.println(l.contains(3) == true);
        System.out.println(l.remove(1) == true);
        System.out.println(l.size() == 9);
        l.clear();
        System.out.println(l.size() == 0);

        System.out.println("");
        str.add("Pippo");
        str.add("Palla");
        str.add("Pluto");
        str.add("Paperino");
        str.add("Topolino");
        str.add("Ciccio");

        System.out.println(str.contains("Ciccio") == true);
        System.out.println(str.remove(2) == true);
        System.out.println(str.size() == 5);
        str.clear();
        System.out.println(str.size() == 0);
    }
}
