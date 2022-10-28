import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sai Teja Madha
 */
public class Urinals {

    boolean goodString(String input) {
        if (input.trim().length() == 0) return false;
        Pattern pattern = Pattern.compile("^[0-1]*$");
        if (!pattern.matcher(input).matches()) {
            throw new NumberFormatException("Invalid input string");
        }
        return pattern.matcher(input).find();
    }

    String[] readFromFile(String filePath) throws IOException {
        File file = new File("./src/main/resources/" + filePath);

        List<String> listOfStrings = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String line = bf.readLine();

        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
        bf.close();

        return listOfStrings.toArray(new String[0]);
    }

    String writeToFile(String[] lines) throws IOException {
        String outFileName = getOutPutFile();
        File outputFile = new File("./" + outFileName);
        StringBuilder output = new StringBuilder();
        for (String line : lines) {
            output.append(this.countUrinals(line)).append("\n");
        }
        Files.write(outputFile.toPath(), output.toString().getBytes());
        return outFileName;
    }

    String getOutPutFile() {
        File file = new File("./rule.txt");
        if (!file.exists()) return "rule.txt";

        File folder = new File("./");
        File[] listOfFiles = folder.listFiles();

        int count = 0;
        assert listOfFiles != null;
        for (File f : listOfFiles) {
            if (f.isFile()) {
                String fileName = f.getName();
                if (fileName.contains("rule")) count ++;
            }
        }

        return "rule" + count + ".txt";
    }

    int countUrinals(String urinals) {
        Pattern pattern = Pattern.compile("11");
        Matcher matcher = pattern.matcher(urinals);
        if (matcher.find()) return -1;

        int prevCounts = (int) urinals.chars().filter(ch -> ch == '1').count();

        int[] urinalsArray = new int[urinals.length()];
        for (int i = 0; i < urinals.length(); i++) {
            urinalsArray[i] = Character.getNumericValue(urinals.charAt(i));
        }

        for (int i = 0; i < urinalsArray.length; i++) {
            int urinal = urinalsArray[i];
            if (i == 0) {
                if (urinalsArray.length == 1) {
                    return 1 - Integer.parseInt(String.valueOf(urinal));
                } else if ((urinal == 0) && urinalsArray[i + 1] == 0) {
                    urinalsArray[i] = 1;
                }
            } else if (i == urinalsArray.length - 1) {
                if (urinal == 0 && urinalsArray[i - 1] == 0) {
                    urinalsArray[i] = 1;
                }
            } else {
                if (urinal == 0 && urinalsArray[i - 1] == 0 && urinalsArray[i + 1] == 0) {
                    urinalsArray[i] = 1;
                }
            }
        }

        return (int) Arrays.stream(urinalsArray).filter(x -> x == 1).count() - prevCounts;

    }

    public static void main(String[] args) throws IOException {
        Urinals uri = new Urinals();
        while (true) {
            System.out.println("\n=== Available Options ===");
            System.out.println("1. Read from console");
            System.out.println("2. Read from file");
            System.out.println("3. Exit");
            System.out.print("Enter on option: ");
            Scanner sc = new Scanner(System.in);
            String next = sc.nextLine();

            if (next.equals("1")) {
                System.out.print("Enter the urinals string: ");
                String uriString = sc.nextLine();

                if (!uri.goodString(uriString)) {
                    System.out.println("Invalid input");
                    continue;
                }

                int count = uri.countUrinals(uriString);
                System.out.print("Available urinals count: " + count + "\n");
            } else if (next.equals("2")) {
                String[] lines = uri.readFromFile("urinal.dat");
                String outFile = uri.writeToFile(lines);
                System.out.println("Output is written to " + outFile);

            } else if (next.equals("3")) {
                System.out.println("Exiting...");
                System.exit(1);
            }
        }
    }

}
