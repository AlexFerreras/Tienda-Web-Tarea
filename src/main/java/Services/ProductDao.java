
package Services;

import DAO.GenericDAO;
import Models.Product;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ProductDao implements GenericDAO<Product>{
    
    final String FILE_NAME ="C:\\Users\\AFERRERAS\\Documents\\NetBeansProjects\\TiendaWeb\\DB.xlsx";
    
    @Override
    public List<Product> getAll() {
     List<Product> products = new ArrayList<Product>();   
     int rowNumber =0;
    FileInputStream fis;
        try {
            fis = new FileInputStream(FILE_NAME);
            //assuming xlsx file
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) 
        {               rowNumber++;
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
            
            while (cellIterator.hasNext()) 
            {
                
            	// Cell cell = cellIterator.next();
                
                String name = sheet.getRow(rowNumber).getCell(0).toString();
                String category = sheet.getRow(rowNumber).getCell(1).toString();
                double price = Double.parseDouble(sheet.getRow(rowNumber).getCell(2).toString());
                int quantity = Integer.parseInt(sheet.getRow(rowNumber).getCell(3).toString());
                String description = sheet.getRow(rowNumber).getCell(4).toString();
                String suplier = sheet.getRow(rowNumber).getCell(5).toString();
                String date = sheet.getRow(rowNumber).getCell(6).toString();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
                String strDate = dateFormat.format(date);
                
                products.add(new Product(name,price, quantity, category, suplier, description, strDate));
            }}
            
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }finally{
            return products;
        }

    }

    @Override
    public void create(Product product) {
        Workbook workbook =  new XSSFWorkbook();
        
         Sheet sheet = workbook.getSheetAt(0);
        
        Row row = sheet.createRow(2);
        
        Cell cell0 = row.createCell(0);
        cell0.setCellValue(product.getName());
        Cell cell1 = row.createCell(1);
        cell1.setCellValue(product.getCategory());
        Cell cell2 = row.createCell(2);
        cell2.setCellValue(product.getPrice());
        Cell cell3 = row.createCell(3);
        cell3.setCellValue(product.getQuantity());
        Cell cell4 = row.createCell(4);
        cell4.setCellValue(product.getDescription());
        Cell cell5 = row.createCell(5);
        cell5.setCellValue(product.getDescription());
        
        
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            workbook.write(fos);
            fos.close();
            System.out.println(FILE_NAME + " written successfully");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
		
		
		
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
