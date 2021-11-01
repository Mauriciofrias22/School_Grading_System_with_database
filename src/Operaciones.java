import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite realizar todas las operaciones con la base de datos
 */
public class Operaciones {
    private Connection connection;

    /**
     * Metodo para crear la conexion de la base de datos
     */
    private void connect() throws Exception {
        // Crear una conexion a la base de datos de SQLite
        connection = DriverManager.getConnection("jdbc:sqlite:./src/reto_db.db");
    }

    /**
     * Metodo para cerrar la conexion a la base de datos de SQLite
     */
    private void close() throws Exception {
        // Cerrar la conexion a la base de datos de SQLite
        connection.close();
    }

    /**
     * Metodo para consultar las notas
     * 
     * @param sql Cadena de consulta
     * @return Resultado
     */
    public List<Nota> obtenerNotas() {
        // Definicion de Lista
        List<Nota> listado = new ArrayList<>();
        try {
            // Crear conexion
            connect();
            // Crear un objeto para ejecutar las sentencias
            Statement statement = connection.createStatement();
            // Crear una sentencia de consulta y retornar los resultados
            ResultSet rs = statement.executeQuery("SELECT * FROM notas");
            // Ciclo para iterar los resultados del comando
            while (rs.next()) {
                // Se crea un objeto nota con todos sus parametros
                Nota nota = new Nota(rs.getInt("persona_id"), rs.getInt("materia_id"), rs.getInt("genero_id"), rs.getDouble("nota"));
                // SE agrega esa nota al listado
                listado.add(nota);
            }
            // Cerrar el objeto de resultados
            rs.close();
            // Cerrar el objeto de sentencia
            statement.close();
            // Cerrar la conexion
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Retornar resultado
        return listado;
    }

    public int buscarNombre(String nombre) {
        // Definicion de resultado
        int res = 0;
        try {
            // Crear conexion
            connect();
            // Crear un objeto para ejecutar las sentencias
            Statement statement = connection.createStatement();
            // Crear una sentencia de consulta y retornar los resultados
            ResultSet rs = statement.executeQuery("SELECT * FROM persona WHERE LOWER(nombre) = LOWER('"+ nombre +"')");
            // Ciclo para iterar los resultados del comando
            while (rs.next()) {
                res = rs.getInt("id");
            }
            // Cerrar el objeto de resultados
            rs.close();
            // Cerrar el objeto de sentencia
            statement.close();
            // Cerrar la conexion
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Retornar resultado
        return res;
    }

    public int buscarMateria(String nombre) {
        // Definicion de resultado
        int res = 0;
        try {
            // Crear conexion
            connect();
            // Crear un objeto para ejecutar las sentencias
            Statement statement = connection.createStatement();
            // Crear una sentencia de consulta y retornar los resultados
            ResultSet rs = statement.executeQuery("SELECT * FROM materia WHERE LOWER(nombre) = LOWER('"+ nombre +"')");
            // Ciclo para iterar los resultados del comando
            while (rs.next()) {
                res = rs.getInt("id");
            }
            // Cerrar el objeto de resultados
            rs.close();
            // Cerrar el objeto de sentencia
            statement.close();
            // Cerrar la conexion
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Retornar resultado
        return res;
    }

    /**
     * Metodo para validar si una  persona ya tiene registrada
     * una nota con esa materia
     * @param persona Id de la persona
     * @param materia Id de la materia
     * @return true si la encuentra false sino la encuentra
     */
    public boolean buscarNota(int persona, int materia) {
        // Definicion de resultado
        boolean res = false;
        try {
            // Crear conexion
            connect();
            // Crear un objeto para ejecutar las sentencias
            Statement statement = connection.createStatement();
            // Crear una sentencia de consulta y retornar los resultados
            String sqlStr = "SELECT * FROM notas WHERE persona_id = %s AND materia_id = %s";
            ResultSet rs = statement.executeQuery(String.format(sqlStr, persona, materia));
            // Otra forma de realizar la consulta
            // ResultSet rs = statement.executeQuery("SELECT * FROM materia WHERE LOWER(nombre) = LOWER('"+ nombre +"')");
            // Ciclo para iterar los resultados del comando
            if (rs.next()) {
                res = true;
            }
            // Cerrar el objeto de resultados
            rs.close();
            // Cerrar el objeto de sentencia
            statement.close();
            // Cerrar la conexion
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Retornar resultado
        return res;
    }
    
    /**
     * Metodo para la creacion de un nuevo registro en la tabla de notas
     * @param nota Objeto nota que tiene todos los campos necesartios para crear una nota
     */
    public void crearNota(Nota nota) {
        try {
            // Crear conexion
            connect();
            // Crear un objeto para ejecutar las sentencias
            Statement statement = connection.createStatement();
            // Crear una sentencia de consulta y retornar los resultados
            String sqlStr = "INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (%s, %s, %s, %s)";
            statement.executeUpdate(String.format(sqlStr, nota.getPersona(), nota.getGenero(), nota.getMateria(), nota.getNota()));
            // Cerrar el objeto de sentencia
            statement.close();
            // Cerrar la conexion
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para eliminar un registro de la tabla de notas
     * @param persona Id de la persona
     * @param materia Id de la materia
     */
    public void eliminarNota(int persona, int materia) {
        try {
            // Crear conexion
            connect();
            // Crear un objeto para ejecutar las sentencias
            Statement statement = connection.createStatement();
            // Crear una sentencia de consulta y retornar los resultados
            String sqlStr = "DELETE FROM notas WHERE persona_id = %s AND materia_id = %s";
            statement.executeUpdate(String.format(sqlStr, persona, materia));
            // Cerrar el objeto de sentencia
            statement.close();
            // Cerrar la conexion
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
