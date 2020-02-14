import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheHeiganDance {

    private static int playerRow = 7;
    private static int playerCol = 7;

    public static void main(String[] args) throws IOException {

        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));

        int playerHitPoints = 18500;
        double heiganHitPoints = 3000000;

        double damage = Double.parseDouble(read.readLine());

        boolean shouldTakeDamage = false;

        String lastSpell = "";

        while (playerHitPoints > 0 && heiganHitPoints > 0) {
            heiganHitPoints -= damage;

            if (shouldTakeDamage) {
                playerHitPoints -= 3500;
                shouldTakeDamage = false;
            }

            if (playerHitPoints < 0 || heiganHitPoints < 0) {
                break;
            }

            String[] tokens = read.readLine().split("\\s+");

            String spell = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            boolean isHit = checkCell(row, col);

            if (isHit && heiganHitPoints > 0) {

                boolean hasMove = movePlayer(row, col);

                if (!hasMove) {
                    if (spell.equals("Cloud")) {
                        playerHitPoints -= 3500;
                        shouldTakeDamage = true;
                    } else { // Eruption
                        playerHitPoints -= 6000;
                    }

                    lastSpell = spell;
                }
            }
        }

        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : lastSpell;

        if (heiganHitPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHitPoints);
        }

        if (playerHitPoints <= 0) {
            System.out.printf("Player: Killed by %s%n", lastSpell);
        } else {
            System.out.printf("Player: %d%n", playerHitPoints);
        }

        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }

    public static boolean checkCell(int targetRow, int targetCol) {
        return playerRow >= targetRow - 1 && playerRow <= targetRow + 1 && playerCol >= targetCol - 1
                && playerCol <= targetCol + 1;
    }

    public static boolean movePlayer(int targetRow, int targetCol) {

        if (targetRow == playerRow && targetCol == playerCol) {
            return false;
        }

        boolean hasMoved = false;

        if (isInRange(playerRow - 1, playerCol) && canMove(targetRow, targetCol, playerRow - 1, playerCol)) {
            playerRow--;
            hasMoved = true;
        } else if (isInRange(playerRow, playerCol + 1) && canMove(targetRow, targetCol, playerRow, playerCol + 1)) {
            playerCol++;
            hasMoved = true;
        } else if (isInRange(playerRow + 1, playerCol) && canMove(targetRow, targetCol, playerRow + 1, playerCol)) {
            playerRow++;
            hasMoved = true;
        } else if (isInRange(playerRow, playerCol - 1) && canMove(targetRow, targetCol, playerRow, playerCol - 1)) {
            playerCol--;
            hasMoved = true;
        }

        return hasMoved;
    }

    public static boolean isInRange(int r, int c) {
        return r >= 0 && r < 15 && c >= 0 && c < 15;
    }

    public static boolean canMove(int targetRow, int targetCol, int newRow, int newCol) {
        return newRow < targetRow - 1 || newRow > targetRow + 1 || newCol < targetCol - 1 || newCol > targetCol + 1;
    }
}