package com.rox.prob.common.struct;

import java.util.HashMap;

/**
 * A Simple Graph Data Structure
 */
public class Graph<V> {
    private HashMap<V, Vertice<V>> vertices = new HashMap<>();

    public Graph(){

    }

    public Vertice<V> addVertice(V verticeIdentity){
        Vertice<V> vertice = null;

        if (vertices.containsKey(verticeIdentity)){
            vertice = vertices.get(verticeIdentity);
        }else {
            vertice = new Vertice<>(verticeIdentity);
            vertices.put(verticeIdentity, vertice);
        }

        return vertice;
    }

    public void addEdge(Vertice<V> a, Vertice<V> b){
        a.twoWayConnectTo(b);
    }

    public Vertice<V> getVertice(Vertice<V> vertice){
        return vertices.get(vertice.getIdentity());
    }

    public Vertice<V> getVertice(V vertice){
        return vertices.get(vertice);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (V verticeIdentity : vertices.keySet()){
            Vertice<V> vertice = vertices.get(verticeIdentity);
            sb.append(vertice.toString() + "\n");
        }

        return sb.toString();
    }
}
