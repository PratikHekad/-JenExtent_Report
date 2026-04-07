package utils;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import java.io.FileInputStream;
import java.util.*;
public class ExcelUtil {

    public static List<Map<String, String>> getTestData(String path, String sheetName) {

        List<Map<String, String>> data = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row currentRow = sheet.getRow(i);
                Map<String, String> map = new HashMap<>();

                for (int j = 0; j < currentRow.getLastCellNum(); j++) {
                    String key = headerRow.getCell(j).toString();
                    String value = currentRow.getCell(j).toString();

                    map.put(key, value);
                }

                data.add(map);
            }

            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}