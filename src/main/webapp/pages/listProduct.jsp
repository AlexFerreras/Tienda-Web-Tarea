<%@page import="java.util.List"%>
<%@page import="Models.Product"%>
<%@page import="Services.ProductDao"%>
<% 

    List<Product> products  =new ProductDao().getAll();
     
%>
<center>
    <div class="container col col-sm-10">

 <div class="table-responsive">
    
     <table class="table table-bordred table-striped" style=" border-bottom: 1px solid #ddd; border:1px solid #ddd ">
         <h1 class="table-title">Productos</h1>        
         <thead>
                <th>Id</th>
                <th>Nombre</th>
                <th>Categoria</th>
                <th>Precio</th>
                 <th>Cantidad</th>
                <th>Descripcion</th>
                <th>Suplidor</th>
                <th>Fecha de Creacion</th>
                <th><i class="ti-layout-grid2-thumb"></i>Opciones</th>
                </thead>
                <tbody>
              
               <% for(Product product : products){%>
                <tr>
                    <td><%= product.getId() %></td>
                    <td><%= product.getName() %></td>
                    <td><%= product.getCategory()%></td>
                   <td><%= product.getPrice()%></td>
                   <td><%= product.getQuantity()%></td>
                   <td><%= product.getDescription()%></td>
                   <td><%= product.getSuplier()%></td>
                   <td><%= product.getCreationDate()%></td>
                    <td>
                        <a class="btn btn-primary btn-ms" href="index.jsp?page=editProduct&id=<%=product.getId()%>">Editar<i class="ti-pencil"/></i></a>
                        <a class="btn btn-danger btn-ms" href="index.jsp?page=removeProduct&id=<%=product.getId()%>">Eliminar<i class="ti-trash"></i></a>
                    </td>

                </tr>
               <%}%>   
                     
                </tbody>           
            </table>
    </div>
               </div>
 </center>  
                

 
