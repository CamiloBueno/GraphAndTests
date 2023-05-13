package model.graph;

import java.util.List;

public interface InterfaceGraphList<T> {

    public void addVertex(T vertex);

    public void addEdge(T source, T destiny, int weight) throws Exception;

    public List<T> getVertices();

    public void BFS(Vertex s);


}
