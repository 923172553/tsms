package com.tsms.servlet.taxpayer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.Tb_Tax_PayerDaoImpl;
import com.tsms.entity.Tb_Tax_Payer;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Tb_Tax_PayerAddServlet
 */
@WebServlet("/Tb_Tax_PayerAddServlet.json")
public class Tb_Tax_PayerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tb_Tax_PayerAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		Tb_Tax_PayerDaoImpl  taxpayerimpl = new Tb_Tax_PayerDaoImpl();
		
		String payerCode = request.getParameter("payerCode");
		String payerName = request.getParameter("payerName");
		String bizAddress = request.getParameter("bizAddress");
		String bizAddressPhone = request.getParameter("bizAddressPhone");
     	String taxOrganId = request.getParameter("taxOrganId");
		String industryId = request.getParameter("industryId");
		String bizScope = request.getParameter("bizScope");
		String invoiceType = request.getParameter("invoiceType");
		String legalPerson = request.getParameter("legalPerson");
		String legalIdCard = request.getParameter("legalIdCard");
		String finaceName = request.getParameter("finaceName");
		String finaceIdCard = request.getParameter("finaceIdCard");
		String recordDate= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		int userId=1;
		Tb_Tax_Payer tax= new Tb_Tax_Payer(payerCode, payerName, bizAddress, Integer.parseInt(taxOrganId), Integer.parseInt(industryId), bizScope, invoiceType, legalPerson, legalIdCard, finaceName, finaceIdCard, bizAddressPhone,recordDate,userId);
		
	//	System.out.println(tax.toString());
		
		boolean res = taxpayerimpl.addTb_Tax_Payer(tax);
		
		JSONObject json = new JSONObject();
		
		if(res){
			json.put("msg", "添加成功");
			json.put("success", true);
		}else{
			json.put("msg", "添加失败");
			json.put("success", false);
		}
		response.getWriter().print(json.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
