public class Barco {
    private int longuitud, numFila, numColumna, tocado;
    private int[] posicionFila, posicionColumna;

    public Barco(int longuitud) {
        this.longuitud = longuitud;
        this.posicionFila = new int[longuitud];
        this.posicionColumna = new int[longuitud];
        this.numColumna = 0;
        this.numFila = 0;
        this.tocado = 0;
    }

    public void añadirFila(int fila){
        posicionFila[numFila] = fila;
        numFila++;
    }

    public void añadirColumna(int columna){
        posicionColumna[numColumna] = columna;
        numColumna++;
    }

    public void tocar(){
        tocado++;
    }

    public int getLonguitud() {
        return longuitud;
    }

    public void setLonguitud(int longuitud) {
        this.longuitud = longuitud;
    }

    public int[] getPosicionFila() {
        return posicionFila;
    }

    public void setPosicionFila(int[] posicionFila) {
        this.posicionFila = posicionFila;
    }

    public int[] getPosicionColumna() {
        return posicionColumna;
    }

    public void setPosicionColumna(int[] posicionColumna) {
        this.posicionColumna = posicionColumna;
    }

    public int getNumFila() {
        return numFila;
    }

    public void setNumFila(int numFila) {
        this.numFila = numFila;
    }

    public int getNumColumna() {
        return numColumna;
    }

    public void setNumColumna(int numColumna) {
        this.numColumna = numColumna;
    }

    public int getTocado() {
        return tocado;
    }

    public void setTocado(int tocado) {
        this.tocado = tocado;
    }
}
