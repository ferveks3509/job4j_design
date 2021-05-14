package io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import test.Analize;

import java.io.*;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void unavailable() throws IOException {
        File source = folder.newFile("logServer.txt");
        File target = folder.newFile("unavailable.csv");
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(source)))) {
            out.write("400 9:10:01" + System.lineSeparator()
                    + "200 9:11:00" + System.lineSeparator()
                    + "300 9:12:02" + System.lineSeparator()
                    + "500 9:13:09" + System.lineSeparator()
                    + "200 9:14:00");
        }
        Analizy analizy = new Analizy();
        List<String> rsl = analizy.unavailable(source.getAbsolutePath());
        analizy.save(rsl, target.getAbsolutePath());
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(stringBuilder::append);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(stringBuilder.toString(), is("9:10:01;9:11:009:13:09;9:14:00"));
    }
}