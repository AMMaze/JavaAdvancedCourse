package Lesson_3.FilesIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            readSmallFile("src/test/aaa");

            concatFiles(new String[]{"src/test/aaa", "src/test/bbb"});

            readPages("src/test/ccc", 1800);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readSmallFile (String path) throws IOException {
        byte[] content = Files.readAllBytes(Paths.get(path));
        System.out.println(Arrays.toString(content));
    }

    public static void concatFiles (String[] paths) throws IOException {
        OutputStream out = new FileOutputStream("output");
        for (String str : paths) {
            out.write(Files.readAllBytes(Paths.get(str)));
        }
    }

    public static void readPages (String path, int pageSize) {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8)) {
            StringBuilder page = new StringBuilder(pageSize);
            for (int c; (c = in.read()) != -1; ) {
                page.append((char)c);
                if (page.length() == pageSize) {
                    System.out.println(page.toString());
                    page.setLength(0);
                }
            }
            if (page.length() != 0) {
                System.out.println(page.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
