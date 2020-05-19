# Problem 24: Crossword
# BROKEN, DO NOT TOUCH!!!

import math, copy

with open('input.txt', 'r') as f:
    lines = f.read().replace('\r', '').split('\n')

def print_grid(gr):
    print('GRID')

    for grx in gr:
        print(''.join(grx))

grid = [['*'] * 11 for i in range(11)]
solutions = []

for i, line in enumerate(lines):
    if line == '-------':
        lines = lines[i+1:]
        break

    split = line.split()
    length = int(split[2])
    x = int(split[3])
    y = int(split[4])
    type = split[1]

    if type == 'H':
        for j in range(x, x + length):
            grid[y][j] = '#'
    else:
        for i in range(y, y + length):
            grid[i][x] = '#'

    solutions.append([split[0], type, x, y, length])

for i, line in enumerate(lines):
    if line == '-------':
        lines = lines[i+1:]
        break

    split = line.split()
    grid[int(split[1])][int(split[0])] = split[2]

def check_horizontal(x, y, matrix, currentWord):
    for i, letter in enumerate(currentWord):
        if matrix[x][y + i] == '#' or matrix[x][y + i] == letter:
            matrix[x][y + i] = letter
        else:
            return

    return matrix

def check_vertical(x, y, matrix, currentWord):
    for i, letter in enumerate(currentWord):
        if matrix[x + i][y] == '#' or matrix[x + i][y] == letter:
            matrix[x + i][y] = letter
        else:
            return

    return matrix

complete = False

def solve_puzzle(words, matrix, index):
    global complete

    if complete:
        return

    if index >= len(words):
        for solution in solutions:
            num, type, x, y, length = solution
            num = num.rjust(2, '0')

            if type == 'H':
                print(num + ' is ' + ''.join(grid[y][x:x + length]))
            else:
                str = ''

                for i in range(y, y + length):
                    str += grid[i][x]
            
                print(num + ' is ' + str)

        complete = True
        return

    ## ALL HAIL THE INDIAN GODS
    word = words[index]
    solved = False

    for i in range(11):
        j = 0

        while j < 11:
            if matrix[i][j] != '*':
                first_index = j
                last_index = 10

                for k in range(first_index + 1, 11):
                    if matrix[i][k] == '*':
                        last_index = k - 1
                        break
                
                length = last_index - first_index + 1
                j = last_index + 1

                if len(word) == length:
                    matrix2 = check_horizontal(i, first_index, matrix, word)

                    if matrix2:
                        solve_puzzle(words, matrix2, index + 1)
                        solved = True
            else:
                j += 1

    for i in range(11):
        j = 0

        while j < 11:
            if matrix[j][i] != '*':
                first_index = j
                last_index = 10

                for k in range(first_index + 1, 11):
                    if matrix[k][i] == '*':
                        last_index = k - 1
                        break

                length = last_index - first_index + 1
                j = last_index + 1

                if len(word) == length:
                    matrix2 = check_vertical(first_index, i, matrix, word)

                    if matrix2:
                        solve_puzzle(words, matrix2, index + 1)
                        solved = True
            else:
                j += 1
    
    if not solved:
        solve_puzzle(words, matrix, index + 1)

words = [word for word in lines if word]
solve_puzzle(words, grid, 0)
