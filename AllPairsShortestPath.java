package Unit3;
import java.util.*;
public class AllPairsShortestPath {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of vertices");
		int n=sc.nextInt();
		System.out.println("Enter the edges's weights in form of adjacent matrix");
		int cost[][]=new int[n+1][n+1];
		int a[][]=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				cost[i][j]=a[i][j]=sc.nextInt();
		for(int k=1;k<=n;k++)
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
				{
					if(a[i][j]>(a[i][k]+a[k][j]))
						a[i][j]=(a[i][k]+a[k][j]);
				}
		System.out.println("Shortest path for all pairs in matrix form:-");
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
				System.out.print(a[i][j]+"\t");
			System.out.println();
		}
	}
}
