package com.nellem.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nellem.dato.BoardDAO;

public class BDeleteCommand implements InterfaceCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8"); 
		  int id = Integer.parseInt(request.getParameter("no"));
		  BoardDAO dao = new BoardDAO();
		  
		  dao.delete(id);		  
	}
}
