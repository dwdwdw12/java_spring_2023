package net.board.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

 public class BoardListAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		BoardDAO boarddao=new BoardDAO();
		List<BoardBean> boardlist=new ArrayList<BoardBean>();
		
		//DAO에게 일을 요청하기 전에 필요한 정보를 만드는 선행작업. 비즈니스 로직....->service에서 처리하는게 좋음
		int page=1;		//페이지 기본값을 1페이지로 설정
		int limit=10;	//1페이지에 나타내는 목록의 개수를 10개로 지정
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount=boarddao.getListCount(); //전체 게시글 카운트
		boardlist = boarddao.getBoardList(page,limit); //list에 전달
		
		//DAO에게 일을 요청한 후, view 페이지에서 필요한 정보를 만드는 후행작업.
		//이전, 페이지, 다음 을 처리
 		int maxpage=(int)((double)listcount/limit+0.95); //나누기의 결과는 n.1 이상. 0.95를 더한뒤 정수를 취해 다음페이지를 반환
 		//(1, 11, 21 ..)
 		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
 		//(10, 20, 30 ...)
		int endpage = startpage+10-1;

 		if (endpage> maxpage) endpage= maxpage;

 		//forwarding하기 위해 값을 집어넣음
 		request.setAttribute("page", page); 
 		request.setAttribute("maxpage", maxpage); 
 		request.setAttribute("startpage", startpage);
 		request.setAttribute("endpage", endpage); 
		request.setAttribute("listcount",listcount); 
		request.setAttribute("boardlist", boardlist);
		
		ActionForward forward= new ActionForward();
	 	forward.setRedirect(false);		//db처리 후 forwarding을 하겠다.
 		forward.setPath("./board/qna_board_list.jsp");	//해당 경로
 		return forward;
	 }
 }