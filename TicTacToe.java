package ru.geekbrains.java_one.lesson_c.game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int winLineLength;    // количество символов в ряд, необходимых для выигрыша

    private static void initField() {
        fieldSizeY = 5;
        fieldSizeX = 5;
        winLineLength = 4;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите, пожалуйста, координаты X от 1 до 3 и Y от 1 до 3 через пробел:");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }

    /*//вытереть кровавые слёзы Ивана перекисью водорода
    private static boolean checkWin(char c) {
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
    } //*/


    private static boolean checkWinAnySquare(char c) {
        for (int y=0; y<fieldSizeY-winLineLength+1; y++) {
            for (int x=0; x<fieldSizeX-winLineLength+1; x++) {
                if (checkWin(c, x, y)) return true;
            }
        }
        return false;
    }

    private static boolean checkWin(char c, int offsetX, int offsetY) {
        if (checkDiagonalWin(c, offsetX, offsetY)) return true;
        boolean winX, winY;
        for (int y=offsetY; y < winLineLength+offsetY; y++) {
            winX = true;
            winY = true;
            for (int x=offsetX; x < winLineLength+offsetX; x++) {
                winX &= (field[y][x] == c);
                winY &= (field[x][y] == c);
            }
            if (winX || winY) return true;
        }

        return false;
    }

    private static boolean checkDiagonalWin(char c, int offsetX, int offsetY) {
        boolean winDiagR = true;
        boolean winDiagL = true;
        for (int x = 0; x < winLineLength; x++) {
                winDiagR = winDiagR & (field[x+offsetX][x+offsetY] == c);
                winDiagL = winDiagL & (field[winLineLength - 1 - x+offsetX][x+offsetY] == c);
            }
        return (winDiagR || winDiagL);
    }

    private static boolean isDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean wannaPlay = true;
        while (wannaPlay) {
            initField();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkWinAnySquare(DOT_HUMAN)) {
                    System.out.println("Вы выиграли!");
                    break;
                }
                if (isDraw()) {
                    System.out.println("Сгоняли вничью...");
                    break;
                }
                aiTurn();
                printField();
                if (checkWinAnySquare(DOT_AI)) {
                    System.out.println("Комп выиграл :-P");
                    break;
                }
                if (isDraw()) {
                    System.out.println("Сгоняли вничью...");
                    break;
                }
            }
            System.out.println("Ещё сыграем? (y/n)");
            String answer = SCANNER.next();
            //System.out.println("Вы ответили "+ answer);
            if (answer.equals("n")) wannaPlay = false;
        }
    }

    /*
    1. Полностью разобраться с кодом;
    2. Переделать проверку победы, чтобы она не была реализована
        просто набором условий.
    3. * Попробовать переписать логику проверки победы,
        чтобы она работала для поля 5х5 и количества фишек 4.
    4. *** Доработать искусственный интеллект, чтобы он мог
        блокировать ходы игрока, и пытаться выиграть сам.
    * */
}