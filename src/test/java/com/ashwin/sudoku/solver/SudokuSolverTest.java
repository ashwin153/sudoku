package com.ashwin.sudoku.solver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SudokuSolverTest {

	@Test
	public void testBruteForceSolver() {
		testSudokuSolver(new BruteForceSolver());
	}
	
	private void testSudokuSolver(SudokuSolver solver) {
		int[][] input = new int[][] {
				{4, 0, 8, 0, 9, 0, 0, 0, 0},
				{0, 7, 0, 0, 0, 0, 4, 0, 0},
				{0, 0, 6, 0, 5, 0, 0, 0, 0},
				{0, 0, 7, 0, 0, 0, 0, 3, 0},
				{0, 4, 0, 0, 0, 1, 6, 0, 0},
				{0, 3, 5, 6, 0, 4, 0, 0, 0},
				{0, 0, 0, 0, 0, 2, 1, 0, 0},
				{9, 1, 0, 0, 7, 0, 8, 0, 0},
				{0, 0, 4, 0, 0, 0, 0, 0, 3}
		};
		
		int[][] output = new int[][] {
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
		
		Sudoku sudoku = new Sudoku(input);
		assertTrue(sudoku.isValid());
		assertFalse(sudoku.isComplete());
		
		Sudoku result = solver.solve(sudoku);
		assertTrue(result.isValid());
		assertTrue(result.isComplete());
		assertNotEquals(result, sudoku);
		
		int size = result.size();
		for(int r = 0; r < size * size; r++)
			for(int c = 0; c < size * size; c++)
				assertEquals(result.get(r, c), output[r][c]);
	}
}
