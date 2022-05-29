package Esercizio1;
import java.util.ArrayList;
import java.util.List;

public class MiaStringa implements Lista<String>{
    private List<String> str;

    MiaStringa(){
        str = new ArrayList<String>();
    }

    @Override
    public String get(int i) {
        return str.get(i);
    }

    @Override
    public boolean contains(Object o) {
        if(!(o instanceof String)) return false;
        String elem = (String) o;
        return str.contains(elem);
    }

    @Override
    public int size() {
        return str.size();
    }

    @Override
    public void add(Object o) {
        if(!(o instanceof String)) return;
        String elem = (String) o;
        str.add(elem);
    }

    @Override
    public boolean remove(int i) {
        String elem = str.get(i);
        return str.remove(elem);
    }

    @Override
    public void clear() {
        str.clear();       
    }

        
}
