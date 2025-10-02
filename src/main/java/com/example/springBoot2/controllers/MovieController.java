package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Movie;
import com.example.springBoot2.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> getAllItems() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getItem( @PathVariable int id ) {
        return movieRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Movie getItem( @RequestBody Movie movie ) {
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}")
    public Movie updateItem( @PathVariable int id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    public Movie deleteItem( @PathVariable int id ) {
        Movie reportMovie = movieRepository.findById(id).orElse(null);
        movieRepository.deleteById(id);
        return reportMovie;
    }
}
