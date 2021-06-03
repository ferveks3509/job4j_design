package io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class DuplicateVisitor extends SimpleFileVisitor<Path> {
    private final List<Path> data = new ArrayList<>();

    public List<Path> get() {
        return data;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        data.add((Path) file);
        return FileVisitResult.CONTINUE;
    }
}
