package com.vimit.crackig.coding.moderate;

import java.util.Arrays;

public class LivingPeopleProblem {
    public static void main(String[] args) {
        int[] birthYears = {1900, 1901, 1902, 1903, 1903, 1904};
        int[] deathYears = {1904, 1903, 1902, 1904, 1904, 1904};

        int year = getMaxPeopleInYear(birthYears, deathYears);
        System.out.println(year);

    }

    private static int getMaxPeopleInYear(int[] birthYears, int[] deathYears) {
        Arrays.sort(birthYears);
        Arrays.sort(deathYears);

        int birthIndex = 0;
        int deathIndex = 0;

        int maxAlive = 0;
        int currentAlive = 0;
        int maxYear = birthYears[0];

        while(birthIndex<birthYears.length){
            if(birthYears[birthIndex]<=deathYears[deathIndex]){
                currentAlive++;
                if(currentAlive>maxAlive){
                    maxAlive = currentAlive;
                    maxYear = birthYears[birthIndex];
                }
                birthIndex++;
            } else{
                currentAlive--; // death happen
                deathIndex++;
            }
        }

        return maxYear;

    }
}
