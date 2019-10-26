package salon.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import salon.Main;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class PreferencesController implements Initializable {

    @FXML
    public Button cancelButton;

    @FXML
    public Button okButton;

    @FXML
    public Button fileButton;

    @FXML
    public Label warningLabel;

    public FileChooser fileChooser = new FileChooser();

    private Main main;

    public PreferencesController() {}

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void handleFileButton() {
        try {
            warningLabel.setText("no files selected");

            // get the file selected
            File file = fileChooser.showOpenDialog(main.secondatyStage);

            if (file != null) {
                warningLabel.setText(file.getAbsolutePath() + "  selected");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void handleCancelButton() {
        main.secondatyStage.close();
    }

    @FXML
    public void handleOKButton() {
        main.secondatyStage.close();
    }

}
