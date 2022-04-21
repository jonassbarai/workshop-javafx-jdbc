package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentServices;

public class DepartmentListController implements Initializable {

	private DepartmentServices service;

	@FXML
	private TableView<Department> tableViewDepartments;
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	@FXML
	private TableColumn<Department, String> TableColumnName;
	@FXML
	private Button btNew;

	private ObservableList<Department> obsList;

	@FXML
	public void onBtNewAction() {
		System.out.println("on btnewAction");
	}

	public void setDepartmenService(DepartmentServices service) {
		this.service = service;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		inicializeNodes();

	}

	private void inicializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		TableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		// tableView acompanhar altura da janela
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartments.prefHeightProperty().bind(stage.heightProperty());
	}

	public void updateObservableList() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.findall();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartments.setItems(obsList);

	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.findall();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartments.setItems(obsList);
	}
}
