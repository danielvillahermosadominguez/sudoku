package org.example;


import java.util.List;

public class Board {

  private final Integer[] numbers;

  private Board(Integer[] numbers) {
    this.numbers = numbers;
  }

  public static Board of(Integer[] numbers) {
    return new Board(numbers);
  }

  public List<BoardChunk> columns() {
    return List.of(BoardChunk.of(numbers));
  }

  public List<BoardChunk> rows() {
    throw new UnsupportedOperationException("Not Implemented!");
  }

  public List<BoardChunk> squares() {
    throw new UnsupportedOperationException("Not Implemented!");
  }

}
