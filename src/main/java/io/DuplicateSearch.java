package io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;

public class DuplicateSearch {
    public static void search(String file) throws Exception {
        DuplicateVisitor duplicateVisitor = new DuplicateVisitor();
        Files.walkFileTree(Path.of(file), duplicateVisitor);
        for (FileProperty el : duplicateVisitor.get()) {
            System.out.println(el.getName());
        }
    }
}
