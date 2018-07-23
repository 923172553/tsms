package com.tsms.servlet.taxpayer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.Tb_Tax_PayerDaoImpl;
import com.tsms.entity.Tb_Tax_Payer;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class q
 */
@WebServlet("/Tb_Tax_PayerXiuGai01Servlet.do")
public class Tb_Tax_PayerXiuGai01Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tb_Tax_PayerXiuGai01Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		String id=request.getParameter("id");
		String payerName=request.getParameter("payerName"); 
		String bizAddress= request.getParameter("bizAddress");
		String taxOrganId= request.getParameter("taxOrganId");
		String industryId= request.getParameter("industryId");
		String bizScope= request.getParameter("bizScope");
		String invoiceType= request.getParameter("invoiceType");
		String legalPerson= request.getParameter("legalPerson");
		String legalIdCard= request.getParameter("legalIdCard");
		String finaceName= request.getParameter("finaceName");
		String finaceIdCard= request.getParameter("finaceIdCard");
		String bizAddressPhone= request.getParameter("bizAddressPhone");
		 
		Tb_Tax_Payer tpp=	new Tb_Tax_Payer(Integer.parseInt(id), payerName, bizAddress, Integer.parseInt(taxOrganId), Integer.parseInt(industryId), bizScope, invoiceType, legalPerson, legalIdCard, finaceName, finaceIdCard, bizAddressPhone);
		 boolean b= new Tb_Tax_PayerDaoImpl().updateTb_Tax_PayerById(tpp);
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
