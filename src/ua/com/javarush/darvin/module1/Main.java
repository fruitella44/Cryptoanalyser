package ua.com.javarush.darvin.module1;


import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static boolean start = true;
    private static final String ALPHABET  = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,«»\"\\:!? ";

    private static final String RUN = "Запуск программы!";
    private static final String CLOSE = "Завершение программы!";
    private static final String OPTIONS = "Выберите действие:\n";
    private static final String OPTIONS_ONE = "1 - шифровка текста\n";
    private static final String OPTIONS_TWO = "2 - расшифровка текста\n";
    private static final String OPTIONS_THREE = "3 - расшифровка с помощью brute force\n";
    private static final String EXIT = "0 - Выход";
    private static final String ERROR = "Неверная команда!";
    private static final String STRING_SPACE = "___________________________\n";

    public static void main(String[] args) {
            Main main = new Main();
            main.inputCommand();
    }

    private boolean inputCommand() {
        if (start) {
            System.out.println(RUN);
            Scanner command = new Scanner(System.in);

            while (true) {
                System.out.println(STRING_SPACE + OPTIONS + OPTIONS_ONE + OPTIONS_TWO + OPTIONS_THREE + EXIT);

                try {
                    int input = Integer.parseInt(command.nextLine());

                    if (input == 1) {
                        System.out.println("Укажите путь к файлу:");
                        scannerEncode();
                    } else if (input == 2) {
                        System.out.println("Укажите путь к файлу:");
                        scannerDecode();
                    } else if (input == 3) {
                        System.out.println("Укажите путь к файлу:");
                        scannerBruteForce();
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

    private static boolean scannerEncode() {
        Encode encrypt = new Encode();
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("outputText.txt"))) {

            System.out.println("Введите номер ключа:");
            bufferedWriter.append(encrypt.encode(line, console.nextInt()));
            bufferedWriter.flush();
            return true;
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать текст " + exception);
        }

       return false;
    }

    private static boolean scannerDecode() {
        Decode decrypt = new Decode();
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inputText.txt"))) {

            System.out.println("Введите номер ключа:");
            bufferedWriter.append(decrypt.decode(line, console.nextInt()));
            bufferedWriter.flush();
            return true;
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать текст " + exception);
        }

        return false;
    }

    private static boolean scannerBruteForce() {
        BruteForce brute = new BruteForce();
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inputText.txt"))) {

            bufferedWriter.append(brute.bruteForce(line, 1));
            bufferedWriter.flush();
            return true;
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать текст " + exception);
        }

        return false;
    }

    public static StringBuilder readFile(String path) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            while (reader.ready()) {
                builder.append(reader.readLine());
                builder.append("\n");
            }

            builder.deleteCharAt(builder.length() - 1);
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать файл " + exception);
            return null;
        }
        return builder;
    }
}

