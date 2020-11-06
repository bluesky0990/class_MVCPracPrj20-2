package com.nellem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nellem.command.InterfaceCommand;
import com.nellem.command.MInsertCommand;
import com.nellem.command.MLoginCommand;
import com.nellem.command.BDeleteCommand;
import com.nellem.command.BListCommand;
import com.nellem.command.BUpdateCommand;
import com.nellem.command.BViewCommand;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String viewPage =null;
		InterfaceCommand command = null;
		
		String uri = request.getRequestURI(); 	//uri :/member-mvc/list.do
		String com= uri.substring(uri.lastIndexOf("/")+ 1, uri.lastIndexOf(".do")); //command :insert
		
		if(com !=null && com.trim().equals("index")) {
			HttpSession session = request.getSession();
			session.invalidate();
			viewPage = "/WEB-INF/view/index.jsp";
		}
		
		
		if(com !=null && com.trim().equals("boardList")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/view/bList.jsp";
		} else if(com !=null && com.trim().equals("view")) {
			command = new BViewCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/view/bView.jsp";
		} else if(com !=null && com.trim().equals("modifyForm")) {
			command = new BUpdateCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/view/bModify.jsp";
		} else if(com !=null && com.trim().equals("boardUpdatedo")) {
			command = new BUpdateCommand();
			command.execute(request, response);
			viewPage = "boardList.do";
		} else if(com !=null && com.trim().equals("viewDelete")){
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "boardList.do";
		}
//		}else if(com !=null && com.trim().equals("insertForm")) {
//			viewPage = "mInsertForm.jsp";
//			
//		}else if(com !=null && com.trim().equals("insert")) {
//			command = new MInsertCommand();
//			command.execute(request, response);
//			viewPage ="list.do";
//		}else if(com !=null && com.trim().equals("view")) {
//			command = new MViewCommand();
//			command.execute(request, response);
//			viewPage = "mView.jsp";
//		}
//		else if(com !=null && com.trim().equals("update")){
//			command = new MUpdateCommand();
//			command.execute(request, response);
//			viewPage = "list.do";
//		}
//		else if(com !=null && com.trim().equals("delete")){
//			command = new MDeleteCommand();
//			command.execute(request, response);
//			viewPage = "list.do";
//		}
		if(com != null && com.trim().equals("signuppage")) {
			viewPage = "/WEB-INF/view/signup.jsp";
		} else if(com != null && com.trim().equals("signup")) {
			command = new MInsertCommand();
			command.execute(request, response);
			viewPage = "index.do";
		} else if(com != null && com.trim().equals("login")) {
			command = new MLoginCommand();
			command.execute(request, response);
			viewPage = "boardList.do";
		} else if(com != null && com.trim().equals("loginFail")) {
			viewPage = "/WEB-INF/view/failMessage.jsp";
		} else if(com != null && com.trim().equals("logout")) {
			viewPage = "index.do";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
