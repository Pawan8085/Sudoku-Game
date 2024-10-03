package com.app.service;

public interface SudokuService {
	
	/**
	 * 
	 * @return -> easy sudoku grid
	 */
	int[][] getEasySudoku(String gameType);
	
	/**
	 * 
	 * @return -> medium sudoku grid
	 */
	int[][] getMediumSudoku(String gameType);
	
	/**
	 * 
	 * @return -> hard sudoku grid
	 */
	int[][] getHardSudoku(String gameType);
	
	
	/**
	 * 
	 * @return -> solved sudoku
	 */
	int[][] getSolution();
	
	
	/**
	 * 
	 * @return -> next sudoku game grid
	 */
	int[][] getNextGame();
	
	
	/**
	 * 
	 * @param row -> row number
	 * @param col -> column number
	 * @param num -> user input 
	 * @return -> returns true/false based on row, column and number
	 */
	boolean userInput(int row, int col, int num);
	
	
	/**
	 * 
	 * @param row -> sudoku row
	 * @param col -> sudoku column
	 * @return -> returns true/false based on empty sudoku position
	 */
	boolean isValidEmptyPosition(int row, int col);
	
	
	/**
	 * 
	 * @return -> returns true if user won the game 
	 */
	boolean wonTheGameOrNot();
	
}
