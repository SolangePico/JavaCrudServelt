/*
 * El siguiente programa coorresponde a un ejercicio práctico enviado 
 * por la empresa AltioraCorp. 
 * Todo su uso es privado. 
 */
package Model;

import Setting.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Solange Pico
 */
public class OrderDAO {

    Conexion cone = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int response = 0;

    public String GenerarOrderSerie() {
        String numeroOrden = "";
        String sqlNumerMaxOrder = "SELECT MAX(OR_CODE) FROM ARTICLE_ORDER";
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlNumerMaxOrder);
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroOrden = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("No se pudo obtener el maximo numero de orden." + e);
        }
        return numeroOrden;
    }

    public int guardarOrden(Order ord) {
        String sqlIdOrden = "INSERT INTO ARTICLE_ORDER(OR_CODE, OR_CLI_CODE) VALUES (?,?)";
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlIdOrden);
            ps.setInt(1, ord.getCodeO());
            ps.setInt(2, ord.getCodeC());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se pudo insertar la orden." + e);
        }
        return response;
    }

    public int guardarDetallesOrden(Order ord) {
        String sqlDetallesOrden = "INSERT INTO ARTICLE_ORDER_DETAIL(ORD_CODE, ORD_ART_CODE) VALUES (?,?)";
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlDetallesOrden);
            ps.setInt(1, ord.getCodeO());
            ps.setInt(2, ord.getCodeA());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se pudo insertar la orden detalle." + e);
        }
        return response;
    }

    public List listarOrdenesCliente(int codCli) {
        String sqlListar = "SELECT AO.OR_CODE, "
                + " CONCAT(CL.CLI_NAME, \" \", CL.CLI_LAST_NAME) AS CLI_NAME, "
                + " A.AR_BAR_CODE, "
                + " A.AR_NAME, "
                + " DATE(AO.OR_DATE) "
                + " FROM ARTICLE_ORDER AO "
                + " LEFT JOIN ARTICLE_ORDER_DETAIL AOD ON AOD.ORD_CODE = AO.OR_CODE "
                + " LEFT JOIN CLIENT CL ON CL.CLI_CODE = AO.OR_CLI_CODE "
                + " LEFT JOIN ARTICLE A ON A.AR_CODE = AOD.ORD_ART_CODE "
                + " WHERE AO.OR_CLI_CODE = " + codCli;
        List<Order> listOrdenes = new ArrayList<>();
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlListar);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order ord = new Order();
                ord.setCodeO(rs.getInt(1));
                ord.setNombreCliente(rs.getString(2));
                ord.setCodeBaA(rs.getString(3));
                ord.setNombreA(rs.getString(4));
                ord.setFechaO(rs.getDate(5));
                listOrdenes.add(ord);
            }
        } catch (Exception e) {
            System.out.println("No se pudo listar las ordenes del cliente." + e);
        }
        return listOrdenes;
    }
}
