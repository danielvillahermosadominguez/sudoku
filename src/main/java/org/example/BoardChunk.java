package org.example;

import java.util.Arrays;

public class BoardChunk {

    private final Integer[] numbers;

    public BoardChunk(Integer[] numbers) {
        this.numbers = numbers;
    }

    public static BoardChunk of(Integer[] numbers) {
        return new BoardChunk(numbers);
    }

    public boolean hasDuplicatedNumber() {
        throw new UnsupportedOperationException();
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
