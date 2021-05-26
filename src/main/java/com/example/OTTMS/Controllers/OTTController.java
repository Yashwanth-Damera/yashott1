/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.OTTMS.Controllers;

import com.example.OTTMS.Models.Genre;
import com.example.OTTMS.Models.Movie;
import com.example.OTTMS.Models.OTTPlatform;
import com.example.OTTMS.Repository.GenreRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.OTTMS.Repository.MovieRepository;
import com.example.OTTMS.Repository.OTTRepositoryRepository;

/**
 *
 * @author VenkataYashwanth Damera
 */
@Controller
public class OTTController {

    ModelAndView mv = new ModelAndView();
    @Autowired
    MovieRepository MovieRepo;
    @Autowired
    OTTRepositoryRepository OTTRepo;
    @Autowired
    GenreRepository GnRepo;

    @RequestMapping("")
    public ModelAndView home() {
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("home")
    public ModelAndView home1() {
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("addMovie")
    public ModelAndView addMovie() {
        mv.setViewName("addNewMovie.html");
        Iterable<OTTPlatform> MovieList = OTTRepo.findAll();
        mv.addObject("OTTs", MovieList);
        Iterable<Genre> GnList = GnRepo.findAll();
        mv.addObject("Genres", GnList);

        return mv;

    }

    @RequestMapping("addOTT")
    public ModelAndView addOTT() {
        mv.setViewName("addNewOTT.html");
        return mv;
    }

    @RequestMapping("OTTAdded")
    public ModelAndView addNewOTT(OTTPlatform OTT) {
        OTTRepo.save(OTT);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("GenreAdded")
    public ModelAndView addNewGenre(Genre gn) {
        GnRepo.save(gn);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("addGenreType")
    public ModelAndView addGenreType() {
        mv.setViewName("addNewGenre.html");
        return mv;
    }

    @RequestMapping("addNewMovie")
    public ModelAndView addNewMovie(Movie movie, @RequestParam("OTTId") int id, Genre genre, @RequestParam("GenreId") int id1) {
        OTTPlatform OTT = OTTRepo.findById(id).orElse(new OTTPlatform());
        Genre gn = GnRepo.findById(id1).orElse(new Genre());
        movie.setOTT(OTT);
        movie.setGenre(gn);
        MovieRepo.save(movie);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("viewModifyDelete")
    public ModelAndView viewMovies() {
        Iterable<Movie> movieList = MovieRepo.findAll();
        mv.addObject("moviesList", movieList);
        mv.setViewName("viewMovies.html");
        return mv;
    }

    @RequestMapping("OTTPrice")
    public ModelAndView viewPrices() {
        mv.setViewName("priceOTT.html");
        Iterable<OTTPlatform> OTTList = OTTRepo.findAll();
        mv.addObject("OTTs", OTTList);
        return mv;
    }

    @RequestMapping("GenreType")
    public ModelAndView viewGenreTypes() {
        mv.setViewName("viewGenre.html");
        Iterable<Genre> GnList = GnRepo.findAll();
        mv.addObject("Genres", GnList);
        return mv;
    }

    @RequestMapping("editmovie")
    public ModelAndView editMovie(Movie movie) {
        MovieRepo.save(movie);
        mv.setViewName("editmovie.html");
        return mv;
    }

    @RequestMapping("cancel")
    public ModelAndView cancel() {
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("search")
    public ModelAndView searchById(int id) {
        Movie MovieFound = MovieRepo.findById(id).orElse(new Movie());
        mv.addObject(MovieFound);
        mv.setViewName("searchresult.html");
        return mv;
    }

    @RequestMapping("deletemovie")
    public ModelAndView deleteMovie(Movie movie) {
        Optional<Movie> movieFound = MovieRepo.findById(movie.getId());
        if (movieFound.isPresent()) {
            MovieRepo.delete(movie);
        }
        return home();
    }

}
