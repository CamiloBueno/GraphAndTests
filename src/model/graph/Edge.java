package model.graph;

import java.util.Comparator;

public class Edge<T> implements Comparator<Edge<T>> {
    private Vertex<T> source;
    private Vertex<T> destiny;
    private int weight;

    public Edge() {}

    public Edge(Vertex<T> source, Vertex<T> destiny, int weight) {
        this.source = source;
        this.destiny = destiny;
        this.weight = weight;
    }

    public Vertex<T> getSource() {
        return source;
    }

    public void setSource(Vertex<T> source) {
        this.source = source;
    }

    public Vertex<T> getDestiny() {
        return destiny;
    }

    public void setDestiny(Vertex<T> destiny) {
        this.destiny = destiny;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compare(Edge<T> o1, Edge<T> o2) {
        return 0;
    }
}
