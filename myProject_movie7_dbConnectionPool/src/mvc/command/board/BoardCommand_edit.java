package mvc.command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCommand_edit implements BoardCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>BoardCommand_edit");
		System.out.println(">>BoardCommand_edit end");
	}
}
