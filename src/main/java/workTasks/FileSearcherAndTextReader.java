package workTasks;

import org.apache.commons.io.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

//Task 7

public class FileSearcherAndTextReader {

    private static int stringsCounter1 = 0;
    private static int stringPositionCounter = 0;
    private static int stringsCounter2 = 0;
    private static String digitalId;
    private static String folder;
    private static String mask;
    private static String fileName;
    private static List<String> lines;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Please, enter a path to your file(-s) and press Enter button: ");
            // 1) you should enter 'src/main/resources/'
            folder = reader.readLine();

            System.out.println("Please, enter a mask for your file(-s) and press Enter button: ");
            // 2) you should enter 'out'
            mask = reader.readLine();

            Collection<File> files = FileUtils.listFiles(new File(folder), new String[]{mask}, true);

            if (files.isEmpty()) {
                System.out.println("There is no such file.");
            }

            for (File file : files) {
                FileSearcherAndTextReader fileSearch = new FileSearcherAndTextReader();

                System.out.println("Please, enter a digital id and press Enter button: ");
                // 3) you should enter '344388738325 0095' to try this code
                digitalId = reader.readLine();

                if (fileSearch.isParsed("" + file, digitalId)) {
                    fileName = file.getName();
                    stringsCounter();
                } else {
                    System.out.println("There is no file(-s) with such id.");
                }
            }
        } catch (IOException ex) {
            System.out.println("There is no such directory.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong format of directory to find.");
        }
    }

    public boolean isParsed(String fileName, String searchStr) throws IOException {
        Scanner scan = new Scanner(new File(fileName));

        while (scan.hasNext()) {
            String line = scan.nextLine().toLowerCase().toString();
            if(line.contains(searchStr)){
                return true;
            }
        }
        return false;
    }

    public static void stringsCounter() throws IOException {
        lines = Files.readAllLines(Paths.get(folder + fileName), StandardCharsets.UTF_8);

        for (String line : lines) {
            stringsCounter1++;

            if (line.contains(digitalId)) {
                stringPositionCounter = stringsCounter1;
            }
        }

        for (String line : lines) {
            stringsCounter2++;

            if (stringsCounter2 == stringPositionCounter + 101) {
                break;
            }

            if (stringsCounter2 > stringPositionCounter - 101) {
                System.out.println(line);
            }
        }
    }
}
