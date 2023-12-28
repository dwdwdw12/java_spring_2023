package net.board.action;

import javax.servlet.http.*;

public interface Action {	//BoardAddAction.java, BoardDeleteAction.java, BoardDetailAction.java, BoardModifyAction.java, BoardReplyAction.java이 구현
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;	//위 java 파일에서 사용하는 method
}
