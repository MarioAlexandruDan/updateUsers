package ro.internship.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class UserFileWritter {

  private static File jsonFile = new File("./../UsersDB.json");

  public static void writeToJSON(String textToWrite) throws FileNotFoundException {

    // actually printing to the file;
    PrintWriter pw = new PrintWriter(jsonFile);
    pw.write(textToWrite);

    pw.flush();
    pw.close();
  }
}
