import com.microsoft.schemas.office.visio.x2012.main.CellType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Iterator;


public class FileManager {

    public void createFile(String path, String name) {
        File file = new File(path + name + ".txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File named \"" + name + "\" created successfully!");
            } else {
                System.out.println("File with name \"" + name + "\" already exists!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String path, String name) {
        File file = new File(path + name + ".txt");
        try {
            if (file.delete()) {
                System.out.println("File \"" + name + "\" deleted successfully!");
            } else {
                System.out.println("Delete operation failed. No such file with name \"" + name + "\".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void renameFile(String path, String name, String newName) {
        File file = new File(path + name + ".txt");
        File newFile = new File(path + newName + ".txt");
        try {
            if (file.renameTo(newFile)) {
                System.out.println("File renamed successful!");
            } else {
                System.out.println("File rename operation failed! No such file with name \"" + name + "\" or file with such name already exists.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findWord(String path, String name, String word) {
        File file = new File(path + name + ".txt");
        Charset charset = Charset.forName("US-ASCII");
        boolean flag = false;
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(word))
                    flag = true;
            }
            if (flag) {
                System.out.println("File contains provided word.");
            } else {
                System.out.println("Word \"" + word + "\" not found.");
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public void replaceWord(String path, String name, String word, String newWord) {
        File file = new File(path + name + ".txt");
        String text = "";
        String newText;
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (System.getProperty("os.name").contains("Windows")) {
                    text += line + "\r\n";
                } else {
                    text += line + "\n";
                }
            }
            reader.close();
            if (text.contains(word)) {
                newText = text.replaceAll(word, newWord);
                FileWriter writer = new FileWriter(path + name + ".txt");
                writer.write(newText);
                writer.close();
                System.out.println("Word \"" + word + "\" replaced with \"" +newWord+ "\".");
            } else {
                System.out.println("Word \"" + word + "\" is missing in the \"" +name+ "\" file.");
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public static void readXLSFile(String path, String name) {

        try {

            FileInputStream file = new FileInputStream (new File(path + name + ".xls"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();

                    if (currentCell.getCellType() == Cell.CELL_TYPE_STRING) {
                        System.out.print(currentCell.getStringCellValue() + "  ");
                    } else if (currentCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "  ");
                    }
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}