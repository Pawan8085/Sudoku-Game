package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.model.Easy;
import com.app.model.Hard;
import com.app.model.Medium;
import com.app.repo.EasyRepo;
import com.app.repo.HardRepo;
import com.app.repo.MediumRepo;
import com.app.service.GridConverter;
import com.google.gson.Gson;

@SpringBootApplication
public class SudokuApplication implements CommandLineRunner{
	
	
	@Autowired
	private EasyRepo easyRepo;
	
	@Autowired
	private MediumRepo mediumRepo;
	
	@Autowired
	private HardRepo hardRepo;
	
	@Autowired
	private GridConverter gridConverter;

	public static void main(String[] args){
		SpringApplication.run(SudokuApplication.class, args);
	} 

	@Override
	public void run(String... args) throws Exception {
		
//		int[][] sudoku = {
//				{0, 0, 8, 0, 9, 0, 0, 1, 0},
//			    {6, 0, 0, 4, 0, 0, 0, 0, 0},
//			    {9, 5, 0, 0, 0, 8, 2, 0, 0},
//			    {0, 0, 0, 0, 4, 0, 0, 0, 8},
//			    {0, 1, 9, 7, 0, 2, 4, 3, 0},
//			    {3, 0, 0, 0, 8, 0, 0, 0, 0},
//			    {0, 0, 6, 2, 0, 0, 0, 5, 7},
//			    {0, 0, 0, 0, 0, 4, 0, 0, 3},
//			    {0, 9, 0, 0, 5, 0, 6, 0, 0}
//			};
//		
//		
//		String s = gridConverter.gridToString(sudoku);
//		
//		Hard hard = new Hard();
//		
//		hard.setGrid(s);
//		
//		hardRepo.save(hard);
		
		
//		mediumRepo.save(medium);
		
//		easyRepo.save(easy);
		
		
		
	}

}
