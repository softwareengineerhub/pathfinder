package com.app.api.impl.graph.impl;

import com.app.api.PathApi;
import com.app.api.impl.graph.common.MaxPath;
import com.app.api.impl.graph.common.MyGraph;
import com.app.api.impl.graph.common.MyGraphHelper;
import com.app.api.impl.graph.finder.FindAllPathes;

import java.util.List;
import java.util.Stack;

public class BulkGraphPathApi extends AbstractGraphApi implements PathApi {

    @Override
    public int findMaxInPath(int[][] path) {
        int verticesCount = super.itemsCount(path);
        MyGraph myGraph = MyGraphHelper.createGraph(path, verticesCount);
        myGraph.printMyGraph();

        FindAllPathes findAllPathes = new FindAllPathes();
        List<Stack<Integer>> list = findAllPathes.findAllPathes(myGraph);
        System.out.println("-----------------All Pathes-------------------");
        for (Stack<Integer> stack : list) {
            System.out.println(stack);
        }
        System.out.println("-----------------Max-------------------");

        MaxPath maxPath = MyGraphHelper.calculateMaxPath(list, myGraph);
        System.out.println(maxPath);

        return maxPath.getValue();
    }
}
