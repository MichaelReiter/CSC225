import java.util.Arrays;

class equalArraySearch {
  public static void main(String[] args) {
    int[] testArray = {1, 1, 1};
    int numberOfPairs = pairs(testArray);
    System.out.println("The array contains " + numberOfPairs + " pairs.");
  }

  public static int pairs(int[] array) {
    Arrays.sort(array);
    int length = array.length;
    int pairs = 0;
    int counter = 1;
    for (int i = 0; i < length - 1; i++) {
      if (array[i] == array[i+1]) {
        counter++;
      } else {
        if (counter > 1) {
          //nCr = n! / ((n-r)! * r!)
          pairs += factorial(counter) / (factorial(counter - 2) * factorial(2));
        }
        counter = 1;
      }
    }
    if (counter > 1) {
      //nCr = n! / ((n-r)! * r!)
      pairs += factorial(counter) / (factorial(counter - 2) * factorial(2));
    }
    return pairs;
  }

  public static int factorial(int n) {
    if (n == 0) {
      return 1;
    } else {
      return n * factorial(n-1);
    }
  }
}