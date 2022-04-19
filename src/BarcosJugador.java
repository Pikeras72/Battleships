public class BarcosJugador {
    private Barco[] barcos, barcosColocados, barcosHundidos;
    private int numBarcos, numHundidos, numColocados;

    public BarcosJugador() {
        this.barcos = new Barco[5];
        this.barcosColocados = new Barco[5];
        this.barcosHundidos = new Barco[5];
        this.numBarcos = 0;
        this.numHundidos = 0;
        this.numColocados = 0;
    }

    public void añadirBarco(Barco barco){
        barcos[numBarcos] = barco;
        numBarcos++;
    }

    public void moverBarco(int i) {
        barcosColocados[numColocados] = barcos[i];
        for (int j = i; j < numBarcos; j++){
            if (j == numBarcos-1){
                barcos[j] = null;
                numBarcos--;
            }
            else {
                barcos[j] = barcos[j+1];
            }
        }
        numColocados++;
    }

    public void hundirBarco(int i){
        barcosHundidos[numHundidos] = barcosColocados[i];
        for (int j = i; j < numColocados; j++){
            if (j == numColocados-1){
                barcosColocados[j] = null;
                numColocados--;
            }
            else {
                barcosColocados[j] = barcosColocados[j+1];
            }
        }
        numHundidos++;
    }

    public Barco[] getBarcos() {
        return barcos;
    }

    public void setBarcos(Barco[] barcos) {
        this.barcos = barcos;
    }

    public int getNumBarcos() {
        return numBarcos;
    }

    public void setNumBarcos(int numBarcos) {
        this.numBarcos = numBarcos;
    }

    public Barco[] getBarcosColocados() {
        return barcosColocados;
    }

    public void setBarcosColocados(Barco[] barcosColocados) {
        this.barcosColocados = barcosColocados;
    }

    public Barco[] getBarcosHundidos() {
        return barcosHundidos;
    }

    public void setBarcosHundidos(Barco[] barcosHundidos) {
        this.barcosHundidos = barcosHundidos;
    }

    public int getNumHundidos() {
        return numHundidos;
    }

    public void setNumHundidos(int numHundidos) {
        this.numHundidos = numHundidos;
    }

    public int getNumColocados() {
        return numColocados;
    }

    public void setNumColocados(int numColocados) {
        this.numColocados = numColocados;
    }
}

