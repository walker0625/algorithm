package aareal.km;

import java.util.*;

public class P2 {

    public static void main(String[] args) {

        int n = 4;
        int[] a = {1,2,4,4,3};
        int[] b = {2,3,1,3,1};

        int[] a1 = {1,2,1,3};
        int[] b1 = {2,4,3,4};

        System.out.println(solution(n,a,b));
    }

    public static boolean solution(int N, int[] A, int[] B) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < A.length; i++) {
            graph.get(A[i]).add(B[i]);
            graph.get(B[i]).add(A[i]);
        }

        if (graph.get(1).isEmpty()) {
            return false;
        }

        // BFS
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(graph.get(1));

        int expectedNode = 2;

        while (!queue.isEmpty()) {
            List<Integer> nearNodeList = queue.poll();

            if (nearNodeList.contains(expectedNode)) {
                queue.add(graph.get(expectedNode));
                expectedNode++;
            }
        }

        return expectedNode > N;
    }

}