package com.vimit.graph;

import java.util.*;
public class KruskalMinCost {
    public static void main(String[] args) {
        Map<Integer, List<Point>> map = new HashMap<>();
        KruskalMinCost km = new KruskalMinCost();
        km.minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}});
    }
    public int minCostConnectPoints(int[][] points) {
        int[] parents = new int[points.length];
        PriorityQueue<Point> pq = new PriorityQueue<>((Point a, Point b) -> a.distance - b.distance);
        Arrays.setAll(parents, i -> i);
        int minDist = 0;
        for(int i =0; i<points.length; i++){
            for(int j = i+1; j<points.length; j++){
                pq.offer(new Point(i, j, getDistance(points[i], points[j])));
            }
        }
        while(!pq.isEmpty()){
            Point curr = pq.poll();
            if(union(curr.x, curr.y, parents)){
                minDist =  minDist + curr.distance;
            }
        }
        return minDist;

    }

    public int find(int value, int[] parents){
        if(value != parents[value]){
            parents[value] = find(parents[value], parents);
        }
        return parents[value];
    }

    public boolean union(int a, int b, int[] parents){
        int rootA = parents[a];
        int rootB = parents[b];
        if(rootA == rootB){
            return false;
        }
        parents[rootA] = rootB;
        return true;
    }



    public int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}


class Point {
    int x;
    int y;
    int distance;
    Point(int x, int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

