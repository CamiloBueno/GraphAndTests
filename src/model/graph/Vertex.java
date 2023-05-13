package model.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Vertex<K,T> {

    //Represent the element into the node
    private T element;
    //The color (for BFS Algorithm)

    private K key;

    //Adjacent representation from the current vertex;
    private ArrayList<Vertex<K,T>> adj;
    private Color color;
    //The distance between two vertex
    private double distance;
    //The weight in an Edge (between two vertex)
    private Double weight;

    private Vertex<K, T> parent;

    public Vertex(K key,T element) {
        this.element = element;
        this.key = key;
        adj = new ArrayList<>();
    }

    public void addAdj(Vertex<K,T> vertex2){
        adj.add(vertex2);
    }

    public boolean isAlreadyInTheAdj(Vertex<K,T> vertexSearched){
        for (int i = 0; i < adj.size(); i++) {
            if(vertexSearched == adj.get(i)){
                return true;
            }
        }
        return false;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getWeight() {
        return weight;
    }

    public ArrayList<Vertex<K,T>> getAdjancent(){
        return adj;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setParent(Vertex<K, T> parent) {
        this.parent = parent;
    }

    public Vertex<K, T> getParent() {
        return parent;
    }

    public ArrayList<Vertex<K,T>> getAdj(){
        return adj;
    }

}
