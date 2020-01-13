package DAL;

import Models.Product;
import com.sun.media.sound.InvalidFormatException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;



public class DBconnection {
private static Workbook wb;
private static Sheet sh;
private static FileInputStream fis;
private static FileOutputStream fos;
private static Row row;
private static Cell cell;


    
    public void CreateConnection() throws IOException {
        Workbook wb = new HSSFWorkbook();

        try  (OutputStream fileOut = new FileOutputStream("./workbook.xls")) {
            wb.write(fileOut);
        }   catch (FileNotFoundException ex) {
                System.err.println(ex.getMessage());
            }


        }
}