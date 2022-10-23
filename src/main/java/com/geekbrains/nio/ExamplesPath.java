package com.geekbrains.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class ExamplesPath {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("serverFiles", "test.txt");
        byte[] bytes = Files.readAllBytes(path);
        System.out.println(new String(bytes));

        Path copy = Paths.get("serverFiles")
                .resolve("copy_test.txt");

        Files.copy(path, copy, StandardCopyOption.REPLACE_EXISTING);

        Files.walk(Paths.get(""))
                .forEach(System.out::println);
    }
}
