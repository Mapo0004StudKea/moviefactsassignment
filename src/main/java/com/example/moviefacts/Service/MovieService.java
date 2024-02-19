package com.example.moviefacts.Service;

import com.example.moviefacts.model.Movie;
import com.example.moviefacts.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getTenSortByPopularity() {
        List<Movie> movieList = movieRepository.findAll();
        List<Movie> randomMovies = getRandomMovies(movieList, 10);

        Collections.sort(randomMovies);

        return randomMovies;
    }

    private List<Movie> getRandomMovies(List<Movie> movieList, int count) {
        List<Movie> randomMovies = new ArrayList<>();
        int size = movieList.size();
        Random random = new Random();

        count = Math.min(count, size);

        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(size);
            randomMovies.add(movieList.get(randomIndex));
        }

        return randomMovies;
    }

    public Movie getRandoms() {
        List<Movie> movieList = movieRepository.findAll();
        int size = movieList.size();
        Random random = new Random();
        int ran = random.nextInt(size);
        return movieList.get(ran);
    }
    public long countMoviesWithAward() {
        return movieRepository.countMoviesWithAward();
    }

    public List<Movie> findAllSort() {
        List<Movie> listMovie = movieRepository.findAll();
        Collections.sort(listMovie);
        return listMovie;
    }
}
