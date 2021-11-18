package os;

import java.util.Scanner;

public class PS {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
	    double avwt,avtat;
	    float sum=0,sum1=0;
	    int count=0,pos,end,smallest;
	    
	    System.out.println("Enter the no. of processes:");
	    int n=sc.nextInt();
	    
	    int tat[]=new int[20];
	    int pr[]=new int[20];
	    int wt[]=new int[20]; 
	    int bt[]=new int[20];
		int at[]=new int[20];
		int temp[]=new int[20];
		int comp[]=new int[20];
		
		System.out.println("Enter arrival time");
	    for(int i=0 ;i<n; i++)
	    {
	        at[i]=sc.nextInt();
	    }
		
		System.out.println("Enter burst time of processes");
	    for(int i=0 ;i<n; i++)
	    {
	        bt[i]=sc.nextInt();
	    }
	    
	    System.out.println("Enter the priority of processes");
	    for(int i=0 ;i<n; i++)
	    {
	        pr[i]=sc.nextInt();
	    }

		  
		for(int i=0; i<n; i++)
		    temp[i]=bt[i];

		    pr[19]=-1;
		    for(int i=0; count!=n; i++)
		    {
		        smallest=19;
		        for(int j=0; j<n; j++)
		        {
		            if(at[j]<=i && pr[j]>pr[smallest] && bt[j]>0 )
		                smallest=j;
		        }
		        bt[smallest]--;

		        if(bt[smallest]==0)
		        {
		            count++;
		            end=i+1;
		            comp[smallest] = end;
		            wt[smallest] = end - at[smallest] - temp[smallest];
		            tat[smallest] = end - at[smallest];
		        }
		    }
		    
		    
		    
		    System.out.println("Proccess  Priority Burst Time Waiting Time Turnaround Time");
		    
		    for(int x=0; x<n;x++)
		    {
		    	System.out.println("Process"+ x +":"+ "\t"+pr[x]+"\t"+temp[x]+"\t"+wt[x]+"\t\t"+tat[x]);
		    	sum+=tat[x];
		    	sum1+=wt[x];
		    }
		    
		    avtat=sum/n;
		    avwt=sum1/n; 
		    
		    System.out.println("\nAverage Turnaround time="+ avtat);
		    System.out.println("Average Waiting time="+ avwt);
		  
	}

}
