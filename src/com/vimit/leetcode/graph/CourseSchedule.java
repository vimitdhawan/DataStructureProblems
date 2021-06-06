package com.vimit.leetcode.graph;

import java.util.*;
public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule cs =  new CourseSchedule();
        int[][] arr = new int[][]{{1, 0}, {1,2}, {0, 1}};
        System.out.print(cs.canFinish(3, arr));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
       Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i =0; i<prerequisites.length; i++){
            int start = prerequisites[i][0];
            int end  = prerequisites[i][1];
            if(map.containsKey(start)){
                List<Integer> list =  map.get(start);
                list.add(end);
            } else{
                List<Integer> list = new ArrayList<>();
                list.add(end);
                map.put(start, list);
            }

        }
        boolean[] visited = new boolean[numCourses+1];
        boolean[] recursive = new boolean[numCourses];
        for(int j : map.keySet()){
            if(!visited[j]){
                findCycles(numCourses, map, visited, recursive, j);
                if(visited[numCourses]){
                    return false;
                }
            }
        }
        return true;

    }

    public void findCycles(int numCourses,   Map<Integer, List<Integer>> map , boolean[] visited, boolean[] recursive, int index){
        visited[index] = true;
        recursive[index] = true;
        if(!visited[numCourses] && map.containsKey(index)){
            List<Integer> neighbours = map.get(index);
            for(int j =0; j<neighbours.size(); j++) {
                int elem = neighbours.get(j);
                if(recursive[elem]){
                    visited[numCourses] = true;
                }
                if(!visited[elem]){
                    findCycles(numCourses, map,visited, recursive, elem);
                }
            }

        }
        recursive[index] = false;

    }

}
