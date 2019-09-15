package org.app;

import com.app.api.PathApi;
import com.app.api.PathApiFactory;
import com.app.api.PathApiType;

public class Main {

    public static void main(String[] args) {
        int[][] data = new int[3][];
        data[0] = new int[]{1,2,3};
        data[1] = new int[]{1,2,3};
        data[2] = new int[]{1,2,3};

        PathApi pathApi = PathApiFactory.getPathApi(PathApiType.GRAPH_BULK);
        int res = pathApi.findMaxInPath(data);
        System.out.println("result = "+res);
    }
}
