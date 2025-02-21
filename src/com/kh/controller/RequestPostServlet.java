package com.kh.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * http://locallhost:8001/servlet/posttest.do
 * Servlet의 요청 경로는 contextPath뒤에 작성됨
 */
@WebServlet("/posttest.do")
public class RequestPostServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setCharacterEncoding("utf-8"); tomcat 구버전에서는 문자셋 변경이 필요하다

        // POST 방식같은 경우에도 동일하게 데이터를 사용하면 된다.

        String name = req.getParameter("name");// 김진석 | 값이 없을경우 ""
        String gender = req.getParameter("gender"); // M | F | null
        int age = Integer.parseInt(req.getParameter("age")); // "23" -> 23
        String address = req.getParameter("address"); // "경기" | "서울" 등등
        double height = Double.parseDouble(req.getParameter("height")); // "180.0" -> 180.0

        // 체크박스와 같이 여러개의 값을 추출하고자 할 때 배열로 받자
        String[] foods = req.getParameterValues("food"); // ["한식", "중식"] | null

        System.out.println("name : " + name);
        System.out.println("gender : " + gender);
        System.out.println("age : " + age);
        System.out.println("adrress : " + address);
        System.out.println("height : " + height);
        System.out.println("foods : " + String.join(", ", foods));


        // service > dao > db

        /**
         * int result = new MemberService().insertMember(name,gender...);
         * if(result > 0){
         *  // 성공
         *  }else{
         *  // 실패
         *}
         */

        // 반환방식 1. 데이터를 그대로 돌려준다 - 클라이언트 사이드 렌더링 (REST API 방식에서 사용)

        // 반환방식 2. 서버사이드 방식으로 html을 java코드로 완성해서 돌려준다. (jsp, thymleaf...)

        // jsp(Java Server Page)방식 : html내에 java코드를 쓸 수 있음

        // 응답페이지를 만드는 과정을 jsp에게 위임
        // 단, 응답화면에서 필요로하는 데이터들을 차곡차곡 담아서 전달해줘야 함
        // 데이터들을 담기 위한 공간 => request의 attribute영역
        // request.setAttribute("키" , 값);

        req.setAttribute("name", name);
        req.setAttribute("gender", gender);
        req.setAttribute("age", age);
        req.setAttribute("address", address);
        req.setAttribute("height", height);
        req.setAttribute("foods", foods);

        // 현재 요청을 responsePage.jsp로 전달하기 위한 객체
        RequestDispatcher view = req.getRequestDispatcher("/views/responsePage.jsp");

        // 위에서 설정한 view로 응답을 위임함
        view.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST로 전달됨");
        doGet(req, resp);
    }
}
