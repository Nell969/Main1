package org.example;

public class Main {

    public static void main(String[] args) {

        // 1
        Button button = new Button();
        button.click();
        button.click();

        // 2
        Balance balance = new Balance();
        balance.addLeft(3);
        balance.addRight(3);
        balance.result();
        balance.addRight(2);
        balance.result();

        // 3
        Bell bell = new Bell();
        for (int i = 0; i < 4; i++) {
            bell.sound();
        }

        // 5
        Table table = new Table(2, 3);
        table.setValue(0, 0, 1);
        table.setValue(0, 1, 2);
        table.setValue(1, 0, 3);
        System.out.println(table);

    }
}

// 1
class Button {
    private int count;

    public Button() {
        this.count = 0;
    }

    public void click() {
        count++;
        System.out.println("Current clicks: " + count);
    }
}

//2
class Balance {
    private int left;
    private int right;

    public Balance() {
        this.left = 0;
        this.right = 0;
    }

    public void addLeft(int weight) {
        left += weight;
    }

    public void addRight(int weight) {
        right += weight;
    }

    public void result() {
        if (left == right) {
            System.out.print("= ");
        } else if (left > right) {
            System.out.println("L");
        } else {
            System.out.println("R");
        }
    }
}

// 3
class Bell {
    private boolean isDing;

    public Bell() {
        isDing = true;
    }

    public void sound() {
        if (isDing) {
            System.out.print("ding ");
        } else {
            System.out.print("dong ");
        }
        isDing = !isDing;
    }
}


// 5
class Table {
    private final int[][] data;
    private final int rows;
    private final int cols;

    public Table(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    public int getValue(int row, int col) {
        return data[row][col];
    }

    public void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : data) {
            for (int value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public double average() {
        int sum = 0;
        int count = 0;
        for (int[] row : data) {
            for (int value : row) {
                sum += value;
                count++;
            }
        }
        return (double) sum / count;
    }
}

