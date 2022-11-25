package org.sudoku.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SudokuValidatorShould {
  private SudokuValidator sudoku;
  private Board board;

  @BeforeEach
  void setUp() {
    sudoku = new SudokuValidator();
    board = mock(Board.class);
  }

  @Test
  void empty_board_should_be_valid() {
    assertTrue(sudoku.isValid(board));
  }

  @Test
  void board_has_same_number_in_a_row_should_be_invalid() {
    BoardChunk row = mock(BoardChunk.class);
    when(board.rows()).thenReturn(List.of(row));
    when(row.hasDuplicatedNumber()).thenReturn(true);

    assertFalse(sudoku.isValid(board));
  }

  @Test
  void board_has_same_number_in_a_col_should_be_invalid() {
    BoardChunk column = mock(BoardChunk.class);
    when(board.columns()).thenReturn(List.of(column));
    when(column.hasDuplicatedNumber()).thenReturn(true);

    assertFalse(sudoku.isValid(board));
  }


  @Test
  void board_has_same_number_in_a_square_should_be_invalid() {
    BoardChunk square = mock(BoardChunk.class);
    when(board.squares()).thenReturn(List.of(square));
    when(square.hasDuplicatedNumber()).thenReturn(true);

    assertFalse(sudoku.isValid(board));
  }

}
