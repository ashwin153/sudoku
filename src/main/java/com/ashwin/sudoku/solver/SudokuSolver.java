package com.ashwin.sudoku.solver;

public interface SudokuSolver {

	/**
	 * This method takes a partially unsolved sudoku puzzle and returns
	 * a fully completed puzzle. The two-dimensional integer arrays are
	 * in row-major order.
	 * 
	 * @param sudoku incomplete puzzle
	 * @return completed puzzle
	 */
	Sudoku solve(Sudoku sudoku);
	
}
