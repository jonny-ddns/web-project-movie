package mvc_member.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc_member.command.MemberCommand;
import mvc_member.command.MemberCommand_memberDelete;
import mvc_member.command.MemberCommand_memberEdit;
import mvc_member.command.MemberCommand_memberView;
import mvc_member.command.MemberCommand_pwCompare;
import mvc_member.command.MemberCommand_signin;
import mvc_member.command.MemberCommand_signup;

@WebServlet("*.bo")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
//    	System.out.println(">>MemberController()");
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
		System.out.println("\nMemberController - actionBo()");
		request.setCharacterEncoding("UTF-8");
		MemberCommand com = null;
		String command = "";
		String viewPage = "";
				
		//연결할 단어를 url에서 추출하는 절차 
		String servletPath = request.getServletPath();
		String folderName = "member";
		
		command = servletPath.substring(folderName.length()+2, servletPath.length()-3);

		System.out.println("command : "+ command);				
		
		if(command.equals("signup")) {
			System.out.println("MemberCommand_signup 호출");
			com = new MemberCommand_signup();
			com.execute(request, response);
			viewPage = "../index.jsp";
		}
		else if(command.equals("signin")) {
			System.out.println("MemberCommand_signin 호출");
			com = new MemberCommand_signin();
			com.execute(request, response);
			viewPage = "./signin_result.jsp";
		}
		else if(command.equals("compare")) {
			System.out.println("MemberCommand_pwCompare 호출");
			com = new MemberCommand_pwCompare();
			com.execute(request, response);
			
			viewPage = "./memberVerify.jsp";
			if((boolean) request.getAttribute("compareResult")) {
				viewPage = "./memberEdit_form.jsp";
			}
		}
		else if(command.equals("memberEdit")) {
			System.out.println("MemberCommand_memberEdit 호출");
			com = new MemberCommand_memberEdit();
			com.execute(request, response);
			viewPage = "../index.jsp";
		}
		else if(command.equals("memberDelete")) {
			System.out.println("MemberCommand_memberDelete 호출");
			com = new MemberCommand_memberDelete();
			com.execute(request, response);
			viewPage = "../index.jsp";
		}
		else if(command.equals("memberView")) {
			System.out.println("MemberCommand_memberView 호출");
			com = new MemberCommand_memberView();
			com.execute(request, response);
			viewPage = "./memberView.jsp";
		}
		else {
			System.out.println("--페이지를 찾지 못함");
			viewPage = "../index.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
