package by.gstu.ip.mogyjib.utils;


import java.io.*;

public class FileHandler {

    public static String read(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String expression;
            String res = "";
            while ((expression = br.readLine()) != null) {
                res += expression + "\n";
            }
            return res;
        }
    }

    public static void write(String fileName, String text) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            bw.write(text);
        }
    }
}
