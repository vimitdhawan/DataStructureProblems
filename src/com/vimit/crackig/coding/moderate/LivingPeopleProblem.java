package com.vimit.crackig.coding.moderate;

import java.util.Arrays;

public class LivingPeopleProblem {
    public static void main(String[] args) {
        int min = 1900;
        int max = 1910;
        int[] birthYears = {1900, 1901, 1902, 1903, 1903, 1904};
        int[] deathYears = {1904, 1903, 1902, 1904, 1904, 1904};

        int year = getMaxPeopleInYear(birthYears, deathYears, min, max);
        System.out.println(year);

    }

    private static int getMaxPeopleInYear(int[] birthYears, int[] deathYears, int min, int max) {
        Arrays.sort(birthYears);
        Arrays.sort(deathYears);

        int[] result = new int[max-min+1];

        int birthIndex = 0;
        int deathIndex = 0;

        int maxAlive = 0;
        int currentAlive = 0;
        int maxYear = min;

        while(birthIndex<birthYears.length){
            if(birthYears[birthIndex]<=deathYears[deathIndex]){
                currentAlive++;
                result[birthYears[birthIndex]-min] = currentAlive;
                if(currentAlive>maxAlive){
                    maxAlive = currentAlive;
                    maxYear = birthYears[birthIndex];
                }
                birthIndex++;
            } else{
                currentAlive--;
                deathIndex++;
            }
        }

        return maxYear;

    }
}
