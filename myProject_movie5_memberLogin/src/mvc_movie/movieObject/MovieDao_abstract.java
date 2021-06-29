package mvc_movie.movieObject;

import java.util.List;

public abstract class MovieDao_abstract {	

	public abstract List<MovieVO> movieList();
	
	public abstract void movieInsert(MovieVO movie);
	
	public abstract MovieVO movieSearchByCode(int movieCode);
	
	public abstract void movieEdit(MovieVO movie, int movieCode);
		
	public abstract void movieDelete(int movieCode);	
}
