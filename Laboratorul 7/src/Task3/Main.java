package Task3;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            String fileName = "src/Task3/fisier_" + i + ".txt";
            writeFile(fileName, i);
        }
    }

    public static void writeFile(String fileName, int index) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            ///data și ora curentă
            LocalDateTime currentTime = LocalDateTime.now();
            String formattedDateTime = currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            ///scrierea in fisier
            fileWriter.write("Index: " + index + "\n");
            fileWriter.write("Data și ora: " + formattedDateTime + "\n");

            System.out.println("Fișierul '" + fileName + "' a fost creat cu succes.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
