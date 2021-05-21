package io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class SearchFiles extends SimpleFileVisitor {
    private Predicate<Path> pred;
    private List<Path> rsl = new ArrayList<>();

    public SearchFiles(Predicate<Path> predicate) {
        this.pred = predicate;
    }

    public List<Path> getPath() {
        return rsl;
    }
    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        if (pred.test((Path) file)) {
            rsl.add((Path) file);
        }
        return FileVisitResult.CONTINUE;
    }
}

