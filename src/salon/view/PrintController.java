package salon.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import salon.Main;
import salon.model.*;
import salon.util.BooleanWrapper;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class PrintController implements Initializable {
    @FXML
    public DatePicker datePicker;

    @FXML
    public Button cancelButton;

    @FXML
    public Button printButton;

    @FXML
    public Label titleLabel;

    @FXML
    public Label askingLabel;

    @FXML
    public TextField reasonTextField;

    @FXML
    public Button okButton;

    private LocalDate selectedDate;

    private Main main;

    public PrintController() {
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setOnAction(event -> handleDatePicker());
    }

    public void handleDatePicker() {
        selectedDate = datePicker.getValue();

        if(selectedDate.getDayOfMonth() <= 15) {
            titleLabel.setText("FIRST HAFT " + selectedDate.getMonth().toString() + "/" +
                    selectedDate.getYear() + " FINANCIAL REPORT");

            ArrayList<Date> dates = new ArrayList<>();

            Boolean[] isExists = new Boolean[15];

            String[] reasons = new String[15];

            for(int i = 0; i < isExists.length; i++) {
                LocalDate thisLocalDate = LocalDate.of(selectedDate.getYear(), selectedDate.getMonthValue(), i + 1);

                System.out.println("Date: " + thisLocalDate);

                if(main.checkForFile(thisLocalDate)) {
                    isExists[i] = true;
                    Date thisDate = new Date();
                    main.readInformation(thisLocalDate,thisDate);
                    dates.add(thisDate);
                }
                else {
                    isExists[i] = false;
                    Date emptyDate = new Date();
                    dates.add(emptyDate);
                }
                System.out.println(isExists[i]);
            }

            for(int i = 0; i < 15; i++) {
                System.out.println(dates.get(i).getDate());
            }

        }
        else {
            titleLabel.setText("SECOND HAFT " + selectedDate.getMonth().toString() + " FINANCIAL REPORT");

        }
    }

    public Boolean isReady (Boolean[] isExists) {
        for (Boolean value : isExists) {
            if (!value)
                return false;
        }
        return true;
    }

    @FXML
    public void handleCancelButton() {
        titleLabel.setText("");
        askingLabel.setText("");
        reasonTextField.setText("");
        reasonTextField.setDisable(true);
        okButton.setDisable(true);

        main.secondatyStage.close();
    }
}
