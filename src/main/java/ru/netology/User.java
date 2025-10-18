package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private List <String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public static void showOperations() {
        System.out.println("Выберите операцию: \n" +
                "\n"+
        "0. Выход из программы \n" +
        "1. Добавить дело \n" +
        "2. Показать дела \n" +
        "3. Удалить дело по номеру \n" +
        "4. Удалить дело по названию" );
        System.out.println();
    }

    public void switchOperation(int operation,Scanner sc) {
        switch (operation) {
            case 1:
                addDeal(sc);
                break;
            case 2:
                showDeals();
                break;
            case 3:
                removeDealByNumber(sc);
                break;
            case 4:
                removeDealByName(sc);
                break;
            default:
                System.out.println("Такой операции не существует. Пожалуйста корректно введите номер операции от " +
                        "\"0\" до \"4\" ");
                break;
        }
    }

    public void addDeal(Scanner sc) {
        System.out.println("Ваш выбор 1");
        System.out.println();
        System.out.print("Введите название задачи : ");
        String task = sc.nextLine();
        if(task.trim().isEmpty()){
            System.out.println("Название задачи не может быть пустым. Повторите ввод");
            return;
        }
        System.out.println(task);
        list.add(task);
        System.out.println("Добавлено!");
        showDeals();
    }

    public void showDeals() {
        System.out.println("Ваш список дел: ");
        System.out.println();
        for(int i=0; i<list.size(); i++) {
            System.out.println(i+1 + ". " + list.get(i));
        }
    }

    public void removeDealByNumber(Scanner sc) {
        System.out.print("Введите номер для удаления : ");
        String s = sc.nextLine();
        if(s.trim().isEmpty()){
            System.out.println("Номер не может быть пустым, введите номер для удаления");
            return;
        }
        int number = 0 ;
        try{
            number = Integer.parseInt(s);
        }catch(NumberFormatException e){
            System.out.println("Введите корректное число");
        }
        if (number < 0 && number > list.size() - 1){
            System.out.println("Такого номера задачи не существует");
            return;
        }
        list.remove(number - 1);
        System.out.println("Удалено!");
        showDeals();
    }

    public void removeDealByName(Scanner sc) {
        System.out.print("Введите задачу для удаления : ");
        String task = sc.nextLine();
        if(task.trim().isEmpty()){
            System.out.println("Имя задачи не может быть пустым");
            return;
        }
        System.out.println(task);
        boolean removed = list.removeIf(s -> s.equalsIgnoreCase(task));
        if(removed){
        System.out.println("Удалено!");
        }else {
            System.out.println("Задача не найдена");
        }
        showDeals();
    }
}
