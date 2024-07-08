import heapq


### min_heap

heap = [5,3,9,4,1,2,6]

heapq.heapify(heap)

print(heapq.heappop(heap))

heapq.heappush(heap, 0)

print(heapq.heappop(heap))


### max_heap(enqueue가 불가하다는 단점이 존재)

max_heap = [5,3,9,4,1,2,6]

heapq._heapify_max(max_heap)
value = heapq._heapify_max(max_heap)

print(value)


### make max heap by min heap(-1)

raw_max_heap = [5,3,9,4,1,2,6]
min_max_heap = [(-1 * i, i) for i in raw_max_heap]
heapq.heapify(min_max_heap)
weight, value = heapq.heappop(min_max_heap)

print(value) # 9(max)


### Dijkstra(다익스트라) - 경로 탐색시에 가중치가 있는 경우(없으면 bfs)

graph = {
    1: [(2,2), (1,4)],
    2: [(1,3), (9,5), (6,6)],
    3: [(4,6)],
    4: [(3,3), (5,7)],
    5: [(1,8)],
    6: [(3,5)],
    7: [(7,6), (9,8)],
    8: []
}

def dijkstra(graph, start, final):
    costs = {}
    pq = []
    heapq.heappush(pq, (0, start))

    while pq:
        cur_cost, cur_v = heapq.heappop(pq)
        if cur_v not in costs:
            costs[cur_v] = cur_cost
            for cost, next_v in graph[cur_v]:
                next_cost = cur_cost + cost
                heapq.heappush(pq, (next_cost, next_v))
    return costs[final]

print(dijkstra(graph, 1, 8))


### network min cost

from collections import defaultdict

times = [[2,1,2],[2,3,5],[2,4,1],[4,3,3]]
start_node = 2
number_node = 4

def networkMin(times, s, n):
    graph = defaultdict(list)

    for time in times:
        graph[time[0]].append((time[2], time[1]))

    costs = {}
    pq = []
    heapq.heappush(pq, (0, start_node))

    while pq:
        cur_cost, cur_node = heapq.heappop(pq)
        if cur_node not in costs:
            costs[cur_node] = cur_cost
            for cost, next_node in graph[cur_node]:
                next_cost = cur_cost + cost
                heapq.heappush(pq, (next_cost, next_node))

    for node in range(1, n+1):
        if node not in costs:
            return -1
        
    return max(costs.values())

print(networkMin(times, start_node, number_node))