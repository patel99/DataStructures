package Graph;


import java.util.ArrayList;

public class V<T> {
    protected T data;

    protected ArrayList<V> adj;
    public V(T data){
        this.data = data;
        this.adj = new ArrayList<>();
    }
}
