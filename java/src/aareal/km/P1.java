package aareal.km;

public class P1 {

    public static void main(String[] args) {
        solution(54321);
    }

    public static void solution(int N) {
        int enable_print = 0;
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
            }
            if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }

}
