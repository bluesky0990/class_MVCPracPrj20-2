package com.nellem.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nellem.dato.MemberDAO;
import com.nellem.dato.MemberDTO;


public class MLoginCommand implements InterfaceCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		dto.setId(id);
		dto.setPwd(pwd);
		boolean memberMatch = dao.MemberChk(dto);
		
		if(memberMatch) {
			request.setAttribute(id, "id");
			request.setAttribute(pwd, "pwd");
		} else {
			response.sendRedirect("./loginFail.do");
		}
	}
}
