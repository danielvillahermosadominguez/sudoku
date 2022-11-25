package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTest {
    @Test
    void a_four_dimension_not_valid_sudoku() {
        Board board = Board.of(new Integer[][]{
                {1, 2, 3, 4},
                {2, 1, 4, 3},
                {3, 4, 1, 2},
                {4, 3, 2, 1}
        });
        SudokuValidator validator = new SudokuValidator();

        assertThat(validator.isValid(board)).isFalse();
    }

    @Test
    void a_four_dimension_valid_sudoku() {
        Board board = Board.of(new Integer[][]{
                {1, 2, 3, 4},
                {3, 4, 1, 2},
                {2, 3, 4, 1},
                {4, 1, 2, 3}
        });
        SudokuValidator validator = new SudokuValidator();

        assertThat(validator.isValid(board)).isTrue();
    }
}
