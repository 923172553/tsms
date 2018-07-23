package com.tsms.servlet.taxsource;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.Tb_Tax_SourceDaoImpl;
import com.tsms.entity.Tb_Tax_Source;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Tb_Tax_SourceXiuGai02
 */
@WebServlet("/Tb_Tax_SourceXiuGai02.do")
public class Tb_Tax_SourceXiuGai02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tb_Tax_SourceXiuGai02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("applicotion/json;charset=UTF-8");
		
		String id= request.getParameter("id");
		String subOrganId= request.getParameter("subOrganId");
		String approverId= request.getParameter("approverId");
		String executeId= request.getParameter("executeId");
		String executeTime= request.getParameter("executeTime");
		String taskState= request.getParameter("taskState");
		
		Tb_Tax_Source tts= new Tb_Tax_Source(Integer.parseInt(id), Integer.parseInt(subOrganId), Integer.parseInt(approverId), Integer.parseInt(executeId), executeTime, taskState);
		boolean b= new Tb_Tax_SourceDaoImpl().updateTb_Tax_SourceById(tts);
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
