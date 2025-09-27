package com.virgille.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InputParser {
    public static List<String> readLines(String path) throws IOException {
        return Files.readAllLines(Path.of(path));
    }
}
