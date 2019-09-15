package com.app.api.impl.recursion;


import com.app.api.PathApi;

public class RecursionPathApi implements PathApi {
    private boolean needToLog;

    public RecursionPathApi() {
        needToLog = Boolean.parseBoolean(System.getProperty("need.to.log", "true"));
    }


    public int findMaxInPath(int[][] path) {
        return calculate(path, 0, 0, "");
    }


    private int calculate(int[][] path, int i, int j, String str) {
        if (needToLog) {
            System.out.println(str + "-----------------" + i + " ; " + j);
        }
        if (i >= path.length) {
            return 0;
        }
        if (j >= path[i].length) {
            return 0;
        }
        int a = calculate(path, i + 1, j, str + "\t");
        int b = calculate(path, i, j + 1, str + "\t");
        int res = Math.max(a, b);
        if (needToLog) {
            System.out.println(str + "res=" + res);
            System.out.println(str + "-----------------");
        }
        return res + path[i][j];
    }


}
