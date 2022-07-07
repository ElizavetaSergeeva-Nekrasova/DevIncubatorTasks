import java.util.LinkedList;

public class CheckingBracketsAlgorithm {

    public static boolean checkingBracketsAlgorithm(String s) {
        LinkedList<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (isLeftBracket(s.charAt(i))) {
                deque.addFirst(s.charAt(i));
            }

            if (isRightBracket(s.charAt(i))) {
                deque.addLast(s.charAt(i));

                if (isPair(deque.getFirst(), deque.getLast())) {
                    deque.removeFirst();
                    deque.removeLast();
                } else {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }

    private static boolean isLeftBracket(char c) {
        return c == '(' || c == '[' || c == '{' || c == '<';
    }

    private static boolean isRightBracket(char c) {
        return c == ')' || c == ']' || c == '}' || c == '>';
    }

    private static boolean isPair(char firstBracket, char secondBracket) {
        return (secondBracket - firstBracket) == 2 || (secondBracket - firstBracket) == 1;
    }
}