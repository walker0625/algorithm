package aground.queue;

import java.util.*;

public class UseTwoQueueForProcessing {

    public static void main(String[] args) {
        int[] trucks = {7,4,5,6};
        System.out.println(solution(2, 10, trucks));
    }

    public static int solution(int bridgeLength, int limitWeight, int[] trucksWeight) {
        int time = 0;
        int nowWeight = 0;

        Queue<Truck> readyTrucks = new LinkedList<>();

        for (int truckWeight : trucksWeight) {
            readyTrucks.add(new Truck(1, truckWeight));
        }

        Queue<Truck> bridge = new LinkedList<>();
        Truck firstTruck = readyTrucks.poll();
        bridge.add(firstTruck);
        nowWeight = firstTruck.weight;
        time = 1;

        while(!bridge.isEmpty() || !readyTrucks.isEmpty()) {

            Truck curTruckOnBridge = bridge.peek();

            if (curTruckOnBridge.distance + 1 > bridgeLength) {
                nowWeight = nowWeight - bridge.poll().weight;
            }

            // queue 자체를 바꾸지 않아도 안의 객체값만 바꾸어도 됨
            for(Truck t : bridge) {
                t.distance++;
            }

            Truck curTruck = readyTrucks.peek();

            if(curTruck != null && limitWeight >= nowWeight + curTruck.weight) {
                nowWeight = nowWeight + curTruck.weight;
                bridge.add(readyTrucks.poll());
            }

            time++;
        }

        return time;
    }

    static class Truck {
        int distance;
        int weight;

        public Truck(int distance, int weight) {
            this.distance = distance;
            this.weight = weight;
        }

    }

}
