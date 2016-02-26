package Tree;

/**
 * Created by Pratik on 2/26/2016.
 */
public class Test {
    public static void main(String[] args) {
        BST binaryTree = new BST(4);
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(1);
        binaryTree.insert(7);
        binaryTree.insert(2);
        binaryTree.insert(8);
        binaryTree.insert(90);
        binaryTree.insert(89);
        binaryTree.insert(6);
        binaryTree.printInOrder();
        System.out.println("---------------------------------------");
        binaryTree.printPostOrder();
        System.out.println("---------------------------------------");
        binaryTree.printPreOrder();
    }
}
