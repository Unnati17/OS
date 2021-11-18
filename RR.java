package os;

import java.util.Scanner;

public class RR {

	static void findWaitingTime(int processes[], int n,
			int bt[], int wt[], int quantum, int at[])
			{
			int rem_bt[] = new int[n];
			for (int i = 0 ; i < n ; i++)
			rem_bt[i] = bt[i];

			int t = 0;
			while(true)
			{
			boolean done = true;
			for (int i = 0 ; i < n; i++)
			{
			if(at[i]<=t ){
			if (rem_bt[i] > 0)
			{
			done = false;

			if (rem_bt[i] > quantum)
			{ 
			t += quantum;
			rem_bt[i] -= quantum;
			}



			else
			{
			t = t + rem_bt[i];
			wt[i] = t - bt[i];
			rem_bt[i] = 0;
			}
			}
			}
			}
			if (done == true)
			break;
			}

			}
			static void findTurnAroundTime(int processes[], int n,
			int bt[], int wt[], int tat[])
			{
			for (int i = 0; i < n ; i++)
			tat[i] = bt[i] + wt[i];
			}



			static void findavgTime(int processes[], int n, int bt[], int quantum, int arrival_time[])
			{
			int wt[] = new int[n], tat[] = new int[n];
			int total_wt = 0, total_tat = 0;



			findWaitingTime(processes, n, bt, wt, quantum, arrival_time);



			findTurnAroundTime(processes, n, bt, wt, tat);

			System.out.println("Processes " + " Burst time " +
			" Waiting time " + " Turn around time" + " Arrival time ");

			for (int i=0; i<n; i++)
			{
			total_wt = total_wt + wt[i];
			total_tat = total_tat + tat[i];
			System.out.println(" " + (i+1) + "\t\t" + bt[i] +"\t " +
			wt[i] +"\t\t " + tat[i] + "\t\t" + arrival_time[i]);
			}

			System.out.println("Average waiting time = " +
			(float)total_wt / (float)n);
			System.out.println("Average turn around time = " +
			(float)total_tat / (float)n);
			}


			public static void main(String[] args)
			{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the no. of processes");
			int n = in.nextInt();
			int processes[] = new int[n];
			int burst_time[] = new int[n];
			int arrival_time[] = new int[n];
			for (int i = 0; i < n ; i++ ) {
			System.out.print("Enter the burst time and arrival time of process P"+(i+1)+" :\n");
			processes[i] = i+1;
			System.out.println("Enter Arrival Time");
			arrival_time[i] = in.nextInt();
			System.out.println("Enter Burst Time");
			burst_time[i] = in.nextInt();
			}

			System.out.println("Enter the value of time quantum");
			int quantum = in.nextInt();
			findavgTime(processes, n, burst_time, quantum, arrival_time);
			}
}
