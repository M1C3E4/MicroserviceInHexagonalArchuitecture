package com.example.demo.domain.service;

import com.example.demo.adapters.entity.MovieEntity;
import com.example.demo.ports.MovieRepository;
import com.example.demo.ports.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceMovie implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Optional<MovieEntity> pullMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public MovieEntity addMovie(MovieEntity movieEntity) {
        return movieRepository.save(movieEntity);
    }


}
