package com.vimit.interview.Line;

import java.util.*;
public class ServerRunningProblem {
    public static void main(String[] args) {
        ServerRunningProblem sr = new ServerRunningProblem();
        sr.solution(4, new String[]{""});
    }

    public String solution(int t, String[] logs) {
        Set<String> runningProcessors = new HashSet<>();
        final String Running = "running";
        final String Waiting = "waiting";
        for(int i =0; i< logs.length; i++){
            String[] logsDetail = logs[i].split("\\s+");
            if(logsDetail.length>=3){
                int logTime = Integer.parseInt(logsDetail[0]);
                if(logTime<=t){
                    if(logsDetail[2].equals(Running)){
                        runningProcessors.add(logsDetail[1]);
                    }else if(logsDetail[2].equals(Waiting)){
                        runningProcessors.remove(logsDetail[1]);
                    }
                } else{
                    break;
                }
            }
        }
        if(runningProcessors.size()==1) return runningProcessors.stream().findFirst().get();
        else return "-1";
    }
}
