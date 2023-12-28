package net.board.controller;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

///**
// * Servlet implementation class myFrontController
// */
//@WebServlet("/myFrontController")
//public class myFrontController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//   
//    public myFrontController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String RequestURI = request.getRequestURI();
//		String contextPath = request.getContextPath();
//		String command = RequestURI.substring(contextPath.length());
//		BoardService service = null;
//		if(command.equals("/boardList.bo")) {	//request mapping과 동일.
//			
//		}
//		
//		if (forward != null) {
//			if (forward.isRedirect()) {
//				response.sendRedirect(forward.getPath());
//			} else {
//				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());	
//				dispatcher.forward(request, response);
//			}
//		}
//	}
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
