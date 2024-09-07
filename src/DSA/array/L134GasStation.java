package DSA.array;

//https://leetcode.com/problems/gas-station
public class L134GasStation {
//https://www.youtube.com/watch?v=HQpDS9wuzws

    public int canCompleteCircuit(int[] gas, int[] cost) {
        //Greedy Approach
        //here cost means the amount of petrol needed to travel from one station to the next
        int totalCost = 0, totalGas = 0, start = 0, fuelInTank = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            fuelInTank += (gas[i] - cost[i]);

            if (fuelInTank < 0) {
                fuelInTank = 0;
                start = i + 1;
            }
        }

        return totalGas < totalCost ? -1 : start;
    }
}

//TC: O(N)
//SC: O(1)
