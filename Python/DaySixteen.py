from functools import lru_cache

@lru_cache(maxsize=None)
def trinomial_coefficient(l, n, k):
    if l < 0 or n < 0 or k < 0:
        return 0

    head = (n == 0 and k == 0)
    bottom_left = (n == l) and (k == 0)
    bottom_right = (n == l) and (k == l)

    if head or bottom_left or bottom_right:
        return 1

    return (trinomial_coefficient(l-1, n-1, k-1) +
            trinomial_coefficient(l-1, n-1, k) +
            trinomial_coefficient(l-1, n, k))


def pascal_pyramid(l):
    rows = list()
    for n in range(l+1):
        coefficients = list()
        for k in range(n+1):
            coefficients.append(trinomial_coefficient(l, n, k))
        rows.append(coefficients)
    return rows

for row in pascal_pyramid(5-1):
    print(row)
