package com.example.moviefacts.controller;

import com.example.moviefacts.model.Movie;
import com.example.moviefacts.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/")
    public String index(){
        return "/findall returnerer alle film<br>"
                +"/getfirst returnerer første film<br>"
                +"/getRandom returnerer en tilfældig film<br>"
                +"/getTenSortByPopularity<br>"
                +"/howManyWonAnAward<br>"
                +"/filter?char=’x’amount=’n’<br>"
                +" /longest?g1=’x’g2=’y’";
    }

    @GetMapping("/findall")
    public List<Movie> findall(){
        return movieRepository.findAll();
    }

    //bør være service
    @GetMapping("/getfirst")
    public String getFirst(){
        return movieRepository.getFirst().toString();
    }

    //bør være service
    @GetMapping("/getrandom")
    public Movie getRandom() {
        List<Movie> movieList = movieRepository.findAll();
        int size = movieList.size();
        Random random = new Random();
        int ran = random.nextInt(size);
        return movieList.get(ran);
    }
}
