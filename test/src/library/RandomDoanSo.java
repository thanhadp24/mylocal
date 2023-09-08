package library;

import java.util.Random;
import java.util.Scanner;

public class RandomDoanSo {
    static Random rd = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            playRandom();
            System.out.println("Bạn có muốn chơi tiếp không? Nhập yes/no");

            String check = sc.nextLine();
            if (check.equals("no")) {
                return;
            }
        }

    }

    private static void playRandom() {
        int guess = rd.nextInt(101);
        int count = 0;
        System.out.print("Nhập vào số cần đoán (0-100): ");
        int ip;
        ip = sc.nextInt();
        sc.nextLine(); // Đọc ký tự xuống dòng sau khi đọc số nguyên
        while (count <= 7) {
            if (ip == guess) {
                System.out.println("Bạn đã đoán đúng, số đúng là: " + guess);
                break;
            } else if (ip < guess) {
                System.out.print("Mời bạn nhập lại, số cần đoán lớn hơn nữa: ");
                ip = sc.nextInt();
                sc.nextLine(); // Đọc ký tự xuống dòng sau khi đọc số nguyên
                count++;

            } else {
                System.out.print("Mời bạn nhập lại, số cần đoán nhỏ hơn nữa: ");
                ip = sc.nextInt();
                sc.nextLine(); // Đọc ký tự xuống dòng sau khi đọc số nguyên
                count++;
            }
            if (count == 7) {
                System.out.println("Bạn đã thua cuộc!");
                break;
            }
        }
    }
}
