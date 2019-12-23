package java1.lesson6;

import java.io.*;
import java.util.Scanner;

public class Lesson6 {

    private static void concatFiles(FileInputStream fis1,FileInputStream fis2,FileOutputStream fos) {
        try {
        Scanner sc1 = new Scanner(fis1);
        Scanner sc2 = new Scanner(fis2);
        PrintStream ps = new PrintStream(fos);
        while (sc1.hasNext()) {
            ps.println(sc1.nextLine());
        }
        PrintStream ps1 = new PrintStream(fos);
        while (sc2.hasNext()) {
            ps1.println(sc2.nextLine());

        }
        fos.close();
        fis1.close();
        fis2.close();
        } catch (FileNotFoundException e) {
             e.printStackTrace();
        } catch (IOException e) {
             System.out.println(e.getMessage());
        }
    }

    public static void main (String[] args) throws Exception {

          FileInputStream fis1 = new FileInputStream("C:/test/test1.txt");
          FileInputStream fis2 = new FileInputStream("C:/test/test2.txt");
          FileOutputStream fos = new FileOutputStream("C:/test/test.txt", true);

        concatFiles(fis1,fis2,fos);

    }

}
