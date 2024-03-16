/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package taskmanagement;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

/**
 *
 * @author Josh
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button newTask;
    
    @FXML
    private Button deleteTask;
    
    @FXML
    private TextField tareaTextField;
    
    @FXML
    private ListView<Tarea>  listaTareasView;
    
    private ObservableList<Tarea> tareas = FXCollections.observableArrayList();
    
    @FXML
    public void initialize() {
        listaTareasView.setItems(tareas);
    }
    
    public void handleButtonAction(ActionEvent event){
        
    }
    
    @FXML
    public void agregarTarea(ActionEvent event) {
        String nombreTarea = tareaTextField.getText();
        if (!nombreTarea.isEmpty()) {
            Tarea nuevaTarea = new Tarea(nombreTarea);
            tareas.add(nuevaTarea);
            tareaTextField.clear();
        }
    }
    
    @FXML
    public void marcarTareaCompleta(ActionEvent event) {
        Tarea tareaSeleccionada = listaTareasView.getSelectionModel().getSelectedItem();
        if (tareaSeleccionada != null) {
            tareaSeleccionada.setCompletada(true);
        }
    }

    @FXML
    public void eliminarTarea(ActionEvent event) {
        ObservableList<Tarea> tareaSeleccionada = listaTareasView.getSelectionModel().getSelectedItems();
        if (tareaSeleccionada != null) {
            
                for(int i = 0; i < tareaSeleccionada.size(); i++){
                 tareas.remove(tareaSeleccionada.get(i));
                 }
           }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initialize();
        listaTareasView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    
    
}
