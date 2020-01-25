
package Services;

import DAO.GenericDAO;
import Models.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ProductDao implements GenericDAO<Product>{
    String PATH = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    final String FILE_NAME ="DB.xlsx";
    final String FILE_PATH =PATH+"\\"+FILE_NAME;
     
    public void setDBHeader(String file_path) throws IOException{
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row = sheet.createRow(sheet.getFirstRowNum());
         
            Cell cell0 = row.createCell(0);
               cell0.setCellValue("Nombre");
            Cell cell1 = row.createCell(1);
               cell1.setCellValue("Categoria");
            Cell cell2 = row.createCell(2);
               cell2.setCellValue("Precio");
            Cell cell3 = row.createCell(3);
               cell3.setCellValue("Cantidad");
            Cell cell4 = row.createCell(4);
               cell4.setCellValue("Descripcion");
            Cell cell5 = row.createCell(5);
               cell5.setCellValue("Suplidor");
            Cell cell6 = row.createCell(6);
               cell6.setCellValue("Fecha de Creacion");
            System.out.println("Se creo el excel con Header");
              
            FileOutputStream fos = new FileOutputStream(file_path);
            workbook.write(fos);
            fos.close();
           
    }
    
    public FileInputStream createDB(){
        File file = new File(FILE_PATH);
        FileInputStream fis = null;
        try{
            if (file.createNewFile()) {
                setDBHeader(FILE_PATH);
            }
            fis = new FileInputStream(file);
            
        }catch(IOException ex){
        System.err.println("Error creando el archivo "+ex.getMessage());
        }
            
    return fis;

    }
    @Override
    public List<Product> getAll() {
     List<Product> products = new ArrayList<Product>();   
        FileInputStream fis;
        try {
            
            fis = createDB();
            
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
                
		while (rowIterator.hasNext()) 
                    {
			Row row = rowIterator.next();
			
                            int index = row.getRowNum()+1;
                              
                            String name = sheet.getRow(index).getCell(0).toString();
                            String category = sheet.getRow(index).getCell(1).toString();
                            double price = sheet.getRow(index).getCell(2).getNumericCellValue();
                            int quantity = (int)(sheet.getRow(index).getCell(3).getNumericCellValue());
                            String description = sheet.getRow(index).getCell(4).toString();
                            String suplier = sheet.getRow(index).getCell(5).toString();
                            String date = sheet.getRow(index).getCell(6).toString();
                             
                            products.add(new Product(index, name,price ,quantity,category, suplier, description, date));
                            
                            
                    }
                fis.close();
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
        
       try {
        FileInputStream fis = createDB();
        Workbook workbook = new XSSFWorkbook(fis);
      
        Sheet sheet = workbook.getSheetAt(0);
        
         Row row = sheet.createRow(sheet.getLastRowNum()+1);
         
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
               cell5.setCellValue(product.getSuplier());
               Cell cell6 = row.createCell(6);
               cell6.setCellValue(product.getCreationDate());
               System.out.println(FILE_PATH + " written successfully");
              
            FileOutputStream out = new FileOutputStream(FILE_PATH);
            workbook.write(out);
            out.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage() );
        }
    }
            

    @Override
    public void update(Product product, int id) {
        try {
            FileInputStream fis = createDB();
        Workbook workbook = new XSSFWorkbook(fis);
      
        Sheet sheet = workbook.getSheetAt(0);
        
         Row row = sheet.createRow(id);
         
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
               cell5.setCellValue(product.getSuplier());
               Cell cell6 = row.createCell(6);
               cell6.setCellValue(product.getCreationDate());
               System.out.println(FILE_PATH + " updated successfully");
              
            FileOutputStream out = new FileOutputStream(FILE_PATH);
            workbook.write(out);
            out.close();

        } catch (IOException ex) {
            System.err.println("Error in the update method "+ex.getMessage());
        }
    }

   
    @Override
    public Product getOneById(int id) {
        Product product =null;
         FileInputStream fis;
        try {
            
            fis = createDB();
            
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
                
                            String name = sheet.getRow(id).getCell(0).toString();
                            String category = sheet.getRow(id).getCell(1).toString();
                            double price = sheet.getRow(id).getCell(2).getNumericCellValue();
                            int quantity = (int)(sheet.getRow(id).getCell(3).getNumericCellValue());
                            String description = sheet.getRow(id).getCell(4).toString();
                            String suplier = sheet.getRow(id).getCell(5).toString();
                            String date = sheet.getRow(id).getCell(6).toString();
                             
                            product = new Product(id, name,price ,quantity,category, suplier, description, date);
                            
                fis.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }finally{
             return product;
        }        
    }

    @Override
    public void delete(int id) {
        
        try {
           
            FileInputStream fis = createDB();
            
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
                //removing row
                
                sheet.removeRow(sheet.getRow(id));
                FileOutputStream out = new FileOutputStream(FILE_PATH);
                workbook.write(out);
                out.close();
           
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }     
    }

    
}
