package com.tsms.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsms.dao.impl.UserDaoImpl;
import com.tsms.entity.User;
import com.tsms.util.EncryptUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class PasswordServlet
 */
@WebServlet("/PasswordServlet.do")
public class PasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
	    String username=request.getParameter("username");
	    String oldPassword=request.getParameter("oldPassword");
	    String newPassword=request.getParameter("newPassword");
	    JSONObject json=new JSONObject();
	    UserDaoImpl u= new UserDaoImpl();
	    User user = u.getallUserByUsername(username);
		String pwd=EncryptUtil.encryptMD5(oldPassword+user.getSalt());
		String npwd=EncryptUtil.encryptMD5(newPassword+user.getSalt());
		if(pwd.equals(user.getPassword())){
			boolean b=u.getpasswordByUsername(username , npwd);
			
		if(b){
				json.put("msg", "修改密码成功");
				json.put("success", true);
			}else{
				json.put("msg", "新密码有误,请重新输入");
				json.put("success", false);
			}
		}else{
			json.put("msg", "输入的密码有误,请重新输入");
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
