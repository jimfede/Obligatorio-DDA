/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class UsuarioDAO {

    private DB db;

    public UsuarioDAO(DB db) {
        this.db = db;
    }

    public boolean crearUsuario(UsuarioVO user) {
        Connection myConn = db.getConnection();

        String sql = "INSERT INTO Usuarios (nombreUsuario, clave, nombreCompleto, rol, credito) VALUES (?, ?, ?, ?, ?)";

        try {

            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, user.getNombreUsuario());
            statement.setString(2, user.getClave());
            statement.setString(3, user.getNombreCompleto());
            statement.setString(4, user.getRol());
            statement.setDouble(5, user.getCredito());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (myConn.isClosed() == false) {
                    myConn.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }

        return false;
    }

    private UsuarioVO SerializarUsuario(ResultSet result) throws SQLException {
        UsuarioVO myUser = null;

        myUser = new UsuarioVO(result.getString("nombreUsuario"), result.getString("clave"),
                result.getString("nombreCompleto"), result.getString("rol"), result.getDouble("credito"),
                result.getInt("usuarioId"));
        return myUser;
    }

    public UsuarioVO leerUsuario(String nombreUsuario) {
        Connection myConn = db.getConnection();
        UsuarioVO myUser = null;
        String sql = "SELECT * FROM Usuarios WHERE nombreUsuario = ?";

        try {

            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, nombreUsuario);

            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                myUser = SerializarUsuario(result);
            }
            return myUser;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (myConn.isClosed() == false) {
                    myConn.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return myUser;
    }

    public boolean actualizarUsuario(int ID, UsuarioVO user) {
        Connection myConn = db.getConnection();

        String sql = "UPDATE Usuarios SET nombreUsuario = ?, clave = ?, nombreCompleto = ?, rol = ?, credito = ? WHERE usuarioId = ?";
        try {
            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, user.getNombreUsuario());
            statement.setString(2, user.getClave());
            statement.setString(3, user.getNombreCompleto());
            statement.setString(4, user.getRol());
            statement.setDouble(5, user.getCredito());
            statement.setInt(6, user.getUsuarioId());

            int filasAfectadas = statement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (myConn.isClosed() == false) {
                    myConn.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return false;
    }

    public boolean eliminarUsuario(int ID) {
        Connection myConn = db.getConnection();

        String sql = "DELETE FROM Usuarios WHERE usuarioId = ?";
        try {

            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setInt(1, ID);

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (myConn.isClosed() == false) {
                    myConn.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }

        return false;
    }

    public boolean cargarSaldo(int ID, double monto) {
        Connection myConn = db.getConnection();

        String sql = "UPDATE Usuarios SET credito = credito + ? WHERE usuarioId = ?";
        try {
            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setDouble(1, monto);
            statement.setInt(2, ID);

            int filasAfectadas = statement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (myConn.isClosed() == false) {
                    myConn.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return false;
    }

}
