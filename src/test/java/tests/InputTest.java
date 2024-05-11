package tests;

import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter The First Number");
        int a= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter The Second Number");
        int b= scanner.nextInt();
        scanner.nextLine();
        add(a,b);


    }
    public static void add(int x, int y) {
        System.out.println("Sum Value: "+(x+y));
        }
}
