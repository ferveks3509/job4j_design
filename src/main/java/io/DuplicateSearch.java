package io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;

public class DuplicateSearch {
    public static void search(String file) throws Exception {
        Path path = Paths.get(file);
        DuplicateVisitor duplicateVisitor = new DuplicateVisitor();
        Files.walkFileTree(path, duplicateVisitor);
        List<Path> rsl = duplicateVisitor.get();
        Comparator<Path> comparator = Comparator.comparing(Path::getFileName);
        rsl.sort(comparator);
        for (int i = 0; i < rsl.size() - 1; i++) {
            Path first = rsl.get(i);
            Path second = rsl.get(i + 1);
            if (first.equals(second) && first.toFile().length() == second.toFile().length()) {
                System.out.println(first.toAbsolutePath());
            }
        }
    }
}
