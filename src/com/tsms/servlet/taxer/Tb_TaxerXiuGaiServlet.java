package com.tsms.servlet.taxer;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsms.dao.impl.Tb_TaxerDaoImpl;

/**
 * Servlet implementation class Tb_TaxerXiuGaiServlet
 */
@WebServlet("/Tb_TaxerXiuGaiServlet.d0")
public class Tb_TaxerXiuGaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tb_TaxerXiuGaiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id= request.getParameter("id");
		List<Map<String, String>> list= new Tb_TaxerDaoImpl().getTb_TaxerById(Integer.parseInt(id));
		request.setAttribute("list", list.get(0));
		request.getRequestDispatcher("manage/jsp/editTaxer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
