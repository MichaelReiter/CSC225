import java.util.Stack;

public class StackSpan {

  public static int[] getSpan(int[] input) {
    Stack stack = new Stack<Integer>();
    stack.push(0);

    int[] result = new int[input.length];
    result[0] = 1;

    for (int i = 0; i < input.length; i++) {
      while (!stack.isEmpty() && input[(int)stack.peek()] <= input[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        result[i] = i + 1;
      } else {
        result[i] = i - (int)stack.peek();
      }
      stack.push(i);
    }

    return result;
  }

  public static void main(String[] args) {
    int p[] = {1,5,6,3,4,5};

    int[] s = getSpan(p);

    for (int i = 0; i < s.length; i++) {
      System.out.println(s[i]);
    }
  }
}