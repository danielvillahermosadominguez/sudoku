package org.sudoku.validation;

import java.util.List;

public class SudokuValidator {
  public boolean isValid(Board board) {
    List<BoardChunk> rows = board.rows();
    List<BoardChunk> columns = board.columns();
    List<BoardChunk> squares = board.squares();

    return noDuplicated(rows) &&
      noDuplicated(columns) &&
      noDuplicated(squares);
  }

  private boolean noDuplicated(List<BoardChunk> chunks) {
    return !chunks.stream().anyMatch(BoardChunk::hasDuplicatedNumber);
  }
}
