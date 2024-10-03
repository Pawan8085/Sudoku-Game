package com.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Easy;
import com.app.model.GameInfo;
import com.app.model.Hard;
import com.app.model.Medium;
import com.app.repo.EasyRepo;
import com.app.repo.GameInfoRepo;
import com.app.repo.HardRepo;
import com.app.repo.MediumRepo;

@Service
public class SudokuServiceImpl implements SudokuService {

	@Autowired
	private EasyRepo easyRepo;

	@Autowired
	private MediumRepo mediumRepo;

	@Autowired
	private HardRepo hardRepo;

	@Autowired
	private GameInfoRepo gameInfoRepo;

	@Autowired
	private GridConverter gridConverter;

	@Override
	public int[][] getEasySudoku(String gameType) {
		
		return getEasyMediumAndHardSudoku(gameType);

	}

	@Override
	public int[][] getMediumSudoku(String gameType) {
		
		return getEasyMediumAndHardSudoku(gameType);

	}

	@Override
	public int[][] getHardSudoku(String gameType) {
		
		 return getEasyMediumAndHardSudoku(gameType);

	}

	public int[][] getEasyMediumAndHardSudoku(String gameType) {

		List<GameInfo> gameInfoList = gameInfoRepo.findAll();
		if (gameInfoList.isEmpty()) {

			GameInfo newGame = new GameInfo();
			newGame.setCurInd(0);
			Set<String> emptyPosition = new HashSet<>();
			int[][] grid = null;
			if (gameType.equals("easy")) {

				List<Easy> list = easyRepo.findAll();
				grid = gridConverter.stringToGrid(list.get(0).getGrid());
				newGame.setCurrentGameType("easy");
			} else if (gameType.equals("medium")) {

				List<Medium> list = mediumRepo.findAll();
				grid = gridConverter.stringToGrid(list.get(0).getGrid());
				newGame.setCurrentGameType("medium");
			} else if (gameType.equals("hard")) {
				List<Hard> list = hardRepo.findAll();
				grid = gridConverter.stringToGrid(list.get(0).getGrid());
				newGame.setCurrentGameType("hard");
			}

			int[][] solvedGrid = new int[9][9];
			for (int i = 0; i < 9; ++i) {
				for (int j = 0; j < 9; ++j) {
					solvedGrid[i][j] = grid[i][j];
					if (grid[i][j] == 0)
						emptyPosition.add(i + "" + j);

				}
			}

			newGame.setEmptyGridPositions(emptyPosition);
			newGame.setGrid(gridConverter.gridToString(grid)); // save unsolved sudoku;
			SudokuSolver.solve(solvedGrid); // solving sudoku
			newGame.setSolution(gridConverter.gridToString(solvedGrid)); // save sudoku solution

			gameInfoRepo.save(newGame);

			// System.out.println("Just Created New Game Info.............");
			return grid;

		}
		GameInfo gameInfo = gameInfoList.get(0);
		gameInfo.setCurInd(0);
		Set<String> emptyPosition = new HashSet<>();
		int[][] grid = null;
		if (gameType.equals("easy")) {
			if (gameInfo.getCurrentGameType().equals("easy")) {

				return gridConverter.stringToGrid(gameInfo.getGrid());

			}else {
				
				List<Easy> list = easyRepo.findAll();
				grid = gridConverter.stringToGrid(list.get(0).getGrid());
				gameInfo.setCurrentGameType("easy");
				
			}
		} else if (gameType.equals("medium")) {
			if (gameInfo.getCurrentGameType().equals("medium")) {

				return gridConverter.stringToGrid(gameInfo.getGrid());

			}else {
				
				List<Medium> list = mediumRepo.findAll();
				grid = gridConverter.stringToGrid(list.get(0).getGrid());
				gameInfo.setCurrentGameType("medium");
				
			}
		} else if (gameType.equals("hard")) {
			if (gameInfo.getCurrentGameType().equals("hard")) {

				return gridConverter.stringToGrid(gameInfo.getGrid());

			}else {
				List<Hard> list = hardRepo.findAll();
				grid = gridConverter.stringToGrid(list.get(0).getGrid());
				gameInfo.setCurrentGameType("hard");
			}
		}
		
		int[][] solvedGrid = new int[9][9];
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				solvedGrid[i][j] = grid[i][j];
				if (grid[i][j] == 0)
					emptyPosition.add(i + "" + j);

			}
		}
		gameInfo.setEmptyGridPositions(emptyPosition); // save empty positions
		gameInfo.setGrid(gridConverter.gridToString(grid)); // save unsolved sudoku;
		SudokuSolver.solve(solvedGrid); // solving sudoku
		gameInfo.setSolution(gridConverter.gridToString(solvedGrid)); // save sudoku solution

		gameInfoRepo.save(gameInfo);

		
		return grid;

	}

	@Override
	public int[][] getSolution() {
		
		System.out.println(gameInfoRepo.findAll().get(0).getSolution());
		return gridConverter.stringToGrid(gameInfoRepo.findAll().get(0).getSolution());

	}

	@Override
	public int[][] getNextGame() {

		List<GameInfo> gameInfoList = gameInfoRepo.findAll();
		GameInfo gameInfo = gameInfoList.get(0);
		Set<String> emptyPosition = new HashSet<>();
		int[][] grid = null;

		if (gameInfo.getCurrentGameType().equals("easy")) {
			List<Easy> list = easyRepo.findAll();
			int next = gameInfo.getCurInd() + 1 == list.size() ? 0 : gameInfo.getCurInd() + 1;
		    grid = gridConverter.stringToGrid(list.get(next).getGrid());
			gameInfo.setCurInd(next);
			

		} else if (gameInfo.getCurrentGameType().equals("medium")) {
			List<Medium> list = mediumRepo.findAll();
			
			System.out.println(gameInfo.getCurInd());
			int next = gameInfo.getCurInd() + 1 == list.size() ? 0 : gameInfo.getCurInd() + 1;
			 grid = gridConverter.stringToGrid(list.get(next).getGrid());
			 gameInfo.setCurInd(next);
			
		} else if (gameInfo.getCurrentGameType().equals("hard")) {
			List<Hard> list = hardRepo.findAll();
			int next = gameInfo.getCurInd() + 1 == list.size() ? 0 : gameInfo.getCurInd() + 1;
			 grid = gridConverter.stringToGrid(list.get(next).getGrid());
			 gameInfo.setCurInd(next);
			
		}
		int[][] solvedGrid = new int[9][9];
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				solvedGrid[i][j] = grid[i][j];
				if (grid[i][j] == 0)
					emptyPosition.add(i + "" + j);
			}
		}

		gameInfo.setEmptyGridPositions(emptyPosition);
		gameInfo.setGrid(gridConverter.gridToString(grid)); // save unsolved sudoku;
		SudokuSolver.solve(solvedGrid); // solving sudoku
		gameInfo.setSolution(gridConverter.gridToString(solvedGrid)); // save sudoku solution

		gameInfoRepo.save(gameInfo);

		return gridConverter.stringToGrid(gameInfo.getGrid());
	}

	@Override
	public boolean userInput(int row, int col, int num) {

		GameInfo gameInfo = gameInfoRepo.findAll().get(0);
		int[][] grid = gridConverter.stringToGrid(gameInfo.getGrid());
		boolean isValidNumber = SudokuSolver.isValid(grid, row, col, num);
		boolean isValidEmptyPosition = gameInfo.getEmptyGridPositions().contains(row + "" + col);

		if (isValidNumber && isValidEmptyPosition) {

			grid[row][col] = num;
			gameInfo.setGrid(gridConverter.gridToString(grid));
			gameInfoRepo.save(gameInfo);

			return true;
		}

		return false;

	}

	@Override
	public boolean isValidEmptyPosition(int row, int col) {

		GameInfo gameInfo = gameInfoRepo.findAll().get(0);
		return gameInfo.getEmptyGridPositions().contains(row + "" + col);

	}

	@Override
	public boolean wonTheGameOrNot() {

		GameInfo gameInfo = gameInfoRepo.findAll().get(0);

		int[][] grid = gridConverter.stringToGrid(gameInfo.getGrid());

		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				if (grid[i][j] == 0)
					return false;
			}
		}

		return true;

	}

}
