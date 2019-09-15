package com.app.api.impl.graph.common;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MyGraphHelper {

    public static MaxPath calculateMaxPath(List<Stack<Integer>> allPathes, MyGraph myGraph) {
        MaxPath maxPath = null;
        for (Stack<Integer> stack : allPathes) {
            if (maxPath == null) {
                maxPath = new MaxPath();
                initMaxPath(maxPath, stack, myGraph);
                continue;
            }
            MaxPath tmp = new MaxPath();
            initMaxPath(tmp, stack, myGraph);
            int compareResult = maxPath.compareTo(tmp);
            if (compareResult < 0) {
                maxPath = tmp;
            }
        }
        return maxPath;
    }

    public static void initMaxPath(MaxPath maxPath, Stack<Integer> path, MyGraph myGraph) {
        Stack<Coordinate> coordinatesStack = new Stack<>();
        int value = 0;
        for (int id : path) {
            Coordinate coordinate = myGraph.getCoordinateById(id);
            value += coordinate.getValue();
            coordinatesStack.push(coordinate);
        }
        maxPath.setValue(value);
        maxPath.setCoordinates(coordinatesStack);
    }

    public static MyGraph createGraph(int[][] data, int verticesCount) {
        int id = 0;

        Coordinate coordinate = new Coordinate();
        coordinate.setI(0);
        coordinate.setJ(0);
        coordinate.setValue(data[0][0]);
        coordinate.setId(id);

        MyGraph myGraph = new MyGraph(verticesCount);
        myGraph.setRoot(coordinate);

        Queue<Coordinate> items = new LinkedList<>();
        items.add(coordinate);

        while (!items.isEmpty()) {
            Coordinate item = items.poll();

            int i = item.getI();
            int j = item.getJ();
            int itemId = item.getId();

            if (i + 1 < data.length) {
                Coordinate bottomMove = new Coordinate();
                bottomMove.setI(i + 1);
                bottomMove.setJ(j);
                bottomMove.setValue(data[i + 1][j]);
                int tmpId = myGraph.getIdForCoordinate(bottomMove);
                bottomMove.setId(tmpId != -1 ? tmpId : ++id);
                items.add(bottomMove);
                myGraph.insert(itemId, bottomMove);
            }

            if (j + 1 < data[i].length) {
                Coordinate rightMove = new Coordinate();

                rightMove.setI(i);
                rightMove.setJ(j + 1);
                int tmpId = myGraph.getIdForCoordinate(rightMove);
                rightMove.setId(tmpId != -1 ? tmpId : ++id);
                rightMove.setValue(data[i][j + 1]);
                items.add(rightMove);
                myGraph.insert(itemId, rightMove);
            }
        }

        return myGraph;
    }
}
