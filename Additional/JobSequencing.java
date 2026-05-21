import java.util.*;

class Job {

    int id, deadline, profit;

    Job(int id, int deadline, int profit) {

        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    public static void jobScheduling(int[] deadline, int[] profit) {

        int n = deadline.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(i, deadline[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;

        for (int d : deadline) {

            maxDeadline = Math.max(maxDeadline, d);
        }

        boolean[] slot = new boolean[maxDeadline + 1];

        int countJobs = 0;

        int totalProfit = 0;

        for (Job job : jobs) {

            for (int j = job.deadline; j > 0; j--) {

                if (!slot[j]) {

                    slot[j] = true;

                    countJobs++;

                    totalProfit += job.profit;

                    break;
                }
            }
        }

        System.out.println("Jobs completed: " + countJobs);

        System.out.println("Maximum profit: " + totalProfit);
    }

    public static void main(String[] args) {

        int[] deadline = { 2, 1, 2, 1, 3 };

        int[] profit = { 100, 19, 27, 25, 15 };

        jobScheduling(deadline, profit);
    }
}