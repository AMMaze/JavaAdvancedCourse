package Lesson_8;

import java.util.Arrays;

public class MatrixSnake {
    static enum Direction{
        RIGHT,
        DOWN,
        LEFT,
        UP {
            @Override
            public Direction next() {
                return RIGHT;
            }
        };


        public Direction next() {
            return values()[ordinal() + 1];
        }
    }

    static class Pos {
        int row = 0, col = 0;

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public void inc(Direction direction) {
            switch (direction) {
                case UP:
                    row++;
                    break;
                case DOWN:
                    row--;
                    break;
                case RIGHT:
                    col++;
                    break;
                case LEFT:
                    col--;
                    break;
            }
        }

        public void dec(Direction direction) {
            switch (direction) {
                case UP:
                    row--;
                    break;
                case DOWN:
                    row++;
                    break;
                case RIGHT:
                    col--;
                    break;
                case LEFT:
                    col++;
                    break;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pos))
                return false;
            Pos pos = (Pos) obj;
            return row == pos.getRow() && col == pos.getCol();
        }
    }

    public static int[][] filledMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        Pos pos = new Pos();
        Direction direction = Direction.RIGHT;
        int value = 1;
        while (value <= rows * columns) {
            while (pos.getRow() >= 0 && pos.getRow() < rows && pos.getCol() >= 0 && pos.getCol() < columns) {
                if (matrix[pos.getRow()][pos.getCol()] != 0)
                    break;
                matrix[pos.getRow()][pos.getCol()] = value++;
                pos.inc(direction);
            }
            pos.dec(direction);
            direction = direction.next();
            pos.inc(direction);
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }

    public static void main (String[] args) {
        printMatrix(filledMatrix(4, 6));
    }

}
