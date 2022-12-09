package org.sudoku.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.sudoku.validation.Board;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Csv {
  public Integer[][] read(InputStream input) throws IOException, CsvException {
    try (CSVReader csvReader = new CSVReader(new InputStreamReader(input))) {
      return readLines(csvReader);
    }
  }

  private Integer[][] readLines(CSVReader csvReader) throws IOException, CsvException {
    List<String[]> csvLinesAsString = csvReader.readAll();
    List<Integer[]> csvLinesAsInteger = listStringToListInteger(csvLinesAsString);
    return csvLinesAsInteger.toArray(new Integer[][]{});
  }

  private List<Integer[]> listStringToListInteger(List<String[]> csvLinesAsString) {
    return csvLinesAsString
      .stream()
      .map(this::stringArrayToIntegerArray)
            .collect(Collectors.toList());
  }

  private Integer[] stringArrayToIntegerArray(String[] arrString) {
    return Arrays.stream(arrString)
            .takeWhile(str -> !str.isEmpty())
            .map(this::parseInt)
            .collect(Collectors.toList())
            .toArray(new Integer[]{});
  }

  private Integer parseInt(String text) {
    if (text.isBlank()) {
      return Board.HOLE;
    }

    return Integer.parseInt(text);
  }
}
