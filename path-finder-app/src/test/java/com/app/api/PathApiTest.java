package com.app.api;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PathApiTest {

    @Test
    public void recursionTest() {
        pathApiTest(PathApiType.RECURSION);
    }

    @Test
    public void graphBulkTest() {
        pathApiTest(PathApiType.GRAPH_BULK);
    }

    @Test
    public void graphSimpleTest() {
        pathApiTest(PathApiType.GRAPH_SINGLE);
    }


    private void pathApiTest(PathApiType pathApiType) {
        PathApi pathApi = PathApiFactory.getPathApi(pathApiType);

        int[][] data = new int[3][];
        data[0] = new int[]{1, 2, 3};
        data[1] = new int[]{3, 4, 5};
        data[2] = new int[]{6, 7, 8};
        int result = pathApi.findMaxInPath(data);
        assertTrue(result == 25);

        data = new int[3][];
        data[0] = new int[]{1, 2, 3};
        data[1] = new int[]{1, 2, 3};
        data[2] = new int[]{1, 2, 3};
        result = pathApi.findMaxInPath(data);
        assertTrue(result == 12);


        data = new int[3][];
        data[0] = new int[]{5, 1, 2};
        data[1] = new int[]{7, 3, 4};
        data[2] = new int[]{6, 2, 8};
        result = pathApi.findMaxInPath(data);
        assertTrue(result == 28);
    }
}
