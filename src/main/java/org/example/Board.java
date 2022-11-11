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
    if (numbers.length == 1) {
      return rows();
    }
    List<BoardChunk> result = new ArrayList<>();
    int limit = (int) Math.sqrt(numbers.length);
    for (int square = 0; square < numbers.length; square++) {
      //0, 1 -> 0
      //2, 3 - 2
      if (square == 0 || square == 1) {
        List<Integer> boardChunkContent = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
          for (int j = 0 + (limit * square); j < limit + (limit * square); j++) {
            boardChunkContent.add(numbers[i][j]);
          }
        }
        result.add(BoardChunk.of(boardChunkContent.toArray(new Integer[boardChunkContent.size()])));
      }
      if (square == 2) {
        List<Integer> boardChunkContent = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
          for (int j = 0; j < limit; j++) {
            boardChunkContent.add(numbers[i][j]);
          }
        }
        result.add(BoardChunk.of(boardChunkContent.toArray(new Integer[boardChunkContent.size()])));
        //result.add(BoardChunk.of(new Integer[]{numbers[2][0], numbers[2][1], numbers[3][0], numbers[3][1]}));
      }
      if (square == 3) {
        result.add(BoardChunk.of(new Integer[]{numbers[2][2], numbers[2][3], numbers[3][2], numbers[3][3]}));
      }
    }

      /* result.add(BoardChunk.of(new Integer[] {numbers[0][0], numbers[0][1], numbers[1][0], numbers[1][1]}));
    result.add(BoardChunk.of(new Integer[] {numbers[0][2], numbers[0][3], numbers[1][2], numbers[1][3]}));
    result.add(BoardChunk.of(new Integer[] {numbers[2][0], numbers[2][1], numbers[3][0], numbers[3][1]}));
    result.add(BoardChunk.of(new Integer[] {numbers[2][2], numbers[2][3], numbers[3][2], numbers[3][3]}));*/

    /*
    List<BoardChunk> result = new ArrayList<>();
    int limit = (int) Math.sqrt(numbers.length);
    for(int square = 0;square< numbers.length;square++) {
      List<Integer> boardChunkContent = new ArrayList<>();
      int init = square* limit;
      int end = init + limit;
      for (int col =init; col < end; col++) {
        for (int row = 0; row < limit; col++) {
          boardChunkContent.add(numbers[row + square][col + (square % limit)]);
        }
      }
      result.add(BoardChunk.of(boardChunkContent.toArray(new Integer[boardChunkContent.size()])));
    }
     */


  /*  int limit = (int) Math.sqrt(numbers.length);
    for(int square = 0;square< numbers.length;square++) {
      List<Integer> boardChunkContent = new ArrayList<>();

      for (int row = 0; row < limit; row++) {
        for (int col = 0; col < limit; col++) {
          boardChunkContent.add(numbers[row + square][col + (square % limit)]);
        }
      }
      result.add(BoardChunk.of(boardChunkContent.toArray(new Integer[boardChunkContent.size()])));
    }*/
   /* result.add(BoardChunk.of(new Integer[] {numbers[0][0], numbers[0][1], numbers[1][0], numbers[1][1]}));
    result.add(BoardChunk.of(new Integer[] {numbers[0][2], numbers[0][3], numbers[1][2], numbers[1][3]}));
    result.add(BoardChunk.of(new Integer[] {numbers[2][0], numbers[2][1], numbers[3][0], numbers[3][1]}));
    result.add(BoardChunk.of(new Integer[] {numbers[2][2], numbers[2][3], numbers[3][2], numbers[3][3]}));*/
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
