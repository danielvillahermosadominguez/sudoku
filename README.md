https://www.codurance.com/katalyst/sudoku-kata

- TDD clasico con inside-out
- Practicar Diseño OOP


- siguientes puntos:
  - Parametrizar test de columnas de Board
- Continuar con columnas y luego pasar rows...etc

Ejemplo:
@ParameterizedTest
@MethodSource("provideStringsForIsBlank")
public void put_the_ant_in_the_middle_of_the_board(int size, String expectedBoardStatus) throws NotOddSquaresNumber, TooShortSequence, InvalidCharacter {
Board board = new Board(size);


...

private static Stream<Arguments> provideStringsForExecute() throws NotOddSquaresNumber, TooShortSequence, InvalidCharacter {
return Stream.of(
Arguments.of(new Board(3),
new Sequence("RL"),
".>.\n" +
".*.\n" +
"...\n"),
Arguments.of(new Board(3),
new Sequence("LR"),
".<.\n" +
".*.\n" +
"...\n")
);
}
