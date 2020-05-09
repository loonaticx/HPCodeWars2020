# Problem 29: LINTER

with open('input.txt', 'r') as f:
    lines = f.read().split('\n')

ERR_NOT_USED = 10
ERR_INDENT = 20
ERR_WHITESPACE = 30
ERR_NO_DOC = 40

errors = {
    ERR_NOT_USED: 'Variable declared but not used',
    ERR_INDENT: 'Unexpected indentation',
    ERR_WHITESPACE: 'Trailing whitespace',
    ERR_NO_DOC: 'Func declaration without documentation'
}

all_errors = []

def log_error(i, code):
    all_errors.append([i + 1, code])

def print_errors():
    for error in sorted(all_errors):
        line_num, code = error
        print('{}:{} {}'.format(line_num, code, errors[code]))

should_be_inner = False
required_variables = {}
seen_variables = {}

for i, line in enumerate(lines):
    if '#' in line:
        # Ignore comments
        line = line[:line.find('#')]

    if not line:
        continue

    inner = line.startswith('    ')

    if inner:
        line = line[4:]

    split = [x for x in line.split(' ') if x.strip()]

    if line.startswith('VAR'):
        if len(split) >= 2:
            # Add a required variable
            var = split[1]
            required_variables[var] = i
    elif line.startswith('ENDIF') or line.startswith('ENDFUNC') or line.startswith('NEXT'):
        # We're done with this section
        should_be_inner = False

    if inner != should_be_inner or line.lstrip() != line:
        # Unexpected intendation
        log_error(i, ERR_INDENT)

    if line[-1] in ' \t\n\r':
        # Whitespace problems :(
        log_error(i, ERR_WHITESPACE)

    for word in split:
        if word.startswith('$'):
            # We've encountered a variable that we are using
            word = word[1:]

            # Only mark this variable if we've declared it
            if word in required_variables:
                seen_variables[word] = i

    if line.startswith('FUNC'):
        should_be_inner = True
        new_variables = split[2:-1]

        for var in new_variables:
            # Adding func variables to required variables
            var = var.strip(',')

            if var not in required_variables:
                required_variables[var] = i

        if len(split) >= 2:
            name = split[1]

            if '(' in name:
                name = name[:name.find('(')]
                previous = lines[i - 1]

                # Check for documentation
                if not previous.startswith('# {} '.format(name)):
                    log_error(i, ERR_NO_DOC)
    elif line.startswith('FOR') or line.startswith('IF'):
        should_be_inner = True

# Check for unused variables
for required_var, line_num in required_variables.items():
    if required_var not in seen_variables:
        log_error(line_num, ERR_NOT_USED)

# Print errors
print_errors()
