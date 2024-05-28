package org.example.Task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.nio.file.StandardOpenOption.CREATE;

public class Git {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GitInit <directory>");
            System.exit(1);
        }

        String directory = args[0];

        File gitDir = new File(directory, ".git");
        if (!gitDir.mkdir()) {
            System.out.println("Error creating .git directory");
            System.exit(1);
        }

        File objectsDir = new File(gitDir, "objects");
        if (!objectsDir.mkdir()) {
            System.out.println("Error creating objects directory");
            System.exit(1);
        }

        File refsDir = new File(gitDir, "refs");
        if (!refsDir.mkdir()) {
            System.out.println("Error creating refs directory");
            System.exit(1);
        }

        File headFile = new File(gitDir, "HEAD");
        try (java.io.FileWriter writer = new java.io.FileWriter(headFile)) {
            writer.write("ref: refs/head/main\n");
            writer.close();
        } catch (IOException e) {
            Logger.getLogger(Git.class.getName()).log(Level.SEVERE, null, e);
            System.exit(1);
        }
    }
}

