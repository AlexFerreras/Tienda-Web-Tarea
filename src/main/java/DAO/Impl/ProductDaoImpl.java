package DAO.Impl;

import DAO.GenericDAO;
import Models.Product;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import helpers.ExcelManagment;

public class ProductDaoImpl extends ExcelManagment implements GenericDAO<Product> {

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<Product>();
        FileInputStream fis;
        try {

            fis = createDB();

            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                int index = row.getRowNum();
                //don't take the header
                if (index == 0) {
                    continue;
                }

                String name = row.getCell(0).toString();
                String category = row.getCell(1).toString();
                double price = row.getCell(2).getNumericCellValue();
                int quantity = (int) (row.getCell(3).getNumericCellValue());
                String description = row.getCell(4).toString();
                String suplier = row.getCell(5).toString();
                String date = row.getCell(6).toString();

                products.add(new Product(index, name, price, quantity, category, suplier, description, date));
            }
            fis.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            return products;
        }
    }

    @Override
    public void create(Product product) {

        try {
            FileInputStream fis = createDB();
            Workbook workbook = new XSSFWorkbook(fis);

            Sheet sheet = workbook.getSheetAt(0);

            Row row = sheet.createRow(sheet.getLastRowNum() + 1);

            row.createCell(0).setCellValue(product.getName());
            row.createCell(1).setCellValue(product.getCategory());
            row.createCell(2).setCellValue(product.getPrice());
            row.createCell(3).setCellValue(product.getQuantity());
            row.createCell(4).setCellValue(product.getDescription());
            row.createCell(5).setCellValue(product.getSuplier());
            row.createCell(6).setCellValue(product.getCreationDate());
            System.out.println(FILE_PATH + " written successfully");

            FileOutputStream out = new FileOutputStream(FILE_PATH);
            workbook.write(out);
            out.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void update(Product product, int id) {
        try {
            FileInputStream fis = createDB();
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(id);

            row.getCell(0).setCellValue(product.getName());
            row.getCell(1).setCellValue(product.getCategory());
            row.getCell(2).setCellValue(product.getPrice());
            row.getCell(3).setCellValue(product.getQuantity());
            row.getCell(4).setCellValue(product.getDescription());
            row.getCell(5).setCellValue(product.getSuplier());;
            row.getCell(6).setCellValue(product.getCreationDate());

            System.out.println(FILE_PATH + " updated successfully");

            FileOutputStream out = new FileOutputStream(FILE_PATH);
            workbook.write(out);
            out.close();

        } catch (IOException ex) {
            System.err.println("Error in the update method " + ex.getMessage());
        }
    }

    @Override
    public Product getOneById(int id) {
        Product product = null;
        FileInputStream fis;
        try {

            fis = createDB();

            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(id);

            String name = row.getCell(0).toString();
            String category = row.getCell(1).toString();
            double price = row.getCell(2).getNumericCellValue();
            int quantity = (int) (row.getCell(3).getNumericCellValue());
            String description = row.getCell(4).toString();
            String suplier = row.getCell(5).toString();
            String date = row.getCell(6).toString();

            product = new Product(id, name, price, quantity, category, suplier, description, date);

            fis.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
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
            int lastRowNum = sheet.getLastRowNum();
            if (id >= 0 && id < lastRowNum) {
                sheet.shiftRows(id + 1, lastRowNum, -1);
            }
            if (id == lastRowNum) {
                Row removingRow = sheet.getRow(id);
                if (removingRow != null) {
                    sheet.removeRow(removingRow);
                }
            }

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
