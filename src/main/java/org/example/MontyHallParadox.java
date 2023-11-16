package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {
    public static void main(String[] args) {
        int totalGames = 1000;
        int wins = 0;
        int losses = 0;

        Random random = new Random();
        Map<Integer, String> results = new HashMap<>();

        for (int i = 0; i < totalGames; i++) {
            int carDoor = random.nextInt(3); // Дверь, за которой находится автомобиль
            int initialChoice = random.nextInt(3); // Исходный выбор участника

            // Ведущий открывает одну из дверей с козами
            int revealedDoor;
            do {
                revealedDoor = random.nextInt(3);
            } while (revealedDoor == carDoor || revealedDoor == initialChoice);

            // Участник делает финальный выбор
            int finalChoice;
            do {
                finalChoice = random.nextInt(3);
            } while (finalChoice == initialChoice || finalChoice == revealedDoor);

            // Проверяем результат
            if (finalChoice == carDoor) {
                wins++;
                results.put(i + 1, "Win");
            } else {
                losses++;
                results.put(i + 1, "Loss");
            }
        }

        // Выводим статистику по победам и поражениям
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Results: " + results);
    }
}
