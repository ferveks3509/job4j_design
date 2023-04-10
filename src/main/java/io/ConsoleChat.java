package io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;


public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private List<String> botWords;
    private List<String> log = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        this.botWords = readFileWords(botAnswers);
    }

    public static List<String> readFileWords(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                sb.append(line + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of(sb.toString().split(System.lineSeparator()));
    }

    public static void saveFile(String path, List<String> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), false))) {
            for (String line : list) {
                bw.write(line + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String takeWord() {
        Random random = new Random();
        int r = random.nextInt(botWords.size());
        return botWords.get(r);
    }


    public void run() {
        System.out.println("input Word: ");
        Scanner scanner = new Scanner(System.in);
        String input = null;
        boolean flag = false;
        while (!(input = scanner.nextLine()).equals(OUT)) {
            if (input.equals(STOP)) {
                flag = true;
            } else if (input.equals(CONTINUE)) {
                flag = false;
            }
            log.add("User: " + input);
            saveFile(path, log);
            if (!flag) {
                log.add("Bot:" + takeWord());
                System.out.println(takeWord());
            }
        }
        log.add("User: " + input);
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data.txt",
                "botWords.txt");
        cc.run();
    }
}
