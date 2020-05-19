# Problem 27: Rhymes with Ablaut

with open('input.txt', 'r') as f:
    lines = f.read().replace('\r', '').split('\n')

def first_vowel(line):
    for i, v in enumerate(line):
        if v in 'AEIOU':
            return i

    return -1

def remove_consonant(line):
    index = first_vowel(line)

    if index != -1:
        return line[index:]
    else:
        return ''

progressive_list = ['I', 'A', 'E', 'O', 'U']

def run_case(line):
    if not line:
        return
    
    split = line.split()
    line = line[line.find(' ')+1:]
    num_words = int(split[0])

    if num_words == 0:
        return

    words = [split[i] for i in range(1, num_words + 1)]
    copy = True
    first_word = words[0]

    for i in range(1, num_words):
        if words[i] != first_word:
            copy = False
            break

    if copy:
        print(line + '  COPY')
        return

    ablaut = True
    vowel_index = -1
    progressive = True

    for i in range(num_words - 1):
        word_one = words[i]
        word_two = words[i + 1]
        length = len(word_one)

        if length != len(word_two):
            ablaut = False
            break

        for j in range(0, length):
            letter = word_one[j]
            letter2 = word_two[j]

            if letter != letter2:
                if letter in 'AEIOU' and letter2 in 'AEIOU' and (vowel_index == -1 or vowel_index == j):
                    if progressive and progressive_list.index(letter) >= progressive_list.index(letter2):
                        progressive = False

                    vowel_index = j
                else:
                    ablaut = False
                    break
                
        if not ablaut:
            break

    if ablaut:
        if progressive:
            print(line + '  PROGRESSIVE')
        else:
            print(line + '  ABLAUT')
        
        return

    first_word_c = remove_consonant(first_word)

    if len(words) == 2 and words[1].startswith('SHM') and words[1][3:] == first_word_c:
        print(line + '  SHM')
        return

    rhymes = True

    for i in range(1, num_words):
        if remove_consonant(words[i]) != first_word_c:
            rhymes = False
            break

    if rhymes:
        print(line + '  RHYMING')
        return

for line in lines:
    run_case(line)
