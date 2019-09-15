package com.app.api.impl.graph.finder;

import com.app.api.impl.graph.common.Coordinate;
import com.app.api.impl.graph.common.MaxPath;
import com.app.api.impl.graph.common.MyGraph;
import com.app.api.impl.graph.common.MyGraphHelper;

import java.util.List;
import java.util.Stack;

public class FindMaxPath {

    private MaxPath maxPath;


    public MaxPath findMaxPath(MyGraph myGraph) {
        findMaxPath(myGraph, 0, myGraph.getVerticesCount() - 1, new Stack());
        return maxPath;
    }

    private void findMaxPath(MyGraph myGraph, int source, int target, Stack<Integer> stack) {
        stack.push(source);
        List<Coordinate> list = myGraph.getItems(source);

        if (source == target) {
            Stack<Integer> currentPath = new Stack<>();
            for (int i : stack) {
                currentPath.push(i);
            }
            if (maxPath == null) {
                maxPath = new MaxPath();
                MyGraphHelper.initMaxPath(maxPath, currentPath, myGraph);
            } else {
                MaxPath tmp = new MaxPath();
                MyGraphHelper.initMaxPath(tmp, currentPath, myGraph);
                int compareResult = maxPath.compareTo(tmp);
                if (compareResult < 0) {
                    maxPath = tmp;
                }
            }
            stack.pop();
            return;
        }

        if (list != null) {
            for (Coordinate c : list) {
                findMaxPath(myGraph, c.getId(), target, stack);
            }
        }

        stack.pop();
    }


}
