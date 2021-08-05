package mvc.command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCommand_delete implements BoardCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(">>BoardCommand_delete");
		
		System.out.println("BoardCommand_delete end");
	}
}
