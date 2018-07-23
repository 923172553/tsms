package com.tsms.servlet.taxsource;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsms.dao.impl.Tb_Tax_SourceDaoImpl;
import com.tsms.entity.Tb_Tax_Source;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Tb_Tax_Source0202Servlet
 */
@WebServlet("/Tb_Tax_Source0202Servlet.d0")
public class Tb_Tax_Source0202Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tb_Tax_Source0202Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		int payerId = Integer.parseInt(request.getParameter("id"));
		String taskName = request.getParameter("taskName");
		int subOrganId = Integer.parseInt(request.getParameter("subOrganId"));
		int approverId = Integer.parseInt(request.getParameter("approverId"));
		int executeId = Integer.parseInt(request.getParameter("executeId"));
		String executeTime  = request.getParameter("executeTime");
		String taskState = request.getParameter("taskState");
		String recordTaskDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Object[] obj = {payerId,taskName,subOrganId,approverId,executeId,executeTime,taskState,recordTaskDate,};
		Tb_Tax_SourceDaoImpl tstd = new Tb_Tax_SourceDaoImpl(); 
		boolean boo = tstd.addTask(obj);
		
		
		JSONObject json = new JSONObject(); 
		
		if(boo==true){
			json.put("success",true);
			json.put("msg","添加成功");
		}else{
			json.put("msg","添加失败");
			json.put("success",false);
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
