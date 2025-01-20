package DSA.array;

//https://leetcode.com/problems/gas-station
public class L134GasStation {
//https://www.youtube.com/watch?v=HQpDS9wuzws

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Greedy Approach
        // here cost means the amount of petrol needed to travel from one station to it immediate next station
        int totalCost = 0, totalGas = 0;

        // Calculate total gas and total cost
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // Early exit if completing the circuit is impossible
        if (totalGas < totalCost) {
            return -1;
        }

        int start = 0, fuelInTank = 0;
        for (int i = 0; i < gas.length; i++) {
            fuelInTank += (gas[i] - cost[i]);
            if (fuelInTank < 0) { //💡If fuelInTank == 0, it means the gas collected is just enough to reach the next station.
                // There's no need to reset the starting station or reset fuelInTank, as you're still on track to complete the journey.
                start = i + 1;
                fuelInTank = 0;
            }
        }

        return start;
    }
}

//TC: O(N)
//SC: O(1)
