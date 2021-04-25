package Lesson04;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    final char SIGN_EMPTY = '.';
    char[][] table;
    int Field_size = 5;
    int Dots_to_win = 4;
    Random random;
    Scanner scanner;

    public static void main(String[] args) {
        new TicTacToe().game();

    }
    TicTacToe() {
        random = new Random();
        scanner = new Scanner(System.in);
        table = new char[Field_size][Field_size];

    }
    void game() {
        initTable();
        while (true) {
            turnHuman();
            if (checkWin(SIGN_X)) {
                System.out.println("Победа");
                break;
            }
            if (isTableFull()) {
                System.out.println("Ничья");
                break;
            }
            turnAI();
            printTable();
            if (checkWin(SIGN_O)) {
                System.out.println("Компьютер победил");
                break;
            }
            if (isTableFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Конец игре");
        printTable();

    }

    void initTable() {
        for (int row = 0; row < Field_size; row++)
            for (int col = 0; col < Field_size; col++)
                table[row][col] = SIGN_EMPTY;
    }

    void printTable() {
        for (int row = 0; row < Field_size; row++) {
            for (int col = 0; col < Field_size; col++)
                System.out.print(table[row][col] + " ");
            System.out.println();
        }
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.printf("Enter X and Y (1..%d):\n", Field_size);
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_X;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= Field_size|| y >= Field_size)
            return false;
        return table[y][x] == SIGN_EMPTY;
    }

    void turnAI() {
        int x, y;
        do {
            x = random.nextInt(Field_size);
            y = random.nextInt(Field_size);
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_O;
    }

    boolean checkWin(char dot) {
        int hor, ver;
        int diagMain, diagRevers;
        for (int i = 0; i < Field_size; i++) {
            hor = 0;
            ver = 0;
            for (int j = 0; j < Field_size; j++) {
                if (table[i][j] == dot) {
                    hor++;
                } else if (table[i][j] != dot && hor < Dots_to_win) {
                    hor = 0;
                }
                if (table[i][j] == dot) {
                    ver++;
                } else if (table[i][j] != dot && ver < Dots_to_win) {
                    ver = 0;
                }
            }
            if (hor >= Dots_to_win || ver >= Dots_to_win) {
                System.out.println("Победа");
                return true;
            }
        }
        for (int j = 0; j < Field_size; j++) {
            diagMain = 0;
            for (int i = 0; i < Field_size; i++) {
                int k = j + i;
                if (k < Field_size) {
                    if (table[i][k] == dot) {                      // проверяем главную диагональ от центральной оси вправо на возможную победу
                        diagMain++;
                    } else if (table[i][k] != dot && diagMain < Dots_to_win) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= Dots_to_win) {
                    System.out.println("Победа");
                    return true;
                }
            }
        }
        for (int j = 1; j < Field_size; j++) {
            diagMain = 0;
            for (int i = 0; i < Field_size; i++) {
                int k = j + i;
                if (k < Field_size) {
                    if (table[k][i] == dot) {                      // проверяем главную диагональ от центральной оси вниз на возможную победу
                        diagMain++;
                    } else if (table[k][i] != dot && diagMain < Dots_to_win) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= Dots_to_win) {
                    System.out.println("Победа");
                    return true;
                }
            }
        }
        for (int j = 0; j < Field_size; j++) {
            diagRevers = 0;
            for (int i = 0; i < Field_size; i++) {
                int k = (Field_size - 1) - i;
                int l = j + i;
                if (k >= 0 && l < Field_size) {
                    if (table[l][k] == dot) {                     // проверяем побочную диагональ от центральной оси вниз на возможную победу
                        diagRevers++;
                    } else if (table[l][k] != dot && diagRevers < Dots_to_win) {
                        diagRevers = 0;
                    }
                }
                if (diagRevers >= Dots_to_win) {
                    System.out.println("Победа");
                    return true;
                }
            }
        }
        for (int j = 1; j < Field_size; j++) {
            diagRevers = 0;
            for (int i = 0; i < Field_size; i++) {
                int k = (Field_size - 1) - j - i;
                if (k >= 0) {
                    if (table[i][k] == dot) {     // проверяем побочную диагональ от центральной оси влево на возможную победу
                        diagRevers++;
                    } else if (table[i][k] != dot && diagRevers < Dots_to_win) {
                        diagRevers = 0;
                    }
                }
                if (diagRevers >= Dots_to_win) {
                    System.out.println("Победа");
                    return true;
                }
            }
        }
        return false;
     }

    boolean isTableFull() {
        for (int row = 0; row < Field_size; row++)
            for (int col = 0; col < Field_size; col++)
                if (table[row][col] == SIGN_EMPTY)
                    return false;
        return true;
    }

}
