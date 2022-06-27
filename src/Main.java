public class Main {
    public static void main(String[] args) {

        String example = "Hello, user! How are you?";

        String result = null;

        result = TextProcessor.appendText(example, "Fine!");
        System.out.println(result);

        result = TextProcessor.insertText(example, "dear", 6);
        System.out.println(result);

        result = TextProcessor.removeCharacter(example, '!');
        System.out.println(result);

        result = TextProcessor.replaceSubstring(example, "user", "programmer");
        System.out.println(result);

        TextProcessor.readAndReverse();

        result = TextProcessor.readAndDeleteSpaces();
        System.out.println(result);

        result = TextProcessor.outputUppercase("YY d dI S P AAAa aa AAA aaA");
        System.out.println(result);

        result = TextProcessor.uppercaseEvenLetters("Friends");
        System.out.println(result);

        String[] array = TextProcessor.readAndEditStringArray();
        for (String s:
                array) {
            System.out.println(s);
        }

        String str1 = "Java";
        String str2 = "JAVA";
        String str3 = "C#";
        String str4 = "Java";

        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str1.equals(str4));
        System.out.println(str2.equals(str3));
        System.out.println(str2.equals(str4));
        System.out.println(str3.equals(str4));

        System.out.println("----------------");

        System.out.println(str1.equalsIgnoreCase(str2));

        System.out.println("----------------");

        System.out.println(str1 == str4);

        System.out.println("----------------");

        str1 = "JavaJava";
        System.out.println(str1.substring(4) == str4);

        System.out.println("----------------");

        System.out.println(str1 == null);

        System.out.println("----------------");

        str1 = null;
        System.out.println(str1 == null);
    }
}
