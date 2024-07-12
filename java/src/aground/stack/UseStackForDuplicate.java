package aground.stack;

import java.util.Stack;

public class UseStackForDuplicate {

    public static Object[] solution(int [] arr) {
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            if (stack.peek() == arr[i]) {
                stack.pop();
            }

            stack.push(arr[i]);
        }

        return stack.toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        for (Object i : solution(arr)) {
            System.out.println(i);
        }
    }

}
