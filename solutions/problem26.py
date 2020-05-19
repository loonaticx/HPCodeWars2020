# Problem 26: Countdown Clock

import datetime

with open('input.txt', 'r') as f:
    lines = f.read().replace('\r', '').split('\n')

def run_case(line):
    if not line:
        return

    split = line.split()
    start_date = split[0] + ' ' + split[1]
    end_date = split[2] + ' ' + split[3]
    form = split[4]

    start_date_ts = datetime.datetime.strptime(start_date, '%Y-%m-%d %H:%M:%S')
    end_date_ts = datetime.datetime.strptime(end_date, '%Y-%m-%d %H:%M:%S')
    seconds = int((end_date_ts - start_date_ts).total_seconds())

    results = []

    if 'D' in form:
        results.append(str(seconds // 86400) + ' days')
        seconds %= 86400
    if 'H' in form:
        results.append(str(seconds // 3600) + ' hours')
        seconds %= 3600
    if 'M' in form:
        results.append(str(seconds // 60) + ' minutes')
        seconds %= 60
    if 'S' in form:
        results.append(str(seconds) + ' seconds')

    print('there are ' + ' '.join(results) + ' remaining until ' + end_date)

for line in lines:
    run_case(line)
