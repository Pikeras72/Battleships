public class PlayersBoats {
    private Boat[] boats, placedBoats;
    private int boatsNum, sunkenNum, placedNum;

    public PlayersBoats() {
        this.boats = new Boat[5];
        this.placedBoats = new Boat[5];
        this.boatsNum = 0;
        this.sunkenNum = 0;
        this.placedNum = 0;
    }

    public void addBoat(Boat boat){
        boats[boatsNum] = boat;
        boatsNum++;
    }

    public void moveBoat(int i) {
        placedBoats[placedNum] = boats[i];
        for (int j = i; j < boatsNum; j++){
            if (j == boatsNum -1){
                boats[j] = null;
                boatsNum--;
            }
            else {
                boats[j] = boats[j+1];
            }
        }
        placedNum++;
    }

    public void sunkBoat(){
        sunkenNum++;
    }

    public Boat[] getBarcos() {
        return boats;
    }

    public void setBarcos(Boat[] boats) {
        this.boats = boats;
    }

    public int getBoatsNum() {
        return boatsNum;
    }

    public void setBoatsNum(int boatsNum) {
        this.boatsNum = boatsNum;
    }

    public Boat[] getPlacedBoats() {
        return placedBoats;
    }

    public void setPlacedBoats(Boat[] placedBoats) {
        this.placedBoats = placedBoats;
    }

    public int getSunkenNum() {
        return sunkenNum;
    }

    public void setSunkenNum(int sunkenNum) {
        this.sunkenNum = sunkenNum;
    }

    public int getPlacedNum() {
        return placedNum;
    }

    public void setPlacedNum(int placedNum) {
        this.placedNum = placedNum;
    }
}

