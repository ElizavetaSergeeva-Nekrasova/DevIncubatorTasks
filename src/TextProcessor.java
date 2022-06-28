import java.util.Scanner;

public class TextProcessor {
    public static String appendText(String text, String append) {
        String result = text + append;
        return result;
    }

    public static String insertText(String text, String insert, int position) {
        String result =
                text.substring(0, position) + insert + text.substring(position, text.length());
        return result;
    }

    public static String removeCharacter(String text, char character) {
        int position = text.indexOf(character);
        String result =
                text.substring(0, position) + text.substring(position + 1, text.length());
        return result;
    }

    public static String replaceSubstring(String text, String oldSubstring, String newSubstring) {
        String result = text.replace(oldSubstring, newSubstring);
        return result;
    }

    public static void readAndReverse() {
        String text = null;

        System.out.println("Print your text: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            text = scanner.nextLine();
        }

        String result = reverse(text);

        System.out.println(result);

    }

    private static String reverse(String text) {

        char[] textArray = new char[text.length()];

        for (int i = 0; i < textArray.length; i++) {
            textArray[i] = text.charAt(text.length() - (i + 1));
        }

        String result = new String(textArray);

        return result;
    }

    public static String readAndDeleteSpaces() {
        String text = null;

        System.out.println("Print your text: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            text = scanner.nextLine();
        }

        int dotPosition = text.indexOf('.');
        if (dotPosition > 0) {
            text = text.substring(0, (dotPosition + 1));
        }

        int spaceCount = countSpaces(text);
        String result = deleteSpaces(text, spaceCount);

        return result;
    }

    private static String deleteSpaces(String text, int spaceCount) {

        char[] resultArray = new char[text.length() - spaceCount];

        for (int i = 0, j = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                resultArray[j] = text.charAt(i);
                j++;
            }
        }

        String result = new String(resultArray);
        return result;
    }

    private static int countSpaces(String text) {
        int counter = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                counter++;
            }
        }

        return counter;
    }

    public static String outputUppercase(String text) {
        StringBuilder textStringBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                textStringBuilder.append(text.charAt(i));
            }
        }

        String result = new String(textStringBuilder);

        return result;
    }

    public static String uppercaseEvenLetters(String text) {
        StringBuilder textStringBuilder = new StringBuilder();

        for (int i = 1; i < text.length(); i = i + 2) {
            textStringBuilder.append(Character.toUpperCase(text.charAt(i)));
        }

        String result = new String(textStringBuilder);

        return result;
    }

    public static String[] readAndEditStringArray() {
        int arrayLength = readArrayLength();
        String[] arrayOfStrings = readStringArray(arrayLength);
        editStringArray(arrayOfStrings);

        return arrayOfStrings;
    }

    private static int readArrayLength() {
        int arrayLength = 0;

        System.out.println("Enter array length: ");
        Scanner scannerInt = new Scanner(System.in);
        if (scannerInt.hasNextInt()) {
            arrayLength = scannerInt.nextInt();
        }

        return arrayLength;
    }

    private static String[] readStringArray(int arrayLength) {
        String[] arrayOfStrings = new String[arrayLength];

        System.out.println("Enter the words line by line: ");
        Scanner scannerLine = new Scanner(System.in);
        for (int i = 0; i < arrayLength; i++) {
            if (scannerLine.hasNextLine()) {
                String word = scannerLine.nextLine();

                if (word.equals("")) {
                    arrayOfStrings[i] = null;
                } else {
                    arrayOfStrings[i] = word;
                }
            }
        }

        return arrayOfStrings;
    }

    private static void editStringArray(String[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == null) ? ("String is empty") : (array[i]);
        }
    }
}