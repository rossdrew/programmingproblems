package com.rox.prob.common.struct;

import java.util.HashMap;

/**
 * A simple connectable vertice/Node implementation
 */
public class Vertice<I, V> {
    private I myIdentity = null;
    private V myValue = null;
    private HashMap<I, Vertice> connections = new HashMap<>();

    public Vertice(I myIdentity, V myValue){
        this.myIdentity = myIdentity;
        this.myValue = myValue;
    }

    public I getIdentity(){
        return myIdentity;
    }

    public V getValue() {
        return myValue;
    }

    public void twoWayConnectTo(Vertice<I, V> vertice){
        connections.put(vertice.getIdentity(), vertice);
        vertice.oneWayConnectTo(this);
    }

    public void oneWayConnectTo(Vertice<I, V> vertice){
        connections.put(vertice.getIdentity(), vertice);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        String seperator = this.getIdentity() + " [";
        for (I verticeIdentity : connections.keySet()){
            sb.append(seperator + verticeIdentity);
            seperator = ", ";
        }
        sb.append("]");

        return sb.toString();
    }

    public Vertice<I ,V>[] getConnections(){
        Vertice<I, V>[] vertices = new Vertice[connections.size()];

        int i=0;
        for (I id : connections.keySet()){
            vertices[i] = connections.get(id);
        }

        return vertices;
    }
}
