package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.SudokuService;

@RestController
@RequestMapping("/sudoku")
@CrossOrigin(origins = "*")
public class SudokuController {
	
	
	
	@Autowired
	private SudokuService sudokuService;
	
	@GetMapping("/easy")
	public int[][] getEasySudokuHandler(){
		
		int[][] sudokuGrid =  sudokuService.getEasySudoku("easy");
        return sudokuGrid;
        
	}
	
	@GetMapping("/medium")
	public int[][] getMediumSudokuHandler(){
		
		int[][] sudokuGrid = sudokuService.getMediumSudoku("medium");
        return sudokuGrid;
	}
	
	@GetMapping("/hard")
	public int[][] getHardSudokuHandler(){
		
		int[][] sudokuGrid =  sudokuService.getHardSudoku("hard");
        return sudokuGrid;
        
	}
	
	@GetMapping("/solve")
	public int[][] solveSudokuHandler(){
		
		int[][] sudokuGrid =  sudokuService.getSolution();
        return sudokuGrid;
        
	}
	
	@GetMapping("/next")
	public int[][] getNextGameHandler(){
		
		int[][] sudokuGrid =  sudokuService.getNextGame();
        return sudokuGrid;
        
	}
	
	
	@GetMapping("/{row}/{col}/{num}")
	public boolean fillSudouEmptyPositionHandler(@PathVariable Integer row, @PathVariable Integer col, @PathVariable Integer num) {
		
		return sudokuService.userInput(row, col, num);
	}
	
	@GetMapping("/{row}/{col}")
	public boolean isValidEmptySudokuPositionHandler(@PathVariable Integer row, @PathVariable Integer col) {
		
		return sudokuService.isValidEmptyPosition(row, col);
		
	}
	
	@GetMapping("/won")
	public boolean wonTheGameOrNotHandler() {
		
		return sudokuService.wonTheGameOrNot();
		
	}
	
	
	
}
