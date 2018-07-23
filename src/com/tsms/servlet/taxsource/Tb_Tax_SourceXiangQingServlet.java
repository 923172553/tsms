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
 * Servlet implementation class Tb_Tax_SourceXiangQingServlet
 */
@WebServlet("/Tb_Tax_SourceXiangQingServlet.do")
public class Tb_Tax_SourceXiangQingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tb_Tax_SourceXiangQingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id= request.getParameter("id");
	    List<Map<String, String>> list1=	new Tb_Tax_SourceDaoImpl().getTb_Tax_SourceByIda(Integer.parseInt(id));
	    List<Map<String, String>> list2=	new Tb_Tax_SourceDaoImpl().getTb_Tax_SourceByIdb(Integer.parseInt(id));
	    List<Map<String, String>> list3=	new Tb_Tax_SourceDaoImpl().getTb_Tax_SourceByIdc(Integer.parseInt(id));

		
		
		request.setAttribute("list1", list1.get(0));
		request.setAttribute("list2", list2.get(0));
		request.setAttribute("list3", list3.get(0));
		request.getRequestDispatcher("manage/jsp/taskInfo.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
