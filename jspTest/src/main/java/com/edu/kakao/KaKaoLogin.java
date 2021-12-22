package com.edu.kakao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.dto.KakaoDto;
import com.edu.util.Action;
import com.edu.util.ActionForward;
import com.google.gson.Gson;



public class KaKaoLogin implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String authorize_code=request.getParameter("code");
		//System.out.println("code:"+code);
		String client_id="아이디";
		String redirect_uri="http://localhost:8002/jspTest/kakao.do";
		String code=authorize_code;
		
		URL url=new URL("https://kauth.kakao.com/oauth/token");
		String bodyData="grant_type=authorization_code";
		bodyData+="&client_id="+client_id;
		bodyData+="&redirect_uri="+redirect_uri;
		bodyData+="&code="+code;
		
		HttpsURLConnection conn=(HttpsURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		//서버한테 전달
		conn.setDoOutput(true);
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"UTF-8"));
		
		bw.write(bodyData);
		bw.flush();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String input="";
		StringBuilder sb=new StringBuilder();
		while((input=br.readLine())!=null) {
			sb.append(input);
		}
		
		System.out.println(sb.toString());
		
		Gson gson=new Gson();
		KakaoDto kakaoDto=gson.fromJson(sb.toString(), KakaoDto.class);
		request.setAttribute("KakaoDto", kakaoDto);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/kakao/kakaoToken.do");
		actionForward.setRedirect(false);
		
		
		return actionForward;
	}
}
