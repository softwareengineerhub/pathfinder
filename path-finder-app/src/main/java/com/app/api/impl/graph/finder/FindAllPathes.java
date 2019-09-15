package com.app.api.impl.graph.finder;

import com.app.api.impl.graph.common.Coordinate;
import com.app.api.impl.graph.common.MyGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindAllPathes {
    private List<Stack<Integer>> pathList = new ArrayList<>();

    private void findAllPathes(MyGraph myGraph, int source, int target, Stack<Integer> stack) {
        stack.push(source);
        List<Coordinate> list = myGraph.getItems(source);

        if (source == target) {
            Stack<Integer> currentPath = new Stack<>();
            for (int i : stack) {
                currentPath.push(i);
            }
            pathList.add(currentPath);
            stack.pop();
            return;
        }

        if (list != null) {
            for (Coordinate c : list) {
                findAllPathes(myGraph, c.getId(), target, stack);
            }
        }

        stack.pop();
    }


    public List<Stack<Integer>> findAllPathes(MyGraph myGraph) {
        findAllPathes(myGraph, 0, myGraph.getVerticesCount() - 1, new Stack());
        return pathList;
    }
}
