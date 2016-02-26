package Tree;

/**
 * Created by Pratik on 2/26/2016.
 */
public class Node<T> {
    protected Node left;
    protected Node right;
    protected T data;

    public Node(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public Node(){
        this.data = null;
        this.left = null;
        this.right = null;
    }
}
