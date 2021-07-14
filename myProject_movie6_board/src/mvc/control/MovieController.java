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
		
		//������ �ܾ url���� �����ϴ� ���� 
		String uri = request.getRequestURI();
		System.out.println("getRequestURI : "+ uri);
		command = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));		
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
		//��ȭ ��ȭ���� ������ ��û
		else if(command.equals("edit")) {
			System.out.println("MovieCommand_edit ȣ��");
			com = new MovieCommand_edit();
			com.execute(request, response);
			String movieCode = request.getParameter("movieCode");
			viewPage = "./movieForm_edit.jsp?movieCode="+ movieCode;
		}
		//��ȭ upload �� ��ȭ �������� ��û
		else if(command.equals("upload")) {
			System.out.println("MovieCommand_upload ȣ��");
			com = new MovieCommand_upload();
			com.execute(request, response);
			int movieCode = (int) request.getAttribute("movieCode");
			viewPage = "spec.do?movieCode="+ movieCode;
			viewPage = "./movieForm_result.jsp?movieCode="+ movieCode;
		}
		//��ȭ update �� ��ȭ �������� ��û
		else if(command.equals("update")) {
			System.out.println("MovieCommand_update ȣ��");
			com = new MovieCommand_update();
			com.execute(request, response);
			int movieCode = (int) request.getAttribute("movieCode");

			viewPage = "./movieForm_result.jsp?movieCode="+ movieCode;
			System.out.println("--����Ϸ�");
		}
		//��ȭ ���� ������ ��ȭ����Ʈ ������ ��û
		else if(command.equals("delete")) {
			System.out.println("MovieCommand_delete ȣ��");
			com = new MovieCommand_delete();
			com.execute(request, response);
			//viewPage = request.getContextPath()+ "/movie/temp.jsp";
			viewPage = "../index.jsp";
		}
		//�������� ã�� ����
		else {
			System.out.println("[error] ��û������ ã������");
			viewPage = request.getContextPath()+ "/index.jsp";
		}				
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}
}
