
package Services;

import DAO.GenericDAO;
import Models.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ProductDao implements GenericDAO<Product>{
    String PATH = "C:\\Users\\ALEX FERRERAS\\Desktop\\Tienda-Web-Tarea";
    final String FILE_NAME ="DBD.xlsx";
    final String FILE_PATH =PATH+"\\"+FILE_NAME;
    
    static boolean isRowEmpty(Row row) {
		boolean isEmpty = true;
		DataFormatter dataFormatter = new DataFormatter();

		if (row != null) {
			for (Cell cell : row) {
				if (dataFormatter.formatCellValue(cell).trim().length() > 0) {
					isEmpty = false;
					break;
				}
			}
		}

		return isEmpty;
	}
    
    
    @Override
    public List<Product> getAll() {
     List<Product> products = new ArrayList<Product>();   
    FileInputStream fis;
        try {
            fis = new FileInputStream(FILE_PATH);
            //assuming xlsx file
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
                
		while (rowIterator.hasNext()) 
                    {
                    
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
            
                        while (cellIterator.hasNext()) 
                            {
                            Cell cell = cellIterator.next();
                            
                            int index = cell.getColumnIndex()+1;
                            // Cell cell = cellIterator.next();
                              
                            String name = sheet.getRow(index).getCell(0).toString();
                            String category = sheet.getRow(index).getCell(1).toString();
                            double price = sheet.getRow(index).getCell(2).getNumericCellValue();
                            int quantity = (int)(sheet.getRow(index).getCell(3).getNumericCellValue());
                            String description = sheet.getRow(index).getCell(4).toString();
                            String suplier = sheet.getRow(index).getCell(5).toString();
                            String date = sheet.getRow(index).getCell(6).toString();
                             
                            products.add(new Product(index, name,price ,quantity,category, suplier, description, date));
                            fis.close();
                            }
                    }
                
   
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
        
       Workbook workbook = null;
       try {
        FileInputStream file = new FileInputStream(new File(FILE_PATH));
        workbook = new XSSFWorkbook(file);
      
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
              
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            fos.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
            
       
		
		
		
    

    @Override
    public void update(Product t, Object id) {
        try {
            FileInputStream file = new FileInputStream(new File("C:\\update.xls"));

            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell = null;

            //Update the value of cell
            cell = sheet.getRow(1).getCell(2);
            cell.setCellValue(cell.getNumericCellValue() * 2);
            cell = sheet.getRow(2).getCell(2);
            cell.setCellValue(cell.getNumericCellValue() * 2);
            cell = sheet.getRow(3).getCell(2);
            cell.setCellValue(cell.getNumericCellValue() * 2);

            file.close();

            FileOutputStream outFile =new FileOutputStream(new File("C:\\update.xls"));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
       
    
   
    
}
