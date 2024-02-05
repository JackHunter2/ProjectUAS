/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DashboardFXMLController implements Initializable {

    @FXML
    private Label name;
    @FXML
    private Button Logout;
    @FXML
    private BorderPane dashboard_form;
    @FXML
    private Button btnFood;
    @FXML
    private Button btnDrink;
    @FXML
    private Button btnOrder;
    @FXML
    private AnchorPane FoodMenu;
    @FXML
    private AnchorPane DrinkMenu;
    @FXML
    private AnchorPane Order;
    @FXML
    private StackPane MainPanel;
    @FXML
    private Button addBurger;
    @FXML
    private Spinner<Integer> qtyBurger;    
    @FXML
    private Label Burger;
    @FXML
    private Label priceBurger;
    @FXML
    private TableView<productData> tableOrder;
    @FXML
    private TableColumn<productData, String> tableOrder_prodName;
    @FXML
    private TableColumn<productData, String> tableOrder_qty;
    @FXML
    private TableColumn<productData, String> tableOrder_price;
    
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;    
    
    private SpinnerValueFactory<Integer> spin;
    @FXML
    private Label Total;
    @FXML
    private Label Return;
    @FXML
    private TextField Cash;
    @FXML
    private Button Pay;
    @FXML
    private Button Remove;
    @FXML
    private Label Pizza;
    @FXML
    private Label pricePizza;
    @FXML
    private Spinner<Integer> qtyPizza;
    @FXML
    private Button addPizza;
    @FXML
    private Button clearBtn;
    private Spinner<Integer> changeQty;
    @FXML
    private Label Fries;
    @FXML
    private Label priceFries;
    @FXML
    private Spinner<Integer> qtyFries;
    @FXML
    private Button addFries;
    @FXML
    private Label hotdog;
    @FXML
    private Label priceHotdog;
    @FXML
    private Spinner<Integer> qtyHotdog;
    @FXML
    private Button addHotdog;
    @FXML
    private Label FriedChicken;
    @FXML
    private Label priceFriedChicken;
    @FXML
    private Spinner<Integer> qtyFriedChicken;
    @FXML
    private Button addFriedChicken;
    @FXML
    private Label Kebab;
    @FXML
    private Label priceKebab;
    @FXML
    private Spinner<Integer> qtyKebab;
    @FXML
    private Button addKebab;
    @FXML
    private Label Cola;
    @FXML
    private Label priceCola;
    @FXML
    private Spinner<Integer> qtyCola;
    @FXML
    private Button addCola;
    @FXML
    private Label AvocadoJuice;
    @FXML
    private Label priceAvocadoJuice;
    @FXML
    private Spinner<Integer> qtyAvocadoJuice;
    @FXML
    private Button addAvocadoJuice;
    @FXML
    private Label IcedCoffe;
    @FXML
    private Label priceIcedCoffe;
    @FXML
    private Spinner<Integer> qtyIcedCoffe;
    @FXML
    private Button addIcedCoffe;
    @FXML
    private Label DragonFruit;
    @FXML
    private Label priceDragonFruit;
    @FXML
    private Spinner<Integer> qtyDragonFruit;
    @FXML
    private Button addDragonFruit;
    @FXML
    private Label BrownSugar;
    @FXML
    private Label priceBrownSugar;
    @FXML
    private Spinner<Integer> qtyBrownSugar;
    @FXML
    private Button addBrownSugar;
    @FXML
    private Label RedVelvet;
    @FXML
    private Label priceRedVelvet;
    @FXML
    private Spinner<Integer> qtyRedVelvet;
    @FXML
    private Button addRedVelvet;
    @FXML
    private Button updateBurger;
    @FXML
    private Button updatePizza;
    @FXML
    private Button updateFries;
    @FXML
    private Button updateHotdog;
    @FXML
    private Button updateFriedC;
    @FXML
    private Button updateKebab;
    @FXML
    private Button updateICol;
    @FXML
    private Button updateIAvo;
    @FXML
    private Button updateIce;
    @FXML
    private Button updateIDra;
    @FXML
    private Button updateIBro;
    @FXML
    private Button updateRed;
    @FXML
    private Button aboutBtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            menuGetTotal();
            menuDisplayTotal();
            menuGetOrder();
            menuShowOrderData();
            displayUsername();
            
            setQuantity();
            setQuantityP();
            setQuantityR();
            setQuantityBr();
            setQuantityD();
            setQuantityI();
            setQuantityA();
            setQuantityCo();
            setQuantityK();
            setQuantityFr();
            setQuantityH();
            setQuantityF();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void LogoutAction(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                dashboard_form.getScene().getWindow().hide();

                // LINK YOUR LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
        }
    }

    @FXML
    private void btnFoodAction(ActionEvent event) {
        FoodMenu.setVisible(true);
        DrinkMenu.setVisible(false);
        Order.setVisible(false);
    }

    @FXML
    private void btnDrinkAction(ActionEvent event) {
        FoodMenu.setVisible(false);
        DrinkMenu.setVisible(true);
        Order.setVisible(false);
    }

    @FXML
    private void btnOrderAction(ActionEvent event) throws SQLException {
        FoodMenu.setVisible(false);
        DrinkMenu.setVisible(false);
        Order.setVisible(true);
        
        menuShowOrderData();
    }       
    private int qty;
        
    public void setQuantity() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        qtyBurger.setValueFactory(spin);
    }
    private double totalB;
    @FXML
    private void addBurgerAction(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qty = qtyBurger.getValue();        
        connect = DataBase.connectDB();
        if (!ExistsInTable(Burger.getText())) {
        String insertData = "INSERT INTO product "
                            + "(prod_id, prod_name, quantity, price, date) "
                            + "VALUES(?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(data.cID));
                    prepare.setString(2, Burger.getText());
                    prepare.setString(3, String.valueOf(qty));

                    String hargaString = priceBurger.getText();
                    double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
                    totalB = (qty * harga);
                    prepare.setString(4, String.valueOf(totalB));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    
                    alert.successMessage("Successfully Added!");
                    
                    menuGetTotal();
                    menuDisplayTotal();
        } else {
            alert.errorMessage("This food already exists in the table!");
        }
    }

    @FXML
    private void updateBurgerAction(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qty = qtyBurger.getValue();
        connect = DataBase.connectDB();
        
        String updateQuery = "UPDATE product "
                            + "SET quantity = ?, price = ?, date = ? "
                            + "WHERE prod_name = ?";
            
            PreparedStatement preparedStatement = connect.prepareStatement(updateQuery); 
            preparedStatement.setInt(1, qty);

            String hargaString = priceBurger.getText();
            double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
            totalB = (qty * harga);
            preparedStatement.setDouble(2, totalB);

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, Burger.getText());

            preparedStatement.executeUpdate();
                    
            alert.successMessage("Successfully Update!");
            
            menuGetTotal();
            menuDisplayTotal();
    }
    
    public ObservableList<productData> menuGetOrder() throws SQLException {
        
        ObservableList<productData> listData = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM product";
        
        connect = DataBase.connectDB();

        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();
            
            productData prodData;
            
            while (result.next()) {
                prodData = new productData(result.getInt("id"),
                        result.getString("prod_id"),
                        result.getString("prod_name"),
                        result.getInt("quantity"),
                        result.getDouble("price"),
                        result.getDate("date"));
                
                listData.add(prodData);
                
            }         
        return listData;
    }
    
    private ObservableList<productData> menuOrderListData;
    
    public void menuShowOrderData() throws SQLException {
        menuOrderListData = menuGetOrder();
        
        tableOrder_prodName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tableOrder_qty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tableOrder_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        tableOrder.setItems(menuOrderListData);
    }
    private int getid;

    @FXML
    private void menuSelectOrder(MouseEvent event) {
        productData prod = tableOrder.getSelectionModel().getSelectedItem();
        int num = tableOrder.getSelectionModel().getSelectedIndex();
        
        if ((num - 1) < -1) {
            return;
        }
        // TO GET THE ID PER ORDER
        getid = prod.getId();
    }
    
    private double totalS;
    
    public void menuGetTotal() throws SQLException {
        customerID();
        String total = "SELECT SUM(price) FROM product WHERE prod_id = " + cID;
        
        connect = DataBase.connectDB();

            prepare = connect.prepareStatement(total);
            result = prepare.executeQuery();
            
            if (result.next()) {
                totalS = result.getDouble("SUM(price)");
            }
    }
    
    public void menuDisplayTotal() throws SQLException {
        menuGetTotal();
        Total.setText("Rp." + totalS);
    }
    
    private int cID;
    
    public void customerID() throws SQLException {
        
        String sql = "SELECT MAX(prod_id) FROM product";
        connect = DataBase.connectDB();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if (result.next()) {
                cID = result.getInt("MAX(prod_id)");
            }
            if (cID == 0) {
                cID += 1;
            } else{
            }
            
            data.cID = cID;
    }
    
    private double amount;
    private double change;
    
    public void menuAmount() throws SQLException {
        menuGetTotal();
        if (Cash.getText().isEmpty() || totalS == 0) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid :3");
            alert.showAndWait();
        } else {
            amount = Double.parseDouble(Cash.getText());
            if (amount < totalS) {
                Cash.setText("");
            } else {
                change = (amount - totalP);
                Return.setText("Rp" + change);
            }
        }
    }

    @FXML
    private void PayAction(ActionEvent event) throws SQLException, JRException {
        menuAmount();
        if (totalS == 0 || Cash.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setContentText("Please order first");
            alert.showAndWait();
        } else {
            HashMap map = new HashMap();
            map.put("getReceipt", (cID - 1));
            
                JasperDesign jDesign = JRXmlLoader.load("C:\\Users\\user\\Documents\\NetBeansProjects\\JavaFXProject\\report2.jrxml");
                JasperReport jReport = JasperCompileManager.compileReport(jDesign);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, map, connect);
                
                JasperViewer.viewReport(jPrint, false);
        }
    }

    @FXML
    private void RemoveAction(ActionEvent event) throws SQLException {
        if (getid == 0) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the order you want to remove");
            alert.showAndWait();
        } else {
            String deleteData = "DELETE FROM product WHERE id = " + getid;
            connect = DataBase.connectDB();
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete this order?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.executeUpdate();
                }
                
                menuShowOrderData();
                menuGetTotal();
                menuDisplayTotal();
        }
    }
    
    public void setQuantityP() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        qtyPizza.setValueFactory(spin);
    }
    
    private int qtyP;
    private double totalP;

    @FXML
    private void addPizzabtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyP = qtyPizza.getValue();        
        connect = DataBase.connectDB();
        if (!ExistsInTable(Pizza.getText())) {
        String insertData = "INSERT INTO product "
                            + "(prod_id, prod_name, quantity, price, date) "
                            + "VALUES(?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(data.cID));
                    prepare.setString(2, Pizza.getText());
                    prepare.setString(3, String.valueOf(qtyP));

                    String hargaString = pricePizza.getText();
                    double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
                    totalP = (qtyP * harga);
                    prepare.setString(4, String.valueOf(totalP));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    
                    alert.successMessage("Successfully Added!");
                    
                    menuGetTotal();
                    menuDisplayTotal();
        } else {
            alert.errorMessage("This food already exists in the table!");
        }
    }

    @FXML
    private void clearBtnAction(ActionEvent event) throws SQLException {
        String deleteAllData = "TRUNCATE TABLE product";
        connect = DataBase.connectDB();

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete all orders?");
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get().equals(ButtonType.OK)) {
            prepare = connect.prepareStatement(deleteAllData);
            prepare.executeUpdate();
            
            Cash.setText("");
            Return.setText("Rp.0");         
        }

        menuShowOrderData();
        menuGetTotal();
        menuDisplayTotal();
    }
    
    public void setQuantityF() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        qtyFries.setValueFactory(spin);
    }
    
    private int qtyF;
    private double totalF;

    @FXML
    private void addFriesBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyF = qtyFries.getValue();        
        connect = DataBase.connectDB();
        if (!ExistsInTable(Fries.getText())) {
        String insertData = "INSERT INTO product "
                            + "(prod_id, prod_name, quantity, price, date) "
                            + "VALUES(?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(data.cID));
                    prepare.setString(2, Fries.getText());
                    prepare.setString(3, String.valueOf(qtyF));

                    String hargaString = priceFries.getText();
                    double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
                    totalF = (qtyF * harga);
                    prepare.setString(4, String.valueOf(totalF));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    
                    alert.successMessage("Successfully Added!");
                    
                    menuGetTotal();
                    menuDisplayTotal();
        } else {
            alert.errorMessage("This food already exists in the table!");
        }
    }
    
    public void setQuantityH() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        qtyHotdog.setValueFactory(spin);
    }
    
    private int qtyH;
    private double totalH;

    @FXML
    private void addHotdogBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyH = qtyHotdog.getValue();        
        connect = DataBase.connectDB();
        if (!ExistsInTable(hotdog.getText())) {
        String insertData = "INSERT INTO product "
                            + "(prod_id, prod_name, quantity, price, date) "
                            + "VALUES(?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(data.cID));
                    prepare.setString(2, hotdog.getText());
                    prepare.setString(3, String.valueOf(qtyH));

                    String hargaString = priceHotdog.getText();
                    double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
                    totalH = (qtyH * harga);
                    prepare.setString(4, String.valueOf(totalH));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    
                    alert.successMessage("Successfully Added!");
                    
                    menuGetTotal();
                    menuDisplayTotal();
        } else {
            alert.errorMessage("This food already exists in the table!");
        }
    }
    
    public void setQuantityFr() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        qtyFriedChicken.setValueFactory(spin);
    }
    
    private int qtyFr;
    private double totalFr;

    @FXML
    private void addFriedChickenBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyFr = qtyFriedChicken.getValue();        
        connect = DataBase.connectDB();
        if (!ExistsInTable(FriedChicken.getText())) {
        String insertData = "INSERT INTO product "
                            + "(prod_id, prod_name, quantity, price, date) "
                            + "VALUES(?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(data.cID));
                    prepare.setString(2, FriedChicken.getText());
                    prepare.setString(3, String.valueOf(qtyFr));

                    String hargaString = priceFriedChicken.getText();
                    double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
                    totalFr = (qtyFr * harga);
                    prepare.setString(4, String.valueOf(totalFr));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    
                    alert.successMessage("Successfully Added!");
                    
                    menuGetTotal();
                    menuDisplayTotal();
        } else {
            alert.errorMessage("This food already exists in the table!");
        }
                    
    }
    
    public void setQuantityK() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        qtyKebab.setValueFactory(spin);
    }
    
    private int qtyK;
    private double totalK;

    @FXML
    private void addKebabBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyK = qtyKebab.getValue();        
        connect = DataBase.connectDB();
        if (!ExistsInTable(Kebab.getText())) {
        String insertData = "INSERT INTO product "
                            + "(prod_id, prod_name, quantity, price, date) "
                            + "VALUES(?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(data.cID));
                    prepare.setString(2, Kebab.getText());
                    prepare.setString(3, String.valueOf(qtyK));

                    String hargaString = priceKebab.getText();
                    double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
                    totalK = (qtyK * harga);
                    prepare.setString(4, String.valueOf(totalK));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    
                    alert.successMessage("Successfully Added!");
                    
                    menuGetTotal();
                    menuDisplayTotal();
        } else {
            alert.errorMessage("This food already exists in the table!");
        }
    }
    
    public void setQuantityCo() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        qtyCola.setValueFactory(spin);
    }
    
    private int qtyCo;
    private double totalCo;

    @FXML
    private void addColaBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyCo = qtyCola.getValue();        
        connect = DataBase.connectDB();
        if (!ExistsInTable(Cola.getText())) {
        String insertData = "INSERT INTO product "
                            + "(prod_id, prod_name, quantity, price, date) "
                            + "VALUES(?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(data.cID));
                    prepare.setString(2, Cola.getText());
                    prepare.setString(3, String.valueOf(qtyCo));

                    String hargaString = priceCola.getText();
                    double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
                    totalCo = (qtyCo * harga);
                    prepare.setString(4, String.valueOf(totalCo));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    
                    alert.successMessage("Successfully Added!");
                    
                    menuGetTotal();
                    menuDisplayTotal();
        } else {
            alert.errorMessage("This drink already exists in the table!");
        }
    }
    
    public void setQuantityA() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        qtyAvocadoJuice.setValueFactory(spin);
    }
    
    private int qtyA;
    private double totalA;

    @FXML
    private void addAvocadoJuiceBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyA = qtyAvocadoJuice.getValue();        
        connect = DataBase.connectDB();
        if (!ExistsInTable(AvocadoJuice.getText())) {
        String insertData = "INSERT INTO product "
                            + "(prod_id, prod_name, quantity, price, date) "
                            + "VALUES(?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(data.cID));
                    prepare.setString(2, AvocadoJuice.getText());
                    prepare.setString(3, String.valueOf(qtyA));

                    String hargaString = priceAvocadoJuice.getText();
                    double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
                    totalA = (qtyA * harga);
                    prepare.setString(4, String.valueOf(totalA));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    
                    alert.successMessage("Successfully Added!");
                    
                    menuGetTotal();
                    menuDisplayTotal();
        } else {
            alert.errorMessage("This drink already exists in the table!");
        }
    }
    
    public void setQuantityI() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        qtyIcedCoffe.setValueFactory(spin);
    }
    
    private int qtyI;
    private double totalI;

    @FXML
    private void addIcedCoffeBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyI = qtyIcedCoffe.getValue();        
        connect = DataBase.connectDB();
        if (!ExistsInTable(IcedCoffe.getText())) {
        String insertData = "INSERT INTO product "
                            + "(prod_id, prod_name, quantity, price, date) "
                            + "VALUES(?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(data.cID));
                    prepare.setString(2, IcedCoffe.getText());
                    prepare.setString(3, String.valueOf(qtyI));

                    String hargaString = priceIcedCoffe.getText();
                    double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
                    totalI = (qtyI * harga);
                    prepare.setString(4, String.valueOf(totalI));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    
                    alert.successMessage("Successfully Added!");
                    
                    menuGetTotal();
                    menuDisplayTotal();
        } else {
            alert.errorMessage("This drink already exists in the table!");
        }
    }
    
    public void setQuantityD() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        qtyDragonFruit.setValueFactory(spin);
    }
    
    private int qtyD;
    private double totalD;

    @FXML
    private void addDragonFruitBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyD = qtyDragonFruit.getValue();        
        connect = DataBase.connectDB();
        if (!ExistsInTable(DragonFruit.getText())) {
        String insertData = "INSERT INTO product "
                            + "(prod_id, prod_name, quantity, price, date) "
                            + "VALUES(?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(data.cID));
                    prepare.setString(2, DragonFruit.getText());
                    prepare.setString(3, String.valueOf(qtyD));

                    String hargaString = priceDragonFruit.getText();
                    double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
                    totalD = (qtyD * harga);
                    prepare.setString(4, String.valueOf(totalD));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    
                    alert.successMessage("Successfully Added!");
                    
                    menuGetTotal();
                    menuDisplayTotal();
        } else {
            alert.errorMessage("This drink already exists in the table!");
        }
    }
    
    public void setQuantityBr() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        qtyBrownSugar.setValueFactory(spin);
    }
    
    private int qtyBr;
    private double totalBr;

    @FXML
    private void addBrownSugarBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyBr = qtyBrownSugar.getValue();        
        connect = DataBase.connectDB();
        if (!ExistsInTable(BrownSugar.getText())) {
        String insertData = "INSERT INTO product "
                            + "(prod_id, prod_name, quantity, price, date) "
                            + "VALUES(?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(data.cID));
                    prepare.setString(2, BrownSugar.getText());
                    prepare.setString(3, String.valueOf(qtyBr));

                    String hargaString = priceBrownSugar.getText();
                    double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
                    totalBr = (qtyBr * harga);
                    prepare.setString(4, String.valueOf(totalBr));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    
                    alert.successMessage("Successfully Added!");
                    
                    menuGetTotal();
                    menuDisplayTotal();
        } else {
            alert.errorMessage("This drink already exists in the table!");
        }
    }
    
    public void setQuantityR() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        qtyRedVelvet.setValueFactory(spin);
    }
    
    private int qtyR;
    private double totalR;

    @FXML
    private void addRedVelvetBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyR = qtyRedVelvet.getValue();        
        connect = DataBase.connectDB();
        if (!ExistsInTable(RedVelvet.getText())) {
        String insertData = "INSERT INTO product "
                            + "(prod_id, prod_name, quantity, price, date) "
                            + "VALUES(?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(data.cID));
                    prepare.setString(2, RedVelvet.getText());
                    prepare.setString(3, String.valueOf(qtyR));

                    String hargaString = priceRedVelvet.getText();
                    double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
                    totalR = (qtyR * harga);
                    prepare.setString(4, String.valueOf(totalR));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    
                    alert.successMessage("Successfully Added!");
                    
                    menuGetTotal();
                    menuDisplayTotal();
        } else {
            alert.errorMessage("This drink already exists in the table!");
        }
    }
    
    private boolean ExistsInTable(String Name) throws SQLException {
        String query = "SELECT * FROM product WHERE prod_name = ?";
        try (PreparedStatement checkStatement = connect.prepareStatement(query)) {
            checkStatement.setString(1, Name);
            ResultSet resultSet = checkStatement.executeQuery();
            return resultSet.next();
        }
    }
    
    public void displayUsername() {
        
        String user = data.username;
        user = user.substring(0, 1).toUpperCase() + user.substring(1);
        
        name.setText("Welcome, " + user);
        
    }

    @FXML
    private void updatePizzaBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyP = qtyPizza.getValue();
        connect = DataBase.connectDB();
        
        String updateQuery = "UPDATE product "
                            + "SET quantity = ?, price = ?, date = ? "
                            + "WHERE prod_name = ?";
            
            PreparedStatement preparedStatement = connect.prepareStatement(updateQuery); 
            preparedStatement.setInt(1, qtyP);

            String hargaString = pricePizza.getText();
            double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
            totalP = (qtyP * harga);
            preparedStatement.setDouble(2, totalP);

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, Pizza.getText());

            preparedStatement.executeUpdate();
                    
            alert.successMessage("Successfully Update!");
            
            menuGetTotal();
            menuDisplayTotal();
    }

    @FXML
    private void updateFriesBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyF = qtyFries.getValue();
        connect = DataBase.connectDB();
        
        String updateQuery = "UPDATE product "
                            + "SET quantity = ?, price = ?, date = ? "
                            + "WHERE prod_name = ?";
            
            PreparedStatement preparedStatement = connect.prepareStatement(updateQuery); 
            preparedStatement.setInt(1, qtyF);

            String hargaString = priceFries.getText();
            double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
            totalF = (qtyF * harga);
            preparedStatement.setDouble(2, totalF);

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, Fries.getText());

            preparedStatement.executeUpdate();
                    
            alert.successMessage("Successfully Update!");
            
            menuGetTotal();
            menuDisplayTotal();
    }

    @FXML
    private void updateHotdogBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyH = qtyHotdog.getValue();
        connect = DataBase.connectDB();
        
        String updateQuery = "UPDATE product "
                            + "SET quantity = ?, price = ?, date = ? "
                            + "WHERE prod_name = ?";
            
            PreparedStatement preparedStatement = connect.prepareStatement(updateQuery); 
            preparedStatement.setInt(1, qtyH);

            String hargaString = priceHotdog.getText();
            double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
            totalH = (qtyH * harga);
            preparedStatement.setDouble(2, totalH);

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, hotdog.getText());

            preparedStatement.executeUpdate();
                    
            alert.successMessage("Successfully Update!");
            
            menuGetTotal();
            menuDisplayTotal();
    }

    @FXML
    private void updateFriedCBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyFr = qtyFriedChicken.getValue();
        connect = DataBase.connectDB();
        
        String updateQuery = "UPDATE product "
                            + "SET quantity = ?, price = ?, date = ? "
                            + "WHERE prod_name = ?";
            
            PreparedStatement preparedStatement = connect.prepareStatement(updateQuery); 
            preparedStatement.setInt(1, qtyFr);

            String hargaString = priceFriedChicken.getText();
            double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
            totalFr = (qtyFr * harga);
            preparedStatement.setDouble(2, totalFr);

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, FriedChicken.getText());

            preparedStatement.executeUpdate();
                    
            alert.successMessage("Successfully Update!");
            
            menuGetTotal();
            menuDisplayTotal();
    }

    @FXML
    private void updateKebabBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyK = qtyKebab.getValue();
        connect = DataBase.connectDB();
        
        String updateQuery = "UPDATE product "
                            + "SET quantity = ?, price = ?, date = ? "
                            + "WHERE prod_name = ?";
            
            PreparedStatement preparedStatement = connect.prepareStatement(updateQuery); 
            preparedStatement.setInt(1, qtyK);

            String hargaString = priceKebab.getText();
            double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
            totalK = (qtyK * harga);
            preparedStatement.setDouble(2, totalK);

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, Kebab.getText());

            preparedStatement.executeUpdate();
                    
            alert.successMessage("Successfully Update!");
            
            menuGetTotal();
            menuDisplayTotal();
    }

    @FXML
    private void updateIColBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyCo = qtyCola.getValue();
        connect = DataBase.connectDB();
        
        String updateQuery = "UPDATE product "
                            + "SET quantity = ?, price = ?, date = ? "
                            + "WHERE prod_name = ?";
            
            PreparedStatement preparedStatement = connect.prepareStatement(updateQuery); 
            preparedStatement.setInt(1, qtyCo);

            String hargaString = priceCola.getText();
            double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
            totalCo = (qtyCo * harga);
            preparedStatement.setDouble(2, totalCo);

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, Cola.getText());

            preparedStatement.executeUpdate();
                    
            alert.successMessage("Successfully Update!");
            
            menuGetTotal();
            menuDisplayTotal();
    }

    @FXML
    private void updateIAvoBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyA = qtyAvocadoJuice.getValue();
        connect = DataBase.connectDB();
        
        String updateQuery = "UPDATE product "
                            + "SET quantity = ?, price = ?, date = ? "
                            + "WHERE prod_name = ?";
            
            PreparedStatement preparedStatement = connect.prepareStatement(updateQuery); 
            preparedStatement.setInt(1, qtyA);

            String hargaString = priceAvocadoJuice.getText();
            double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
            totalA = (qtyA * harga);
            preparedStatement.setDouble(2, totalA);

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, AvocadoJuice.getText());

            preparedStatement.executeUpdate();
                    
            alert.successMessage("Successfully Update!");
            
            menuGetTotal();
            menuDisplayTotal();
    }

    @FXML
    private void updateIceBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyI = qtyIcedCoffe.getValue();
        connect = DataBase.connectDB();
        
        String updateQuery = "UPDATE product "
                            + "SET quantity = ?, price = ?, date = ? "
                            + "WHERE prod_name = ?";
            
            PreparedStatement preparedStatement = connect.prepareStatement(updateQuery); 
            preparedStatement.setInt(1, qtyI);

            String hargaString = priceIcedCoffe.getText();
            double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
            totalI = (qtyI * harga);
            preparedStatement.setDouble(2, totalI);

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, IcedCoffe.getText());

            preparedStatement.executeUpdate();
                    
            alert.successMessage("Successfully Update!");
            
            menuGetTotal();
            menuDisplayTotal();
    }

    @FXML
    private void updateIDraBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyD = qtyDragonFruit.getValue();
        connect = DataBase.connectDB();
        
        String updateQuery = "UPDATE product "
                            + "SET quantity = ?, price = ?, date = ? "
                            + "WHERE prod_name = ?";
            
            PreparedStatement preparedStatement = connect.prepareStatement(updateQuery); 
            preparedStatement.setInt(1, qtyD);

            String hargaString = priceDragonFruit.getText();
            double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
            totalD = (qtyD * harga);
            preparedStatement.setDouble(2, totalD);

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, DragonFruit.getText());

            preparedStatement.executeUpdate();
                    
            alert.successMessage("Successfully Update!");
            
            menuGetTotal();
            menuDisplayTotal();
    }

    @FXML
    private void updateIBroBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyBr = qtyBrownSugar.getValue();
        connect = DataBase.connectDB();
        
        String updateQuery = "UPDATE product "
                            + "SET quantity = ?, price = ?, date = ? "
                            + "WHERE prod_name = ?";
            
            PreparedStatement preparedStatement = connect.prepareStatement(updateQuery); 
            preparedStatement.setInt(1, qtyBr);

            String hargaString = priceBrownSugar.getText();
            double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
            totalBr = (qtyBr * harga);
            preparedStatement.setDouble(2, totalBr);

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, BrownSugar.getText());

            preparedStatement.executeUpdate();
                    
            alert.successMessage("Successfully Update!");
            
            menuGetTotal();
            menuDisplayTotal();
    }

    @FXML
    private void updateRedBtn(ActionEvent event) throws SQLException {
        alertMessage alert = new alertMessage();
        qtyR = qtyRedVelvet.getValue();
        connect = DataBase.connectDB();
        
        String updateQuery = "UPDATE product "
                            + "SET quantity = ?, price = ?, date = ? "
                            + "WHERE prod_name = ?";
            
            PreparedStatement preparedStatement = connect.prepareStatement(updateQuery); 
            preparedStatement.setInt(1, qtyR);

            String hargaString = priceRedVelvet.getText();
            double harga = Double.parseDouble(hargaString.replace("Rp.", "").replace(",", ""));
            totalR = (qtyR * harga);
            preparedStatement.setDouble(2, totalR);

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, RedVelvet.getText());

            preparedStatement.executeUpdate();
                    
            alert.successMessage("Successfully Update!");
            
            menuGetTotal();
            menuDisplayTotal();
    }

    @FXML
    private void aboutBtnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AboutFXML.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.show();
    }
}