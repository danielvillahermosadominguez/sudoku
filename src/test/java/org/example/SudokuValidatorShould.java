package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SudokuValidatorShould {
  @Test
  void empty_board_should_be_valid() {
    Board board = mock(Board.class);

    SudokuValidator sudoku = new SudokuValidator();

    assertTrue(sudoku.isValid(board));
  }

  @Test
  void board_has_same_number_in_a_row_should_be_invalid() {
    Board board = mock(Board.class);
    when(board.hasSameNumberInRow(0)).thenReturn(true);

    SudokuValidator sudoku = new SudokuValidator();

    assertFalse(sudoku.isValid(board));
  }

  @Test
  void board_has_same_number_in_a_col_should_be_invalid() {
    Board board = mock(Board.class);

    Column column = mock(Column.class);
    when(board.columns()).thenReturn(List.of(column));

    when(board.hasSameNumberInCol(column)).thenReturn(true);

    SudokuValidator sudoku = new SudokuValidator();

    assertFalse(sudoku.isValid(board));
  }


  @Test
  void board_has_same_number_in_a_square_should_be_invalid() {
    Board board = mock(Board.class);
    when(board.hasSameNumberInSquare(0)).thenReturn(true);

    SudokuValidator sudoku = new SudokuValidator();

    assertFalse(sudoku.isValid(board));
  }

}
