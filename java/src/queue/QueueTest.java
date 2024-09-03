package queue;

import java.util.*;

public class QueueTest {

    public static void main(String[] args) {
        queueSample();
    }

    public static void queueSample() {

        Deque<Integer> dq = new LinkedList<>();

        dq.add(2);
        dq.addFirst(1);
        dq.addLast(3);

        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());

        System.out.println("---------------------");

        Queue<Integer> q = new ArrayDeque<>();

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.peek()); // 확인만
        System.out.println(q.poll()); // 꺼내고 제거
        System.out.println(q.remove(3)); // poll 꺼내고 제거는 같으나, poll에 비해 비효율적(특정 값을 제거할 때 유용)
        System.out.println(q.peek());
    }

}
