def ducci_sequence(*ns):
    while True:
        yield ns
        ns = tuple(abs(ns[i - 1] - ns[i]) for i in range(len(ns)))

def ducci(*ns):
    known = set()
    for ns in ducci_sequence(*ns):
        print(ns)
        if ns in known or set(ns) == {0}:
            break
        known.add(ns)
    return len(known) + 1
print(ducci(0, 345, 1788, 5078), "steps")
