package com.edu.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.dto.MemberDto;
import com.edu.dto.User;
import com.edu.dto.UserDto;
import com.edu.kakao.KaKaoLogin;
import com.edu.kakao.KakaoTokenAction;
import com.edu.util.Action;
import com.edu.util.ActionForward;
import com.google.gson.Gson;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI=request.getRequestURI();
		int lastIndex=requestURI.lastIndexOf("/")+1;
		String requestPage=requestURI.substring(lastIndex);
		
		Action action=null;
		ActionForward actionForward=null;
		
		try {
			if(requestPage.equals("member.do")) {
				Gson gson=new Gson();
				BufferedReader br=request.getReader();
				PrintWriter out=response.getWriter();
				String data=br.readLine();
				MemberDto dto = gson.fromJson(data, MemberDto.class);
				
				System.out.println("dto:"+dto);
				out.print(dto);
			}
			else if(requestPage.equals("ajaxTest.do")) {
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				
				System.out.println("username:"+username);
				System.out.println("password:"+password);
				
				PrintWriter out=response.getWriter();
				out.print("ok");
				out.flush();
			}	
			else if(requestPage.equals("Postajax.do")) {
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				
				System.out.println("username:"+username);
				System.out.println("password:"+password);
				
				String jsonData="{\"username\":\"ssar\",\"password\":\"1234\"}";
				
				PrintWriter out=response.getWriter();
				out.print(jsonData);
				out.flush();
			}
			else if(requestPage.equals("JsonTest.do")) {
				BufferedReader br=request.getReader(); //http body?????? ????????????
				String requestData=br.readLine();
				System.out.println(requestData);
				
				Gson gson=new Gson();
				//gson.fromJson() -> json?? ???? ??????????
				//gson.toJson() -> ?????????????? json????
				
				UserDto userDto=gson.fromJson(requestData, UserDto.class);
				
				System.out.println(userDto);
				
				User user=new User();
				user.setId(1);
				user.setUsername("love");
				user.setPassword("1234");
				user.setPhone("0102222");
				
				String userJson=gson.toJson(user);
				System.out.print(userJson);
				PrintWriter out=response.getWriter();
				out.print(userJson);
				out.flush();
			}
			//?????? ?????? Test
			else if(requestPage.equals("kakao.do")) {
				System.out.println("?????? ??????");
				action=new KaKaoLogin();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("kakaoToken.do")) {
				action=new KakaoTokenAction();
				actionForward=action.execute(request, response);
			}
			
			
			if(actionForward!=null) {
				if(actionForward.isRedirect()) {
					response.sendRedirect(actionForward.getNextPath());
				}else {
					request.getRequestDispatcher(actionForward.getNextPath()).forward(request, response);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
