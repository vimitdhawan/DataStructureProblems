package com.vimit.segmenttree;

public class RangeModule {
    private boolean[] segmentTree;
    public RangeModule() {
        int size = 2 * (int)Math.pow(10, 9);
        segmentTree = new boolean[size-1];
    }

    public void addRange(int left, int right) {


    }

    public boolean queryRange(int left, int right) {
         return false;
    }

    public void removeRange(int left, int right) {

    }
}
