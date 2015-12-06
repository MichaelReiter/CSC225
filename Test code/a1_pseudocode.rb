#225 assignment 1 question 6 pseudocode

Algorithm factorial(n)
  if n = 0 then
    return 1
  else
    return n * factorial(n-1)
  end

Algorithm countPairs(A, n)
  sort(A)
  pairs <- 0
  counter <- 1
  i <- 0
  while i < n-1 do
    if A[i] = A[i+1] then
      counter <- counter + 1
    else
      if counter > 1 then
        pairs <- pairs + (factorial(counter) / (factorial(counter-2) * factorial(2)))
      end
      counter <- 1
    end
    i <- i + 1
  end
  if counter > 1 then
    pairs <- pairs + (factorial(counter) / (factorial(counter-2) * factorial(2)))
  end
  return pairs