import java.io.IOException;
import java.util.Scanner;

class Momo {

    public static void main(String args[]) throws NumberFormatException, IOException {
        Scanner s = new Scanner(System.in);
        int t;
        t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();

            int heights[] = new int[n];
            long totSum = 0;
            for (int i = 0; i < n; i++) {
                heights[i] = s.nextInt();
                totSum += heights[i];
            }

            //array created

            int[] incArr = new int[n];
            incArr[0] = 1;
            int[] decArr = new int[n];
            decArr[n - 1] = 1;
            for (int i = 1; i < heights.length; i++) {
                if (heights[i] > incArr[i - 1]) {
                    incArr[i] = incArr[i - 1] + 1;
                } else {
                    incArr[i] = heights[i];
                }
            }

            for (int i = heights.length - 2; i >= 0; i--) {

                if (heights[i] > decArr[i + 1]) {
                    decArr[i] = decArr[i + 1] + 1;
                } else {
                    decArr[i] = heights[i];
                }
            }


            int maxPattern = Integer.MIN_VALUE;

            for (int i = 0; i < heights.length; i++) {
                if (incArr[i] <= decArr[i]) {
                    if (maxPattern < incArr[i]) {
                        maxPattern = incArr[i];
                    }
                } else {
                    if (maxPattern < decArr[i]) {
                        maxPattern = decArr[i];
                    }
                }
            }

//            printArr(incArr);
//            printArr(decArr);
//            printArr(diffArr);
//            System.out.println(maxPattern);
//            System.out.println(totSum);

            long sumPatt = maxPattern * maxPattern;
            System.out.println(totSum - sumPatt);

        }
    }

    private static void printArr(int[] Arr) {
        System.out.println("<<<<<printing>>>>>>");
        for (int aArr : Arr) {
            System.out.print(aArr + " ");
        }
        System.out.println();
    }
}