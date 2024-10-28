package Task;

import java.io.*;
import java.util.Arrays;

public class Yan5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int amount = Integer.parseInt(reader.readLine());

        int[][] blocks = new int[amount][2];

        for(int i = 0; i < amount; i++){
            blocks[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        blocks = Arrays.stream(blocks)
                .sorted((x,y) ->{
                    if (x[0] != y[0]) {
                        return Integer.compare(y[0], x[0]);
                    }
                    return Integer.compare(y[1], x[1]);
                }).toArray(int[][]::new);

//        for (int[] block: blocks){
//            System.out.print(block[0]);
//            System.out.println(block[1]);
//        }
        int totalHeight = 0, lastWidth = 0;
        for (int i = 0; i < blocks.length; i++){
            if (i == 0) {
                totalHeight += blocks[i][1];
                lastWidth = blocks[i][0];
            }
            else {
                if (lastWidth > blocks[i][0]) {
                    lastWidth = blocks[i][0];
                    totalHeight += blocks[i][1];
                }
            }
        reader.close();
        writer.close();
}
}}


