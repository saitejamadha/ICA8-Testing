import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    void writeToFile(String content) {}

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

    public static void main(String[] args) {

    }

}
