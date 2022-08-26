package ua.com.javarush.darvin.module1;

import java.io.*;
import java.util.Scanner;

public class ReadAndWrite {

    public StringBuilder readFile(String path) {
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

    public boolean encode() {
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
            return false;
        }
    }

    public boolean decode() {
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
            return false;
        }
    }

    public boolean bruteForce() {
        BruteForce brute = new BruteForce();
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inputText.txt"))) {

            bufferedWriter.append(brute.bruteForce(line, 1));
            bufferedWriter.flush();
            return true;
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать текст " + exception);
            return false;
        }

    }

}
