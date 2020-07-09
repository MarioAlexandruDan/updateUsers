package ro.internship.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileProcessor {
  private static File jsonFile = new File("./../UsersDB.json");

  public static void writeStringToFile(String textToWrite) {

    // actually printing to the file;
    PrintWriter pw;
    try {

      pw = new PrintWriter(jsonFile);
      pw.write(textToWrite);

      pw.flush();
      pw.close();

    } catch (FileNotFoundException e) {

      System.out.println("PROBLEM WITH FILE");
      e.printStackTrace();
    }
  }

  public static String readStringFromFIle() {

    StringBuilder contentBuilder = new StringBuilder();

    try (Stream<String> stream =
        Files.lines(Paths.get("./../UsersDB.json"), StandardCharsets.UTF_8)) {
      stream.forEach(s -> contentBuilder.append(s).append("\n"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return contentBuilder.toString();
  }
}
