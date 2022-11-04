package org.example;


import java.io.IOException;
import java.io.UncheckedIOException;
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
    throw new UnsupportedOperationException("Not Implemented!");
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
