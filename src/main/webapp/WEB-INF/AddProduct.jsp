<%-- 
    Document   : AgregarContacto
    Created on : 08-dic-2017, 19:38:03
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<center><h1 class="h1">Ingresar Producto</h1></center>
<div class="col col-sm-3"></div>
    <div class="container col col-sm-6">
        <form id="formagregar">
            
                <div class="form-group">
                <label for="nombre" >Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
                </div>
                
                <div class="form-group">
                <label for="Precio"  >Precio:</label>
                <input type="text" class="form-control" id="Precio" name="Precio" required/>
                </div>
                
                <div class="form-group">
                <label for="cantidad"  >Cantidad:</label>
                <input type="text" class="form-control" id="cantidad" name="cantidad"/>
                </div>
            
                <div class="form-group">
                <label for="categoria"  >Categoria:</label>
                <input type="text" class="form-control" id="categoria" name="categoria" required/>
                </div>
            
            <div class="form-group">
                <label for="suplidor"  >Suplidor:</label>
                <input type="text" class="form-control" id="suplidor" name="suplidor" required/>
                </div>
            
                <div class="form-group">
                <label for="direccion"  >Descripcion</label>
                <input type="text" class="form-control" id="direccion" name="direccion"/>
                </div>
            
            <input class="btn btn-primary active right" type="button" id="agregar" value="Registrar">
            
            <input class="btn btn-danger active left" type="reset" value="Limpiar">
        </form>
        
    </div>
        
    
    
  