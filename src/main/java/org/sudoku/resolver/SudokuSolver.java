package org.sudoku.resolver;

import org.sudoku.validation.Board;
import org.sudoku.validation.SudokuValidator;

public class SudokuSolver {
    final SudokuValidator sudokuValidator;

    public SudokuSolver(SudokuValidator sudokuValidator) {
        this.sudokuValidator = sudokuValidator;
    }

    public Board solve(Board board) {
        throw new UnsupportedOperationException("Not Implemented!");
    }
}
