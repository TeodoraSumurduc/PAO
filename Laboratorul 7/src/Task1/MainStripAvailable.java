package Task1;

import java.io.*;

public class MainStripAvailable {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src/Task1/task1.txt");
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader reader = new BufferedReader(isr)) {
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