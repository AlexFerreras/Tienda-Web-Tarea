/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ALEX FERRERAS
 */
public class ExcelManagment {

    String PATH = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    final String FILE_NAME = "DB.xlsx";
    public final String FILE_PATH = PATH + "\\" + FILE_NAME;

    public void setHeaderStyle(Workbook workbook, Row row) {
        CellStyle style = workbook.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setRightBorderColor(IndexedColors.BLUE.getIndex());
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        //Fonts
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 15);
        font.setFontName("Comic Sans MS");
        font.setItalic(true);
        style.setFont(font);

        for (Cell cell : row) {
            cell.setCellStyle(style);
        }
    }

    public void setDBHeader(String file_path) throws FileNotFoundException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Products");
        try {
            Row row = sheet.createRow(sheet.getFirstRowNum());

            row.createCell(0).setCellValue("Nombre");
            row.createCell(1).setCellValue("Categoria");
            row.createCell(2).setCellValue("Precio");
            row.createCell(3).setCellValue("Cantidad");
            row.createCell(4).setCellValue("Descripcion");
            row.createCell(5).setCellValue("Suplidor");
            row.createCell(6).setCellValue("Fecha de Creacion");
            //set header styles
            setHeaderStyle(workbook, row);

            FileOutputStream fos = new FileOutputStream(file_path);
            workbook.write(fos);
        } catch (IOException ex) {
            System.err.println("el error es " + ex.getMessage());
        }

    }

    public FileInputStream createDB() {
        File file = new File(FILE_PATH);
        FileInputStream fis = null;
        try {
            //create the excel file if doesnt exist and set header
            if (file.createNewFile()) {
                setDBHeader(FILE_PATH);
            }
            fis = new FileInputStream(file);

        } catch (IOException ex) {
            System.err.println("Error creando el archivo " + ex.getMessage());
        }

        return fis;

    }
}
