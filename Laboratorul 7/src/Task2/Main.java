package Task2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (FileReader fis = new FileReader("src/Task2/task2.txt");
             BufferedReader reader = new BufferedReader(fis)) {
            reader.readLine(); ///ignor prima linie
            ///citesc a doua linie
            String secondLine = reader.readLine();
            if (secondLine != null) {
                System.out.println(secondLine);
            } else {
                System.out.println("Nu exista a doua linie in fisier.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}