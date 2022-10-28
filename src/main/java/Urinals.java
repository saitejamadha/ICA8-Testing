import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sai Teja Madha
 */
public class Urinals {

    void getString() {}

    void openFile() {}

    int countUrinals(String urinals) {
        Pattern pattern = Pattern.compile("11");
        Matcher matcher = pattern.matcher(urinals);
        if (matcher.find()) {
            return -1;
        }

        int previousCount = (int) urinals.chars().filter(ch -> ch == '1').count();

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

        return (int) Arrays.stream(urinalsArray).filter(x -> x == 1).count() - previousCount;

    }

    boolean goodString(String str) {
        System.out.println("Not yet implemented");
        return true;
    }

    public static void main(String[] args) {
    }

}
