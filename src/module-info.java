module workshopjavaFXJDBC {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires mysql.connector.java;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
	opens gui to javafx.fxml;
	opens model.entities to javafx.base;
}
