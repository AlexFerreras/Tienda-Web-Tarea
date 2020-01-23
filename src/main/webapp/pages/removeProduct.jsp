<%-- 
    Document   : removeProduct
    Created on : Jan 23, 2020, 2:07:29 PM
    Author     : aferreras
--%>

<%@page import="Services.ProductDao"%>
<h1 class="text-center">Eliminando...</h1>
<%
    ProductDao controller = new ProductDao();
    controller.delete(Integer.parseInt(request.getParameter("id")));
    response.sendRedirect("index.jsp?page=listProduct");
%>
