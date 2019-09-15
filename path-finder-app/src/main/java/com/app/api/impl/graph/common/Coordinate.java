/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.impl.graph.common;

/**
 * @author DProkopiuk
 */
public class Coordinate {

    private int id;
    private int i;
    private int j;
    private int value;

    public Coordinate(int id, int i, int j, int value) {
        this.id = id;
        this.i = i;
        this.j = j;
        this.value = value;
    }

    public Coordinate() {
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String toString() {
        return String.valueOf(id);
    }

}
