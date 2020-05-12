package com.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Movie;
import com.service.IMovieService;

@Service
public class MovieServiceImp implements IMovieService{


	@Override
	public Movie findMovieById(long movie_id) {
		return null;
	}

	@Override
	public Movie findMovieByName(String movie_cn_name) {
		return null;
	}

	@Override
	public Integer addMovie(Movie movie) {
		return null;
	}

	@Override
	public Integer deleteMovie(long movie_id) {
		return null;
	}

	@Override
	public Integer updateMovie(Movie movie) {
		return null;
	}

	@Override
	public Integer delCommentCount(long movie_id) {
		return null;
	}

	@Override
	public Integer changeMovieBoxOffice(float price, long movie_id) {
		return null;
	}

	@Override
	public Integer addCommentCount(long movie_id) {
		return null;
	}

	@Override
	public List<Movie> findAllMovies(int movie_state) {
		return null;
	}

	@Override
	public List<Movie> findMoviesLikeName(String name) {
		return null;
	}

	@Override
	public List<Movie> findMoviesLikeType(String type) {
		return null;
	}

	@Override
	public List<Movie> sortMovieByDate() {
		return null;
	}

	@Override
	public List<Movie> sortMovieByCount() {
		return null;
	}

	@Override
	public List<Movie> sortMovieByScore() {
		return null;
	}

	@Override
	public List<Movie> sortMovieByBoxOffice() {
		return null;
	}
}
