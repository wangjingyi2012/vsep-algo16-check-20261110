import sys

# Streaming sum: valid because 1..n occurs once, with one extra copy.
def numbers():
    value = 0
    active = False
    while True:
        chunk = sys.stdin.buffer.read(65536)
        if not chunk:
            break
        for c in chunk:
            if 48 <= c <= 57:
                value = value * 10 + c - 48
                active = True
            elif active:
                yield value
                value = 0
                active = False
    if active:
        yield value

values = numbers()
n = next(values)
print(sum(values) - n * (n + 1) // 2)
