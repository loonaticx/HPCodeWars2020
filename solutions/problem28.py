# Problem 28: Series Identifier

import math

with open('input.txt', 'r') as f:
    lines = f.read().replace('\r', '').split('\n')

ROUND_DIGITS = 5 # For floating point number inaccuracies.

def is_x2(steps):
    for i in range(len(steps) - 1):
        if steps[i + 1] < 0 or round(steps[i + 1] ** (1.0/2.0), ROUND_DIGITS) != steps[i]:
            return False

    return True

def is_x3(steps):
    for i in range(len(steps) - 1):
        if steps[i + 1] < 0 or round(steps[i + 1] ** (1.0/3.0), ROUND_DIGITS) != steps[i]:
            return False

    return True

def is_fibonacci(data):
    for i in range(2, len(data)):
        if data[i - 2] + data[i - 1] != data[i]:
            return False
        
    return True

def is_geometric(step):
    first_step = step[0]

    for i in range(1, len(step)):
        if step[i] != first_step:
            return False

    return True

def is_almost_geometric(data):
    first_step = data[0]

    for i in range(1, len(data)):
        if data[i] % first_step != 0:
            return False

    return True

def get_steps(data):
    return [data[i + 1] / data[i] for i in range(len(data) - 1)]

def get_type(data, line):
    if len(data) < 3:
        return '{0} is an Unknown series'.format(line)

    if is_fibonacci(data):
        return 'Fibonacci'

    steps = get_steps(data)

    if is_x2(steps):
        return 'X^2'
    if is_x3(steps):
        return 'X^3'

    if data[0] > data[1]:
        # Decreasing order, we should flip
        data = data[::-1]
        steps = get_steps(data)

    if is_geometric(steps):
        return 'Geometric'

    if is_almost_geometric(data):
        return 'Geometric (With Gaps)'

    return '{0} is an Unknown series'.format(line)

for line in lines:
    if line:
        group = [int(num) for num in line.split()]
        print(get_type(group, line))
