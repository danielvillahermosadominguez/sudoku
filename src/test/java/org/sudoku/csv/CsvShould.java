package org.sudoku.csv;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.sudoku.csv.Csv.HOLE;

public class CsvShould {
  @Test
  void read_lines_without_holes() throws IOException, CsvException {
    String source = """
            1,2,3,4
            2,1,4,3
            3,4,1,2
            4,3,2,1""";

    Integer[][] expectedOutput = new Integer[][]{
            {1, 2, 3, 4},
            {2, 1, 4, 3},
            {3, 4, 1, 2}, {4, 3, 2, 1}};

    InputStream input = new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8));
    Csv csv = new Csv();
    Integer[][] numbers = csv.read(input);
    input.close();

    assertThat(numbers).isEqualTo(expectedOutput);
  }

  @Test
  void read_lines_with_blank_holes_and_empty_holes() throws IOException, CsvException {
    String source = """
            5,3, , ,7, , , , , 
            6, , ,1,9,5, , , , 
             ,9,8, , , , ,6, , 
            8, , , ,6, , , ,3, 
            4, , ,8,7,3, , ,1, 
            7, , , ,2, , , ,6, 
             ,6, , , , ,2,8, , 
             , , ,4,1,9, , ,5, 
             ,1, , ,8, , ,7,9, """;

    Integer[][] expectedOutput = new Integer[][]{
            {5, 3, HOLE, HOLE, 7, HOLE, HOLE, HOLE, HOLE},
            {6, HOLE, HOLE, 1, 9, 5, HOLE, HOLE, HOLE},
            {HOLE, 9, 8, HOLE, HOLE, HOLE, HOLE, 6, HOLE},
            {8, HOLE, HOLE, HOLE, 6, HOLE, HOLE, HOLE, 3},
            {4, HOLE, HOLE, 8, 7, 3, HOLE, HOLE, 1},
            {7, HOLE, HOLE, HOLE, 2, HOLE, HOLE, HOLE, 6},
            {HOLE, 6, HOLE, HOLE, HOLE, HOLE, 2, 8, HOLE},
            {HOLE, HOLE, HOLE, 4, 1, 9, HOLE, HOLE, 5},
            {HOLE, 1, HOLE, HOLE, 8, HOLE, HOLE, 7, 9}
    };

    InputStream input = new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8));
    Csv csv = new Csv();
    Integer[][] numbers = csv.read(input);
    input.close();

    assertThat(numbers).isEqualTo(expectedOutput);
  }
}
