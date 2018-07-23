package com.tsms.servlet.taxsource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.Tb_Tax_SourceDaoImpl;

/**
 * Servlet implementation class Tb_Tax_SourceXiuGai01
 */
@WebServlet("/Tb_Tax_SourceXiuGai01.do")
public class Tb_Tax_SourceXiuGai01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tb_Tax_SourceXiuGai01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id= request.getParameter("id");
	    List<Map<String, String>> list=	new Tb_Tax_SourceDaoImpl().getTb_Tax_SourceByIda(Integer.parseInt(id));
		request.setAttribute("list", list.get(0));
		request.getRequestDispatcher("manage/jsp/editTask.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
