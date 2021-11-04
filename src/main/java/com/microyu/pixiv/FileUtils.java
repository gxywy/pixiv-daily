package com.microyu.pixiv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FileUtils {

    private static Path readmePath = Paths.get("README.md");

    /**
     * 写入 README.md
     *
     * @param imgList
     * @throws IOException
     */
    public static void writeReadme(List<Image> imgList) throws IOException {
        if (!Files.exists(readmePath)) {
            Files.createFile(readmePath);
        }
        //List<String> allLines = Files.readAllLines(path);
        Files.write(readmePath, "## Pixiv Daily".getBytes());
        Files.write(readmePath, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
        Files.write(readmePath, ("Update: " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(), StandardOpenOption.APPEND);
        Files.write(readmePath, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
        Files.write(readmePath, "|      |      |      |".getBytes(), StandardOpenOption.APPEND);
        Files.write(readmePath, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
        //Files.write(readmePath, "| ---- | ---- | ---- |".getBytes(), StandardOpenOption.APPEND);
        Files.write(readmePath, "| :----: | :----: | :----: |".getBytes(), StandardOpenOption.APPEND);
        Files.write(readmePath, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
        int i = 1;
        for (Image images : imgList) {
            Files.write(readmePath, ("|" + images.toString()).getBytes(), StandardOpenOption.APPEND);
            if (i % 3 == 0) {
                Files.write(readmePath, "|".getBytes(), StandardOpenOption.APPEND);
                Files.write(readmePath, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
            }
            i++;
        }
        if (i % 3 != 1) {
            Files.write(readmePath, "|".getBytes(), StandardOpenOption.APPEND);
        }
    }

}
