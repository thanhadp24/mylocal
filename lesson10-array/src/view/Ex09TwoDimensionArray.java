package view;

public abstract class Ex09TwoDimensionArray {
	public static void main(String[] args) {
		int[] oneD = {1, 2, 4};
		
		int[][] twoD = {{1,2,4}, {2, 3, 5}};
		
		// TwoD(x, y, z)
		// TwoD[] twoD = {new TwoD(1,2,3), new TwoD(2,3,4)};
		
		int[][][] threeD = {
				{
					{1,2,4}, // threeD[0]
					{3,5,9}
				},
				{
					{1,2,3}, // threeD[1]
					{3,5,5}
				},
		};
		
		// Xtype(x,y,z)
		// Ytype --> Xtype[]
		// Ytype[]
		
		for (int row = 0; row < twoD.length; row++) {
			for (int col = 0; col < twoD[row].length; col++) {
				System.out.print(twoD[row][col] + " ");
			}
			System.out.println();
		}
	}
}
