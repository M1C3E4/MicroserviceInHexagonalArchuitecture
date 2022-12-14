package com.example.demo.ports;

import com.example.demo.adapters.entity.MovieEntity;
import java.util.Optional;

public interface MovieService {
    Optional<MovieEntity> pullMovieById(Long id);
    MovieEntity addMovie(MovieEntity movieEntity);
}
