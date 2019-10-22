package cn.kgc.tangcco.tcbd1015.wangxinyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.kgc.tangcco.tcbd1015.wangxinyu.entity.UserInfo;
import cn.kgc.tangcco.tcbd1015.wangxinyu.service.UserInfoService;
import cn.kgc.tangcco.tcbd1015.wangxinyu.service.impl.UserInfoServiceImpl;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		UserInfoService uis = new UserInfoServiceImpl();
		PrintWriter out = response.getWriter();
		if (method == null) {
			UserInfo user = uis.getInfo(1);
			Object ui = JSON.toJSONString(user);
			out.print(ui);
		} else if (method.equals("update") && method != null) {
			try {
				UserInfo user = new UserInfo(request.getParameter("email"), request.getParameter("realName"),
						request.getParameter("phoneNum"), request.getParameter("tel"),
						Integer.parseInt(request.getParameter("sex")),
						request.getParameter("birthday"),
						request.getParameter("address"), Integer.parseInt(request.getParameter("typeId")),
						Integer.parseInt(request.getParameter("marriage")),
						Integer.parseInt(request.getParameter("family")), request.getParameter("incomDescid"),
						Integer.parseInt(request.getParameter("hasCar")), Integer.parseInt(request.getParameter("id")),
						request.getParameter("paswword"));
				if (uis.updateUserInfo(user) > 0) {
					out.print("true");
				} else {
					out.print("laji");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
