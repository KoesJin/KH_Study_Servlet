package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

/**
 * http://locallhost:8001/servlet/gettest.do
 * Servlet의 요청 경로는 contextPath뒤에 작성됨
 */
@WebServlet("/gettest.do")
public class RequestGetServlet extends HttpServlet {
    public RequestGetServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get방식으로 요청시 해당 doGet메서드가 저절로 호출된다.(톰캣이 서블릿 객체를 생성해서 메서드 호출까지 함)
        System.out.println("Get 요청 도착");

        /*
            첫번째 매개변수인 request에는 요청시 전달된 내용들이 담겨있음 (사용자가 입력한 값, 요청방식 , 요청자의 Url등...)
            두번째 매개변수인 response에는 요청 처리 후 응답에 사용되는 객체(어떤타입으로 응답을 할지 , 어떤 값을 응답할지등을 넣어주면 됨)

            요청 처리를 위해서 요청시 전달된 값을 추출
            request의 parameter영역안에 존재
            request.getparameter("키");
         */

        String name = req.getParameter("name");// 김진석 | 값이 없을경우 ""
        String gender = req.getParameter("gender"); // M | F | null
        int age = Integer.parseInt(req.getParameter("age")); // "23" -> 23
        String address = req.getParameter("address"); // "경기" | "서울" 등등
        double height = Double.parseDouble(req.getParameter("height")); // "180.0" -> 180.0

        // 체크박스와 같이 여러개의 값을 추출하고자 할 때 배열로 받자
        String[] foods = req.getParameterValues("foods"); // ["한식", "중식"] | null

        System.out.println("name : " + name + " gender : " + gender + " age : " + age + " address : " + address + " height : " + height);
        System.out.println("foods : " + String.join(",", foods));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
