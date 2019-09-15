package com.app.api.impl.graph.impl;

public abstract class AbstractGraphApi {

    protected int itemsCount(int[][] path) {
        int count = 0;
        for (int i = 0; i < path.length; i++) {
            count += path[i].length;
        }
        return count;
    }

}
