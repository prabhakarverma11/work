import java.io.BufferedReader;
import java.io.IOException;
        import java.io.InputStreamReader;

public class SnakeTemple3 {

    public static void main(String args[]) throws NumberFormatException, IOException {
        Integer foundPatternValue = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        long patternSumArray[] = new long[10001];
        for(int i=1;i<=10000;i++)
        {
            patternSumArray[i] =sumOfPattern(i);
        }
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int heights[] = new int[n];
            long sumOfArray=0;

            String str[] = br.readLine().split(" ");
            int badIndexArray[] = new int[n];
            int k=0;
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(str[i]);

                if(heights[i]==1)
                    k++;

                badIndexArray[i] = k;

                sumOfArray+=heights[i];
            }

            //now we have the table of heights.
            int maxPattern = Integer.MIN_VALUE;
            //System.out.println("badIndexes: "+Arrays.toString(badIndexArray));
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
                    if(badIndexArray[i]-badIndexArray[j]!=0&&(heights[i]!=1||heights[j]!=1))
                        break;

                    if(Math.abs(i-j)+1<=(maxPattern*2-1))
                        break;
                    foundPatternValue = getNumberOfOperations(heights, i, j, foundPatternValue);
                    System.out.println("i: "+i+", j="+j+", ans="+foundPatternValue);
                    if(foundPatternValue!=-1)
                    {
                        if(foundPatternValue>maxPattern)
                            maxPattern = foundPatternValue;
                        break;
                    }
                    j -= 2;
                }
            }
            long sumOfPattern;
            if(maxPattern<=10000)
                sumOfPattern = patternSumArray[maxPattern];
            else
                sumOfPattern = sumOfPattern(maxPattern);
            long noOfOperations = sumOfArray-sumOfPattern;
            //System.out.println("sumOfPattern: "+sumOfPattern+" maxPattern: "+maxPattern+" sumofArray: "+sumOfArray);
            System.out.println(noOfOperations);
        }
    }

    private static long sumOfPattern(int foundValue) {
        int sumOfPattern = foundValue;
        for(int i=foundValue-1;i>0;i--){
            sumOfPattern+=2*i;
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