def insertion_sort(A):
  inversions = 0
  printArray(A)
  for j in xrange(1, len(A)):
    i = j-1
    value = A[j]
    while (A[i] > value) and (i >= 0):
      A[i+1] = A[i]
      inversions += 1
      i -= 1
      printArray(A)
    A[i+1] = value
  printArray(A)
  return inversions


def printArray(A):
  for k in range(0, len(A)):
    print A[k],
  print

array = [5, 7, 0, 3, 4, 2, 6, 1]

insertion_sort(array)