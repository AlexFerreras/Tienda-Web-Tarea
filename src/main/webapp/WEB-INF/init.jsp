<%@page import="java.util.ArrayList"%>
<%@page import="Models.Product"%>
<%@page import="Services.ProductDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<% 

    ProductDao cs= new ProductDao();
    ArrayList<Product> products = null;
    products =(ArrayList<Product>)cs.getAll();
     
%>
<center>
    

 <div class="table-responsive ">
    
     <table class="table table-bordred table-striped" style=" border-bottom: 1px solid #ddd; border:1px solid #ddd ">
         <h1 class="table-title">Mis Productos</h1>        
         <thead>
                <th>Id</th>
                <th>Nombre</th>
                <th>Categoria</th>
                <th>Precio</th>
                 <th>Cantidad</th>
                <th>Descripcion</th>
                <th>Suplidor</th>
                <th>Fecha de Creacion</th>
                <th>Editar</th>
                <th>Eliminar</th> 
                </thead>
                <tbody>
              
                <% for (int i =0; i<products.size(); i++){
                System.err.println(products.get(i).getName());
                %>
                <tr>
                    <td><%= products.get(i).getId() %></td>
                    <td><%= products.get(i).getName() %></td>
                    <td><%= products.get(i).getCategory()%></td>
                   <td><%= products.get(i).getPrice()%></td>
                   <td><%= products.get(i).getQuantity()%></td>
                   <td><%= products.get(i).getDescription()%></td>
                   <td><%= products.get(i).getSuplier()%></td>
                   <td><%= products.get(i).getCreationDate()%></td>
                    <td><p data-placement="top" data-toggle="tooltip" title="Edit"><a class="btn btn-primary btn-ms" href="index.jsp?page=editarContacto&id=<%=products.get(i).getId()%>"  >Editar</a></p></td>
                    <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-ms" onclick="eliminar(this)" id="<%=products.get(i).getId()%>">Eliminar</button></p></td>
    
                </tr>
               <%}%>    
                             
                </tbody>           
            </table>
    </div>
 </center>  
                

 
