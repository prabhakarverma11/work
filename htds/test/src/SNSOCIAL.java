import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SNSOCIAL {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        long start = System.currentTimeMillis();
        int t = scanner.nextInt();
        while(t-- > 0)
        {
            int n,m;
            n = scanner.nextInt();
            m = scanner.nextInt();
            int [][]a = new int[n][m];
            int max = Integer.MIN_VALUE;
            List<Integer> rowIndex = new ArrayList<Integer>();
            List<Integer> colIndex = new ArrayList<Integer>();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    a[i][j] = scanner.nextInt();
                    if(a[i][j]==max)
                    {
                        max = a[i][j];
                        rowIndex.add(i);
                        colIndex.add(j);
                    }
                    else if(a[i][j]>max)
                    {
                        rowIndex = new ArrayList<Integer>();
                        colIndex = new ArrayList<Integer>();
                        max = a[i][j];
                        rowIndex.add(i);
                        colIndex.add(j);
                    }
                }
            }

			/*for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					System.out.print(a[i][j]+"   ");
				}
				System.out.println();
			}*/
			
			/*System.out.println("max: "+max);
			for(int i=0;i<rowIndex.size();i++)
			{
				System.out.println("("+rowIndex.get(i)+","+colIndex.get(i)+")");
			}*/
            int maxOfAll = Integer.MIN_VALUE; //Max distance any maxima takes to reach a cell
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    int minDist = Integer.MAX_VALUE;
                    for(int k=0;k<rowIndex.size();k++)
                    {
                        int dist = distance(rowIndex.get(k),colIndex.get(k),i,j);
                        if(dist<minDist)
                            minDist=dist;
                    }
                    if(minDist>maxOfAll)
                        maxOfAll = minDist;

                }
            }
            System.out.println(maxOfAll); //Result
            System.out.println("time: "+(System.currentTimeMillis()-start));
        }

    }

    public static int distance(int x1,int y1,int x2,int y2)
    {
        int rowDist = Math.abs(x2 - x1);
        int colDist = Math.abs(y2 - y1);
        int res= Math.min(colDist, rowDist);
        rowDist -= res;
        colDist -= res;
        res += Math.max(colDist,rowDist);
        return res;
    }

}