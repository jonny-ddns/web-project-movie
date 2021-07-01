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
import mvc_movie.command.MovieCommand_list;
import mvc_movie.command.MovieCommand_spec;
import mvc_movie.command.MovieCommand_update;
import mvc_movie.command.MovieCommand_upload;

@WebServlet("*.do")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieController() {
        super();
//        System.out.println(">>MovieController.servlet");
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
		//영화 리스트 페이지 요청
		if(command.equals("list")) {
			System.out.println("MovieCommand_list 호출");
			com = new MovieCommand_list();
			com.execute(request, response);
			viewPage = "./movieList.jsp";
		}
		//영화 상세 정보 페이지 요청
		else if(command.equals("spec")) {
			System.out.println("MovieCommand_spec 호출");			
			com = new MovieCommand_spec();
			com.execute(request, response);
			viewPage = "./movieSpec.jsp";
		}
//		//영화 신규등록 페이지 요청. 혹은 영화수정 페이지 요청
//		else if(command.equals("edit")) {
//			System.out.println("MovieCommand_edit 호출");
//			com = new MovieCommand_edit();
//			com.execute(request, response);
//			viewPage = "./movieEdit.jsp";
//		}
		//영화 upload 후 영화 상세페이지 요청
		else if(command.equals("upload")) {
			System.out.println("MovieCommand_upload 호출");
			com = new MovieCommand_upload();
			com.execute(request, response);
//			int movieCode = (int) request.getAttribute("movieCode");
//			viewPage = "spec.do?movieCode="+ movieCode;
			viewPage = "./index.jsp";
//			response.sendRedirect("spec.do?movieCode="+ movieCode);
		}
		//영화 update 후 영화 상세페이지 요청
		else if(command.equals("update")) {
			System.out.println("MovieCommand_update 호출");
			com = new MovieCommand_update();
			
//			System.out.println("000");
			com.execute(request, response);
			
//			System.out.println("111");
//			int movieCode = (int) request.getAttribute("movieCode");
//			System.out.println("222");
//			viewPage = "spec.do?movieCode="+ movieCode;
		}
		//영화 내용 삭제후 영화리스트 페이지 요청
		else if(command.equals("delete")) {
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
