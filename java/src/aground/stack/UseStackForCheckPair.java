package aground.stack;

import java.util.Stack;

public class UseStackForCheckPair {

    public static void main(String[] args) {
        System.out.println(solution(")()("));
    }

    static boolean solution(String str) {

        Stack<Character> stack = new Stack<>();

        for (char b : str.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != '(' && b == ')') {
                stack.add(b);
            } else if (stack.peek() == '(' && b == ')') {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
