package com.example.moviefacts.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.example.moviefacts.model.Movie;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
    //læse movies

    public List<Movie> findAll() {
        List<Movie> movieList = new ArrayList<>();
        try {
            //findAll

            File file = new ClassPathResource("imdb-data.csv").getFile();
            Scanner input = new Scanner(file);
            //skip header
            input.nextLine();
            while (input.hasNextLine()){
                //her skal den enkelte linie behandles og movies oprettes
                Scanner lineScanner = new Scanner(input.nextLine()).useDelimiter(";");
                Movie movie = new Movie();
                //set et field ad gangen fra lineScanner
                //Year;Length;Title;Subject;Popularity;Awards
                movie.setYear(lineScanner.nextInt());
                movie.setLength(lineScanner.nextInt());
                movie.setTitle(lineScanner.next());
                movie.setSubject(lineScanner.next());
                movie.setPopularity(lineScanner.nextInt());
                //konverter Awards til boolean
                boolean result = lineScanner.next().equals("Yes");
                movie.setAwards(result);

                movieList.add(movie);

                //men vi skriver bare ud...
                System.out.println(movie);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
        //her skal returneres movies
        return movieList;
    }

    public Movie getFirst(){

        Movie movie = new Movie();

        //hent en film
        try {
            File file = new ClassPathResource("imdb-data.csv").getFile();

            Scanner input = new Scanner(file);
            //smid tabel header væk
            input.nextLine();

            //læs første film
            Scanner lineScanner = new Scanner(input.nextLine()).useDelimiter(";");

            //set et field ad gangen fra lineScanner
            //Year;Length;Title;Subject;Popularity;Awards
            movie.setYear(lineScanner.nextInt());
            movie.setLength(lineScanner.nextInt());
            movie.setTitle(lineScanner.next());
            movie.setSubject(lineScanner.next());
            movie.setPopularity(lineScanner.nextInt());
            //konverter Awards til boolean
            boolean result = lineScanner.next().equals("Yes");
            movie.setAwards(result);

        }catch(FileNotFoundException e){
            System.out.println("File not found: " + e);
        }
        catch(IOException e){
            System.out.println("IO exception: " + e);
        }
        return movie;

    }

}
