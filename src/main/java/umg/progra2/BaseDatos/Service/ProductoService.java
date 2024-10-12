package umg.progra2.BaseDatos.Service;

import umg.progra2.BaseDatos.Dao.ProductoDao;
import umg.progra2.BaseDatos.model.Producto;

import java.sql.SQLException;
import java.util.List;

public class ProductoService {

    private ProductoDao productoDAO;

    public ProductoService() {
        this.productoDAO = new ProductoDao();
    }

    public void crearProducto(Producto producto) throws SQLException {
        productoDAO.insertar(producto);
    }

    public Producto obtenerProducto(int id) throws SQLException {
        return productoDAO.obtenerPorId(id);
    }

    public Producto obtenerProductoMenoresA30(String condicion) throws SQLException {
        return productoDAO.obtenerMenoresA30(condicion);
    }

    public List<Producto> obtenerTodosLosProductos() throws SQLException {
        return productoDAO.obtenerTodos();
    }

    public void actualizarProducto(Producto producto) throws SQLException {
        productoDAO.actualizar(producto);
    }

    public void eliminarProducto(int id) throws SQLException {
        productoDAO.eliminar(id);
    }

}
