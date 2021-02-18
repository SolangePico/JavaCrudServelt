/*
 * El siguiente programa coorresponde a un ejercicio práctico enviado 
 * por la empresa AltioraCorp. 
 * Todo su uso es privado. 
 */
package Model;

/**
 *
 * @author Solange Pico
 */
public class Article {

    int codeA;
    String barCodeA;
    String nameArt;
    Double unitPriceA;
    String stateA;

    public Article() {
    }

    public Article(int codeA, String barCodeA, String nameArt, Double unitPriceA, String stateA) {
        this.codeA = codeA;
        this.barCodeA = barCodeA;
        this.nameArt = nameArt;
        this.unitPriceA = unitPriceA;
        this.stateA = stateA;
    }

    public int getCodeA() {
        return codeA;
    }

    public void setCodeA(int codeA) {
        this.codeA = codeA;
    }

    public String getBarCodeA() {
        return barCodeA;
    }

    public void setBarCodeA(String barCodeA) {
        this.barCodeA = barCodeA;
    }

    public String getNameArt() {
        return nameArt;
    }

    public void setNameArt(String nameArt) {
        this.nameArt = nameArt;
    }

    public Double getUnitPriceA() {
        return unitPriceA;
    }

    public void setUnitPriceA(Double unitPriceA) {
        this.unitPriceA = unitPriceA;
    }

    public String getStateA() {
        return stateA;
    }

    public void setStateA(String stateA) {
        this.stateA = stateA;
    }
}
