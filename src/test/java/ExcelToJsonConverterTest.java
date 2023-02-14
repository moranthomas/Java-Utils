import org.json.JSONArray;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.assertEquals;
public class ExcelToJsonConverterTest {
    @Test
    public void testConversion() throws IOException {

        ExcelToJsonConverter excelToJsonConverter = new ExcelToJsonConverter();

        // Load the Excel file
        FileInputStream excelFile = new FileInputStream(new File("/Users/thomasmoran/Hacking/Java/Java-Utils/src/test/java/file.xlsx"));

        // Convert the Excel file to JSON format
        JSONArray jsonArray = excelToJsonConverter.transform(excelFile);
        // Convert the JSON to string format
        String json = jsonArray.toString();

        // Verify the JSON data
        assertEquals("[{\"column1\":\"value2\",\"column0\":\"value1\"},{\"column1\":\"value4\",\"column0\":\"value3\"}]", json);

        // Write the JSON out to a file
        // Write the JSON data to a file
        FileWriter fileWriter = new FileWriter("data.json");
        fileWriter.write(String.valueOf(json));
        fileWriter.close();

    }
}