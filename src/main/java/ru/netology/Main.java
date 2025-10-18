package ru.netology;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();

        while (true){
            User.showOperations();

            String input = sc.nextLine();
            if(input.trim().isEmpty()){
                System.out.println("Введите номер операции");
                continue;
            }

            int operation;
            try {
                operation = Integer.parseInt(input);
            }catch (NumberFormatException е){
                System.out.println("Не верный формат ввода, введите число от 0 до 4 ");
                continue;
            }
            if(operation == 0){
                break;
            }

            user.switchOperation(operation,sc);
        }
        sc.close();
        System.out.println("Работа с программой закончена");

    }
}