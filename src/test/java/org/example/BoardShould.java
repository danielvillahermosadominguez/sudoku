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

  @Test
  void square_return_one_element_when_board_has_one_dimension() {
    Board board = Board.of(new Integer[][]{{1}});
    BoardChunk expected = BoardChunk.of(new Integer[]{1});

    List<BoardChunk> squares = board.squares();

    assertThat(squares)
            .containsExactly(expected);
  }

  @Test
  void return_squares_when_board_has_four_dimension() {
    Board board = Board.of(new Integer[][]{
            {1, 2,  3,  4},
            {5, 6,  7,  8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    });

    BoardChunk firstSquare = BoardChunk.of(new Integer[]{1, 2,5,6});
    BoardChunk secondSquare = BoardChunk.of(new Integer[]{3,4,7, 8});
    BoardChunk thirdSquare = BoardChunk.of(new Integer[]{9,10,13, 14});
    BoardChunk fourthSquare = BoardChunk.of(new Integer[]{11,12,15, 16});

    List<BoardChunk> squares = board.squares();

    assertThat(squares)
            .containsExactly(firstSquare, secondSquare,thirdSquare,fourthSquare);
  }

  @Test
  void return_squares_when_board_has_nine_dimension() {
    Board board = Board.of(new Integer[][]{
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    });

    BoardChunk firstSquare = BoardChunk.of(new Integer[]{5, 3, 4,6, 7, 2,1, 9, 8});

    List<BoardChunk> squares = board.squares();

    assertThat(squares)
            .contains(firstSquare);
  }
}
