package binarySearch;

public class GuessNumber374 {
    public int guessNumber(int n) {
        int from = 1, to = n;
        while (from <= to) {
            int middle = from + (to - from) / 2;
            if (0 == guess(middle)) {
                return middle;
            } else if (guess(middle) == 1) {
                from = middle + 1;
            } else if (guess(middle) == -1) {
                to = middle - 1;
            }
        }
        return from;
    }

    public int guess(int guess) {
        return 0;
    }
}
