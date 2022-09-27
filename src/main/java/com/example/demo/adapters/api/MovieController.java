package com.example.demo.adapters.api;

import com.example.demo.adapters.entity.MovieEntity;
import com.example.demo.domain.service.ServiceMovie;
import com.example.demo.ports.MovieRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MovieController {

   private MovieRepository movieRepository;
   private ServiceMovie serviceMovie;

    public MovieController(MovieRepository movieRepository, ServiceMovie serviceMovie) {
        this.movieRepository = movieRepository;
        this.serviceMovie = serviceMovie;
    }

    @GetMapping("/findById/{id}")
    public Optional<MovieEntity> movieById(@PathVariable Long id){
        return serviceMovie.pullMovieById(id);
    }

    @PostMapping("/add")
    public MovieEntity add(@RequestBody MovieEntity movieEntity){
        return serviceMovie.addMovie(movieEntity);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        MovieEntity movieEntity = new MovieEntity(1L, "psy", "kryminalny");
        addMovie(movieEntity);
    }


    public MovieEntity addMovie(MovieEntity movieEntity) {
        return movieRepository.save(movieEntity);
    }

}
