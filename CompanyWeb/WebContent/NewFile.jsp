<%@page import="com.crispico.dao.impl.CompanyJPADao"%>
<%@page import="com.crispico.dao.EntityManagerHolder"%>
<%@page import="com.crispico.dao.impl.ClientJPADao"%>
<%@page import="com.crispico.model.Company"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<th>
	Nr. crt
	</th>
	
	<th>
		CUI
	</th>

	<th>
		Address
	</th>

<% 
List<Company> list = new CompanyJPADao(EntityManagerHolder.getInstance().getEntityManager()).loadAll();
int i = 1;
for (Company comp : list) {
//for (int i = 0; i < 10; i++) {
%>
	<tr>
		<td>
		<%= i++ %>
		</td>
		<td>
		<%= comp.getName() %>
		</td>
		<td>
		<%= comp.getCui() %>
		</td>
		<td>
		<%= comp.getAddress() %>
		</td>
	</tr>
<% } %>

</table>
</body>
</html>