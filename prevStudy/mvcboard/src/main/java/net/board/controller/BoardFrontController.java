package net.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.action.Action;
import net.board.action.ActionForward;
import net.board.action.BoardAddAction;
import net.board.action.BoardDeleteAction;
import net.board.action.BoardDetailAction;
import net.board.action.BoardListAction;
import net.board.action.BoardModifyAction;
import net.board.action.BoardModifyView;
import net.board.action.BoardReplyAction;
import net.board.action.BoardReplyView;

public class BoardFrontController extends javax.servlet.http.HttpServlet // httpservlet을 상속받으면 controller
		implements javax.servlet.Servlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) // 메인 프로그램을 tomcat이 가지고 있다가,
																					// 요청(get/post)이 들어오면 해당 메서드를 실행
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) // 추가적으로 필요한 방식이 있다면 새로 구현할 수 있음
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		// System.out.println("RequestURI: "+RequestURI); //기본경로+index에서 입력한 uri
		String contextPath = request.getContextPath();
		// System.out.println("contextPath: "+contextPath); //기본경로.
		// servers-module-path에서 설정한 경로.
		String command = RequestURI.substring(contextPath.length()); // index에서 입력한 uri
		ActionForward forward = null;
		Action action = null;

///		
//		Map<String, ActionForward> requestMapping = null;	//getter가 필요.
//		try {
//			requestMapping = new HashMap<String, ActionForward>();
//			requestMapping.put("/BoardWrite.bo", new ActionForward(false, "./board/qna_board_write.jsp"));
//			...
//			requestMapping.put("/BoardDelete.bo",new BoardReplyAction().execute(request,response));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		 
//		  
//		forward = requestMapping.get(command);
		 
		//public ActionForward()			//생성자에 추가
		//public ActionForward(boolean b, String string){
		//	isRedirect = b;
		//	return isRedirect;
		//}
///
		if (command.equals("/BoardWrite.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/qna_board_write.jsp");
		} else if (command.equals("/BoardReplyAction.bo")) {
			action = new BoardReplyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardDelete.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/qna_board_delete.jsp");
		} else if (command.equals("/BoardModify.bo")) {
			action = new BoardModifyView();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardAddAction.bo")) {
			action = new BoardAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardReplyView.bo")) {
			action = new BoardReplyView();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardModifyAction.bo")) {
			action = new BoardModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardDeleteAction.bo")) {
			action = new BoardDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardList.bo")) {
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardDetailAction.bo")) {
			action = new BoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
///		
		if (forward != null) { // redirct->새로운 요청, forward->요청을 다른 곳에서 처리하도록 보냄.
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath()); // forward하는 방법
				dispatcher.forward(request, response);
			}
		}
	}

}