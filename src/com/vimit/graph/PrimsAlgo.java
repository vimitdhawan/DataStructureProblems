package com.vimit.graph;
import java.util.*;

class PrimsAlgo {
    private static class Point {
        int index;
        int distance;
        Point(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
    }
    public static void main(String[] args) {
        PrimsAlgo pa = new PrimsAlgo();
        System.out.println(pa.minCostConnectPoints(new int[][]{{1,2}, {3,4}}));
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Point> pq = new PriorityQueue<>((Point a, Point b) -> a.distance-b.distance);
        boolean[] processed = new boolean[points.length];
        int[] distances = new int[points.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        int minCost = 0;
        pq.offer(new Point(0,0));
        processed[0] = true;
        while(!pq.isEmpty()){
            Point currentPoint = pq.poll();
            if(!processed[currentPoint.index]){
                minCost = minCost + currentPoint.distance;
                processed[currentPoint.index] = true;
                for(int i =0; i<points.length; i++){
                    if(!processed[i]){
                        int distance = getDistance(points[currentPoint.index],points[i]);
                        if(distances[i]>distance){
                            distances[i] = distance;
                            pq.offer(new Point(i, distance));
                        }

                    }
                }
            }
        }

        return minCost;


    }

    public int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}


