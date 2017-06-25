import java.io.IOException;
import java.util.Scanner;

/**
 * Created by prabhakar on 28/5/17.
 */
public class TEAMFORM {
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        Scanner s = new Scanner(System.in);
        int t;
        t = s.nextInt();
        while(t-- > 0)
        {
            int n = s.nextInt();
            int heights[] = new int[n];
            int temp[] = new int[n];
            for(int i=0;i<n;i++)
            {
                heights[i] = s.nextInt();
            }
            int count=0;
            if(n%2!=0)
            {
                for(int i=1;i<=n/2;i++)
                {
                    count += heights[i-1] - i;
                    count += heights[(n)-i] - i;
                }
                count+= heights[n/2] - (n+1)/2;
            }
            else
            {
                if(heights[0]<heights[n-1])
                {
                    count += heights[n-1];
                    for(int i=1;i<=(n/2)-1;i++)
                    {
                        count += heights[i-1] - 1;
                        count += heights[n-2] - i;
                    }
                }
                else
                {
                    count += heights[0];
                    for(int i=1;i<=(n/2)-1;i++)
                    {
                        count += heights[i] - i;
                        count += heights[n-1] - i;
                    }
                }

            }
            System.out.println(count);

        }
    }
}
