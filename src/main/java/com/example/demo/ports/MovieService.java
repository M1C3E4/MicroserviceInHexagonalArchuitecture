package com.example.demo.ports;

import com.example.demo.adapters.entity.MovieEntity;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Optional<MovieEntity> pullMovieById(Long id);
    List<MovieEntity> pullAllMovies();
}
