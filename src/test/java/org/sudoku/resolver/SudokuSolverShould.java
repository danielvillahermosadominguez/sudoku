package org.sudoku.resolver;

import org.junit.jupiter.api.Test;
import org.sudoku.validation.Board;
import org.sudoku.validation.SudokuValidator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.sudoku.validation.Board.HOLE;

public class SudokuSolverShould {
    @Test
    void solve_a_valid_sudoku_with_a_hole() {
        Board board = Board.of(new Integer[][]{
                {1, 2, HOLE, 4},
                {3, 4, 1, 2},
                {2, 3, 4, 1},
                {4, 1, 2, 3}
        });

        Board expectedSolution = Board.of(new Integer[][]{
                {1, 2, 3, 4},
                {3, 4, 1, 2},
                {2, 3, 4, 1},
                {4, 1, 2, 3}
        });

        SudokuValidator sudokuValidator = mock(SudokuValidator.class);
        when(sudokuValidator.isValid(expectedSolution)).thenReturn(true);

        SudokuSolver solver = new SudokuSolver(sudokuValidator);
        assertThat(solver.solve(board)).isEqualTo(expectedSolution);
    }
}
