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
public class ClientDAO {

    Conexion cone = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int response = 0;

    public Client buscar(String apellidoCli) {
        String sqlBuscar = "SELECT * FROM CLIENT WHERE CLI_LAST_NAME = '" + apellidoCli + "'";
        Client cli = new Client();
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlBuscar);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setCode(rs.getInt(1));
                cli.setName(rs.getString(2));
                cli.setLastName(rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("No se pudo obtener al cliente " + e);
        }
        return cli;
    }

    //operaciones crud
    public List listar() {
        String sqlListar = "SELECT * FROM CLIENT";
        List<Client> listClients = new ArrayList<>();
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlListar);
            rs = ps.executeQuery();
            while (rs.next()) {
                Client cli = new Client();
                cli.setCode(rs.getInt(1));
                cli.setName(rs.getString(2));
                cli.setLastName(rs.getString(3));
                listClients.add(cli);
            }
        } catch (Exception e) {
            System.out.println("No se pudo listar los clientes. " + e);
        }
        return listClients;
    }

    public int agregar(Client c) {
        String sqlAgregar = "INSERT INTO CLIENT (CLI_NAME, CLI_LAST_NAME) VALUES (?,?);";
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlAgregar);
            System.out.println("ps" + ps);
            ps.setString(1, c.getName());
            ps.setString(2, c.getLastName());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se pudo agregar al cliente " + e);
        }
        System.out.println("response" + response);
        return response;
    }

    public Client listarCode(int code) {
        Client cli = new Client();
        String sqlListarCode = "SELECT * FROM CLIENT WHERE CLI_CODE= " + code;
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlListarCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setName(rs.getString(2));
                cli.setLastName(rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("No se pudo obtener el codigo del cliente " + e);
        }
        return cli;
    }

    public int actualizar(Client c) {
        String sqlActualizar = "UPDATE CLIENT SET CLI_NAME=?, CLI_LAST_NAME=? WHERE CLI_CODE = ?";
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlActualizar);
            ps.setString(1, c.getName());
            ps.setString(2, c.getLastName());
            ps.setInt(3, c.getCode());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se pudo actualizar al cliente " + e);
        }
        return response;
    }

    public void eliminar(int code) {
        String sqlEliminar = "DELETE FROM CLIENT WHERE CLI_CODE = " + code;
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlEliminar);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar al cliente " + e);
        }
    }
}
