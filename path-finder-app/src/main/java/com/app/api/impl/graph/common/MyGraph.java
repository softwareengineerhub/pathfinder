/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.impl.graph.common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author DProkopiuk
 */
public class MyGraph {

    private int verticesCount;
    private LinkedList<Coordinate>[] array;
    private Coordinate root;
    private Map<Integer, Coordinate> coordinateById;


    public MyGraph(int verticesCount) {
        this.verticesCount = verticesCount;
        array = new LinkedList[verticesCount];
        coordinateById = new HashMap();
    }

    public void insert(int source, Coordinate coordinate) {
        if (array[source] == null) {
            array[source] = new LinkedList();
        }
        for (Coordinate c : array[source]) {
            if (c.getId() == coordinate.getId()) {
                return;
            }
        }
        array[source].add(coordinate);
        coordinateById.put(coordinate.getId(), coordinate);
    }

    public void printMyGraph() {
        System.out.println("---------------MyGraph------------");
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " --> " + array[i]);
        }
        System.out.println("---------------MyGraph------------");
    }

    public LinkedList<Coordinate> getItems(int source) {
        return array[source];
    }

    public int getVerticesCount() {
        return verticesCount;
    }

    public int getIdForCoordinate(Coordinate coordinate) {
        for (int i = 0; i < array.length; i++) {
            LinkedList<Coordinate> list = array[i];
            if (list == null) {
                continue;
            }
            for (Coordinate c : list) {
                if (c.getI() == coordinate.getI()) {
                    if (c.getJ() == coordinate.getJ()) {
                        return c.getId();
                    }
                }
            }
        }
        return -1;
    }

    public Coordinate getCoordinateById(int id) {
        return coordinateById.containsKey(id) ? coordinateById.get(id) : null;
    }

    public void setRoot(Coordinate root) {
        coordinateById.put(root.getId(), root);
        this.root = root;
    }
}
