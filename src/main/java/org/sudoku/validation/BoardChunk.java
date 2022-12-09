package org.sudoku.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.sudoku.validation.Board.HOLE;

public class BoardChunk {

  private final Integer[] numbers;

  public BoardChunk(Integer[] numbers) {
    this.numbers = numbers;
  }

  public static BoardChunk of(Integer[] numbers) {
    return new BoardChunk(numbers);
  }

  public boolean hasDuplicatedNumber() {
    Set<Integer> set = new HashSet<>(Arrays.asList(numbers));
    return numbers.length != set.size();
  }

  public boolean hasAHole() {
    return Arrays.asList(numbers).contains(HOLE);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BoardChunk that = (BoardChunk) o;
    return Arrays.equals(numbers, that.numbers);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(numbers);
  }

  @Override
  public String toString() {
    return "BoardChunk{" +
      "numbers=" + Arrays.toString(numbers) +
      '}';
  }


}
