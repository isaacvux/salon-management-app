package salon.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import salon.Main;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HistoryController implements Initializable {

    private LocalDate selectedDate;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label warningLabel;

    @FXML
    private Button cancelButton;

    @FXML
    private Button okButton;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setOnAction(event -> handleDatePicker());
    }

    public void handleDatePicker() {
        selectedDate = datePicker.getValue();
        System.out.println("You selected: " + selectedDate);

        if(main.checkForFile(selectedDate)) {
            warningLabel.setText("I got your file.");
            okButton.setDisable(false);
        }
        else {
            warningLabel.setText("That date hasn't created yet.");
            okButton.setDisable(true);
        }
    }

    @FXML
    public void handleCancelButton() {
        warningLabel.setText("");
        main.secondatyStage.close();

    }

    @FXML
    public void handleOKButton() {
        System.out.println("Pressed OK");

        main.date.getPersons().clear();

        System.out.println("Check point after clear persons list: ");
        for(int i = 0; i < main.date.getPersons().size(); i ++) {
            System.out.println(main.date.getPersons().get(i).getFirstName());
        }

        System.out.println(">>> Done Check Point");

        main.tempLocalDate = selectedDate;

        warningLabel.setText("");

        main.readInformation(main.tempLocalDate, main.date);
        main.restoreGUI();

        main.primaryStage.setTitle("Oasis Nails : " + main.tempLocalDate);
        main.secondatyStage.close();
    }
}
