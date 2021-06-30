package mvc_movie.movieObject;

import java.util.List;

public abstract class MovieDao_abstract {	

	public abstract List<MovieVO> movieList();
	
	public abstract MovieVO movieSearchByCode(int movieCode);
	
	public abstract void movieUpload(MovieVO movie);
	
	public abstract void movieUpdate(MovieVO movie, int movieCode);
		
	public abstract void movieDelete(int movieCode);	
}
