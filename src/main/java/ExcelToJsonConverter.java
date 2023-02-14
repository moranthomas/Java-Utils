
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.Iterator;

@Slf4j
public class ExcelToJsonConverter {

    public JSONArray transform(FileInputStream inputExcelFile) throws IOException {

        // Load the Excel file
        //FileInputStream excelFile = new FileInputStream(new File("file.xlsx"));
        Workbook workbook = WorkbookFactory.create(inputExcelFile);

        // Get the first sheet from the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Get an iterator for the rows
        Iterator<Row> rowIterator = sheet.iterator();

        // Create a JSON array to store the data
        JSONArray data = new JSONArray();

        // Iterate over the rows
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Get an iterator for the cells
            Iterator<Cell> cellIterator = row.cellIterator();

            // Create a JSON object to store the row data
            JSONObject obj = new JSONObject();

            // Iterate over the cells
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                // Get the cell value
                String value = cell.getStringCellValue();

                // Get the cell index
                int index = cell.getColumnIndex();

                // Add the cell value to the JSON object
                obj.put("column" + index, value);
            }

            // Add the JSON object to the JSON array
            data.put(obj);
        }

        return data;
    }


}

