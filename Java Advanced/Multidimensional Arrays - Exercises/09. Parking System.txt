import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkingSystem {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String[] size = read.readLine().split("\\s+");
        int r = Integer.parseInt(size[0]);
        int c = Integer.parseInt(size[1]);

        int[][] parking = new int[r][];

        String input;
        while (!"stop".equals(input=read.readLine())) {

            String[] data = input.split("\\s+");

            int carRow = Integer.parseInt(data[0]);
            int parkRow =Integer.parseInt(data[1]);
            int parkCol =Integer.parseInt(data[2]);

            if (parking[parkRow] == null){
                parking[parkRow] = new int[c];
            }

            if (GetNearestFreeCol(parking,parkRow,parkCol)==-1){
                System.out.println("Row "+parkRow+" full");
                continue;
            }

            if (parking[parkRow][parkCol] == 1){
                parkCol = GetNearestFreeCol(parking, parkRow, parkCol);
            }

            parking[parkRow][parkCol] = 1;

            int distance = Math.abs(carRow - parkRow) + parkCol + 1;
            System.out.println(distance);
        }
    }

    private static int GetNearestFreeCol(int[][] parking, int parkRow, int parkCol){

        for (int i = 1; i < parking[parkRow].length; i++){
            if (parkCol > i && parking[parkRow][parkCol - i] != 1){
                return parkCol - i;
            }
            if (parkCol + i < parking[parkRow].length && parking[parkRow][parkCol + i] != 1){
                return parkCol + i;
            }
        }
        return -1;
    }
}