
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class ExcelToJsonConverter {

    public JSONArray transform(FileInputStream inputExcelFile) throws IOException {

        // Load the Excel file
        //FileInputStream excelFile = new FileInputStream(new File("file.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(inputExcelFile);

        //Workbook workbook = WorkbookFactory.create(inputExcelFile);
        // Get the first sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Get an iterator for the rows
        Iterator<Row> rowIterator = sheet.iterator();

        // Create a JSON array to store the data
        JSONArray data = new JSONArray();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Create a list to store the values of the cells in the row
            List<String> cellValues = new ArrayList<>();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cellValues.add(cell.getStringCellValue());
            }

            // Create a JSON object to store the values of the cells in the row
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ica_no", cellValues.get(0));
            jsonObject.put("ica_name", cellValues.get(1));

            // Add the JSON object to the JSON array
            data.put(jsonObject);
        }

        return data;
    }


}

