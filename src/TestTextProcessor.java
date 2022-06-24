import java.util.Scanner;

public class TestTextProcessor {
    public static void main(String[] args) {
        String example = "Hello, user! How are you?";

        String result = null;

        //result = TextProcessor.appendText(example, "Fine!");
        //System.out.println(result);

        //result = TextProcessor.insertText(example, "dear", 6);
        //System.out.println(result);

        //result = TextProcessor.removeCharacter(example, '!');
        //System.out.println(result);

        //result = TextProcessor.replaceSubstring(example, "user", "programmer");
        //System.out.println(result);

        //TextProcessor.readAndReverse();

        //result = TextProcessor.readAndDeleteSpaces();
        //System.out.println(result);

        //result = TextProcessor.outputUppercase("YY d dI S P AAAa aa AAA aaA");
        //System.out.println(result);

        //result = TextProcessor.uppercaseEvenLetters("Friends");
        //System.out.println(result);

        String[] array = TextProcessor.readAndEditStringArray();
        for (String s:
             array) {
            System.out.println(s);
        }


    }
}
