public class Boat {
    private int boatLength, rowNum, columnNum, touched;
    private int[] rowPosition, columnPosition;

    public Boat(int boatLength) {
        this.boatLength = boatLength;
        this.rowPosition = new int[boatLength];
        this.columnPosition = new int[boatLength];
        this.columnNum = 0;
        this.rowNum = 0;
        this.touched = 0;
    }

    public void addRow(int row){
        rowPosition[rowNum] = row;
        rowNum++;
    }

    public void addColumn(int column){
        columnPosition[columnNum] = column;
        columnNum++;
    }

    public void tocar(){
        touched++;
    }

    public int getBoatLength() {
        return boatLength;
    }

    public void setBoatLength(int boatLength) {
        this.boatLength = boatLength;
    }

    public int[] getRowPosition() {
        return rowPosition;
    }

    public void setRowPosition(int[] rowPosition) {
        this.rowPosition = rowPosition;
    }

    public int[] getColumnPosition() {
        return columnPosition;
    }

    public void setColumnPosition(int[] columnPosition) {
        this.columnPosition = columnPosition;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public int getTouched() {
        return touched;
    }

    public void setTouched(int touched) {
        this.touched = touched;
    }
}
