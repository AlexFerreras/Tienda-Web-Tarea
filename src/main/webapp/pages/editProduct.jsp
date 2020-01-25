<%@page import="Services.ProductDao"%>
<%@page import="java.util.List"%>
<%@page import="Models.Product"%>
<%
    Product product = new ProductDao().getOneById(Integer.parseInt((String)request.getParameter("id")));
%>
  <center><h1 class="h1">Editar Producto</h1></center>
<div class="col col-sm-3"></div>
    <div class="container col col-sm-6">
        <form action="Product" method="POST">
         
                <div class="form-group">
                <label for="id" >Id:</label>
                <input type="text" class="form-control" value="<%= product.getId()%>" id="id" name="id" readonly>
                </div>
                
                <div class="form-group" >
                <label for="name" >Nombre:</label>
                <input type="text" class="form-control" id="name" name="name" value="<%= product.getName()%>" required>
                </div>
                
                <div class="form-group">
                <label for="price"  >Precio:</label>
                <input type="text" class="form-control" id="price" name="price" value="<%= product.getPrice()%>" required/>
                </div>
                
                <div class="form-group">
                <label for="quantity"  >Cantidad:</label>
                <input type="text" class="form-control" id="quantity" name="quantity" value="<%= product.getQuantity()%>" required/>
                </div>
            
                <div class="form-group">
                <label for="category"  >Categoria:</label>
                <input type="text" class="form-control" id="category" value="<%= product.getCategory()%>" name="category" />
                </div>
            
                <div class="form-group">
                <label for="suplier"  >Suplidor:</label>
                <input type="text" class="form-control" id="suplier" value="<%= product.getSuplier()%>" name="suplier"/>
                </div>
            
                <div class="form-group">
                <label for="description"  >Descripcion</label>
                <input type="text" class="form-control" id="description" value="<%= product.getDescription()%>" name="description"/>
                </div>
            
                <input class="btn btn-primary active right" type="submit" value="Guardar Cambios">
            
        </form>
        
    </div>
        
    

