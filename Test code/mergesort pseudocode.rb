Algorithm mergeSort(A):

input: an array A of length n
output: a sorted version of A

  if n = 1 then
    return A
  else
    middle <- floor((last + first)/2)
    left <- mergesort(A(first..middle)) 
    right <- mergesort(A(middle+1..last)) 
    result <- merge(left, right) 
    return result
  end
end

inversions <- 0

Algorithm merge(left, right):

  input: two arrays left and right
  output: an resulting merged array of size left.length + right.length

  result <- []
  i <- 0
  j <- 0
  while i < left.length and j < right.length do
    if left[i] < right[j] then
      result.append(left[i])
      i <- i + 1
    else
      result.append(right[j])
      inversions <- inversions + (left.length - i)
      j <- j + 1
    end
  end

  while i < left.length do
    result.append(left[i])
    i <- i + 1
  end
  while j < right.length do
    result.append(right[j])
    j <- j + 1
  end
  return result

