package com.vimit.leetcode.design.movierentalsystem;

import  java.util.*;
import java.util.stream.Collectors;

public class MovieRentingSystem {

    private Map<Integer, Map<Integer, Movie>> movies;
    private Map<Integer, Map<Integer, Movie>> rentedMovies;

    public MovieRentingSystem(int n, int[][] entries) {
         movies = new HashMap<>();
        rentedMovies = new HashMap<>();
         for(int i = 0; i<entries.length; i++) {
             int[] entry =  entries[i];
              int shopId = entry[0];
              int movieId = entry[1];
              int price = entry[2];
              Movie movie = new Movie(movieId,  shopId, price);
             Map<Integer, Movie> shops = new HashMap<>();
              if(movies.containsKey(movieId)){
                  shops  = movies.get(movieId);
              }
             shops.put(shopId, movie);
             movies.put(movieId, shops);
        }
    }

    public List<Integer> search(int movie) {
        if(movies.containsKey(movie)) {
            return movies.get(movie).values().stream().sorted().filter(m -> !m.isRented).map(m -> m.shopId).limit(5).collect(Collectors.toList());
        }
       return new ArrayList<>();
    }

    public void rent(int shop, int movie) {
        if(movies.containsKey(movie) && movies.get(movie).containsKey(shop)){
            Movie mov = movies.get(movie).get(shop);
            mov.isRented = true;
            Map<Integer, Movie> shops = rentedMovies.get(movie);
            if(shops!=null){
                shops.put(shop, mov);
            }
            rentedMovies.put(movie, shops);
        }

    }

    public void drop(int shop, int movie) {
        if(movies.containsKey(movie) && movies.get(movie).containsKey(shop)){
            Movie mov = movies.get(movie).get(shop);
            mov.isRented = false;
            Map<Integer, Movie> shops = rentedMovies.get(movie);
            if(shops!=null){
                shops.remove(shop);
            }
        }

    }

    public List<List<Integer>> report() {
        List<Movie> movs = rentedMovies.entrySet().stream()
                .flatMap(s-> s.getValue().entrySet().stream())
                .map(Map.Entry::getValue).sorted().filter(m -> !m.isRented).limit(5)
                .collect(Collectors.toList());
        List<List<Integer>> reportedList = new ArrayList<>();
        for(Movie mov : movs){
            reportedList.add(Arrays.asList(mov.shopId, mov.movieId));
        }
        return reportedList;
    }
}

class Movie implements Comparable<Movie>{
    int  movieId;
    int  shopId;
    int  price;
    boolean isRented;
    Movie(int movieId,int shopId,int price){
        this.movieId = movieId;
        this.price  = price;
        this.shopId = shopId;
        isRented  = false;
    }


    @Override
    public int compareTo(Movie o) {
        if(this.price - o.price == 0){
            if(this.shopId - o.shopId == 0){
                return this.movieId - o.movieId;
            }
            return this.shopId - o.shopId;
        }
        return this.price - o.price ;
    }
}
