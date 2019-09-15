package com.app.api.impl.graph.impl;

import com.app.api.PathApi;
import com.app.api.impl.graph.common.MaxPath;
import com.app.api.impl.graph.common.MyGraph;
import com.app.api.impl.graph.common.MyGraphHelper;
import com.app.api.impl.graph.finder.FindMaxPath;

public class SingleGraphPathApi extends AbstractGraphApi implements PathApi {

    @Override
    public int findMaxInPath(int[][] path) {
        int verticesCount = super.itemsCount(path);
        MyGraph myGraph = MyGraphHelper.createGraph(path, verticesCount);
        myGraph.printMyGraph();

        FindMaxPath findMaxPath = new FindMaxPath();
        MaxPath maxPath = findMaxPath.findMaxPath(myGraph);
        System.out.println(maxPath);

        return maxPath.getValue();
    }


}
