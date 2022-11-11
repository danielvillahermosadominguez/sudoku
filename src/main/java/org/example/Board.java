package org.example;


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
    int limit = (int) Math.sqrt(numbers.length);
    for (int square = 0; square < numbers.length; square++) {
      List<Integer> boardChunkContent = new ArrayList<>();
      int initVer = ((square/limit)*limit);
      int endVer = limit + initVer;
      for (int i = initVer; i < endVer; i++) {
        int initHor = (square % limit)*limit;
        int endHor = limit + initHor;
        for (int j = initHor; j < endHor; j++) {
          boardChunkContent.add(numbers[i][j]);
        }
      }
      result.add(BoardChunk.of(boardChunkContent.toArray(new Integer[boardChunkContent.size()])));
    }
    return result;
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
