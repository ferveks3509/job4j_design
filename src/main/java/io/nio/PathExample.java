package io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

public class PathExample {
    public static void main(String[] args) throws IOException {
        //Path file = Path.of("data/test.txt");
        //Files.createFile(file);
        //Files.move(file, Path.of("src/main/java/io/nio/test.txt"));
        //Path dir = Path.of("E:\\projects");
        //DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
        //stream.forEach(System.out::println);
        Path file = Path.of("data/attribute.txt");
        Files.createFile(file);
        BasicFileAttributes attributes = Files.readAttributes(file, BasicFileAttributes.class);
        System.out.println("Это обычный файл? " + attributes.isRegularFile());
        System.out.println("Это директория? " + attributes.isDirectory());
        System.out.println("Это символическая ссылка? " + attributes.isSymbolicLink());
        System.out.println("Это не файл, директория или символическая ссылка? " + attributes.isOther());
        System.out.println("Дата создания файла: " + attributes.creationTime());
        System.out.println("Размер файла: " + attributes.size());
        System.out.println("Время последнего доступа: " + attributes.lastAccessTime());
        System.out.println("Время последнего изменения: " + attributes.lastModifiedTime());
    }
}
