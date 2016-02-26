package Graph;

public class DemoApplicationGraph {
    public static void main(String[] args) {
        Graph test = new Graph();
        V one = new V(1);
        V two = new V(2);
        V three = new V(3);
        V four = new V(4);
        V five = new V(5);
        V six = new V("rt");

        test.addEdge(one, two);
        test.addEdge(two, three);
        test.addEdge(three, four);
        test.addEdge(five, six);
        test.addEdge(four,one);
        //test.printGraph();
        test.DFS_Graph();

    }
}
