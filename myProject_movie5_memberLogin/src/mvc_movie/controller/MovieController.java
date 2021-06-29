package mvc_movie.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc_movie.command.MovieCommand;
import mvc_movie.command.MovieCommand_delete;
import mvc_movie.command.MovieCommand_edit;
import mvc_movie.command.MovieCommand_list;
import mvc_movie.command.MovieCommand_spec;
import mvc_movie.command.MovieCommand_update;
import mvc_movie.command.MovieCommand_upload;

@WebServlet("*.do")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieController() {
        super();
        System.out.println(">>MovieController.servlet");
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("init()");
    	super.init();
    }
	@Override
	public void destroy() {
		System.out.println("destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("\n>>doGet()");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("\n>>doPost()");
		actionDo(request, response);
	}
		
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("actionDo()");
		MovieCommand com	= null;
		String command		= "";
		String viewPage		= "";		
		
		//controller에서 거를 .do 페이지
		String movieList = "list";
		String movieSpec = "spec";
		String movieEdit = "edit";
		String movieUpload = "upload";
		String movieUpdate = "update";
		String movieDelete = "delete";	
		
		//연결할 단어를 url에서 추출하는 절차 
		String uri = null;
		String contextPath;
		
		uri = request.getRequestURI();
//		System.out.println("getRequestURI : "+ uri);		
		
		contextPath = request.getContextPath();
//		System.out.println("getContextPath : "+ contextPath);
		
		command = uri.substring(contextPath.length()+1, uri.length()-3);
		System.out.println("command : "+ command);		
		
		//MovieCommand 구현체 호출해서 연결하기
		if(command.equals(movieList)) {
			System.out.println("MovieCommand_list 호출");
			com = new MovieCommand_list();
			com.execute(request, response);
			viewPage = "./movieList.jsp";
		}
		else if(command.equals(movieSpec)) {
			System.out.println("MovieCommand_spec 호출");			
			com = new MovieCommand_spec();
			com.execute(request, response);
			viewPage = "./movieSpec.jsp";
		}
		else if(command.equals(movieEdit)) {
			System.out.println("MovieCommand_edit 호출");
			com = new MovieCommand_edit();
			com.execute(request, response);
			viewPage = "./movieEdit.jsp";
		}		
		else if(command.equals(movieUpload)) {
			System.out.println("MovieCommand_upload 호출");
			com = new MovieCommand_upload();
			com.execute(request, response);
			int movieCode = (int) request.getAttribute("movieCode");
			viewPage = "spec.do?movieCode="+ movieCode;
		}
		else if(command.equals(movieUpdate)) {
			System.out.println("MovieCommand_update 호출");
			com = new MovieCommand_update();
			com.execute(request, response);
			int movieCode = (int) request.getAttribute("movieCode");
			viewPage = "spec.do?movieCode="+ movieCode;
		}
		else if(command.equals(movieDelete)) {
			System.out.println("MovieCommand_delete 호출");
			com = new MovieCommand_delete();
			com.execute(request, response);
			viewPage = "./index.jsp";
		}
		//페이지를 찾지 못함
		else {
			System.out.println("--error : 요청정보를 찾지못함");
			viewPage = "./index.jsp";
		}				
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}
}
