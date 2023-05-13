package model.graph;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph <K extends Comparable<K>,T> {
    private HashMap<K, Vertex<K, T>> hashMapVertexes;

    private int time = 0;



    public Graph() {
        hashMapVertexes = new HashMap<>();
    }

    public void addNode(K key, T value) { //Add vertice
        Vertex<K, T> newVertex = new Vertex<>(key, value);
        hashMapVertexes.put(key, newVertex);
    }

    //1 - simple
    //2- multigrafo
    // 3- bucle/multigrafo
    //4 dirigido
    public String connectVertex(K vStart, K vFinal, int typeGraph) {
        String msj = "One of those vertexes doesn't exist";
        Vertex<K, T> vertexStart = hashMapVertexes.get(vStart);
        Vertex<K, T> vertexFinal = hashMapVertexes.get(vFinal);
        if (vertexStart != null && vertexFinal != null) {
            switch (typeGraph) {
                case 1:
                    if (vertexStart != vertexFinal) {
                        if (vertexStart.isAlreadyInTheAdj(vertexFinal) || vertexFinal.isAlreadyInTheAdj(vertexStart)) {
                            msj = "This is a simple graph, loops aren't allowed";
                        } else {
                            vertexStart.addAdj(vertexFinal);
                            vertexFinal.addAdj(vertexStart);
                            msj = "Vertexes connected";
                        }
                    }
                    break;
                case 2:
                    if (vertexStart != vertexFinal) {
                        vertexStart.addAdj(vertexFinal);
                        vertexFinal.addAdj(vertexStart);
                        msj = "Vertexes connected";
                    }else{
                        msj = "loops aren't allowed";
                    }
                    break;
                case 3:
                    vertexStart.addAdj(vertexFinal);
                    vertexFinal.addAdj(vertexStart);
                    msj = "Vertexes connected";
                    break;
                case 4:
                    if (vertexStart != vertexFinal) {
                        vertexStart.addAdj(vertexFinal);
                        msj = "Vertexes connected";
                    }else{
                        msj = "loops aren't allowed";
                    }
                    break;
            }
        }
        return msj;
    }

    public String showAdjList(K key) {
        String msj = "";
        Vertex<K, T> vertex = hashMapVertexes.get(key);
        msj = vertex.toString();
        return msj;
    }

    public void bfs(K vStart){
        Vertex<K,T> S = hashMapVertexes.get(vStart);
        for(K u : hashMapVertexes.keySet()){
            hashMapVertexes.get(u).setColor(Color.WHITE);
            hashMapVertexes.get(u).setDistance(Double.MAX_VALUE);
            hashMapVertexes.get(u).setParent(null);
        }
        S.setColor(Color.GRAY);
        S.setDistance(0.0);
        S.setParent(null);

        Queue<Vertex> Q = new LinkedList<>();
        Q.add(S);
        while (!Q.isEmpty()){
            Vertex<K,T> u  = Q.poll();

            for(Vertex<K,T> v : u.getAdj() ){
                if(v.getColor() == Color.WHITE){
                    v.setColor(Color.GRAY);
                    v.setDistance(u.getDistance() + 1);
                    v.setParent(u);
                    Q.add(v);
                }
            }
            u.setColor
        }
    }

    public void dfs(){
        for (K u : hashMapVertexes.keySet()){
            hashMapVertexes.get(u).setColor(Color.WHITE);
            hashMapVertexes.get(u).setParent(null);
        }

        time = 0;

        for (K u : hashMapVertexes.keySet()){
            if(hashMapVertexes.get(u).getColor() == Color.WHITE){
                dfsVisit(hashMapVertexes.get(u));
            }
        }
    }

    public void dfsVisit(Vertex<K,T> u){
        time = time + 1;
        u.setStartTime(time);
        u.setColor("GREY");
        for (Vertex<K,T> v : u.getAdj()){
            if(v.getColor() == "WHITE"){
                v.setParent(u);
                dfsVisit(v);
            }
        }
        u.setColor("BLACK");
        time = time +1;
        u.setFinalTime(time);
    }



}

/*
public class Graph<K,T> {
    private final List<Vertex<K,T>> vertices;
    private HashMap <K,Vertex<K,T>> graph;

    public Graph(int i) {
        vertices = new ArrayList<>();
        graph = new HashMap<>();
    }



    public void bfs(K vStart){
        Vertex<K,T> S = graph.get(vStart);
        for(K u : graph.keySet()){
            graph.get(u).setColor(Color.WHITE);
            graph.get(u).setDistance(Double.MAX_VALUE);
            graph.get(u).setParent(null);
        }
        S.setColor(Color.GRAY);
        S.setDistance(0.0);
        S.setParent(null);

        Queue<Vertex> Q = new LinkedList<>();
        Q.add(S);
        while (!Q.isEmpty()){
            Vertex<K,T> u  = Q.poll();

            for(Vertex<K,T> v : u.getAdjancent() ){
                if(v.getColor() == Color.WHITE){
                    v.setColor(Color.GRAY);
                    v.setDistance(u.getDistance() + 1);
                    v.setParent(u);
                    Q.add(v);
                }
            }
            u.setColor(Color.BLACK);
        }

    }

   @Override
    public void addVertex(Object vertex) {
        vertices.add((T) vertex);
        // Fill the existent rows with a new Edge
        for (List<Edge<T>> row : adj) {
            row.add(new Edge<>());
        }
        // Add a new row with a new ArrayList that contains n copies of Edge (n = adj.size + 1 E.g. 3 existing edges plus 1 new edge to add)
        adj.add(new ArrayList<>(Collections.nCopies(adj.size() + 1, new Edge<>())));
    }
   public void addVertex(Vertex<K,T> element){
       Vertex<K,T> newVertex = new Vertex<K,T>((element);
       vertices.add(newVertex);
   }

    public int getVertixIndex(Object vertex){

        for (int i = 0; i < vertices.size(); i++) {
            if(vertices.get(i).equals(vertex)){
                return i;
            }
        }
       return -1;
    }

    public String connectVertex(K vStart, K vFinal){
        String msj = "One of those vertexes doesn't exist";
        Vertex<K,T> vertexStart = graph.get(vStart);
        Vertex<K,T> vertexFinal = graph.get(vFinal);
        if(vertexStart != null && vertexFinal != null){
            vertexStart.addAdj(vertexFinal);
            vertexFinal.addAdj(vertexStart);
            msj = "Vertexes connected";
        }
        return msj;
    }

    private boolean validateVertexExists(Object vertex) {
//si mi hasmap tuviera de clase el T y de valor el vertice pordria acceder a ellos en O(1)
       for(int i = 0 ; i < vertices.size(); i++){
           if(vertices.get(i).getElement() == (T) vertex){
               return true;
           }
       }

       return false;

    }

    public List<Vertex<K,T>> getVertices() {
        return vertices;
    }
}
*/