import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Enter keys to action:");
        System.out.println("Create txt file - 1");
        System.out.println("Delete txt file - 2");
        System.out.println("Rename txt file - 3");
        System.out.println("Find word in txt file - 4");
        System.out.println("Replace word in txt file - 5");
        System.out.println("Read xlsx file - 6");
        System.out.println("Write xlsx file - 7");
        System.out.println("Find word in xlsx file - 8");
        System.out.println("Replace word in xlsx file - 9");
        System.out.println("Replace all repeated words in xlsx file - 10");
        System.out.println("Exit - 0");

        do {
            System.out.println("\nEnter your command:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();

            FileManager fileManager = new FileManager();
            int num = Integer.parseInt(input);

            if (input.equals("0")) {
                break;
            }

            System.out.print("Enter path ");
            if (isWindows()) {
                System.out.println("(example: \"C:\\Users\\Desktop\\\"):");
            } else if (isMac()) {
                System.out.println("(example: \"Macintosh HD:Documents:\"):");
            } else if (isUnix()) {
                System.out.println("(example: \"/home/user/docs/\"):");
            } else {
                System.out.println("This is unknown OS");
            }
            String path = reader.readLine();

            if (num == 1) {
                System.out.println("Enter name of new file:");
                String name = reader.readLine();
                fileManager.createFile(path, name);
            } else if (num == 2) {
                System.out.println("Enter name of file to delete:");
                String name = reader.readLine();
                fileManager.deleteFile(path, name);
            } else if (num == 3) {
                System.out.println("Enter old name:");
                String name = reader.readLine();
                System.out.println("Enter new name:");
                String newName = reader.readLine();
                fileManager.renameFile(path, name, newName);
            } else if (num == 4) {
                System.out.println("Enter file name:");
                String name = reader.readLine();
                System.out.println("Enter word that need to be found:");
                String word = reader.readLine();
                fileManager.findWord(path, name, word);
            } else if (num == 5) {
                System.out.println("Enter file name:");
                String name = reader.readLine();
                System.out.println("Enter word that need to be replaced:");
                String word = reader.readLine();
                System.out.println("Enter new word:");
                String newWord = reader.readLine();
                fileManager.replaceWord(path, name, word, newWord);
            } else if (num == 6) {
                System.out.println("Enter name of xlsx file:");
                String name = reader.readLine();
                fileManager.readXLSXFile(path, name);
            } else if (num == 7) {
                System.out.println("Enter name of xlsx file:");
                String name = reader.readLine();
                System.out.println("Enter new data:");
                String data = reader.readLine();
                fileManager.writeXLSXFile(path, name, data);
            } else if (num == 8){
                System.out.println("Enter name of xlsx file:");
                String name = reader.readLine();
                System.out.println("Enter word to found:");
                String content = reader.readLine();
                fileManager.findWordXLSX(path, name, content);
            } else if (num == 9){
                System.out.println("Enter name of xlsx file:");
                String name = reader.readLine();
                System.out.println("Enter word that need to be replaced:");
                String content = reader.readLine();
                System.out.println("Enter new word:");
                String newContent = reader.readLine();
                fileManager.replaceWordXLSX(path, name, content, newContent);
            } else if (num == 10){
                System.out.println("Enter name of xlsx file:");
                String name = reader.readLine();
                System.out.println("Enter word that need to be replaced:");
                String content = reader.readLine();
                System.out.println("Enter new word:");
                String newContent = reader.readLine();
                fileManager.replaceAllXLSX(path, name, content, newContent);
            }
        } while (true);
    }

    public static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("win"));
    }
    public static boolean isMac(){
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("mac"));
    }
    public static boolean isUnix (){
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("nix") || os.contains("nux"));
    }
}