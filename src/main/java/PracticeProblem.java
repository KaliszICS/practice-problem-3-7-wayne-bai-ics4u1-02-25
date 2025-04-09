public class PracticeProblem {

    // imported from 3.5 
	public static void main(String args[]) {}

	public static final String START = "S";
	public static final String FINISH = "F";
    public static final String WALL = "*";
	public static final int LARGE =(int) Math.pow(2,31)-1;

	public static int nonNegativeMin(int[] args) {
		assert args.length > 0;
		int min = LARGE;

		for (int i = 0; i < args.length; i++) {
			if (args[i] >= 0 && args[i] < min) { // non-negative && smaller than min
				min = args[i];
			}
		}
		return min;
	}

	public static int[][] getEmptyInt2d(String[][] arr) {
		int[][] newArr = new int[arr.length][];

		for (int i = 0; i < arr.length; i++) {
			newArr[i] = new int[arr[i].length];
		}

		return newArr;
	}

	public static int search(String[][] grid, int[][] stepsCounts, int myX, int myY, int stepCount) {
		if (
			stepCount == -1 || // square one
			(
				myY >= 0 && myY < grid.length &&// y within bounds
				myX >= 0 && myX < grid[myY].length && // x within bounds
				!grid[myY][myX].equals(START) && // not the starting square
                !grid[myY][myX].equals(WALL) &&
				(stepsCounts[myY][myX] == 0 || stepsCounts[myY][myX] > stepCount) // this is a shorter path or an unchecked path
			)
		) {
			stepCount += 1;
			// base cases
			stepsCounts[myY][myX] = stepCount; // update its status because it was searched
			if (grid[myY][myX].equals(FINISH)) {
				return stepCount;
			}

			return nonNegativeMin(new int[] {
				search(grid, stepsCounts, myX, myY + 1, stepCount),
				search(grid, stepsCounts, myX, myY - 1, stepCount),
				search(grid, stepsCounts, myX - 1, myY, stepCount),
				search(grid, stepsCounts, myX + 1, myY, stepCount)
			});
		}
		return -1; // negative to avoid being tagged by search
	}

	public static int searchMazeMoves(String[][] arr2d) {

		int[][] stepCounterArray = getEmptyInt2d(arr2d);

		for (int y = 0; y < arr2d.length; y++) {
			for (int x = 0; x < arr2d[y].length; x++) {
				if (arr2d[y][x].equals(START)) {
					int result = search(arr2d, stepCounterArray, x,y, -1);
                    if (result == LARGE) {
                        return -1;
                    }
                    return result;
				}
			}
		}
		return -1; // no "S" was provided
	}
}