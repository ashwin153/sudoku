package com.ashwin.sudoku.solver;


public class BruteForceSolver implements SudokuSolver {
	
	public static void main(String[] args) {
		BruteForceSolver solver = new BruteForceSolver();
		int[][] board = new int[][] {
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
		
		System.out.println(solver.solve(new Sudoku(board)));
	}
	
	/**
	 * This method recursively solves the 3-dimensional possibility matrix.
	 * If the board has no possible moves/invalid, then null is returned. (Base Case)
	 * If the board the board is solved (all sets of size 1), the board is returned. (Base Case)
	 * If an element is the ONLY element in the row/column/region that can take a value, it takes that value
	 * If there are possible moves, but no obvious ones (see last line) then it tries every possible value for the element with the fewest possibilities
	 * 
	 * @param sudoku
	 * @return solved possibility matrix
	 */
	public Sudoku solve(Sudoku sudoku) {
		// Base Cases: (1) if the sudoku board is complete and and valid then it is solved and
		// the method returns, (2) if the sudoku board is invalid, then null is returned.
		if(!sudoku.isValid())
			return null;
		else if(sudoku.isComplete())
			return sudoku;
		
		SudokuCell first = getMinimumPossibilities(sudoku);
		for(Integer value : first.getValues()) {
			Sudoku next = new Sudoku(sudoku);
			next.set(first.getRow(), first.getCol(), value);
			next = solve(next);
			
			if(next != null)
				return next;
		}
		
		return null;
	}
	
	/** Returns the SudokuCell with the fewest possibilites. */
	private SudokuCell getMinimumPossibilities(Sudoku sudoku) {
		int size = sudoku.size();
		SudokuCell min = null;
		
		for(int r = 0; r < size * size; r++) {
			for(int c = 0; c < size * size; c++) {
				if(sudoku.get(r, c) == 0) {
					SudokuCell cell = new SudokuCell(r, c, sudoku.getPossibleValues(r, c));
					if(min == null || cell.size() < min.size())
						min = cell;
				}
			}
		}
		
		return min;
	}
}
