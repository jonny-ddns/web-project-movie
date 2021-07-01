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
		
		//������ �ܾ url���� �����ϴ� ���� 
		String uri = null;
		String contextPath;
		
		uri = request.getRequestURI();
//		System.out.println("getRequestURI : "+ uri);		
		
		contextPath = request.getContextPath();
//		System.out.println("getContextPath : "+ contextPath);
		
		command = uri.substring(contextPath.length()+1, uri.length()-3);
		System.out.println("command : "+ command);		
		
		//MovieCommand ����ü ȣ���ؼ� �����ϱ�
		//��ȭ ����Ʈ ������ ��û
		if(command.equals("list")) {
			System.out.println("MovieCommand_list ȣ��");
			com = new MovieCommand_list();
			com.execute(request, response);
			viewPage = "./movieList.jsp";
		}
		//��ȭ �� ���� ������ ��û
		else if(command.equals("spec")) {
			System.out.println("MovieCommand_spec ȣ��");			
			com = new MovieCommand_spec();
			com.execute(request, response);
			viewPage = "./movieSpec.jsp";
		}
//		//��ȭ �űԵ�� ������ ��û. Ȥ�� ��ȭ���� ������ ��û
//		else if(command.equals("edit")) {
//			System.out.println("MovieCommand_edit ȣ��");
//			com = new MovieCommand_edit();
//			com.execute(request, response);
//			viewPage = "./movieEdit.jsp";
//		}
		//��ȭ upload �� ��ȭ �������� ��û
		else if(command.equals("upload")) {
			System.out.println("MovieCommand_upload ȣ��");
			com = new MovieCommand_upload();
			com.execute(request, response);
//			int movieCode = (int) request.getAttribute("movieCode");
//			viewPage = "spec.do?movieCode="+ movieCode;
			viewPage = "./index.jsp";
//			response.sendRedirect("spec.do?movieCode="+ movieCode);
		}
		//��ȭ update �� ��ȭ �������� ��û
		else if(command.equals("update")) {
			System.out.println("MovieCommand_update ȣ��");
			com = new MovieCommand_update();
			
//			System.out.println("000");
			com.execute(request, response);
			
//			System.out.println("111");
//			int movieCode = (int) request.getAttribute("movieCode");
//			System.out.println("222");
//			viewPage = "spec.do?movieCode="+ movieCode;
		}
		//��ȭ ���� ������ ��ȭ����Ʈ ������ ��û
		else if(command.equals("delete")) {
			System.out.println("MovieCommand_delete ȣ��");
			com = new MovieCommand_delete();
			com.execute(request, response);
			viewPage = "./index.jsp";
		}
		//�������� ã�� ����
		else {
			System.out.println("--error : ��û������ ã������");
			viewPage = "./index.jsp";
		}				
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}
}
