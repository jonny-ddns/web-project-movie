package mvc.db.dto;

import java.util.Date;

public class DtoMovie {
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
	public DtoMovie setMovieCode(int movieCode) {
		this.movieCode = movieCode;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public DtoMovie setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getDirector() {
		return director;
	}
	public DtoMovie setDirector(String director) {
		this.director = director;
		return this;
	}
	public String getActors() {
		return actors;
	}
	public DtoMovie setActors(String actors) {
		this.actors = actors;
		return this;
	}
	public String getGenre() {
		return genre;
	}
	public DtoMovie setGenre(String genre) {
		this.genre = genre;
		return this;
	}
	public String getContent() {
		return content;
	}
	public DtoMovie setContent(String content) {
		this.content = content;
		return this;
	}
	public int getRunningTime() {
		return runningTime;
	}
	public DtoMovie setRunningTime(int runningTime) {
		this.runningTime = runningTime;
		return this;
	}
	public String getRating() {
		return rating;
	}
	public DtoMovie setRating(String rating) {
		this.rating = rating;
		return this;
	}
	public int getScore() {
		return score;
	}
	public DtoMovie setScore(int score) {
		this.score = score;
		return this;
	}
	public String getMoviePoster() {
		return moviePoster;
	}
	public DtoMovie setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
		return this;
	}	
	public Date getRegisterDate() {
		return registerDate;
	}
	public DtoMovie setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
		return this;
	}
	public String getIsActive() {
		return isActive;
	}
	public DtoMovie setIsActive(String isActive) {
		this.isActive = isActive;
		return this;
	}
}