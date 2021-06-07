package io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateVisitor extends SimpleFileVisitor<Path> {
    private final Set<FileProperty> files = new HashSet<>();
    private final List<FileProperty> duplicate = new ArrayList<>();

    public List<FileProperty> get() {
        return duplicate;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile()) {
            FileProperty fileProperty = new FileProperty(attrs.size(), file.getFileName().toString());
            boolean add = files.add(fileProperty);
            if (!add) {
                duplicate.add(fileProperty);
            }
        }
        return FileVisitResult.CONTINUE;
    }
}
