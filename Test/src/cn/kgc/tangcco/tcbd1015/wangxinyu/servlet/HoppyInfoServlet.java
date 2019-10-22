package cn.kgc.tangcco.tcbd1015.wangxinyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.kgc.tangcco.tcbd1015.wangxinyu.entity.HoppyInfo;
import cn.kgc.tangcco.tcbd1015.wangxinyu.service.HoppyInfoService;
import cn.kgc.tangcco.tcbd1015.wangxinyu.service.impl.HoppyInfoServiceImpl;

@WebServlet("/HoppyInfoServlet")
public class HoppyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HoppyInfoService his = new HoppyInfoServiceImpl();
		String method = request.getParameter("method");
		PrintWriter out = response.getWriter();
		if (method.equals("get") && method != null) {
			HoppyInfo hoppy = his.getHoppyInfo(Integer.parseInt(request.getParameter("id")));
			Object hi = JSON.toJSONString(hoppy);
			out.print(hi);
		}
		if (method.equals("update") && method != null) {
			HoppyInfo hoppy = new HoppyInfo(Integer.parseInt(request.getParameter("id")),
					request.getParameter("favoriteBrand"), request.getParameter("favoriteStar"),
					request.getParameter("favoriteMovie"), request.getParameter("favoritePersonage"));
			if (his.updateHoppyInfo(hoppy) > 0) {
				out.print("success");
			} else {
				out.print("laji");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
