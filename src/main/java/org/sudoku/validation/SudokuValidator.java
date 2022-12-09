package org.sudoku.validation;

import java.util.List;

public class SudokuValidator {
  public boolean isValid(Board board) {
    List<BoardChunk> rows = board.rows();
    List<BoardChunk> columns = board.columns();
    List<BoardChunk> squares = board.squares();

    return isChunksValid(rows) &&
      isChunksValid(columns) &&
      isChunksValid(squares);
  }

  private boolean isChunksValid(List<BoardChunk> chunks) {
    return !chunks.stream().anyMatch(this::isChunkInvalid);
  }

  private boolean isChunkInvalid(BoardChunk chunk) {
    return chunk.hasDuplicatedNumber() || chunk.hasAHole();
  }
}
