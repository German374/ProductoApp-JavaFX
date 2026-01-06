package productoapp;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductoController implements Initializable
{
    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, Integer> colId;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, String> colCategoria;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, LocalDate> colFecha;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private ComboBox<String> cmbCategoria;

    @FXML
    private TextField txtPrecio;

    @FXML
    private DatePicker dpFecha;

    private ObservableList<Producto> listaProductos;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        colId.setCellValueFactory(
            new PropertyValueFactory<>("id")
        );

        colNombre.setCellValueFactory(
            new PropertyValueFactory<>("nombre")
        );

        colCategoria.setCellValueFactory(
            new PropertyValueFactory<>("categoria")
        );

        colPrecio.setCellValueFactory(
            new PropertyValueFactory<>("precio")
        );

        colFecha.setCellValueFactory(
            new PropertyValueFactory<>("fecha")
        );

        listaProductos = FXCollections.observableArrayList();
        tablaProductos.setItems(listaProductos);

        cmbCategoria.getItems().addAll(
            "Alimentos",
            "Tecnología",
            "Ropa"
        );

        // Al seleccionar un producto se cargan los datos en los campos
        tablaProductos.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldSelection, newSelection) ->
            {
                if (newSelection != null)
                {
                    txtId.setText(String.valueOf(newSelection.getId()));
                    txtNombre.setText(newSelection.getNombre());
                    cmbCategoria.setValue(newSelection.getCategoria());
                    txtPrecio.setText(String.valueOf(newSelection.getPrecio()));
                    dpFecha.setValue(newSelection.getFecha());
                }
            }
        );
    }

    // Botón nuevo
    @FXML
    private void nuevo()
    {
        limpiar();
        tablaProductos.getSelectionModel().clearSelection();
    }

    // Botón guaradar
    @FXML
    private void guardar()
    {
        Producto p = new Producto(
            Integer.parseInt(txtId.getText()),
            txtNombre.getText(),
            cmbCategoria.getValue(),
            Double.parseDouble(txtPrecio.getText()),
            dpFecha.getValue()
        );

        listaProductos.add(p);
        limpiar();
    }

    // Botón editar
    @FXML
    private void editar()
    {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();

        if (seleccionado != null)
        {
            seleccionado.setId(
                Integer.parseInt(txtId.getText())
            );

            seleccionado.setNombre(
                txtNombre.getText()
            );

            seleccionado.setCategoria(
                cmbCategoria.getValue()
            );

            seleccionado.setPrecio(
                Double.parseDouble(txtPrecio.getText())
            );

            seleccionado.setFecha(
                dpFecha.getValue()
            );

            tablaProductos.refresh();
            limpiar();
        }
    }

    // Boton eliminar
    @FXML
    private void eliminar()
    {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();

        if (seleccionado != null)
        {
            listaProductos.remove(seleccionado);
            limpiar();
        }
    }

    // Botón limpiar
    @FXML
    private void limpiar()
    {
        txtId.clear();
        txtNombre.clear();
        txtPrecio.clear();
        cmbCategoria.getSelectionModel().clearSelection();
        dpFecha.setValue(null);
    }
}



