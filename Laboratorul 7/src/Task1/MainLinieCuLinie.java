package Task1;

import java.io.*;

public class MainLinieCuLinie {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src/Task1/task1.txt");
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader reader = new BufferedReader(isr)) {
            ///ignor prima linie
            reader.readLine();
            ///citesc si afisez a doua linie
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}