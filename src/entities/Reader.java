package entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    String userHome = System.getProperty("user.home");
    String path = "/home/" + userHome + "/out/summary.csv";
    Scanner sc = new Scanner(System.in);

    public Reader() {
        List<Product> list = new ArrayList<>();

        System.out.println("Enter file path: ");
        String sourceFileStr = sc.nextLine();
        File sourceFile = new File(sourceFileStr);

        String sourceFolderStr = sourceFile.getParent();

        boolean success = new File(sourceFolderStr + "/out").mkdir();

        String targetFileStr = sourceFolderStr + "/out/summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

            String itemCsv = br.readLine();
            while (itemCsv != null) {

                String[] fields = itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                list.add(new Product(name, price, quantity));

                itemCsv = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

                for (Product item : list) {
                    bw.write(item.getName() + "," + String.format("%.2f", item.total()));
                    bw.newLine();
                }

                System.out.println(targetFileStr + "Created!");

            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error reading file " + e.getMessage());
        }

        sc.close();
    }

}
