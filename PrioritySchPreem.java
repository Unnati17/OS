package os;

import java.util.Scanner;

public class PrioritySchPreem {

	public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			
		    double avwt,avtat;
		    float sum=0,sum1=0;
		    int count=0,pos;
		    
		    System.out.println("Enter the no. of processes:");
		    int n=sc.nextInt();
		    
		    int tat[]=new int[20];
		    int p[]=new int[20];
		    int wt[]=new int[20]; 
		    int bt[]=new int[20];
			int at[]=new int[20];
			int temp[]=new int[20];
			int pr[]=new int[20];
			
			System.out.println("Enter arrival time");
		    for(int i=0 ;i<n; i++)
		    {
		        at[i]=sc.nextInt();
		        p[i]=i+1;
		    }
			
			System.out.println("Enter burst time of processes");
		    for(int i=0 ;i<n; i++)
		    {
		        bt[i]=sc.nextInt();
		        temp[i]=bt[i];
		    }
		    
		    System.out.println("Enter the priority of processes");
		    for(int i=0 ;i<n; i++)
		    {
		        pr[i]=sc.nextInt();
		    }
		    
		    pr[19]=9999;
		    
		    for(int i=0;count!=n;i++)
		    {
		    	pos=19;
		    	for(int j=0;j<n;j++)
		    	{
		    		if(pr[pos]>pr[j] && at[j]<=i && bt[j]>0)
		    		{
		    			pos=j;
		    		}
		    	}
		    	
		    	bt[pos]--;
		        
		        if(bt[pos]==0)
		        {
		            count++;
		            wt[pos]=i+1-at[pos]-temp[pos];
		            tat[pos]=i+1-at[pos];
		 
		            sum=sum+wt[pos];
		            sum1=sum1+tat[pos];
		            
		        }
		    }
		    
		    avtat=sum/n;
		    avwt=sum1/n; 
		    
		    System.out.println("Proccess  Priority Burst Time Waiting Time Turnaround Time");
		    
		    for(int i=0; i<n;i++)
		    {
		    	System.out.println("Process"+ p[i] +":"+ "\t"+pr[i]+"\t"+temp[i]+"\t"+wt[i]+"\t\t"+tat[i]);
		    }
		    
		    
		    
		    System.out.println("\nAverage Turnaround time "+ avtat);
		    System.out.println("Average Waiting time "+ avwt);
	}

}
