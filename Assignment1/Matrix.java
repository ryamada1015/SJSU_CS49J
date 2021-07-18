package edu.sjsu.assignment1;

import java.util.Arrays;

public class Matrix {
	
	public static void main(String[] args) {
		int[][] array1 = {{2, 4}, {3, 4}};
		int[][] array2 = {{1, 2}, {1, 3}};
		Matrix matrix1 = new Matrix(array1);
		Matrix matrix2 = new Matrix(array2);
		Matrix resultMatrix = matrix1.multiply(matrix2);
		int[][] resultArray = resultMatrix.getMatrix();
		
		System.out.println(Arrays.deepToString(resultArray));
	}

	private int[][] array;
	
	public Matrix(int[][] array) {
		this.array = array;
	}
	
	public Matrix multiply(Matrix matrix) {
		int resultRow = this.array.length;
		int resultCol = matrix.array[0].length;
		int[][] resultArr = new int[resultRow][resultCol];
		for(int i = 0; i < resultRow; i++) {
			for(int j = 0; j < resultCol; j++) {
				resultArr[i][j] = 0;
				for(int k = 0; k < resultRow; k++) {
					resultArr[i][j] += this.array[i][k]*matrix.array[k][j];
				}
			}
		}
		Matrix resultMatrix = new Matrix(resultArr);
		
		return resultMatrix;
	}
	
	public int[][] getMatrix() {
		return this.array;
	}

}
