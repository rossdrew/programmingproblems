package com.rox.prob.common.struct;

import java.util.HashMap;

/**
 * A simple connectable vertice/Node implementation
 */
public class Vertice<V> {
    private V myValue = null;
    private HashMap<V, Vertice> connections = new HashMap<>();

    public Vertice(V myValue){
        this.myValue = myValue;
    }

    public V getIdentity(){
        return myValue;
    }

    public void twoWayConnectTo(Vertice<V> vertice){
        connections.put(vertice.getIdentity(), vertice);
        vertice.oneWayConnectTo(this);
    }

    public void oneWayConnectTo(Vertice<V> vertice){
        connections.put(vertice.getIdentity(), vertice);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        String seperator = this.getIdentity() + " [";
        for (V verticeIdentity : connections.keySet()){
            sb.append(seperator + verticeIdentity);
            seperator = ", ";
        }
        sb.append("]");

        return sb.toString();
    }

}
