package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CheckValidBracket {

    public static boolean isValidBracket(String str) {

        Stack<Character> bracketStack = new Stack();

        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i) == '(') {
                bracketStack.add(')');
            } else if (str.charAt(i) == '[') {
                bracketStack.add(']');
            } else if (str.charAt(i) == '{') {
                bracketStack.add('}');
            } else if (bracketStack.isEmpty() || bracketStack.pop() != str.charAt(i)) {
                return false;
            }
        }

        return bracketStack.isEmpty();
    }

    public static boolean isValidBracketByList(String str) {

        List<Character> bracketStack = new ArrayList<>();

        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i) == '(') {
                bracketStack.add(')');
            } else if (str.charAt(i) == '[') {
                bracketStack.add(']');
            } else if (str.charAt(i) == '{') {
                bracketStack.add('}');
            } else if(bracketStack.get(bracketStack.size() - 1) == str.charAt(i)) {
                bracketStack.remove(bracketStack.size() - 1);
            } else if (bracketStack.isEmpty() || bracketStack.get(bracketStack.size() - 1) != str.charAt(i)) {
                return false;
            }
        }

        return bracketStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidBracketByList("[()]{}"));
    }

}