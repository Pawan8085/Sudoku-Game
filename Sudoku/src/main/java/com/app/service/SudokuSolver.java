package com.app.service;

public class SudokuSolver {
	
	 public static boolean solve(int[][] board) {
	        for (int row=0; row<9; row++) {
	            for (int col=0; col<9; col++) {
	                if (board[row][col] == 0) {
	                    for (int mynum=1; mynum<= 9; mynum++) {
	                        if (isValid(board, row, col, mynum)) {
	                            board[row][col] = mynum;
	                            if (solve(board)) {
	                                return true;
	                            }
	                            board[row][col] = 0; // Backtrack
	                        }
	                    }
	                    return false; // didn't get valid number, need to backtrack
	                }
	            }
	        }
	        
	        return true; 
	    }
	    
	    public static boolean isValid(int[][] board, int row, int col, int num) {
	        // check row
	        for (int i=0; i<9; i++) {
	            if (board[row][i] == num && col != i) {
	                return false;
	            }
	        }

	        // check column
	        for (int i=0; i<9; i++) {
	            if (board[i][col] == num && row != i) {
	                return false;
	            }
	        }

	        // check in 3*3 matrix
	        int startRow = 3 * (row/3);
	        int startCol = 3 * (col/3);

	        for (int i=0; i<3; i++) {
	            for (int j=0; j<3; j++) {
	                if (board[startRow+i][startCol+j] == num && row != startRow+i && col!= startCol+j) {
	                    return false;
	                }
	            }
	        }

	        return true;
	    }
	    
}
