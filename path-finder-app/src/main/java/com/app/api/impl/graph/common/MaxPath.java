package com.app.api.impl.graph.common;

import java.util.Stack;

public class MaxPath implements Comparable<MaxPath> {
    private int value;
    private Stack<Coordinate> coordinates;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Stack<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Stack<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Max value: ");
        sb.append(value);
        sb.append("\n");

        sb.append("-----------Node ids:-----------\n");
        sb.append(coordinates);
        sb.append("-----------Coordinates:-----------\n");
        for (Coordinate c : coordinates) {
            sb.append("[");
            sb.append(c.getI());
            sb.append(",");
            sb.append(c.getJ());
            sb.append("]\n");
        }
        return sb.toString();
    }

    public int compareTo(MaxPath other) {
        return value - other.value;
    }
}

