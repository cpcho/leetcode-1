package greedy;

/**
 * 
 * Problem:
 * 
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
 *
 * Time Complexity: O(N)
 * 
 * Space Complexity: O(1)
 *
 */
public class _134_GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length != cost.length) {
			return -1;
		}
		int len = gas.length;
		// check if there is a solution
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += gas[i] - cost[i];
		}
		if (sum < 0) {
			return -1;
		}
		// there must be a solution.
		int i = 0;
		int j = 0;
		while (i < len) {
			sum = 0;
			for (j = i; j < len; j++) {
				sum += gas[j] - cost[j];
				if (sum < 0) {
					i = j + 1;
					break;
				}
			}
			if (sum >= 0) {
				return i;
			}
		}
		return -1;
	}
}
