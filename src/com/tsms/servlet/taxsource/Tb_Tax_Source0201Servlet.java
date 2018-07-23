package com.tsms.servlet.taxsource;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsms.dao.impl.Tb_Tax_SourceDaoImpl;

/**
 * Servlet implementation class Tb_Tax_Source02Servlet
 */
@WebServlet("/Tb_Tax_Source0201Servlet.do")
public class Tb_Tax_Source0201Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tb_Tax_Source0201Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String payerCode=request.getParameter("payerCode");
		List<Map<String, String>> list= new Tb_Tax_SourceDaoImpl().getPayerInfoByPayerCode(payerCode);
		String recordTaskDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		if(list==null ){
			request.setAttribute("msg", "没有此识别号");
			request.setAttribute("success",false);
		}else{
			request.setAttribute("list", list.get(0));
			request.setAttribute("recordTaskDate", recordTaskDate);
		}
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
