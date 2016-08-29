package com.ashwin.sudoku.solver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sudoku {

	private int[][] _board;
	private int _size;
	
	public Sudoku(Sudoku sudoku) {
		_size = sudoku.size();
		
		_board = new int[_size * _size][_size * _size];
		for(int r = 0; r < _board.length; r++)
			for(int c = 0; c < _board[r].length; c++)
				_board[r][c] = sudoku.get(r, c);
	}
	
	public Sudoku(int[][] board) {
		_board = board;
		_size = (int) Math.sqrt(board.length);
	}
	
	/** Returns the value contained in the board at the specified row, col */
	public int get(int row, int col) {
		return _board[row][col];
	}
	
	/** Sets the value of the board at the specified row, col to the specified value. */
	public void set(int row, int col, int value) {
		_board[row][col] = value;
	}
	
	/**
	 * Returns the size of each square in the Sudoku board. Sudoku boards are
	 * composed of n x n squares arranged in a n^2 by n^2 grid.
	 * 
	 * @return the size of the Sudoku board
	 */
	public int size() {
		return _size;
	}
	
	/**
	 * Returns whether the board has been completed. Completed boards have no zeros.
	 * 
	 * @return true if solved, false if not
	 */
	public boolean isComplete() {
		for(int r = 0; r < _size * _size; r++)
			for(int c = 0; c < _size * _size; c++)
				if(_board[r][c] == 0)
					return false;
		return true;
	}
	
	/**
	 * Returns whether the board represents a possible state of a Sudoku board.
	 * Valid boards have unique elements in each row, column, and square.
	 * 
	 * @return true if valid, false if not
	 */
	public boolean isValid() {
		Set<Integer> numbers = new HashSet<Integer>();
		for(int i = 1; i <= _size * _size; i++)
			numbers.add(i);

		// Step 1: Check that there are distinct elements in the row
		for(int r = 0; r < _size * _size; r++) {
			Set<Integer> row = new HashSet<Integer>(numbers);
			for(int c = 0; c < _size * _size; c++)
				if(_board[r][c] != 0 && !row.remove(_board[r][c]))
					return false;
		}

		// Step 2: Check that there are distinct elements in the columns
		for(int c = 0; c < _size * _size; c++) {
			Set<Integer> col = new HashSet<Integer>(numbers);
			for(int r = 0; r < _size * _size; r++) 
				if(_board[r][c] != 0 && !col.remove(_board[r][c]))
					return false;
		}
		
		// Step 3: Check that there are distinct elements in the squares
		for(int i = 0; i < _size; i++) {
			for(int j = 0; j < _size; j++) {
				Set<Integer> square = new HashSet<Integer>(numbers);
				for(int r = i * _size; r < i * _size + _size; r++)
					for(int c = j * _size; c < j * _size + _size; c++)
						if(_board[r][c] != 0 && !square.remove(_board[r][c]))
							return false;
			}
		}
		
		return true;
	}
	
	/**
	 * This method returns a set of all possible values for a particular location
	 * in the sudoku grid. This method considers the values of other elements that
	 * have (1) same row, (2) same col, and (3) same n x n region.
	 * 
	 * @param sudoku unsolved puzzle
	 * @param row row-index
	 * @param col column-index
	 * @return set of all possible values
	 */
	public Set<Integer> getPossibleValues(int row, int col) {
		// If the sudoku puzzle already contains a value at the specified
		// row column pair, then return a set containing ONLY that value.
		if(_board[row][col] != 0)
			return new HashSet<Integer>(Arrays.asList(_board[row][col]));
		
		// We use a HashSet because we want to avoid duplicates. The set begins
		// full and we remove elements from it as we iterate over the puzzle.
		Set<Integer> values = new HashSet<Integer>();
		values.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		
		// Step 1: Remove all the non-zero elements in the same row
		for(int c = 0; c < _board[row].length; c++)
			if(_board[row][c] != 0 && c != col)
				values.remove(_board[row][c]);
		
		// Step 2: Remove all the non-zero elements in the same column
		for(int r = 0; r < _board.length; r++)
			if(_board[r][col] != 0 && r != row)
				values.remove(_board[r][col]);
		
		// Step 3: Remove all the non-zero elements in the same region
		int offr = _size * (row / _size), offc = _size * (col / _size);
		for(int r = offr; r < offr + 3; r++)
			for(int c = offc; c < offc + 3; c++)
				if((r != row || c != col) && _board[r][c] != 0)
					values.remove(_board[r][c]);
		
		return values;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int r = 0; r < _size * _size; r++)
			sb.append(Arrays.toString(_board[r]) + "\n");
		return sb.toString();
	}
}
