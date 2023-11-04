/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vista;

import Aplicacion.Mensaje;
import Excepciones.ExcpecionesDao;
import ModeloDAO.ClienteDaoImpl;
import Persistencia.Conexion;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Cliente;



/**
 * FXML Controller class
 *
 * @author Cristian
 */
public class AgregarClienteControlador implements Initializable {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtApellidoP;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtRfc;
    @FXML
    private TextField txtApellidoM;
    @FXML
    private TextField txtNumeroT;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtCalle;
    @FXML
    private TextField txtNumeroE;
    @FXML
    private TextField txtNumeroI;
    @FXML
    private TextField txtCodigoP;
    @FXML
    private TextField txtColonia;
    @FXML
    private TextField txtMunicipio;
    @FXML
    private TextField txtEstado;
    @FXML
    private TextField txtPais;
    @FXML
    private TextField txtFechaR;
    @FXML
    private TextField txtEstatus;
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
    private Button btnAgregar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    
    private ObservableList<Cliente> Clientes;
    
     String columId = "id";
     String columRfc = "Rfc";
     String columNombre = "nombre";
     String columApelledoP = "apellidoPaterno";
     String columApellidoM = "apellidoMaterno";
     String columNumeroT = "numeroTelefonico";
     String columCorreo = "correo";
     String columCalle = "calle";
     String columNumeroE = "numeroExterior";
     String columNumeroI = "numeroInterior";
     String columCodigoP = "codigoPostal";
     String columColonia = "colonia";
     String columMunicipio = "municipio";
     String columEstado = "estado";
     String columPais = "pais";
     String columFechaR = "fechaRegistro";
     String columEstatus = "estatus";
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        
       /**
        * Creo el observablelist
        */
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
         /*ClienteDaoImpl todosClientes = new ClienteDaoImpl();
        todosClientes.getTodosClientes();*/
    }   

    @FXML
    private void registrarCliente(ActionEvent event) throws ExcpecionesDao {
        try{
            int id = Integer.parseInt(this.txtId.getText());
            String Rfc = this.txtRfc.getText();
            String nombre = this.txtNombre.getText();
            String apellidoPaterno = this.txtApellidoP.getText();
            String apellidoMaterno = this.txtApellidoM.getText();
            String numeroTelefonico = this.txtNumeroT.getText();
            String correoo = this.txtCorreo.getText();
            String calle = this.txtCalle.getText();
            int numeroExterior = Integer.parseInt(this.txtNumeroE.getText());
            int numeroInterior = Integer.parseInt(this.txtNumeroI.getText());
            int codigoPostal = Integer.parseInt(this.txtCodigoP.getText());  
            String colonia = this.txtColonia.getText();
            String municipio = this.txtMunicipio.getText();
            String estado = this.txtEstado.getText();
            String pais = this.txtPais.getText();
            String fechaRegistro = this.txtFechaR.getText();
            String estatus = this.txtEstatus.getText(); 
            
            /**
              * Creo un Alumno
              */
           Cliente c = new Cliente(id,Rfc,nombre,apellidoPaterno,apellidoMaterno,numeroTelefonico,correoo,calle,numeroExterior,numeroInterior,codigoPostal,colonia,municipio,estado,pais,fechaRegistro,estatus);
           ClienteDaoImpl aux = new ClienteDaoImpl();
           aux.crearCliente(c);
           /**
           * Compruebo si el alumno esta en el lista
           */ 
            if(!this.Clientes.contains(c)){
                this.Clientes.add(c);
                this.tblClientes.setItems(Clientes);
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Info");
                alert.setContentText("Cliente añadido");
                alert.showAndWait();
                               
            }else{
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setHeaderText(null);
                alert1.setTitle("Info");
                alert1.setContentText("El Cliente ya existe");
                alert1.showAndWait();
            }  
        }catch(NumberFormatException e) {

            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setHeaderText(null);
            alert2.setTitle("Error");
            alert2.setContentText("Formato incorrecto");
            alert2.showAndWait();  
       }   
     }   
    
    private void seleccionar(MouseEvent event) {
        /**
         * Obtengo al cliente seleccionado
         */
         Cliente c = this.tblClientes.getSelectionModel().getSelectedItem();

        /**
         * Sino es nulo seteo los campos
         */
        if (c != null) {
            
            this.txtId.setText(c.getId() + "");
            this.txtRfc.setText(c.getRfc());
            this.txtNombre.setText(c.getNombre());
            this.txtApellidoP.setText(c.getApellidoPaterno());
            this.txtApellidoM.setText(c.getApellidoMaterno());
            this.txtNumeroT.setText(c.getNumeroTelefonico());
            this.txtCorreo.setText(c.getCorreo());
            this.txtCalle.setText(c.getCalle());
            this.txtNumeroE.setText(c.getNumeroExterior() + "");
            this.txtNumeroI.setText(c.getNumeroInterior()+ "");
            this.txtCodigoP.setText(c.getCodigoPostal() + "");  
            this.txtColonia.setText(c.getColonia());
            this.txtMunicipio.setText(c.getMunicipio());
            this.txtEstado.setText(c.getEstado());
            this.txtPais.setText(c.getPais());
            this.txtFechaR.setText(c.getFechaRegistro());
            this.txtEstatus.setText(c.getEstatus()); 
            
           
        }
    }

    @FXML
    private void modificarCliente(ActionEvent event) throws ExcpecionesDao, SQLException {
         /** 
         * Obtengo al cliente seleccionado
         */
         Cliente c = this.tblClientes.getSelectionModel().getSelectedItem();
         
         /**
         * Si el cliente es nulo, lanzo error
         */
        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un cliente");
            alert.showAndWait();
        } else {

            try {
                
            int id = Integer.parseInt(this.txtId.getText());
            String Rfc = this.txtRfc.getText();
            String nombre = this.txtNombre.getText();
            String apellidoPaterno = this.txtApellidoP.getText();
            String apellidoMaterno = this.txtApellidoM.getText();
            String numeroTelefonico = this.txtNumeroT.getText();
            String correoo = this.txtCorreo.getText();
            String calle = this.txtCalle.getText();
            int numeroExterior = Integer.parseInt(this.txtNumeroE.getText());
            int numeroInterior = Integer.parseInt(this.txtNumeroI.getText());
            int codigoPostal = Integer.parseInt(this.txtCodigoP.getText());  
            String colonia = this.txtColonia.getText();
            String municipio = this.txtMunicipio.getText();
            String estado = this.txtEstado.getText();
            String pais = this.txtPais.getText();
            String fechaRegistro = this.txtFechaR.getText();
            String estatus = this.txtEstatus.getText(); 
            
             /**
                 * Creo un cliente
                 */
                Cliente aux = new Cliente(id,Rfc,nombre,apellidoPaterno,apellidoMaterno,numeroTelefonico,correoo,calle,numeroExterior,numeroInterior,codigoPostal,colonia,municipio,estado,pais,fechaRegistro,estatus);
                ClienteDaoImpl dao = new ClienteDaoImpl();
                dao.actualizarCliente(aux);
                /**
                 * Compruebo si el cliente esta en el lista
                 */
                
                if (!this.Clientes.contains(aux)) {

                    /**
                     * Modifico el objeto
                     */
                    c.setId(aux.getId());
                    c.setRfc(aux.getRfc());
                    c.setNombre(aux.getNombre());
                    c.setApellidoPaterno(aux.getApellidoPaterno());
                    c.setApellidoMaterno(aux.getApellidoMaterno());
                    c.setNumeroTelefonico(aux.getNumeroTelefonico());
                    c.setCorreo(aux.getCorreo());
                    c.setCalle(aux.getCalle());
                    c.setNumeroExterior(aux.getNumeroExterior());
                    c.setNumeroInterior(aux.getNumeroInterior());
                    c.setCodigoPostal(aux.getCodigoPostal());  
                    c.setColonia(aux.getColonia());
                    c.setMunicipio(aux.getMunicipio());
                    c.setEstado(aux.getEstado());
                    c.setPais(aux.getPais());
                    c.setFechaRegistro(aux.getFechaRegistro());
                    c.setEstatus(aux.getEstatus()); 
                    /**
                     * Refresco la tabla
                     */
                    this.tblClientes.refresh();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Info");
                    alert.setContentText("cliente modificado");
                    alert.showAndWait();

                } else {

                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setHeaderText(null);
                    alert2.setTitle("Error");
                    alert2.setContentText("El cliente ya existe");
                    alert2.showAndWait();
                }
                
            } catch (NumberFormatException e) {

                Alert alert3 = new Alert(Alert.AlertType.ERROR);
                alert3.setHeaderText(null);
                alert3.setTitle("Error");
                alert3.setContentText("Formato incorrecto");
                alert3.showAndWait();
            }

        }
    }
            
    @FXML
    private void eliminarCliente(ActionEvent event) throws ExcpecionesDao {
        
        /**
         * Obtengo el cliente seleccionado
         */
          Cliente c = this.tblClientes.getSelectionModel().getSelectedItem();
          
        /**
         * Si el cliente es nulo, lanzo error
         */
        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un cliente");
            alert.showAndWait();
        } else {
            ClienteDaoImpl dao = new ClienteDaoImpl();
            dao.eliminarCliente(c);
            /**
             * elimino al cliente de la lista
             */
            this.Clientes.remove(c);
            /**
             *  Refresco la lista
             */
            this.tblClientes.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Cliente eliminado");
            alert.showAndWait();

        }
    }    
    public ObservableList<Cliente> getTodosClientes(){
            
            var sql = "SELECT * FROM cliente";
        /**
         * Creamos una coleccion vacia
         */
        ObservableList<Cliente> clientesList = FXCollections.observableArrayList();
        
        try{
                Conexion conexion = new Conexion();
                PreparedStatement consulta = conexion.obtenerConexion().prepareStatement(sql);
                ResultSet resultSet = consulta.executeQuery();
                
                while(resultSet.next()) {
                    Cliente cliente = new Cliente();
                    Map<String, Object> coleccion = new HashMap<>();
        
                    cliente.setId(Integer.parseInt(resultSet.getString("idCliente	")));
                    cliente.setRfc(resultSet.getString("rfcCliente"));
                    cliente.setNombre(resultSet.getString("nombreCliente"));
                    cliente.setApellidoPaterno(resultSet.getString("apellidoPaterno"));
                    cliente.setApellidoMaterno(resultSet.getString("apellidoMaterno"));
                    cliente.setNumeroTelefonico(resultSet.getString("numeroTelefono"));
                    cliente.setCorreo(resultSet.getString("correoElectronico"));
                    cliente.setCalle(resultSet.getString("calleCliente"));
                    cliente.setNumeroExterior(Integer.parseInt(resultSet.getString("numeroExterior")));
                    cliente.setNumeroInterior(Integer.parseInt(resultSet.getString("numeroInterior")));
                    cliente.setCodigoPostal(Integer.parseInt(resultSet.getString("codigoPostal")));
                    cliente.setColonia(resultSet.getString("colonia"));
                    cliente.setMunicipio(resultSet.getString("municipio"));
                    cliente.setEstado(resultSet.getString("estado")); 
                    cliente.setPais(resultSet.getString("pais"));
                    cliente.setFechaRegistro(resultSet.getString("fechaRegistro"));
                    cliente.setEstatus(resultSet.getString("estatus"));
                    
                     //Por cada fila creamos una nueva coleccion
                    coleccion.put(columId, String.valueOf(resultSet.getInt("Id")));
                    coleccion.put(columRfc, cliente.getRfc());
                    coleccion.put(columNombre, cliente.getNombre());
                    coleccion.put(columApelledoP,cliente.getApellidoPaterno());
                    coleccion.put(columApellidoM,cliente.getApellidoMaterno()); 
                    coleccion.put(columNumeroT,cliente.getNumeroTelefonico()); 
                    coleccion.put(columCorreo,cliente.getCorreo()); 
                    coleccion.put(columCalle,cliente.getCalle()); 
                    coleccion.put(columNumeroE,cliente.getNumeroExterior()); 
                    coleccion.put(columNumeroI,cliente.getNumeroInterior()); 
                    coleccion.put(columCodigoP,cliente.getCodigoPostal()); 
                    coleccion.put(columColonia,cliente.getColonia()); 
                    coleccion.put(columMunicipio,cliente.getMunicipio()); 
                    coleccion.put(columEstado,cliente.getEstado()); 
                    coleccion.put(columPais,cliente.getPais()); 
                    coleccion.put(columFechaR,cliente.getFechaRegistro()); 
                    coleccion.put(columEstatus,cliente.getEstatus()); 
                    clientesList.add(cliente);
                }   
                resultSet.close();
                consulta.close();
            } catch (SQLException e){
                Mensaje.notificar(Alert.AlertType.ERROR, "mysql", "AgregarClienteControlador dice:", e.getMessage());
            }
            return clientesList;
        }
    
     private void llenarTabla (){
            ObservableList<Cliente> lista = getTodosClientes();
            this.colId.setCellFactory(new MapValueFactory(columId));
            this.colRFC.setCellFactory(new MapValueFactory(columRfc));
            this.colNombre.setCellFactory(new MapValueFactory(columNombre));
            this.colApellidoP.setCellFactory(new MapValueFactory(columApelledoP));
            this.colApellidoM.setCellFactory(new MapValueFactory(columApellidoM)); 
            this.colNumeroT.setCellFactory(new MapValueFactory(columNumeroT)); 
            this.colCorreo.setCellFactory(new MapValueFactory(columCorreo)); 
            this.colCalle.setCellFactory(new MapValueFactory(columCalle)); 
            this.colNumeroE.setCellFactory(new MapValueFactory(columNumeroE)); 
            this.colNumeroI.setCellFactory(new MapValueFactory(columNumeroI)); 
            this.colCodigoP.setCellFactory(new MapValueFactory(columCodigoP)); 
            this.colColonia.setCellFactory(new MapValueFactory(columColonia)); 
            this.colMunicipio.setCellFactory(new MapValueFactory(columMunicipio)); 
            this.colEstado.setCellFactory(new MapValueFactory(columEstado)); 
            this.colPais.setCellFactory(new MapValueFactory(columPais)); 
            this.colFechaRegistro.setCellFactory(new MapValueFactory(columFechaR)); 
            this.colEstatus.setCellFactory(new MapValueFactory(columEstatus)); 
            
            this.tblClientes.setItems(lista);
     }

    @FXML
    private void desplegarBusqueda(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("buscarCliente.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
        
    }
     
     

