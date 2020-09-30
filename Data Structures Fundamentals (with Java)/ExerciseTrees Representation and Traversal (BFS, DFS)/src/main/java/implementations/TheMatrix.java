package implementations;

public class TheMatrix {
    private char[][] matrix;
    private char fillChar;
    private char startChar;
    private int startRow;
    private int startCol;

    public TheMatrix(char[][] matrix, char fillChar, int startRow, int startCol) {
        this.matrix = matrix;
        this.fillChar = fillChar;
        this.startRow = startRow;
        this.startCol = startCol;
        this.startChar = this.matrix[this.startRow][this.startCol];
    }

    public void solve() {
        fillMatrix(startRow,startCol);
    }

    private void fillMatrix(int row, int col) {
        if (isOutOfBounds(row,col)||this.matrix[row][col]!=this.startChar){
 return;
    }
        this.matrix[row][col]=this.fillChar;
        this.fillMatrix(row+1,col);
        this.fillMatrix(row,col+1);
        this.fillMatrix(row-1,col);
        this.fillMatrix(row,col-1);
}

    private boolean isOutOfBounds(int row, int col) {
        return  row<0||row>=matrix.length||col<0||col>=matrix[row].length;
    }

    public String toOutputString() {
        StringBuilder builder=new StringBuilder();
        for (int r = 0; r <this.matrix.length ; r++) {
            for (int c = 0; c <this.matrix[r].length ; c++) {
                builder.append(this.matrix[r][c]);
            }
builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
