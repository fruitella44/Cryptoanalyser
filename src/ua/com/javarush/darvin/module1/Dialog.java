package ua.com.javarush.darvin.module1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialog {
    private static boolean start = true;

    private static final String RUN = "Запуск программы!";
    private static final String CLOSE = "Завершение программы!";
    private static final String OPTIONS = "Выберите действие:\n";
    private static final String OPTIONS_ONE = "1 - шифровка текста\n";
    private static final String OPTIONS_TWO = "2 - расшифровка текста\n";
    private static final String OPTIONS_THREE = "3 - расшифровка с помощью brute force\n";
    private static final String EXIT = "0 - Выход";
    private static final String ERROR = "Неверная команда!";
    private static final String STRING_SPACE = "___________________________\n";

    public static boolean inputCommand() {
        ReadAndWrite write = new ReadAndWrite();

        if (start) {
            System.out.println(RUN);
            Scanner command = new Scanner(System.in);

            while (true) {
                System.out.println(STRING_SPACE + OPTIONS + OPTIONS_ONE + OPTIONS_TWO + OPTIONS_THREE + EXIT);

                try {
                    int input = Integer.parseInt(command.nextLine());

                    if (input == 1) {
                        System.out.println("Укажите путь к файлу:");
                        write.encode();
                    } else if (input == 2) {
                        System.out.println("Укажите путь к файлу:");
                        write.decode();
                    } else if (input == 3) {
                        System.out.println("Укажите путь к файлу:");
                        write.bruteForce();
                    } else if (input == 0) {
                        System.out.println(CLOSE);
                        break;
                    } else {
                        System.out.println(ERROR);
                    }

                } catch (InputMismatchException exception) {
                    System.out.println("Требуется ввести число! " + exception);
                }
            }
        }

        return start = false;
    }

}
