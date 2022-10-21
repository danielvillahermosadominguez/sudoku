package org.example;

import java.util.List;

public class SudokuValidator {
  public boolean isValid(Board board) {
    if (board.hasSameNumberInRow(0)) {
      return false;
    }
    if (hasAnyColumnWithSameNumber(board)) {
      return false;
    }
    if (board.hasSameNumberInSquare(0)) {
      return false;
    }
    return true;
  }

  private boolean hasAnyColumnWithSameNumber(Board board) {
    List<Column> columns = board.columns();
    return columns.stream().anyMatch(board::hasSameNumberInCol);
  }
}
