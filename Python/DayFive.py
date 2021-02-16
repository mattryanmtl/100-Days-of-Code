from itertools import count

def is_prime(n):
    for x in range(2, n):
        if not n % x:
            return False
    return True

def prev_prime(n):
    for x in range(n, 2, -1):
        if is_prime(x):
            return x

def next_prime(n):
    for x in count(n + 1):
        if is_prime(x):
            return x

user_input = (270, 541, 993, 649)
for i in user_input:
    if is_prime(i):
        print(f'{i} is prime')
    else:
        print(f'{prev_prime(i)} < {i} < {next_prime(i)}')
