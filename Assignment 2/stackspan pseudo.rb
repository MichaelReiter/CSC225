Algorithm computeSpan(A):
  
  stack.push(0)
  resultArray[0] <- 1
  n <- A.length

  for i <- 0 to n-1 do
    while !stack.isEmpty() and A[stack.peek()] < A[i] do
      stack.pop()
    end
    if stack.isEmpty() then
      resultArray[i] <- i + 1
    else
      resultArray[i] <- i - stack.peek()
    end
    stack.push(i)
  end

  return resultArray