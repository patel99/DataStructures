package Tree;

import java.util.Stack;

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

    // Other method to do BFS on tree is similar to the BFS in Graph. Check the graph implementation of BFS
    public void printLevelOrder()
    {
        int h = height(this.root);
        for (int i=1; i<=h; i++){
            printGivenLevel(this.root, i);
            System.out.println();
        }
    }

    public void printGivenLevel (Node current ,int level)
    {
        if (current == null)
            return;
        if (level == 1)
            System.out.print(current.data + " ");
        else if (level > 1)
        {
            printGivenLevel(current.left, level-1);
            printGivenLevel(current.right, level-1);
        }
    }

    public int height(Node root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

    public void printPostOrderIterative(){
        if(this.root == null) return;
        Stack<Node> stack = new Stack<>();
        Node current = this.root;
        do {
            while (current != null){
                if(current.right != null){
                    stack.push(current.right);
                    stack.push(current);
                    current = current.left;
                }
                else {
                    stack.push(current);
                    current = current.left;
                }
            }
            Node poped = stack.pop();
            if(poped.right != null && !stack.isEmpty() && poped.right == stack.peek()){
                stack.pop();
                stack.push(poped);
                current = poped.right;
            }
            else {
                System.out.println(poped.data);
                current = null;
            }
        }while (!stack.isEmpty());
    }

    public T minValue(Node current)
    {
        T minv = (T)current.data;
        while (current.left != null)
        {
            minv = (T)current.left.data;
            current = current.left;
        }
        return minv;
    }

    public void deleteKey(T key){
        this.root = deleteKey_Aux(this.root, key);
    }

    private Node deleteKey_Aux(Node current, T key){
        if(current == null) return current;
        if(((Comparable)key).compareTo(current.data)<0){
            current.left = deleteKey_Aux(current.left,key);
        } else if(((Comparable)key).compareTo(current.data)>0){
            current.right = deleteKey_Aux(current.right,key);
        }
        else{ // match found
            if(current.left == null) return current.right;
            else if(current.right == null) return current.left;
            current.data = minValue(current.right);
            current.right = deleteKey_Aux(current.right, (T)current.data);
        }

        return current;
    }

}
