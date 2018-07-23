package com.tsms.servlet.taxpayer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.Tb_Tax_PayerDaoImpl;
import com.tsms.dao.impl.Tb_Tax_SourceDaoImpl;

/**
 * Servlet implementation class Tb_Tax_PayerRenwu
 */
@WebServlet("/Tb_Tax_PayerRenwu.do")
public class Tb_Tax_PayerRenwu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tb_Tax_PayerRenwu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String payerCode=request.getParameter("payerCode");
	
		List<Map<String, String>> list= new Tb_Tax_PayerDaoImpl().getTb_Tax_PayerById02(payerCode);

		request.setAttribute("list",list.get(0));
		
		request.getRequestDispatcher("manage/jsp/addTask2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
