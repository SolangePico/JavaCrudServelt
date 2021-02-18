/*
 * El siguiente programa coorresponde a un ejercicio práctico enviado 
 * por la empresa AltioraCorp. 
 * Todo su uso es privado. 
 */
package Controller;

import Model.Article;
import Model.ArticleDAO;
import Model.Client;
import Model.ClientDAO;
import Model.Order;
import Model.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Solange Pico
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Client cli = new Client();
    ClientDAO cliDAO = new ClientDAO();
    int idO;
    Article art = new Article();
    ArticleDAO artDAO = new ArticleDAO();
    int idA;
    Order or = new Order();
    OrderDAO orDAO = new OrderDAO();
    List<Order> listaO = new ArrayList<>();
    int item;
    int codA;
    String codigoBarraA;
    String nombreArticulo;
    double precioArticulo = 0.00;
    double total = 0.00;
    String numeroOrden;
    int codigoCli;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Client")) {
            switch (accion) {
                case "Listar":
                    List listaClient = cliDAO.listar();
                    System.out.println("listaClient" + listaClient);
                    request.setAttribute("clients", listaClient);
                    break;
                case "Agregar":
                    String name = request.getParameter("txtName");
                    String lastName = request.getParameter("txtLastName");
                    cli.setName(name);
                    cli.setLastName(lastName);
                    cliDAO.agregar(cli);
                    request.getRequestDispatcher("Controlador?menu=Client&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idO = Integer.parseInt(request.getParameter("code"));
                    Client cl = cliDAO.listarCode(idO);
                    request.setAttribute("client", cl);
                    request.getRequestDispatcher("Controlador?menu=Client&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nameA = request.getParameter("txtName");
                    String lastNameA = request.getParameter("txtLastName");
                    cli.setName(nameA);
                    cli.setLastName(lastNameA);
                    cli.setCode(idO);
                    cliDAO.actualizar(cli);
                    request.getRequestDispatcher("Controlador?menu=Client&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idO = Integer.parseInt(request.getParameter("code"));
                    cliDAO.eliminar(idO);
                    request.getRequestDispatcher("Controlador?menu=Client&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Client.jsp").forward(request, response);
        }

        if (menu.equals("Article")) {
            switch (accion) {
                case "ListarArticulo":
                    List listaArticle = artDAO.listarArticulo();
                    request.setAttribute("articles", listaArticle);
                    break;
                case "AgregarArticulo":
                    String codigoBarras = request.getParameter("txtBarCode");
                    String nameA = request.getParameter("txtNameA");
                    String precioU = request.getParameter("txtPrecioU");
                    art.setBarCodeA(codigoBarras);
                    art.setNameArt(nameA);
                    art.setUnitPriceA(Double.parseDouble(precioU));
                    artDAO.agregarArticulo(art);
                    request.getRequestDispatcher("Controlador?menu=Article&accion=ListarArticulo").forward(request, response);
                    break;
                case "EditarArticulo":
                    idA = Integer.parseInt(request.getParameter("code"));
                    Article ar = artDAO.listarCodeArticulo(idA);
                    request.setAttribute("article", ar);
                    request.getRequestDispatcher("Controlador?menu=Article&accion=ListarArticulo").forward(request, response);
                    break;
                case "ActualizarArticulo":
                    String codigoBarrasA = request.getParameter("txtBarCode");
                    String nameAr = request.getParameter("txtNameA");
                    String precioUA = request.getParameter("txtPrecioU");
                    art.setBarCodeA(codigoBarrasA);
                    art.setNameArt(nameAr);
                    art.setUnitPriceA(Double.parseDouble(precioUA));
                    art.setCodeA(idA);
                    artDAO.actualizarArticulo(art);
                    request.getRequestDispatcher("Controlador?menu=Article&accion=ListarArticulo").forward(request, response);
                    break;
                case "EliminarArticulo":
                    idA = Integer.parseInt(request.getParameter("code"));
                    artDAO.eliminarArticulo(idA);
                    request.getRequestDispatcher("Controlador?menu=Article&accion=ListarArticulo").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Article.jsp").forward(request, response);
        }

        if (menu.equals("CreateOrder")) {
            switch (accion) {
                case "BuscarCliente":
                    String apellidoCliente = request.getParameter("apellidoCliente");
                    cli.setLastName(apellidoCliente);
                    cli = cliDAO.buscar(apellidoCliente);
                    request.setAttribute("cli", cli);
                    request.setAttribute("nOrden", numeroOrden);
                    break;
                case "BuscarArticulo":
                    String barCodeA = request.getParameter("codBarrasProducto");
                    art.setBarCodeA(barCodeA);
                    request.setAttribute("cli", cli);
                    request.setAttribute("nOrden", numeroOrden);
                    art = artDAO.buscarArticulo(barCodeA);
                    request.setAttribute("art", art);
                    request.setAttribute("listaO", listaO);
                    break;
                case "Agregar":
                    request.setAttribute("cli", cli);
                    item = item + 1;
                    codA = Integer.parseInt(request.getParameter("codigoArticulo"));
                    codigoBarraA = request.getParameter("codBarrasProducto");
                    nombreArticulo = request.getParameter("nombreArticulo");
                    precioArticulo = Double.parseDouble(request.getParameter("precioArticulo"));
                    or = new Order();
                    or.setCodeO(item);
                    or.setCodeA(codA);
                    or.setCodeBaA(codigoBarraA);
                    or.setNombreA(nombreArticulo);
                    or.setPrecioA(precioArticulo);
                    listaO.add(or);
                    request.setAttribute("listaO", listaO);
                    request.setAttribute("nOrden", numeroOrden);
                    break;
                case "GenerarOrden":
                    or.setCodeO(Integer.parseInt(numeroOrden));
                    or.setCodeC(cli.getCode());
                    orDAO.guardarOrden(or);
                    int idCodeOrder = Integer.parseInt(orDAO.GenerarOrderSerie());
                    for (int i = 0; i < listaO.size(); i++) {
                        or = new Order();
                        or.setCodeO(idCodeOrder);
                        or.setCodeA(listaO.get(i).getCodeA());
                        orDAO.guardarDetallesOrden(or);
                    }
                    break;
                default:
                    or = new Order();
                    listaO = new ArrayList<>();
                    item = 0;
                    numeroOrden = orDAO.GenerarOrderSerie();
                    if (numeroOrden == null) {
                        numeroOrden = "0000000001";
                        request.setAttribute("nOrden", numeroOrden);
                    } else {
                        int incrementar = Integer.parseInt(numeroOrden);
                        System.out.println("incrementar" + incrementar);
                        numeroOrden = String.format("%010d", incrementar + 1);
                        request.setAttribute("nOrden", numeroOrden);
                    }
                    request.getRequestDispatcher("CreateOrder.jsp").forward(request, response);
            }
            request.getRequestDispatcher("CreateOrder.jsp").forward(request, response);
        }

        if (menu.equals("Order")) {
            switch (accion) {
                case "BuscarCliente":
                    String apellidoCliente = request.getParameter("apellidoCliente");
                    cli.setLastName(apellidoCliente);
                    cli = cliDAO.buscar(apellidoCliente);
                    request.setAttribute("cli", cli);
                    request.setAttribute("nOrden", numeroOrden);
                    break;
                case "BuscarOrdenes":
                    int codClient = Integer.parseInt(request.getParameter("codigoClient"));
                    List listaOC = orDAO.listarOrdenesCliente(codClient);
                    request.setAttribute("listaOC", listaOC);
                    break;
                default:
                    request.getRequestDispatcher("Order.jsp").forward(request, response);
            }
            request.getRequestDispatcher("Order.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
