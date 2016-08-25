package com.rox.prob.common.struct;

import java.util.HashMap;
import java.util.Vector;

/**
 * A Simple Graph Data Structure
 */
public class Graph<I, V> {
    private HashMap<I, Vertice<I, V>> vertices = new HashMap<>();
    private Vertice<I, V> rootNode = null;

    public Graph(){

    }

    public Vertice<I, V> addVertice(I verticeIdentity, V verticeValue){
        Vertice<I, V> vertice = new Vertice<>(verticeIdentity, verticeValue);
        vertices.put(verticeIdentity, vertice);

        if (rootNode == null){
            rootNode = vertice;
        }

        return vertice;
    }

    public Vertice<I, V> getRootNode(){
        return rootNode;
    }

    public void addVector(Vertice<I, V> from, Vertice<I, V> to){
        from.oneWayConnectTo(to);
    }

    public void addEdge(Vertice<I, V> a, Vertice<I, V> b){
        a.twoWayConnectTo(b);
    }

    public Vertice<I, V> getVertice(Vertice<I, V> vertice){
        return vertices.get(vertice.getIdentity());
    }

    public Vertice<I, V> getVertice(I vertice){
        return vertices.get(vertice);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (I verticeIdentity : vertices.keySet()){
            Vertice<I, V> vertice = vertices.get(verticeIdentity);
            sb.append(vertice.toString() + "\n");
        }

        return sb.toString();
    }
}
