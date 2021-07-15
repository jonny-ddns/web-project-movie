package mvc.command.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MovieCommand {
	void execute(HttpServletRequest request, HttpServletResponse response);	
}