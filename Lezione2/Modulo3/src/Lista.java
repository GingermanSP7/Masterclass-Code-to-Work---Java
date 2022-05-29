public interface Lista<T>{
    public abstract T get(int i);
    public abstract boolean contains(Object o);
    public abstract int size();
    void add(Object o);     // il public abstract è sottointeso
    boolean remove(int i);
    void clear();
}
