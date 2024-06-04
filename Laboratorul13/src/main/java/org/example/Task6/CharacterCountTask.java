package org.example.Task6;

import java.util.concurrent.Callable;

class CharacterCountTask implements Callable<Integer> {
    private final String line;
    private final char characterToCount;

    public CharacterCountTask(String line, char characterToCount) {
        this.line = line;
        this.characterToCount = characterToCount;
    }

    @Override
    public Integer call() {
        int count = 0;
        for (char c : line.toCharArray()) {
            if (c == characterToCount) {
                count++;
            }
        }
        return count;
    }
}
