package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class BoardShould {

  @Test
  void columns_return_one_element_when_board_has_one_dimension() {
    Board board = Board.of(new Integer[][]{{1}});
    BoardChunk expected = BoardChunk.of(new Integer[]{1});

    List<BoardChunk> columns = board.columns();

    assertThat(columns)
      .containsExactly(expected);
  }

  @Test
  void columns_return_two_columns_when_board_has_two_dimension() {
    Board board = Board.of(new Integer[][]{
      {1, 2},
      {3, 4}
    });
    BoardChunk firstColumn = BoardChunk.of(new Integer[]{1, 3});
    BoardChunk secondColumn = BoardChunk.of(new Integer[]{2, 4});

    List<BoardChunk> columns = board.columns();

    assertThat(columns)
      .containsExactly(firstColumn, secondColumn);
  }

  @Test
  void columns_return_three_columns_when_board_has_three_dimension() {
    Board board = Board.of(new Integer[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
      }
    );
    BoardChunk firstColumn = BoardChunk.of(new Integer[]{1, 4, 7});
    BoardChunk secondColumn = BoardChunk.of(new Integer[]{2, 5, 8});
    BoardChunk thirdColumn = BoardChunk.of(new Integer[]{3, 6, 9});

    List<BoardChunk> columns = board.columns();

    assertThat(columns)
      .containsExactly(firstColumn, secondColumn, thirdColumn);
  }

  @Test
  void boards_should_throw_error_on_non_square_matrix() {
    assertThatExceptionOfType(InvalidBoardException.class)
      .isThrownBy(() ->
        Board.of(new Integer[][]{
          {1, 2},
          {4, 5, 6},
          {7, 8, 9},
        })
      );
  }

  @Test
  void rows_return_one_element_when_board_has_one_dimension() {
    Board board = Board.of(new Integer[][]{{1}});
    BoardChunk expected = BoardChunk.of(new Integer[]{1});

    List<BoardChunk> rows = board.rows();

    assertThat(rows)
      .containsExactly(expected);
  }

  @Test
  void rows_return_two_rows_when_board_has_two_dimension() {
    Board board = Board.of(new Integer[][]{
      {1, 2},
      {3, 4}
    });
    BoardChunk firstRow = BoardChunk.of(new Integer[]{1, 2});
    BoardChunk secondRow = BoardChunk.of(new Integer[]{3, 4});

    List<BoardChunk> rows = board.rows();

    assertThat(rows)
      .containsExactly(firstRow, secondRow);
  }

  @Test
  void rows_return_three_rows_when_board_has_three_dimension() {
    Board board = Board.of(new Integer[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
      }
    );
    BoardChunk firstRow = BoardChunk.of(new Integer[]{1, 2, 3});
    BoardChunk secondRow = BoardChunk.of(new Integer[]{4, 5, 6});
    BoardChunk thirdRow = BoardChunk.of(new Integer[]{7, 8, 9});

    List<BoardChunk> rows = board.rows();

    assertThat(rows)
      .containsExactly(firstRow, secondRow, thirdRow);
  }

}
