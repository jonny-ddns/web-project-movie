package mvc.db;

public class MovieDto {

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
	
	public int getMovieCode() {
		return movieCode;
	}
	public MovieDto setMovieCode(int movieCode) {
		this.movieCode = movieCode;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public MovieDto setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getDirector() {
		return director;
	}
	public MovieDto setDirector(String director) {
		this.director = director;
		return this;
	}
	public String getActors() {
		return actors;
	}
	public MovieDto setActors(String actors) {
		this.actors = actors;
		return this;
	}
	public String getGenre() {
		return genre;
	}
	public MovieDto setGenre(String genre) {
		this.genre = genre;
		return this;
	}
	public String getContent() {
		return content;
	}
	public MovieDto setContent(String content) {
		this.content = content;
		return this;
	}
	public int getRunningTime() {
		return runningTime;
	}
	public MovieDto setRunningTime(int runningTime) {
		this.runningTime = runningTime;
		return this;
	}
	public String getRating() {
		return rating;
	}
	public MovieDto setRating(String rating) {
		this.rating = rating;
		return this;
	}
	public int getScore() {
		return score;
	}
	public MovieDto setScore(int score) {
		this.score = score;
		return this;
	}
	public String getMoviePoster() {
		return moviePoster;
	}
	public MovieDto setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
		return this;
	}
}