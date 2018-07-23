package com.tsms.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tsms.dao.impl.UserDaoImpl;
import com.tsms.entity.User;
import com.tsms.util.EncryptUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/LoginUserServlet.json")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String captchad=request.getParameter("captcha");
		Object validate = request.getSession().getAttribute("validate");
		HttpSession h=  request.getSession();
		JSONObject json = new JSONObject();
		if(validate.toString().equalsIgnoreCase(captchad)){
			User user=new UserDaoImpl().getallUserByUsername(username);
			if(user != null){
				String pwd=EncryptUtil.encryptMD5(password+user.getSalt());
				if(pwd.equals(user.getPassword())){
					h.setAttribute("username", username);
					h.setAttribute("userId",user.getId());
					json.put("msg", "登录成功");
					json.put("success", true);
				}else{
					json.put("msg", "密码有误");
					json.put("success", false);
				}
			}else{
				json.put("msg", "账号有误");
				json.put("success", false);
			}
			
		}else{
			json.put("msg", "验证码有误");
			json.put("success",false);
		}
		response.getWriter().println(json.toString());
		
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
