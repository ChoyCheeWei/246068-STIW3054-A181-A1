import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

class Excel {


    private static final String[] columns = {"Tajuk", "Maklumat"};

    public void WriteToExcel(ArrayList<Data> data) throws IOException {

            // Create a Workbook
            Workbook workbook = new XSSFWorkbook();

            //Create sheet
            Sheet sheet = workbook.createSheet("Trivia Table Data");

           // Create a Font for styling header cells
           Font headerFont = workbook.createFont();
           headerFont.setBold(true);
           headerFont.setFontHeightInPoints((short) 16);


           // Create a CellStyle with the font
           CellStyle headerCellStyle = workbook.createCellStyle();
           headerCellStyle.setFont(headerFont);


            //set border style for header cells
            headerCellStyle.setBorderRight(BorderStyle.MEDIUM);
            headerCellStyle.setBorderBottom(BorderStyle.MEDIUM);

            //set text to center
            headerCellStyle.setAlignment(HorizontalAlignment.CENTER);


            //create a  CellStyle with border
            CellStyle cellStyle = workbook.createCellStyle();

            cellStyle.setBorderRight(BorderStyle.MEDIUM);
            cellStyle.setBorderLeft(BorderStyle.MEDIUM);
            cellStyle.setBorderTop(BorderStyle.MEDIUM);
            cellStyle.setBorderBottom(BorderStyle.MEDIUM);

            //Create row
            Row headerRow = sheet.createRow(0);

            // Create cells
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerCellStyle);

            }

            // Print data to row
            int rowNum = 1;
            for (Data data1 : data) {
                Row row = sheet.createRow(rowNum++);

                Cell column1 = row.createCell(0);
                column1.setCellValue(data1.getFirstColumn());
                column1.setCellStyle(cellStyle);

                Cell column2 = row.createCell(1);
                column2.setCellValue(data1.getSecondColumn());
                column2.setCellStyle(cellStyle);

            }

            // Resize all columns to fit the content size
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

             // Write the output to a file
                FileOutputStream fileOut = new FileOutputStream("C:\\Users\\ccw\\Desktop\\Trivia_Table_Data.xlsx");
                workbook.write(fileOut);
                fileOut.close();

                System.out.println("\n\n\n"+"Excel file has successfully created..........");

            }

    }


