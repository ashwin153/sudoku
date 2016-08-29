package com.ashwin.sudoku.solver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a single cell in a sudoku puzzle. Sudoku cells
 * have a set of possible values and expose method for accessing, calculating
 * and iterating over these possible values.
 * 
 * @author ashwin
 *
 */
public class SudokuCell {
	
	private Set<Integer> _values;
	private int _row, _col;
	
	public SudokuCell(int row, int col, Set<Integer> values) {
		_values = values;
		_row = row;
		_col = col;
	}
	
	public int getRow() {
		return _row;
	}
	
	public int getCol() {
		return _col;
	}
	
	/**
	 * Returns the number of possible values for this SudokuCell.
	 * @return number of possible values
	 */
	public int size() {
		return _values.size();
	}

	/**
	 * Returns the set of all possible values for this SudokuCell.
	 * @return set of all possible values
	 */
	public Set<Integer> getValues() {
		return _values;
	}
	
	@Override
	public String toString() {
		return _values.toString();
	}
}