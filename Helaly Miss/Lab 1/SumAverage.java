package Lab1;
import java.util.Scanner;

public class SumAverage {
	public static void main(String[] args)
    {
  	  Scanner input = new Scanner(System.in);
  	  int n=input.nextInt();
  	  int[] a= new int[n];
  	  for(int i=0;i<n;i++)
  	  {
  		  a[i]=input.nextInt();
  	  }
  	  int sum=0;
  	for(int i=0;i<n;i++)
  	{
  		sum=sum+a[i];
  	}
  	double avg = (double)sum/n;
  	System.out.print("Sum: "+sum+"\nAverage: "+avg);
}
}
