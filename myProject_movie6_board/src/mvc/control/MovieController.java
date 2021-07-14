package mvc.control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.movie.MovieCommand;
import mvc.command.movie.MovieCommand_delete;
import mvc.command.movie.MovieCommand_edit;
import mvc.command.movie.MovieCommand_list;
import mvc.command.movie.MovieCommand_spec;
import mvc.command.movie.MovieCommand_update;
import mvc.command.movie.MovieCommand_upload;

@WebServlet("*.do")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
		
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieCommand com	= null;
		String command		= "";
		String viewPage		= "";	
		
		//연결할 단어를 url에서 추출하는 절차 
		String uri = request.getRequestURI();
		System.out.println("getRequestURI : "+ uri);
		command = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));		
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
		//영화 영화수정 페이지 요청
		else if(command.equals("edit")) {
			System.out.println("MovieCommand_edit 호출");
			com = new MovieCommand_edit();
			com.execute(request, response);
			String movieCode = request.getParameter("movieCode");
			viewPage = "./movieForm_edit.jsp?movieCode="+ movieCode;
		}
		//영화 upload 후 영화 상세페이지 요청
		else if(command.equals("upload")) {
			System.out.println("MovieCommand_upload 호출");
			com = new MovieCommand_upload();
			com.execute(request, response);
			int movieCode = (int) request.getAttribute("movieCode");
			viewPage = "spec.do?movieCode="+ movieCode;
			viewPage = "./movieForm_result.jsp?movieCode="+ movieCode;
		}
		//영화 update 후 영화 상세페이지 요청
		else if(command.equals("update")) {
			System.out.println("MovieCommand_update 호출");
			com = new MovieCommand_update();
			com.execute(request, response);
			int movieCode = (int) request.getAttribute("movieCode");

			viewPage = "./movieForm_result.jsp?movieCode="+ movieCode;
			System.out.println("--실행완료");
		}
		//영화 내용 삭제후 영화리스트 페이지 요청
		else if(command.equals("delete")) {
			System.out.println("MovieCommand_delete 호출");
			com = new MovieCommand_delete();
			com.execute(request, response);
			//viewPage = request.getContextPath()+ "/movie/temp.jsp";
			viewPage = "../index.jsp";
		}
		//페이지를 찾지 못함
		else {
			System.out.println("[error] 요청정보를 찾지못함");
			viewPage = request.getContextPath()+ "/index.jsp";
		}				
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}
}
