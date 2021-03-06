package com.tsms.servlet.taxer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.Tb_TaxerDaoImpl;
import com.tsms.entity.Tb_Taxer;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Tb_TaxerXiuGai02Servlet
 */
@WebServlet("/Tb_TaxerXiuGai02Servlet.do")
public class Tb_TaxerXiuGai02Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tb_TaxerXiuGai02Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		
		String id= request.getParameter("id");
		String taxerCode= request.getParameter("taxerCode");
		String taxerName= request.getParameter("taxerName");
		String mobile= request.getParameter("mobile");
		String address= request.getParameter("address");
		String sex= request.getParameter("sex");
		String birthday= request.getParameter("birthday");
		String email= request.getParameter("email");
		String organId= request.getParameter("organId");
		
		Tb_Taxer tt= new Tb_Taxer(Integer.parseInt(id),taxerCode, taxerName, mobile, address, sex, birthday, email, Integer.parseInt(organId));
		boolean b= new Tb_TaxerDaoImpl().updateTb_TaxerById(tt);
		JSONObject json=new JSONObject();
		if(b){
			json.put("msg", "修改成功");
			json.put("success", true);
			
		}else{
			json.put("msg", "修改失败");
			json.put("success", false);
		}
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
