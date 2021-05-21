package io;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static List<Path> search(Path root, Predicate<Path> pathPredicate) throws IOException {
        SearchFiles searchFiles = new SearchFiles(pathPredicate);
        Files.walkFileTree(root, searchFiles);
        return searchFiles.getPath();
    }
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        search(path, path1 -> path.toFile().getName().endsWith("js")).forEach(System.out::println);
    }
}
