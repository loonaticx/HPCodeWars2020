"""
bruh this isnt working im gay
"""

# find a way to loop when next str is EMPLOYEE

#f = open("file.txt", "r")

def calcRate(inTimeb4Lunch, outTimeb4Lunch, inTimeaftLunch, outTimeaftLunch):
    # lunch difference = inTimeaftLunch - outTimeb4lunch
    # hour/rate diff = (outTime - inTime) * rate
    b4LunchDiff = outTimeb4Lunch - inTimeb4Lunch
    aftLunchDiff = outTimeaftLunch - inTimeaftLunch
    totalHourDiff = b4LunchDiff + aftLunchDiff

    #possibly: (inTimeb4Lunch + outTimeaftLunch) - inTimeaftLunch - outTimeb4 lunch
    print("a " + str(((outTimeaftLunch - inTimeb4Lunch) - (inTimeaftLunch - outTimeb4Lunch))/ 100 * rate))

    return float(totalHourDiff / 100) * rate


with open("file.txt", "r") as f:
    for line in f:
        if line.startswith("EMPLOYEE"):
            employeeName = str(line.split(' ')[1])
            print("EMPLOYEE " + employeeName)
            rate = float(f.readline().split(' ')[1])
            print("RATE " + str(rate))
            inTimeb4Lunch = int(f.readline().split(' ')[1])
            outTimeb4Lunch = int(f.readline().split(' ')[1])
            inTimeaftLunch = int(f.readline().split(' ')[1])
            outTimeaftLunch = int(f.readline().split(' ')[1])
            print(calcRate(inTimeb4Lunch, outTimeb4Lunch, inTimeaftLunch, outTimeaftLunch))




#print(b4LunchDiff)

# hours is every 100th integer so / 100

