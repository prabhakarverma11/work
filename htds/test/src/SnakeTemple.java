/**
 * Created by prabhakar on 28/5/17.
 */

import java.util.Scanner;

public class SnakeTemple {

    public static void main(String args[]) {
        Integer foundPatternValue = 0;
        Scanner s = new Scanner(System.in);
        int t;
        t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();

            int heights[] = new int[n];
            long sumOfArray = 0;
            for (int i = 0; i < n; i++) {
                heights[i] = s.nextInt();
                sumOfArray += heights[i];
            }

            //now we have the table of heights.
            long noOfOperations = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
//                System.out.println("i: " + i);
                int j = 0;
                if (i % 2 == 0) {
                    if (n % 2 == 0) {
                        j = n - 2;
                    } else {
                        j = n - 1;
                    }
                } else {
                    if (n % 2 == 0) {
                        j = n - 1;
                    } else {
                        j = n - 2;
                    }
                }

                while (j >= i) {
                    foundPatternValue = getNumberOfOperations(heights, i, j, foundPatternValue);
                    System.out.println("i: " + i + ", j=" + j + ", ans=" + foundPatternValue);
                    if (foundPatternValue != -1)
                        break;
                    j -= 2;
                }
            }
            long sumOfPattern = sumOfPattern(foundPatternValue);
            noOfOperations = sumOfArray - sumOfPattern;
            System.out.println(noOfOperations);
        }
    }

    private static long sumOfPattern(int foundValue) {

        int sumOfPattern = foundValue;
        for (int i = foundValue - 1; i > 0; i--) {
            sumOfPattern += 2 * i;
        }
        return sumOfPattern;
    }

    private static int getNumberOfOperations(int[] tempArray, int startIndex, int endIndex, int foundPatternValue) {

        int midIndex = (startIndex + endIndex) / 2;
        //this is the index of mid element of array;

        int midNumber = (endIndex - startIndex) / 2 + 1; //mid of temple if formation possible

        if (midNumber < foundPatternValue)
            return -1;
        //base case
        if (tempArray[midIndex] < midNumber) {
            return -1;
        }

        for (int i = 1; i <= midIndex - startIndex; i++) {
            int op = tempArray[midIndex - i] - (midNumber - i);
            if (op < 0)
                return -1;
            op = tempArray[midIndex + i] - (midNumber - i);

            if (op < 0)
                return -1;
        }

        return midNumber;
    }
}
