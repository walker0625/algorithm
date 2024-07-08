from collections import deque

graph = {
    "A" : ["B", "D", "E"],
    "B" : ["A", "C", "D"],
    "C" : ["B"],
    "D" : ["A", "B"],
    "E" : ["A"],
}

### graphByBfs

def graphByBfs(graph, start_v):
    
    visited = [start_v]
    q = deque(start_v)
    
    while q:
        cur_v = q.popleft()
        for v in graph[cur_v]:
            if v not in visited:
                visited.append(v)
                q.append(v)
    
    return visited

# print(graphByBfs(graph, "A"))


### graphByDfs

visited = []

def graphByDfs(cur_v):

    visited.append(cur_v)

    for v in graph[cur_v]:
        if v not in visited:
            graphByDfs(v)

# graphByDfs("A")
# print(visited)

def graphByDfsWithParam(graph, cur_v, visited = []):

    visited.append(cur_v)
    
    for v in graph[cur_v]:
        if v not in visited:
            graphByDfsWithParam(graph, v, visited)                

    return visited

# print(graphByDfsWithParam(graph, "A"))


### numIslands

def numIslands(grid):
    number_of_islands = 0
    row = len(grid)
    col = len(grid[0])
    visited = [[False]*col for _ in range(row)]

    def bfs(x, y):
        
        visited[x][y] = True
        
        queue = deque()
        queue.append((x,y))

        # 방향 탐색을 위한 상수값(상/하/좌/우) : 대각선이 필요하면 추가하면 됨
        dx = [-1, 1, 0, 0]
        dy = [0, 0, -1, 1]

        while queue:
            cur_x, cur_y = queue.popleft()
            for i in range(4):
                next_x = cur_x + dx[i]                    
                next_y = cur_y + dy[i]
                if next_x >= 0 and next_x < row and next_y >= 0 and next_y < col:
                    if grid[next_x][next_y] == "1" and not visited[next_x][next_y]:
                        visited[next_x][next_y] = True
                        queue.append((next_x, next_y))

    for i in range(row):
        for j in range(col):
            if grid[i][j] == "1" and not visited[i][j]:
                bfs(i, j)
                number_of_islands += 1

    return number_of_islands

numIslands(grid=[
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
])


### shortest path > bfs 추천
# (dfs는 최단거리를 판단하기 어려움 : 모든 경우의 수를 깊이 탐색 한 후 비교해야 함)
def shortestPath(grid):

    shortest_len = -1 
    
    row = len(grid)
    col = len(grid[0])

    if grid[0][0] != 0 or grid[row-1][col-1] != 0:
        return shortest_len

    visited = [[False] * col for _ in range(row)] 

    directions = [(1,0), (-1,0), (0,-1), (0,1),   # 상하좌우
                  (1,1), (1,-1), (-1,1), (-1,-1)] # 대각선

    queue = deque()
    queue.append((0,0,1))

    visited[0][0] = True

    while queue:
        cur_r, cur_c, cur_l = queue.popleft()

        if cur_r == row-1 and cur_c == col-1:
            shortest_len = cur_l
            break

        for dr, dc in directions:
            next_r = cur_r+dr
            next_c = cur_c+dc
            if next_r >= 0 and next_r < row and next_c >= 0 and next_c < col:
                if grid[next_r][next_c] == 0 and not visited[next_r][next_c]:
                    queue.append((next_r, next_c, cur_l+1))
                    visited[next_r][next_c] = True

    return shortest_len

shortestPath(
                   [
                    [0,0,0],
                    [1,1,0],
                    [1,1,0]
                    ]
                  )


### dfs => O(v + e) 1000 + 3000
### canVisitAllRooms

def canVisitAllRoomByDfs(rooms):
    visited = set()
    
    def dfs(room):
        visited.add(room)
        for next_room in rooms[room]:
            if next_room not in visited:
                dfs(next_room)

    dfs(0)

    return len(visited) == len(rooms)

#rooms = [[1,3],[2,4],[0],[4],[]]
# print(canVisitAllRoomByDfs(rooms))


### bfs

def canVisitAllRoomByBfs(rooms):
    
    visited = set()
    queue = deque()
    
    queue.append(0)
    visited.add(0)

    while queue:
        cur_room = queue.popleft()
        for next_room in rooms[cur_room]:
            if next_room not in visited:
                queue.append(next_room)
                visited.add(next_room)
                
    return len(visited) == len(rooms)

rooms = [[1,3],[2,4],[0],[4],[],[3,4]]
canVisitAllRoomByBfs(rooms)