package org.sudoku.validation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

  private final Integer[][] numbers;

  private Board(Integer[][] numbers) {
    this.numbers = numbers;
  }

  public static Board of(Integer[][] numbers) throws InvalidBoardException {
    checkValidDimension(numbers);

    return new Board(numbers);
  }


  public List<BoardChunk> columns() {
    Integer[][] transposedNumbers = transpose();

    return Arrays.stream(transposedNumbers)
      .map(BoardChunk::of)
      .collect(Collectors.toList());
  }

  public List<BoardChunk> rows() {
    return Arrays.stream(numbers)
      .map(BoardChunk::of)
      .collect(Collectors.toList());
  }

  public List<BoardChunk> squares() {
    List<BoardChunk> result = new ArrayList<>();

    for (int square = 0; square < numbers.length; square++) {
      List<Integer> boardChunkContent = square(square);
      result.add(BoardChunk.of(boardChunkContent.toArray(new Integer[]{})));
    }
    return result;
  }

  private List<Integer> square(int square) {
    List<Integer> boardChunkContent = new ArrayList<>();

    int squareVerticalPosition = square / dimension();

    for (int row = startIndex(squareVerticalPosition); row < endIndex(squareVerticalPosition); row++) {
      boardChunkContent.addAll(horizontalRows(square, numbers[row]));
    }
    return boardChunkContent;
  }

  private List<Integer> horizontalRows(int square, Integer[] verticalRows) {
    List<Integer> result = new ArrayList<>();
    int squareHorizontalPosition = square % dimension();

    for (int column = startIndex(squareHorizontalPosition); column < endIndex(squareHorizontalPosition); column++) {
      result.add(verticalRows[column]);
    }
    return result;
  }

  private int startIndex(int index) {
    return index * dimension();
  }

  private int endIndex(int index) {
    return startIndex(index) + dimension();
  }

  private int dimension() {
    return (int) Math.sqrt(numbers.length);
  }

  private Integer[][] transpose() {
    Integer[][] result = new Integer[numbers.length][numbers.length];

    for (int row = 0; row < numbers.length; row++) {
      for (int column = 0; column < numbers[row].length; column++) {
        result[row][column] = numbers[column][row];
      }
    }

    return result;
  }


  private static void checkValidDimension(Integer[][] numbers) {
    if (Arrays.stream(numbers)
      .anyMatch(row -> row.length != numbers.length)) {
      throw new InvalidBoardException();
    }
  }


}
