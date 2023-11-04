/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vista;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cliente;

/**
 * FXML Controller class
 *
 * @author Cristian
 */
public class BuscarClienteController implements Initializable {

    @FXML
    private TextField txtBuscarCliente;
    @FXML
    private Button btnBuscarCliente;
    @FXML
    private TableView<Cliente> tblClientes;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colRFC;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidoP;
    @FXML
    private TableColumn colApellidoM;
    @FXML
    private TableColumn colNumeroT;
    @FXML
    private TableColumn colCorreo;
    @FXML
    private TableColumn colCalle;
    @FXML
    private TableColumn colNumeroE;
    @FXML
    private TableColumn colNumeroI;
    @FXML
    private TableColumn colCodigoP;
    @FXML
    private TableColumn colColonia;
    @FXML
    private TableColumn colMunicipio;
    @FXML
    private TableColumn colEstado;
    @FXML
    private TableColumn colPais;
    @FXML
    private TableColumn colFechaRegistro;
    @FXML
    private TableColumn colEstatus;
    @FXML
    private Button btnModificar;
    
    private ObservableList<Cliente> Clientes;
    
    private ArrayList clientes = new ArrayList<Cliente>();

     Cliente clienteEncontrado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Clientes = FXCollections.observableArrayList();
        /**
         * Asigno las columnas con los atributos del modelo
         */
        this.colId.setCellValueFactory(new PropertyValueFactory("id"));
        this.colRFC.setCellValueFactory(new PropertyValueFactory("Rfc"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellidoP.setCellValueFactory(new PropertyValueFactory("apellidoPaterno"));
        this.colApellidoM.setCellValueFactory(new PropertyValueFactory("apellidoMaterno"));
        this.colNumeroT.setCellValueFactory(new PropertyValueFactory("numeroTelefonico"));
        this.colCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
        this.colCalle.setCellValueFactory(new PropertyValueFactory("calle"));
        this.colNumeroE.setCellValueFactory(new PropertyValueFactory("numeroExterior"));
        this.colNumeroI.setCellValueFactory(new PropertyValueFactory("numeroInterior"));
        this.colCodigoP.setCellValueFactory(new PropertyValueFactory("codigoPostal"));
        this.colColonia.setCellValueFactory(new PropertyValueFactory("colonia"));
        this.colMunicipio.setCellValueFactory(new PropertyValueFactory("municipio"));
        this.colEstado.setCellValueFactory(new PropertyValueFactory("estado"));
        this.colPais.setCellValueFactory(new PropertyValueFactory("pais"));
        this.colFechaRegistro.setCellValueFactory(new PropertyValueFactory("fechaRegistro"));
        this.colEstatus.setCellValueFactory(new PropertyValueFactory("estatus"));
        // TODO
    }    

    @FXML
    private void buscarCliente(ActionEvent event) {
        String nombreCliente = txtBuscarCliente.getText();
        Cliente cliente = new Cliente();
        clienteEncontrado = cliente.buscarClienteNombre(nombreCliente);
        // Limpiar la lista de Clientes antes de agregar el resultado
        this.Clientes.clear();

        if (clienteEncontrado != null) {
            this.Clientes.add(clienteEncontrado);
        }

            this.tblClientes.setItems(Clientes);
        }

    @FXML
    private void modificarCliente(ActionEvent event) {
    }
    
}
