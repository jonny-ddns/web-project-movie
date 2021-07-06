package mvc_movie.movieObject;

import java.util.Date;

public class MovieVO {

	private int movieCode;
	private String title;
	private String director;
	private String actors;
	private String genre;
	private String content;
	private int runningTime;
	private String rating;
	private int score;
	private String moviePoster;
	private Date registerDate;
	private String isActive;	
	
	public int getMovieCode() {
		return movieCode;
	}
	public MovieVO setMovieCode(int movieCode) {
		this.movieCode = movieCode;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public MovieVO setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getDirector() {
		return director;
	}
	public MovieVO setDirector(String director) {
		this.director = director;
		return this;
	}
	public String getActors() {
		return actors;
	}
	public MovieVO setActors(String actors) {
		this.actors = actors;
		return this;
	}
	public String getGenre() {
		return genre;
	}
	public MovieVO setGenre(String genre) {
		this.genre = genre;
		return this;
	}
	public String getContent() {
		return content;
	}
	public MovieVO setContent(String content) {
		this.content = content;
		return this;
	}
	public int getRunningTime() {
		return runningTime;
	}
	public MovieVO setRunningTime(int runningTime) {
		this.runningTime = runningTime;
		return this;
	}
	public String getRating() {
		return rating;
	}
	public MovieVO setRating(String rating) {
		this.rating = rating;
		return this;
	}
	public int getScore() {
		return score;
	}
	public MovieVO setScore(int score) {
		this.score = score;
		return this;
	}
	public String getMoviePoster() {
		return moviePoster;
	}
	public MovieVO setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
		return this;
	}	
	public Date getRegisterDate() {
		return registerDate;
	}
	public MovieVO setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
		return this;
	}
	public String getIsActive() {
		return isActive;
	}
	public MovieVO setIsActive(String isActive) {
		this.isActive = isActive;
		return this;
	}	
}