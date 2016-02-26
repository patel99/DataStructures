package Tree;

/**
 * Created by Pratik on 2/26/2016.
 */
public class BinaryTree<T> {
    public Node root;

    public BinaryTree(){
        this.root = new Node();
    }

    public BinaryTree(T data){
        this.root = new Node(data);
    }

    public Node isNode(T checkNode){
        return isNode_Aux(this.root, checkNode);
    }

    private Node isNode_Aux(Node current, T checkNode){
        if(current == null) return null;
        if(current.data == checkNode) return current;
        else{
            Node temp;
            if ((temp = isNode_Aux(current.left, checkNode)) != null) {
                return temp;
            }
            else if((temp = isNode_Aux(current.right, checkNode))!= null ){
                return temp;
            }
        }
        return null;
    }

    public boolean insertLeft(T parent,T newNode){
        Node temp = isNode(parent);
        if(temp == null){
            System.out.println("Node is not present in Tree");
            return false;
        }
        if(temp.left != null){
            System.out.println("Left of this node is not null");
            return false;
        }
        temp.left = new Node(newNode);
        return true;
    }

    public boolean insertRight(T parent,T newNode){
        Node temp = isNode(parent);
        if(temp == null){
            System.out.println("Node is not present in Tree");
            return false;
        }
        if(temp.right != null){
            System.out.println("Left of this node is not null");
            return false;
        }
        temp.right = new Node(newNode);
        return true;
    }

    public void printInOrder(){
        printInOrder_Aux(this.root);
    }

    public void printInOrder_Aux(Node current){
        if(current == null) return;
        printInOrder_Aux(current.left);
        System.out.println(current.data);
        printInOrder_Aux(current.right);
    }

    public void printPostOrder(){
        printPostOrder_Aux(this.root);
    }

    public void printPostOrder_Aux(Node current){
        if(current == null) return;
        printPostOrder_Aux(current.left);
        printPostOrder_Aux(current.right);
        System.out.println(current.data);
    }

    public void printPreOrder(){
        printPreOrder_Aux(this.root);
    }

    public void printPreOrder_Aux(Node current){
        if(current == null) return;
        System.out.println(current.data);
        printPreOrder_Aux(current.left);
        printPreOrder_Aux(current.right);
    }
}
