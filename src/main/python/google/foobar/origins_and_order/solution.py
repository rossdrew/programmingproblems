import itertools

# Could be optimised so that entries to valid_permutations check if there's a previous entry and return Ambiguous
def answer(x, y, z):
    days_in_month = [31,28,31,30,31,30,31,31,30,31,30,31]

    valid_permutations = set()
    perms = itertools.permutations([x,y,z])
    for perm in perms:
        month = perm[0]
        day_of_month = perm[1]
        year = perm[2]

        if month <= 12:
            days_in_current_month = days_in_month[month - 1]
            if day_of_month <= days_in_current_month:
                valid_permutations.add("{0:02d}/{1:02d}/{2:02d}".format(month, day_of_month, year))

    if len(valid_permutations) == 1:
        return valid_permutations.pop()
    else:
        return "Ambiguous"
