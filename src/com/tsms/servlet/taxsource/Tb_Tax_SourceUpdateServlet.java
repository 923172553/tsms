package com.tsms.servlet.taxsource;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.Tb_Tax_SourceDaoImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Tb_Tax_SourceUpdateServlet
 */
@WebServlet("/Tb_Tax_SourceUpdateServlet.do")
public class Tb_Tax_SourceUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tb_Tax_SourceUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		String id= request.getParameter("id");
		boolean b=new Tb_Tax_SourceDaoImpl().deleteTb_Tax_SourceById(Integer.parseInt(id));
		JSONObject json=new JSONObject();
		if(b){
			json.put("msg","删除成功");
			json.put("success",true );
		}else{
			json.put("msg","删除失败");
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
