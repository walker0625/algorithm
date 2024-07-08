package stack;

import java.util.AbstractMap.SimpleEntry;
import java.util.Stack;

public class DailyTemperatures {

    public static int[] dailyTemperatureDays(int[] temps) {
        int[] answer = new int[temps.length];
        Stack<SimpleEntry<Integer, Integer>> dayAndTemp = new Stack<>();

        for (int i = 0; i < temps.length; i++) {
            while (dayAndTemp.size() != 0 &&
                   dayAndTemp.peek().getValue() < temps[i]) {
                int prevDay = dayAndTemp.peek().getKey();
                answer[prevDay] = i - prevDay;
                dayAndTemp.pop();
            }
            dayAndTemp.add(new SimpleEntry<>(i, temps[i]));
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        for (int d : dailyTemperatureDays(temperatures)){
            System.out.println(d);
        }
    }

}
