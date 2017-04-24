package workTasks;

import java.util.Scanner;

//1c
public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");

        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Please enter an integer.");
        }

        int Num = scanner.nextInt();

        for (int i = 0; i < Num; i++) {
            if (i % 2 == 1)
                if (String.valueOf(i).charAt(String.valueOf(i).length() / 2) == '2')
                    System.out.println(i);

        }
    }
}
