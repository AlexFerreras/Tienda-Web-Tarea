<%@page contentType="text/html" pageEncoding="UTF-8"%>

<center><h1 class="form-text">Ingresar Producto</h1></center>

    <div class="container col col-sm-4">
        <form action="Product" method="POST">
            
                <div class="form-group" >
                <label for="name" >Nombre:</label>
                <input type="text" class="form-control" id="name" name="name" required>
                </div>
                
                <div class="form-group">
                <label for="price"  >Precio:</label>
                <input type="text" class="form-control" id="price" name="price" required/>
                </div>
                
                <div class="form-group">
                <label for="quantity"  >Cantidad:</label>
                <input type="text" class="form-control" id="quantity" name="quantity" required/>
                </div>
            
                <div class="form-group">
                <label for="category"  >Categoria:</label>
                <input type="text" class="form-control" id="category" name="category" />
                </div>
            
                <div class="form-group">
                <label for="suplier"  >Suplidor:</label>
                <input type="text" class="form-control" id="suplier" name="suplier"/>
                </div>
            
                <div class="form-group">
                <label for="description"  >Descripcion</label>
                <input type="text" class="form-control" id="description" name="description"/>
                </div>
            
            <input class="btn btn-primary active right" type="submit" value="Guardar" />
            
            <input class="btn btn-danger active left-align" type="reset" value="Limpiar" />
        </form>
        
    </div>
        
    
    
  