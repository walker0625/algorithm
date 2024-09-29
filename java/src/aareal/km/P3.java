package aareal.km;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P3 {

    public static void main(String[] args) {
        System.out.println(solution(22, "1A 3C 2B 20G 5A"));
    }

    public static int solution(int N, String S) {
        Set<String> checkSeats = new HashSet<>(Arrays.asList(S.split(" ")));
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            boolean leftSeat = !(checkSeats.contains(i + "B") || checkSeats.contains(i + "C") || checkSeats.contains(i + "D") || checkSeats.contains(i + "E"));
            boolean middleSeat = !(checkSeats.contains(i + "D") || checkSeats.contains(i + "E") || checkSeats.contains(i + "F") || checkSeats.contains(i + "G"));
            boolean rightSeat = !(checkSeats.contains(i + "F") || checkSeats.contains(i + "G") || checkSeats.contains(i + "H") || checkSeats.contains(i + "J"));
            
            if (leftSeat && rightSeat) {
                answer += 2;
            } else if (leftSeat || middleSeat || rightSeat) {
                answer += 1;
            }
        }

        return answer;
    }

}