package br.com.union;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("file.txt"));
            String line;
            int p, q;
            String[] expected;

            UnionFinder uf = new UnionFinderWeighted(
                    Integer.parseInt(reader.readLine())
            );

            line = reader.readLine();
            while (line != null) {
                // read next line
                expected = line.split(" ");
                p = Integer.parseInt(expected[0]);
                q = Integer.parseInt(expected[1]);
                if (!uf.connected(p, q)) {
                    uf.union(p, q);
                }
                line = reader.readLine();
            }
            reader.close();

            uf.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
