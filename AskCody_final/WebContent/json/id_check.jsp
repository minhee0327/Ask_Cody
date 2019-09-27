<%@page import="dao.UsersDao_Oracle"%>
<%@page import="dao.UsersDao"%>
<%@page import="json_jdbc.JsonDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
UsersDao dao = new UsersDao_Oracle();
String id = request.getParameter("id");
String data = dao.idcheck(id); //JSON DB에 있는 데이터를 가져온다.

%>

<%= data %>