package Graph;

import java.util.*;


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

    private static Map<V,Integer> isVisited = new HashMap<>();
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

    public void clearVisited(){
        isVisited.clear();
    }

    public void DFS_Graph(){
        Iterator<V> vertex = vertices.iterator();
        while(vertex.hasNext()){
            V temp = vertex.next();
            if(!isVisited.containsKey(temp)){
                DFS_Vertex(temp);
            }
        }
        isVisited.clear();
    }

    private static Queue<V> queue = new LinkedList<>();
    public void BFS_Vertex(V vertex){
        if(!isVisited.containsKey(vertex)){
            System.out.println(vertex.data);
            isVisited.put(vertex,1);
            queue.add(vertex);
            while (!queue.isEmpty()){
                V temp = queue.poll();

                Iterator<V> adjIterator = temp.adj.iterator();
                while (adjIterator.hasNext()){
                    V adj = adjIterator.next();
                    if(!isVisited.containsKey(adj)){
                        System.out.println(adj.data);
                        isVisited.put(adj,1);
                        queue.add(adj);
                    }
                }
            }
        }
    }

    public void BFS_Graph(){
        Iterator<V> vertex = vertices.iterator();
        while(vertex.hasNext()){
            V temp = vertex.next();
            if(!isVisited.containsKey(temp)){
                BFS_Vertex(temp);
            }
        }
        isVisited.clear();
    }
}