package by.incubator.task3;

public class Main {
    private static String example = "Hello, user! How are you?";
    private static String str1 = "Java";
    private static String str2 = "JAVA";
    private static String str3 = "C#";
    private static String str4 = "Java";

    public static void main(String[] args) {
        testTextProcessorMethods();
        showEqualsResult();
    }

    private static void testTextProcessorMethods() {
        String result = null;

        System.out.println("Original phrase: " + example);

        result = TextProcessor.appendText(example, "Fine!");
        System.out.println("result of appendText(): " + result);

        result = TextProcessor.insertText(example, "dear", 6);
        System.out.println("result of insertText(): " + result);

        result = TextProcessor.removeCharacter(example, '!');
        System.out.println("result of removeCharacter(): " + result);

        result = TextProcessor.replaceSubstring(example, "user", "programmer");
        System.out.println("result of replaceSubstring(): " + result);

        System.out.println("testing readAndReverse() method: ");
        TextProcessor.readAndReverse();

        System.out.println("testing readAndDeleteSpaces() method: ");
        result = TextProcessor.readAndDeleteSpaces();
        System.out.println("result of readAndDeleteSpaces(): " + result);

        result = TextProcessor.outputUppercase("YY d dI S P AAAa aa AAA aaA");
        System.out.println("result of outputUppercase(), original phrase was 'YY d dI S P AAAa aa AAA aaA': " + result);

        result = TextProcessor.uppercaseEvenLetters("Friends");
        System.out.println("result of uppercaseEvenLetters(), original phrase was 'Friends': " + result);

        System.out.println("testing readAndEditStringArray() method: ");
        String[] array = TextProcessor.readAndEditStringArray();
        System.out.println("result of readAndEditStringArray(): ");
        for (String s :
                array) {
            System.out.println(s);
        }
    }

    private static void showEqualsResult() {
        System.out.println("str1.equals(str2): " + str1.equals(str2));
        System.out.println("str1.equals(str3): " + str1.equals(str3));
        System.out.println("str1.equals(str4): " + str1.equals(str4));
        System.out.println("str2.equals(str3): " + str2.equals(str3));
        System.out.println("str2.equals(str4): " + str2.equals(str4));
        System.out.println("str3.equals(str4): " + str3.equals(str4));

        System.out.println("----------------------");

        System.out.println("str1.equalsIgnoreCase(str2): " + str1.equalsIgnoreCase(str2));

        System.out.println("----------------------");

        System.out.println("str1 == str4: " + str1 == str4);

        System.out.println("----------------------");

        str1 = "JavaJava";
        System.out.println("str1.substring(4) == str4): " + str1.substring(4) == str4);

        System.out.println("----------------------");

        System.out.println("str1 == null: " + str1 == null);

        System.out.println("----------------------");

        str1 = null;
        System.out.println("str1 == null (after null-initialization of str1: " + str1 == null);
    }
}
