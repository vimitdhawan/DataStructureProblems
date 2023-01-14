package com.vimit.topal;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
    }

    public static int numberOfCarryOperations(int input1, int input2) {
        int carryCount = 0;
        int carryOver = 0;
        while(input1 > 0 || input2 > 0 ){
            int firstLastDigit = input1 % 10;
            int secondLastDigit = input2 % 10;
            int sum = carryOver + firstLastDigit + secondLastDigit;
            if(sum>9){
                carryCount++;
                carryOver = sum/10;
            }else{
                carryOver = 0;
            }
            input1 = input1/10;
            input2 = input2/10;
        }
        return carryCount;
    }
    public static String[] sensorMerge(String[] colors, String[] coordinates){
        if(colors.length == 0 && coordinates.length == 0) return new String[]{"0,0,0,0,0,0,0"};
       String[] zeroArr = new String[]{"0,0,0,0"};

        if(colors.length>0 && colors[0].split(",")[0] != "0"){
            colors = (String[]) Stream.concat(Arrays.stream(zeroArr),Arrays.stream(colors)).map(String::new).toArray();
        }
        if(coordinates.length>0 && coordinates[0].split(",")[0] != "0"){
            coordinates = (String[])Stream.concat(Arrays.stream(zeroArr),Arrays.stream(coordinates)).map(String::new).toArray();
        }
        String[] mergeData = new String[colors.length + coordinates.length];
        int colorIndex = 0;
        int coordinateIndex = 0;
        int resIndex = 0;
        int[] colorArr;
        int[] coordinateArr;
        while(colorIndex<colors.length && coordinateIndex<coordinates.length){
            colorArr = Arrays.stream(colors[colorIndex].split(",")).mapToInt(Integer::new).toArray();
            coordinateArr = Arrays.stream(coordinates[coordinateIndex].split(",")).mapToInt(Integer::new).toArray();
            if(colorArr[colorIndex]<coordinateArr[coordinateIndex]){
                String result = colorArr.toString() + coordinates[coordinateIndex-1].substring(1,4);
                mergeData[resIndex] = result;
                colorIndex++;
            } else if(colorArr[colorIndex]>coordinateArr[coordinateIndex]){
                String result = coordinates[coordinateIndex].substring(0,1)+ colors[colorIndex-1].substring(1,4) + coordinates[coordinateIndex].substring(1,4);
                mergeData[resIndex] = result;
                coordinateIndex++;
            } else {
                String result = coordinates[coordinateIndex].substring(0,1)+ colors[colorIndex].substring(1,4) + coordinates[coordinateIndex].substring(1,4);
                mergeData[resIndex] = result;
                colorIndex++;
                coordinateIndex++;
            }
            resIndex++;
        }
        while(colorIndex<colors.length){
            String result = colors[colorIndex] + coordinates[coordinateIndex-1].substring(1,4);
            mergeData[resIndex] = result;
            colorIndex++;
            resIndex++;
        }
        while(coordinateIndex<coordinates.length){
            String result = coordinates[coordinateIndex].substring(0,1)+ colors[colorIndex-1].substring(1,4) + coordinates[coordinateIndex].substring(1,4);
            mergeData[resIndex] = result;
            coordinateIndex++;
            resIndex++;
        }
        return mergeData;
    }
}


