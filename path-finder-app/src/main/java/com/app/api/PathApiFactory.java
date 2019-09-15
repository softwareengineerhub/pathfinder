package com.app.api;

import com.app.api.impl.graph.impl.BulkGraphPathApi;
import com.app.api.impl.graph.impl.SingleGraphPathApi;
import com.app.api.impl.recursion.RecursionPathApi;

public class PathApiFactory {

    public static PathApi getPathApi(PathApiType pathApiType) {
        switch (pathApiType) {
            case RECURSION:
                return new RecursionPathApi();
            case GRAPH_BULK:
                return new BulkGraphPathApi();
            case GRAPH_SINGLE:
                return new SingleGraphPathApi();
            default:
                throw new RuntimeException(String.format("Incorrect PathApiType: %s", pathApiType));
        }
    }
}
