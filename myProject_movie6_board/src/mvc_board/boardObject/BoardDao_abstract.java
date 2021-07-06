package mvc_board.boardObject;

import java.util.List;

public abstract class BoardDao_abstract {

	public abstract List<BoardVO> getBoardAll();
	
	public abstract boolean boardVerify(String id, String pw); 
	
	public abstract void boardInsert(BoardVO board);
	
	public abstract BoardVO boardSearchByID(String id);
	
//	public abstract boolean memberPwCompare(MemberVO member, String inputPw);
	
	public abstract void boardEdit(BoardVO board, String id);
		
	public abstract void boardDelete(String id);	
}
