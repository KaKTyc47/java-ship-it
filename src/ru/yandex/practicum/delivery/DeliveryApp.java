package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> trackableParcels = new ArrayList<>();
    private static final ParcelBox<StandardParcel> standardBox = new ParcelBox<>(100.0);
    private static  final ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(50);
    private static  final ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(80);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    showBoxContents();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Отследить посылку");
        System.out.println("5 — Вывод содержимого коробки");
        System.out.println("0 — Завершить");
    }



    private static void addParcel() {

        System.out.println("Введите описание посылки!");
        String description = scanner.nextLine();
        System.out.println("Введите вес посылки");
        double weigh = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Введите адрес доставки");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Введите день отправки");
        int sendDay = scanner.nextInt();
        scanner.nextLine();
        System.out.println("выберете тип посылки:");
        System.out.println("1 — Обычная посылка");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся посылка");
        int typeParcel = scanner.nextInt();
        scanner.nextLine();
        if (typeParcel == 1) {
            StandardParcel parcel = new StandardParcel(description, weigh, deliveryAddress, sendDay);
            allParcels.add(parcel);
            System.out.println("Стандартная посылка добавлена!");
            standardBox.addParcel(parcel);
        } else if (typeParcel == 2) {
            FragileParcel parcel = new FragileParcel(description, weigh, deliveryAddress, sendDay);
            allParcels.add(parcel);
            trackableParcels.add(parcel);
            System.out.println("Хрупкая посылка добавлена!");
            fragileBox.addParcel(parcel);
        } else if (typeParcel == 3) {
            System.out.println("Введите срок годности посылки");
            int timeToLive = scanner.nextInt();
            scanner.nextLine();
            PerishableParcel parcel = new PerishableParcel(description, weigh, deliveryAddress, sendDay, timeToLive);
            allParcels.add(parcel);
            System.out.println("Скоропортящаяся посылка добавлена !");
            perishableBox.addParcel(parcel);
        } else {
            System.out.println("Ошибка! Введен не верный тип посылки!");
        }
    }

    private static void sendParcels() {

        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        double total = 0;
        for (Parcel parcel : allParcels) {
            total += parcel.calculateDeliveryCost();
        }
        System.out.println("Итого: " + total);
    }

    private static void reportStatus() {
        System.out.println("Введите новое местоположение посылки");
        String newLocation = scanner.nextLine();
        for (Trackable trackable : trackableParcels) {
            trackable.reportStatus(newLocation);
        }
    }

    private static void showBoxContents() {
        System.out.println("Тип коробки: 1 — стандарт, 2 — хрупкая, 3 — скоропортящаяся");
        int type = Integer.parseInt(scanner.nextLine());

        List<? extends Parcel> boxParcels = null;
        if (type == 1) {
            boxParcels = standardBox.getAllParcels();
        } else if (type == 2) {
            boxParcels = fragileBox.getAllParcels();
        } else if (type == 3) {
            boxParcels = perishableBox.getAllParcels();
        }

        if (boxParcels == null) {
            System.out.println("Неверный тип");
            return;
        }

        System.out.println("Содержимое коробки:");
        for (Parcel p : boxParcels) {
            System.out.println(p.description);
        }
    }

}

