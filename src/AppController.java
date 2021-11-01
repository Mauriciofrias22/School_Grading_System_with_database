import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AppController {

    @FXML
    private Pane mainPane;

    @FXML
    private Label titleLabel;

    @FXML
    private TextField nombreIn;

    @FXML
    private TextField materiaIn;

    @FXML
    private TextField notaIn;

    @FXML
    private TextField generoIn;

    @FXML
    private TextArea entradaPro;

    @FXML
    private TextArea salidaPro;

    @FXML
    private TextField nombreCon;

    @FXML
    private TextField materiaCon;

    @FXML
    private TextArea resultadoCon;

    private int persona;

    private int materia;

    @FXML
    void cargar(ActionEvent event) {
        // Crear instacia de operaciones
        Operaciones o = new Operaciones();
        // Obtener todas las notas de la base de datos
        List<Nota> notas = o.obtenerNotas();
        // Crear un string vacio
        String lineas = "";
        // Definir formato de lineas
        String fmt = "%s %s %s %s\n";
        // Crear ciclo para llenar text area
        for (Nota nota : notas) {
            lineas += String.format(fmt, nota.getPersona(), nota.getGenero(), nota.getMateria(), nota.getNota());
        }
        // Se asigna resulta al text area
        entradaPro.setText(lineas);

    }

    @FXML
    void consultar(ActionEvent event) {
        // Limpiar el cuadro de texto
        resultadoCon.clear();
        try {
            // Instancia de operaciones
            Operaciones o = new Operaciones();
            // Validar que los campos esten diligenciados
            if (nombreCon.getText().isEmpty() || materiaCon.getText().isEmpty()) {
                // Crear instancia de mensaje de alerta
                Alert alert = new Alert(AlertType.ERROR, "Los parametros son obligatorios!");
                // Mostrar mensaje de alerta en la pantalla
                alert.show();
                //System.out.println("Los parametros son obligatorios");
            } else {
                // Buscar la persona
                this.persona = o.buscarNombre(nombreCon.getText());
                // Buscar la materia
                this.materia = o.buscarMateria(materiaCon.getText());
                // Validar que se hayan encontrado los datos buscados
                if (this.persona == 0 || this.materia == 0) {
                    resultadoCon.setText("No se encontraron resultados.");
                } else {
                    resultadoCon.setText("El registro consultado está listo para ser eliminado.");
                }
            }
        } catch (Exception e) {
            // Mostrar mensaje de excepcion
            resultadoCon.setText(e.getMessage());
            e.printStackTrace();
        }

    }

    @FXML
    void eliminar(ActionEvent event) {
        // Limpiar el cuadro de texto
        resultadoCon.clear();
        try {
            // Instancia de operaciones
            Operaciones o = new Operaciones();
            if (this.persona == 0 || this.materia == 0) {
                resultadoCon.setText("Nombre y/o Materia errados.");
            } else {
                o.eliminarNota(this.persona, this.materia);
                resultadoCon.setText("Nota eliminada exitosamente.");
            }
        
    } catch (Exception e) {
            // Mostrar mensaje de excepcion
            resultadoCon.setText(e.getMessage());
            e.printStackTrace();
        }
    }

    void limpiarIn() {
        nombreIn.clear();
        generoIn.clear();
        materiaIn.clear();
        notaIn.clear();

    }

    @FXML
    void guardar(ActionEvent event) {
        try {
            // Instancia de operaciones
            Operaciones o = new Operaciones();
            // Validar que todos los campos del formulario sean diligenciados
            if (nombreIn.getText().isEmpty() || generoIn.getText().isEmpty() || materiaIn.getText().isEmpty()
                    || notaIn.getText().isEmpty()) {
                // Crear instancia de mensaje de alerta
                Alert alert = new Alert(AlertType.ERROR, "Los parametros son obligatorios!");
                // Mostrar mensaje de alerta en la pantalla
                alert.show();
                //System.out.println("Los parametros son obligatorios");
            } else {
                // Crear instancia de notas
                Nota nota = new Nota();
                // Buscar Persona a traves del nombre
                nota.setPersona(o.buscarNombre(nombreIn.getText()));
                // Asignar genero
                nota.setGenero(Integer.parseInt(generoIn.getText()));
                // Buscar materia a traves del nombre
                nota.setMateria(o.buscarMateria(materiaIn.getText()));
                // Asignar nota
                nota.setNota(Double.parseDouble(notaIn.getText()));
                // Si la materia o la persona son 0, entonces no encontro
                // resultados
                if (nota.getPersona() > 0 && nota.getMateria() > 0) {
                    if (o.buscarNota(nota.getPersona(), nota.getMateria())) {
                        // Crear instancia de mensaje de alerta
                        Alert alert = new Alert(AlertType.ERROR, "Esta nota ya se encuentra registrada.");
                        // Mostrar mensaje de alerta en la pantalla
                        alert.show();
                } else {
                    o.crearNota(nota);
                    limpiarIn();
                    // Crear instancia de mensaje de alerta y mostrar en pantalla
                    (new Alert(AlertType.INFORMATION, "Nota creada exitosamente!")).show();
                    //System.out.println("Nombre y/o Materia errados.");
                }
             } else {
                    // Crear instancia de mensaje de alerta
                    Alert alert = new Alert(AlertType.ERROR, "Nombre y/o Materia errados.");
                    // Mostrar mensaje de alerta en la pantalla
                    alert.show();
                }
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void procesar(ActionEvent event) {
        SchoolGradingSystem objeto = new SchoolGradingSystem();
        String[] lines = entradaPro.getText().split("\n");
        objeto.loadData(lines.length, lines);
        StringBuilder sb = new StringBuilder();
        sb.append(objeto.stat1() + "\n");
        sb.append(objeto.stat2() + "\n");
        sb.append(objeto.stat3() + "\n");
        sb.append(objeto.stat4());
        salidaPro.setText(sb.toString());

    }

}
