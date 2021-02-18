/*
 * El siguiente programa coorresponde a un ejercicio práctico enviado 
 * por la empresa AltioraCorp. 
 * Todo su uso es privado. 
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Solange Pico
 */
public class Order {

    Integer codeO;
    Date fechaO;
    Integer codeC;
    Integer codeA;
    String state;
    String nombreA;
    Double precioA;
    String codeBaA;
    String nombreCliente;

    public Order() {
    }

    public Order(Integer codeO, Date fechaO, Integer codeC, Integer codeA, String state) {
        this.codeO = codeO;
        this.fechaO = fechaO;
        this.codeC = codeC;
        this.codeA = codeA;
        this.state = state;
    }

    public Integer getCodeO() {
        return codeO;
    }

    public void setCodeO(Integer codeO) {
        this.codeO = codeO;
    }

    public Date getFechaO() {
        return fechaO;
    }

    public void setFechaO(Date fechaO) {
        this.fechaO = fechaO;
    }

    public Integer getCodeC() {
        return codeC;
    }

    public void setCodeC(Integer codeC) {
        this.codeC = codeC;
    }

    public Integer getCodeA() {
        return codeA;
    }

    public void setCodeA(Integer codeA) {
        this.codeA = codeA;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public Double getPrecioA() {
        return precioA;
    }

    public void setPrecioA(Double precioA) {
        this.precioA = precioA;
    }


    public String getCodeBaA() {
        return codeBaA;
    }

    public void setCodeBaA(String codeBaA) {
        this.codeBaA = codeBaA;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
