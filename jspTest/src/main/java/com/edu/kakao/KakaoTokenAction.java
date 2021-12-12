package com.edu.kakao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.dto.KakaoDto;
import com.edu.util.Action;
import com.edu.util.ActionForward;
import com.google.gson.Gson;



public class KakaoTokenAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		KakaoDto kakaoDto=(KakaoDto)request.getAttribute("KakaoDto");
		URL url=new URL("https://kapi.kakao.com/v2/user/me");
		
		HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "Bearer "+kakaoDto.getAccess_token());
		conn.setDoOutput(true);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String input="";
		StringBuilder sb=new StringBuilder();
		while((input=br.readLine())!=null) {
			sb.append(input);
		}
		
		System.out.println("사용자 정보:"+sb.toString());
		
		Gson gson=new Gson();
		
		
		
		return null;
	}
}
