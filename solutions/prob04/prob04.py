number = int(input())
if number > 1:
    for i in range(2, number // 2):
        if (number % i ) == 0:
            print(number, "is NOT Prime")
            break
    else:
        print(number, "is PRIME")

else:
    print(number, "is NOT Prime")
