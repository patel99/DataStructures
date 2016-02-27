package Tree;

import java.util.Comparator;
import java.util.Stack;

/**
 * Created by Pratik on 2/26/2016.
 */
public class BST<T> {
    public Node root;

    public BST(){
        this.root = new Node();
    }

    public BST(T data){
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

    public void insert(T data){
        Node current = this.root;
        if(this.root == null) {
            this.root = new Node(data);
            return;
        }
        while(current != null){
            if(((Comparable)data).compareTo(current.data)<=0){
                if(current.left == null) {
                    current.left = new Node(data);
                    return;
                }
                current = current.left;
            }
            else{
                if(current.right == null){
                    current.right = new Node(data);
                    return;
                }
                current = current.right;
            }
        }
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

    public void printInOrderIterative(){
        if(this.root == null) return;
        Stack<Node> stack = new Stack<>();
        Node current = this.root;
        while(current!= null){
            stack.push(current);
            current = current.left;
        }
        while(!stack.empty()){
            Node visitingNode = stack.pop();
            System.out.println(visitingNode.data);
            current = visitingNode.right;
            while(current != null){
                stack.push(current);
                current = current.left;
            }
        }
    }

    public void printPreOrderIterative(){
        if(this.root == null) return;
        Stack<Node> stack = new Stack<>();
        Node current = this.root;
        while(current!= null){
            stack.push(current);
            System.out.println(current.data);
            current = current.left;
        }
        while(!stack.empty()){
            Node visitingNode = stack.pop();
            current = visitingNode.right;
            while(current != null){
                stack.push(current);
                System.out.println(current.data);
                current = current.left;
            }
        }
    }
}
