package org.sudoku;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;
import org.sudoku.csv.Csv;
import org.sudoku.validation.Board;
import org.sudoku.validation.SudokuValidator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTest {

  SudokuValidator validator = new SudokuValidator();

  @Test
  void incorrect_sudoku1_should_be_invalid() throws IOException, CsvException {
    String source = """
      5,3, , ,7, , , , , 
      6, , ,1,9,5, , , , 
       ,9,8, , , , ,6, , 
      8, , , ,6, , , ,3, 
      4, , ,8,7,3, , ,1, 
      7, , , ,2, , , ,6, 
       ,6, , , , ,2,8, , 
       , , ,4,1,9, , ,5, 
       ,1, , ,8, , ,7,9, 
      """;

    Integer[][] numbers = parseCsv(source);
    Board board = Board.of(numbers);
    assertThat(validator.isValid(board)).isFalse();
  }

  @Test
  void incorrect_sudoku2_should_be_invalid() throws IOException, CsvException {
    String source = """
      5,3,4,5,7,8,9,1,2,
      6,7,2,1,9,5,3,4,8,
      1,9,8,3,4,2,5,6,7,
      8,5,9,7,6,1,4,2,3,
      4,2,6,8,5,3,7,9,1,
      7,1,3,9,2,4,8,5,6,
      9,6,1,5,3,7,2,8,4,
      2,8,7,4,1,9,6,3,5,
      3,4,5,2,8,6,1,7,9,
      """;

    Integer[][] numbers = parseCsv(source);
    Board board = Board.of(numbers);
    assertThat(validator.isValid(board)).isFalse();
  }

  @Test
  void incorrect_sudoku3_should_be_valid() throws IOException, CsvException {
    String source = """
      4,5,3,8,2,6,1,9,7,
      8,9,2,5,7,1,6,3,4,
      1,6,7,4,9,3,5,2,8,
      7,1,4,9,5,2,8,6,3,
      5,8,6,1,3,7,2,4,9,
      3,2,9,6,8,4,7,5,1,
      9,3,5,2,1,8,4,7,6,
      6,7,1,3,4,5,9,8,2,
      2,4,8,7,6,9,3,1,5,
      """;

    Integer[][] numbers = parseCsv(source);
    Board board = Board.of(numbers);
    assertThat(validator.isValid(board)).isTrue();
  }

  @Test
  void incorrect_sudoku4_should_be_valid() throws IOException, CsvException {
    String source = """
      5,3,4,6,7,8,9,1,2,
      6,7,2,1,9,5,3,4,8,
      1,9,8,3,4,2,5,6,7,
      8,5,9,7,6,1,4,2,3,
      4,2,6,8,5,3,7,9,1,
      7,1,3,9,2,4,8,5,6,
      9,6,1,5,3,7,2,8,4,
      2,8,7,4,1,9,6,3,5,
      3,4,5,2,8,6,1,7,9,
      """;

    Integer[][] numbers = parseCsv(source);
    Board board = Board.of(numbers);
    assertThat(validator.isValid(board)).isTrue();
  }

  private Integer[][] parseCsv(String source) throws IOException, CsvException {
    Csv csv = new Csv();
    Integer[][] numbers;
    try (InputStream input = new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8))) {
      numbers = csv.read(input);
    }
    return numbers;
  }


}
