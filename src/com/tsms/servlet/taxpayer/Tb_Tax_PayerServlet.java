package com.tsms.servlet.taxpayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.Tb_Tax_PayerDaoImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Tb_Tax_PayerServlet
 */
@WebServlet("/Tb_Tax_PayerServlet.do")
public class Tb_Tax_PayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tb_Tax_PayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		String pageNo= request.getParameter("page");
		String pageSize= request.getParameter("rows");
		String payerCode= request.getParameter("payerCode");
		String payerName= request.getParameter("payerName");
	    Tb_Tax_PayerDaoImpl td=	new Tb_Tax_PayerDaoImpl();
	    List<Map<String, String>> list=  td.getAllTb_Tax_Payers(Integer.parseInt(pageNo),Integer.parseInt(pageSize),payerCode,payerName);
		int total=td.listAllTb_Tax_PayersByPageCount(payerCode,payerName);
		JSONObject json=new JSONObject();
		PrintWriter out= response.getWriter();
		if(list.size()<0 || list ==null){
			return;
		}
		
		json.put("rows", JSONArray.fromObject(list));
		json.put("total", total);
		out.write(json.toString());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
