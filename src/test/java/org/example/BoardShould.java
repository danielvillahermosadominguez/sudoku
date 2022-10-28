package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardShould {

  @Test
  void columns_return_one_element_when_board_has_one_dimension() {
    Board board = Board.of(new Integer[]{1});

    BoardChunk expected = BoardChunk.of(new Integer[]{1});
    assertTrue(board.columns().get(0).equals(expected));
  }
}
