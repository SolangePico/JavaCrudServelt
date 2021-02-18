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
public class ArticleDAO {

    Conexion cone = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int response = 0;

    //operaciones crud
    public List listarArticulo() {
        String sqlListar = "SELECT * FROM ARTICLE";
        List<Article> listArticles = new ArrayList<>();
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlListar);
            rs = ps.executeQuery();
            while (rs.next()) {
                Article art = new Article();
                art.setCodeA(rs.getInt(1));
                art.setBarCodeA(rs.getString(2));
                art.setNameArt(rs.getString(3));
                art.setUnitPriceA(rs.getDouble(4));
                listArticles.add(art);
            }
        } catch (Exception e) {
            System.out.println("No se pudo listar los artículos." + e);
        }
        return listArticles;
    }

    public int agregarArticulo(Article a) {
        String sqlAgregar = "INSERT INTO ARTICLE (AR_BAR_CODE, AR_NAME, AR_UNIT_PRICE) VALUES (?,?,?);";
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlAgregar);
            ps.setString(1, a.getBarCodeA());
            ps.setString(2, a.getNameArt());
            ps.setDouble(3, a.getUnitPriceA());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se pudo agregar los artículos." + e);
        }
        return response;
    }

    public Article buscarArticulo(String code) {
        Article art = new Article();
        String sqlListarCode = "SELECT * FROM ARTICLE WHERE AR_BAR_CODE = '" + code + "';";
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlListarCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                art.setCodeA(rs.getInt(1));
                art.setBarCodeA(rs.getString(2));
                art.setNameArt(rs.getString(3));
                art.setUnitPriceA(rs.getDouble(4));
            }
        } catch (Exception e) {
            System.out.println("No se pudo obtener el artículo." + e);
        }
        return art;
    }
    
    public Article listarCodeArticulo(int code) {
        Article art = new Article();
        String sqlListarCode = "SELECT * FROM ARTICLE WHERE AR_CODE= " + code;
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlListarCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                art.setBarCodeA(rs.getString(2));
                art.setNameArt(rs.getString(3));
                art.setUnitPriceA(rs.getDouble(4));
            }
        } catch (Exception e) {
            System.out.println("No se pudo obtener el id los artículos." + e);
        }
        return art;
    }

    public int actualizarArticulo(Article a) {
        String sqlActualizar = "UPDATE ARTICLE SET AR_BAR_CODE=?, AR_NAME=?, AR_UNIT_PRICE=? WHERE AR_CODE = ?";
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlActualizar);
            ps.setString(1, a.getBarCodeA());
            ps.setString(2, a.getNameArt());
            ps.setDouble(3, a.getUnitPriceA());
            ps.setInt(4, a.getCodeA());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el artículo." + e);
        }
        return response;
    }

    public void eliminarArticulo(int code) {
        String sqlEliminar = "DELETE FROM ARTICLE WHERE AR_CODE = " + code;
        try {
            con = cone.Conexion();
            ps = con.prepareStatement(sqlEliminar);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el artículo." + e);
        }
    }
}
