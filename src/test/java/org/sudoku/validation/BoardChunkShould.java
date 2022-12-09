package org.sudoku.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.sudoku.validation.Board.HOLE;

class BoardChunkShould {

  @Test
  void when_duplicated_numbers_returns_true() {
    BoardChunk chunk = new BoardChunk(new Integer[]{1, 1});

    assertThat(chunk.hasDuplicatedNumber()).isTrue();
  }

  @Test
  void when_not_duplicated_numbers_returns_false() {
    BoardChunk chunk = new BoardChunk(new Integer[]{1, 2});

    assertThat(chunk.hasDuplicatedNumber()).isFalse();
  }

  @Test
  void when_board_has_zero_should_be_invalid() {
    BoardChunk chunk = new BoardChunk(new Integer[]{HOLE, 2});

    assertThat(chunk.hasAHole()).isTrue();
  }
}