# This is a standard DP problem to capture the min number of edits
# reqd to transform a string to another string.

def main(a, b):
    mat = [[0 for x in range(len(a))] for x in range(len(b))]
    
    if a[0] != b[0]:
        mat[0][0] = 1

    for i in range(len(a) - 1):
        i += 1
        mat[0][i] = mat[0][i-1] + 1
    for j in range(len(b) - 1):
        j += 1
        mat[j][0] = mat[j-1][0] + 1

    for j in range(len(b) - 1):
        j += 1
        for i in range(len(a) - 1):
            i += 1
            res = min(mat[j-1][i], mat[j][i-1]) + 1
            if a[i] == b[j]:
                if res > mat[j-1][i-1]:
                    res = mat[j-1][i-1]
            else:
                res = min(res, mat[j-1][i-1] + 1)
            mat[j][i] = res
    print mat[len(b) -1][len(a) - 1]

main("carthorse", "orchestra")
