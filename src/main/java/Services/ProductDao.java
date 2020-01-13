
package Services;

import DAL.DBconnection;
import DAO.GenericDAO;
import Models.Product;
import java.io.FileInputStream;
import java.util.List;

public class ProductDao extends DBconnection implements GenericDAO<Product>{

    @Override
    public List<Product> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Product t) {
         
        
    }

    @Override
    public void update(Product t, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
       
    
   
    
}
