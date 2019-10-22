package cn.kgc.tangcco.tcbd1015.wangxinyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.kgc.tangcco.tcbd1015.wangxinyu.entity.WorkInfo;
import cn.kgc.tangcco.tcbd1015.wangxinyu.service.WorkInfoService;
import cn.kgc.tangcco.tcbd1015.wangxinyu.service.impl.WorkInfoServiceImpl;

/**
 * Servlet implementation class WorkInfoServlet
 */
@WebServlet("/WorkInfoServlet")
public class WorkInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		WorkInfoService wis = new WorkInfoServiceImpl();
		String method = request.getParameter("method");
		PrintWriter out = response.getWriter();
		if (method.equals("get") && method != null) {
			WorkInfo work = wis.getWorkInfo(Integer.parseInt(request.getParameter("id")));
			Object wi = JSON.toJSONString(work);
			out.print(wi);
		}
		if (method.equals("update") && method != null) {
			WorkInfo work = new WorkInfo(Integer.parseInt(request.getParameter("id")), request.getParameter("company"),
					request.getParameter("position"), Integer.parseInt(request.getParameter("workSeniorityId")),
					Integer.parseInt(request.getParameter("degreeid")), request.getParameter("schoolTag"),
					request.getParameter("schoolTagDate"));
			if (wis.updateWorkInfo(work) > 0) {
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
