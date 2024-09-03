package stack;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Stack;

public class StackReview {

    public static void main(String[] args) {
        //System.out.println(isValid2("((){}[])"));

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        for (int d : tempGap(temperatures)){
            System.out.println(d);
        }
    }

    public static boolean isValid(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.add('(');
            } else if (str.charAt(i) == '{') {
                stack.add('{');
            } else if (str.charAt(i) == '[') {
                stack.add('[');
            } else if (str.charAt(i) == ')') {
                if(stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (str.charAt(i) == '}') {
                if(stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (str.charAt(i) == ']') {
                if(stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }

    public static boolean isValid2(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.add(')');
            } else if (str.charAt(i) == '{') {
                stack.add('}');
            } else if (str.charAt(i) == '[') {
                stack.add(']');
            } else if(stack.isEmpty() || stack.pop() != str.charAt(i)) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static int[] tempGap(int[] temp) {
        int dayNum = temp.length;
        int[] answer = new int[dayNum];
        Stack<int[]> dayAndTemp= new Stack<>();

        //O(2n)의 시간 복잡도
        for (int d = 0; d < dayNum; d++) {
            int curTemp = temp[d];

            // 총 n번만 반복
            while (!dayAndTemp.isEmpty() && dayAndTemp.peek()[1] < curTemp) {
                int[] prev = dayAndTemp.pop();
                answer[prev[0]] = d - prev[0];
            }

            dayAndTemp.push(new int[]{d, curTemp});
        }

        return answer;
    }

}