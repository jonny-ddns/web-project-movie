package mvc_member.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc_member.command.MemberCommand;
import mvc_member.command.MemberCommand_signup;

@WebServlet("*.bo")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
    	System.out.println(">>MemberController()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\ndoGet()");
		actionBo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\ndoPost()");
		actionBo(request, response);
	}
	
	private void actionBo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionBo()");
		MemberCommand com = null;
		String command = "";
		String viewPage = "";		
				
		//������ �ܾ url���� �����ϴ� ���� 
		String uri = null;
		String contextPath;
				
		uri = request.getRequestURI();
//		System.out.println("getRequestURI : "+ uri);		
			
		contextPath = request.getContextPath();
//		System.out.println("getContextPath : "+ contextPath);
			
		command = uri.substring(contextPath.length()+1, uri.length()-3);
		System.out.println("command : "+ command);				
		
		if(command.equals("signup")) {
			System.out.println("MemberCommand_login ȣ��");
			com = new MemberCommand_signup();
			com.execute(request, response);
			viewPage = "./.jsp";
		}
		else if(command.equals("signin")) {
			System.out.println("MemberCommand_login ȣ��");
			com = new MemberCommand_signup();
			com.execute(request, response);
			viewPage = "./.jsp";
		}
		else {
			System.out.println("--�������� ã�� ����");
			viewPage = "index.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
