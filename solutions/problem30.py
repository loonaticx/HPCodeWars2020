# Problem THIRTY: THE UNIBAKER
import copy, sys

with open('input.txt', 'r') as f:
    lines = f.read().replace('\r', '').split('\n')

n = int(lines[0])
grid = [list(line) for line in lines[1:] if line]

def print_grid(grid):
    for i in range(len(grid)):
        print(''.join(grid[i]))

def is_solution(grid, n):
    for i in range(n):
        for j in range(n):
            if grid[i][j] == '?':
                return False
    
    return True

def is_all_same(l):
    f = l[0]

    for i in range(1, len(l)):
        if l[i] != f:
            return False
    
    return True

rowN = [-1, 1, 0, 0]
colN = [0, 0, 1, -1]
visited = []

def dfs(grid, i, j, c, n):
    global visited
    visited[i][j] = True

    for k in range(4):
        xI = i + rowN[k]
        xJ = j + colN[k]

        if xI >= 0 and xI < n and xJ >= 0 and xJ < n and grid[xI][xJ] == c and not visited[xI][xJ]:
            dfs(grid, xI, xJ, c, n)

def get_connected_components(grid, n):
    global visited
    components = 0
    visited = [[False] * n for i in range(n)]

    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                c = grid[i][j]
                dfs(grid, i, j, c, n)
                components += 1

    return components

def is_ok(grid, n):
    all_n = grid[0] + grid[-1] + [x[-1] for x in grid[1:-1]] + [x[0] for x in grid[1:-1]]

    if '#' not in all_n or '.' not in all_n:
        return False

    for i in range(n - 1):
        for j in range(n - 1):
            if is_all_same([grid[i][j], grid[i + 1][j], grid[i + 1][j + 1], grid[i][j + 1]]):
                return False

    return get_connected_components(grid, n) == 2

def solve_cupcakes(grid, n):
    if is_solution(grid, n) and is_ok(grid, n):
        return grid
    
    for i in range(n):
        for j in range(n):
            if grid[i][j] == '?':
                for choice in ('#', '.'):
                    grid[i][j] = choice
                    solution = solve_cupcakes(grid, n)

                    if solution:
                        return solution
                    else:
                        grid[i][j] = '?'

print_grid(solve_cupcakes(grid, n))
