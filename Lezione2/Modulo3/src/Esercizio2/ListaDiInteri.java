package Esercizio2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaDiInteri implements Iterable <Integer>{
    private List<Integer> l;
    private Iterator s;
    private int i;

    private void reset_Lista() {
        i = 0;
    }

    public ListaDiInteri() {
        l = new ArrayList<>();
        i = 0;
    }

    public void add(Object o) {
        if(!(o instanceof Integer)) return;
        Integer e = (Integer) o;
        l.add(e);
    }

    public void printList(){
        for (Integer integer : l) {
            System.out.println(integer);
        }
    }

    @Override
    public boolean hasNext() {
        if(i >= l.size()) return false;
        return true;
    }

    @Override
    public Integer next() {
        Integer elem = l.get(i);
        ++i;
        return elem;
    }

    @Override
    public void reset() {
        reset_Lista();            
    }
    
   

    public static void main(String[] args) {
        ListaDiInteri l = new ListaDiInteri();

        for(int i=0;i<=10;i++){
            l.add(i);
        }

        //l.printList();
        System.out.println(l.next());
        System.out.println(l.next());
        System.out.println(l.next());
        System.out.println(l.next());
        System.out.println(l.next());
        System.out.println(l.next());
        System.out.println(l.next());
        System.out.println(l.next());
        System.out.println(l.next());
        System.out.println(l.next());
        System.out.println(l.next());

        System.out.println(l.hasNext() == true);
    }
}
