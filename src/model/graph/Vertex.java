package model.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Vertex<K extends Comparable<K>,T> {

    //Adjacent representation from the current vertex;
    private ArrayList<Vertex<K,T>> adj;

    //Represent the element into the node
    private T element;
    //The color (for BFS Algorithm)

    private K key;;

    private Color color;

    private int originTime;

    private int endTime;

    private int distance;

    private Vertex parent;

    public Vertex(K key,T element) {
        this.element = element;
        this.key = key;
        adj = new ArrayList<>();
    }

    public void addAdj(Vertex<K,T> vertex){
        adj.add(vertex);
    }

    @Override
    public String toString(){
        String msj = "";
        for (int i = 0; i < adj.size(); i++) {
            msj += "[" + adj.get(i).getElement() + "]";
        }
        return msj;
    }

    public boolean isAlreadyInTheAdj(Vertex<K,T> vertexSearched){
        for (int i = 0; i < adj.size(); i++) {
            if(vertexSearched == adj.get(i)){
                return true;
            }
        }
        return false;
    }

    //g & s

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public ArrayList<Vertex<K,T>> getAdjancent(){
        return adj;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public int getOriginTime() {
        return originTime;
    }

    public void setOriginTime(int originTime) {
        this.originTime = originTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Vertex getParent() {
        return parent;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ArrayList<Vertex<K,T>> getAdj(){
        return adj;
    }

}
