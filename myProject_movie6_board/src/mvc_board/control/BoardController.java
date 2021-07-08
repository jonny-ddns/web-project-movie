package mvc_board.control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc_board.command.BoardCommand;
import mvc_board.command.BoardCommand_delete;
import mvc_board.command.BoardCommand_list;
import mvc_board.command.BoardCommand_read;
import mvc_board.command.BoardCommand_search;
import mvc_board.command.BoardCommand_update;
import mvc_board.command.BoardCommand_upload;

@WebServlet("*.co")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	public BoardController() {
    	 System.out.println(">>boardController()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionCo(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionCo(request, response);
	}
	
	private void actionCo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>actionCo()");
		
		BoardCommand com	= null;
		String command		= "";
		String viewPage		= "";		
		
		/*
		 * 이동할 path 생성하기
		 * getRequestURI 로 가져온 값에서 '/'과 '.' 사이의 단어 추출하기
		 */
		String uri = request.getRequestURI();
		System.out.println("getRequestURI : "+ uri);
		command = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));		
		System.out.println("command : "+ command);		
		
		//경로 설정
		if(command.equals("list")) {
			System.out.println("BoardCommand_list 호출");
			com = new BoardCommand_list();
			com.execute(request, response);						
			//디버깅
			if(request.getAttribute("boardList") == null) {
				System.out.println("[error] parameter boardList is null");
			}			
			viewPage = "./boardList.jsp";
		}
		else if(command.equals("search")) {
			System.out.println("BoardCommand_search 호출");
			com = new BoardCommand_search();
			com.execute(request, response);
			viewPage = "./temp.jsp";
		}
		else if(command.equals("read")) {
			System.out.println("BoardCommand_read 호출");
			com = new BoardCommand_read();
			com.execute(request, response);
			viewPage = "./temp.jsp";
		}
		else if(command.equals("upload")) {
			System.out.println("BoardCommand_read 호출");
			com = new BoardCommand_upload();
			com.execute(request, response);
			viewPage = "./temp.jsp";
		}
		else if(command.equals("update")) {
			System.out.println("BoardCommand_update 호출");
			com = new BoardCommand_update();
			com.execute(request, response);
			viewPage = "./temp.jsp";
		}
		else if(command.equals("delete")) {
			System.out.println("BoardCommand_delete 호출");
			com = new BoardCommand_delete();
			com.execute(request, response);
			viewPage = "./temp.jsp";
		}
		else {
			System.out.println("--error : 요청정보를 찾지못함");
			viewPage = "./temp.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

}
