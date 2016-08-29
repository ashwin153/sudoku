package com.ashwin.sudoku.solver;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuTest {

	// Tests that the isValid method detects failure and success for Sudoku
	// puzzles that are of different sizes. This ensures that the code works
	// properly with non-traditional Sudoku puzzles.
	@Test
	public void testIsValidFailure3x3() {
		int[][] result = new int[][] {
				{4, 2, 9, 1, 9, 7, 3, 6, 5},
				{5, 7, 1, 2, 6, 3, 4, 8, 9},
				{3, 9, 6, 4, 5, 8, 7, 1, 2},
				{1, 6, 7, 5, 8, 9, 2, 3, 4},
				{2, 4, 9, 7, 3, 1, 6, 5, 8},
				{8, 3, 5, 6, 2, 4, 9, 7, 1},
				{6, 5, 3, 8, 4, 2, 1, 9, 7},
				{9, 1, 2, 3, 7, 5, 8, 4, 6},
				{7, 8, 4, 9, 1, 6, 5, 2, 3}
		};
		
		Sudoku sudoku = new Sudoku(result);
		assertFalse(sudoku.isValid());
	}
	
	@Test
	public void testIsValidFailure2x2() {
		int[][] result = new int[][] {
				{1, 2, 3, 4},
				{3, 4, 4, 2},
				{1, 3, 4, 1},
				{4, 1, 2, 3}
		};
		
		Sudoku sudoku = new Sudoku(result);
		assertFalse(sudoku.isValid());
	}
	
	@Test
	public void testIsValidSuccess3x3() {
		int[][] result = new int[][] {
				{4, 2, 8, 1, 9, 7, 3, 6, 5},
				{5, 7, 1, 2, 6, 3, 4, 8, 9},
				{3, 9, 6, 4, 5, 8, 7, 1, 2},
				{1, 6, 7, 5, 8, 9, 2, 3, 4},
				{2, 4, 9, 7, 3, 1, 6, 5, 8},
				{8, 3, 5, 6, 2, 4, 9, 7, 1},
				{6, 5, 3, 8, 4, 2, 1, 9, 7},
				{9, 1, 2, 3, 7, 5, 8, 4, 6},
				{7, 8, 4, 9, 1, 6, 5, 2, 3}
		};
		
		Sudoku sudoku = new Sudoku(result);
		assertTrue(sudoku.isValid());
	}
	
	@Test
	public void testIsValidSuccess2x2() {
		int[][] result = new int[][] {
				{1, 2, 3, 4},
				{3, 4, 1, 2},
				{2, 3, 4, 1},
				{4, 1, 2, 3}
		};
		
		Sudoku sudoku = new Sudoku(result);
		assertTrue(sudoku.isValid());
	}

	// Tests that the isComplete method works for Sudoku puzzles that are of different
	// sizes. This ensures that the code works properly with non-traditional
	// Sudoku puzzles.
	@Test
	public void testIsCompleteFailure3x3() {
		int[][] result = new int[][] {
				{4, 2, 9, 1, 9, 7, 3, 6, 5},
				{5, 7, 1, 2, 6, 3, 4, 8, 9},
				{3, 9, 6, 4, 5, 8, 7, 1, 2},
				{1, 6, 7, 5, 8, 9, 2, 3, 4},
				{2, 4, 9, 7, 3, 1, 6, 5, 8},
				{8, 3, 5, 6, 2, 4, 9, 7, 1},
				{6, 5, 3, 8, 4, 2, 1, 9, 7},
				{9, 1, 2, 3, 7, 5, 8, 4, 6},
				{7, 8, 4, 9, 1, 6, 5, 2, 3}
		};
		
		Sudoku sudoku = new Sudoku(result);
		assertFalse(sudoku.isComplete());
	}

	@Test
	public void testIsCompleteSuccess3x3() {
		int[][] result = new int[][] {
				{4, 2, 8, 1, 9, 7, 3, 6, 5},
				{5, 7, 1, 2, 6, 3, 4, 8, 9},
				{3, 9, 6, 4, 5, 8, 7, 1, 2},
				{1, 6, 7, 5, 8, 9, 2, 3, 4},
				{2, 4, 9, 7, 3, 1, 6, 5, 8},
				{8, 3, 5, 6, 2, 4, 9, 7, 1},
				{6, 5, 3, 8, 4, 2, 1, 9, 7},
				{9, 1, 2, 3, 7, 5, 8, 4, 6},
				{7, 8, 4, 9, 1, 6, 5, 2, 3}
		};
		
		Sudoku sudoku = new Sudoku(result);
		assertTrue(sudoku.isComplete());
	}

	@Test
	public void testIsCompleteFailure2x2() {
		int[][] result = new int[][] {
				{1, 2, 3, 4},
				{3, 4, 4, 2},
				{1, 3, 4, 1},
				{4, 1, 2, 3}
		};
			
		Sudoku sudoku = new Sudoku(result);
		assertFalse(sudoku.isComplete());
	}

	@Test
	public void testIsCompleteSuccess2x2() {
		int[][] result = new int[][] {
				{1, 2, 3, 4},
				{3, 4, 1, 2},
				{2, 3, 4, 1},
				{4, 1, 2, 3}
		};
			
		Sudoku sudoku = new Sudoku(result);
		assertTrue(sudoku.isComplete());
	}
}
