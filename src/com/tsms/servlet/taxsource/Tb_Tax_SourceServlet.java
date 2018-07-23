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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Tb_Tax_SourceServlet
 */
@WebServlet("/Tb_Tax_SourceServlet.do")
public class Tb_Tax_SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tb_Tax_SourceServlet() {
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
		String organName= request.getParameter("organName");
		String industryName= request.getParameter("industryName");
		Tb_Tax_SourceDaoImpl tts= new Tb_Tax_SourceDaoImpl();
		List<Map<String, String>> list= tts.getAllTb_Tax_Sources(Integer.parseInt(pageNo), Integer.parseInt(pageSize),payerCode,payerName,organName,industryName);
		int total= tts.listAllTb_Tax_SourcesByPageCount(payerCode,payerName,organName,industryName);
		JSONObject json =new JSONObject();
		if(list.size()<0 || list==null){
			return;
		}
		
		json.put("rows", JSONArray.fromObject(list));
		json.put("total", total);
		response.getWriter().append(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
