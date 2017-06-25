import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SNELECT {

    public static void main(String[] args) throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0)
        {

            String str = br.readLine();
            int n = str.length();
            int snakesLeft = 0;
            int mongoosesLeft = 0;
            int []arr = new int[n];

            for(int i=0;i<n;i++)
            {
                if(str.charAt(i)=='s')
                {
                    arr[i] = -1;snakesLeft++;
                }
                else
                {
                    mongoosesLeft++;
                    if(i==0)
                    {
                        if(n>1&&str.charAt(1)=='s')
                            arr[i] = 2;
                        else
                            arr[i] = 0;
                    }
                    else if(i==(n-1))
                    {

                        if(n>1&&str.charAt(n-2)=='s')
                            arr[i] = 1;
                        else
                            arr[i] = 0;
                    }
                    else
                    {
                        if(str.charAt(i-1)=='s'&&str.charAt(i+1)=='s')
                            arr[i] = 3;
                        else if(str.charAt(i-1)=='s'&&str.charAt(i+1)!='s')
                            arr[i] = 1;
                        else if(str.charAt(i-1)!='s'&&str.charAt(i+1)=='s')
                            arr[i] = 2;
                        else
                            arr[i] = 0;
                    }

                }

            }
            //array initialized
            if(snakesLeft<=mongoosesLeft)
            {
                System.out.println("mongooses");
                continue;
            }
            //System.out.println(Arrays.toString(arr));
            char visited[] = new char[n];

            for(int i=0;i<n;i++)
            {
                if(arr[i]==-1||arr[i]==3) continue;

                visited[i]='V';
                if(arr[i]==0)
                {
                    continue;
                }

                if(arr[i]==1 && visited[i-1] != 'V')
                {
                    visited[i-1] = 'V';snakesLeft--;
                }
                else if(arr[i]==2 && visited[i+1] != 'V')
                {
                    visited[i+1] = 'V';snakesLeft--;
                }

            }

            for(int i=1;i<n-1;i++)
            {
                if(arr[i]<3) continue;
                if(visited[i-1]!='V')
                {
                    visited[i-1]='V';snakesLeft--;
                }
                else if(visited[i+1]!='V')
                {
                    visited[i+1]='V';snakesLeft--;

                }

            }

            //System.out.println("snakes left: "+snakesLeft);
            if(snakesLeft<mongoosesLeft)
                System.out.println("mongooses");
            else if(snakesLeft>mongoosesLeft)
                System.out.println("snakes");
            else
                System.out.println("tie");
        }
        br.close();
    }
}