package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class Graph {
    private ArrayList<V> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }

    public boolean isVertex(V vertex) {
        if(vertices.contains(vertex)) return true;
        else return false;
    }

    public void addEdge(V vertex1, V vertex2) {
        if(!isVertex(vertex1)){
            vertices.add(vertex1);
        }
        if(!isVertex(vertex2)){
            vertices.add(vertex2);
        }
        vertex1.adj.add(vertex2);
    }

    public boolean deleteEdge(V vertex1, V vertex2) {
        if(!isVertex(vertex1) || !isVertex(vertex2)) return false;

        if(!vertex1.adj.contains(vertex2)) return false;

        vertex1.adj.remove(vertex2);
        return true;
    }

    private static HashMap<V,Integer> isVisited = new HashMap<>();
    public void DFS_Vertex(V vertex) {
        if(!isVisited.containsKey(vertex)) {
            System.out.println(vertex.data);
            isVisited.put(vertex,1);
            Iterator<V> adjVertices = vertex.adj.iterator();
            while (adjVertices.hasNext()) {
                DFS_Vertex(adjVertices.next());
            }
        }
    }

    public void DFS_Graph(){
        Iterator<V> vertex = vertices.iterator();
        while(vertex.hasNext()){
            V temp = vertex.next();
           if(!isVisited.containsKey(temp)){
                DFS_Vertex(temp);
            }
        }
    }
}