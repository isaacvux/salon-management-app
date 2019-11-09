package salon.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import salon.Main;
import salon.model.*;
import salon.util.BooleanWrapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class PrintController implements Initializable {
    private int dateIndex;

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

    private int numOfDays;

    private ArrayList<Date> dates = new ArrayList<>();;

    private Boolean[] isExists;

    private String[] reasons;

    private String tittle;

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
            tittle = "FIRST HAFT " + selectedDate.getMonth().toString() + " " +
                    selectedDate.getYear() + " FINANCIAL REPORT";
            titleLabel.setText(tittle);

            numOfDays = 15;

            isExists = new Boolean[numOfDays];
            reasons = new String[numOfDays];

            readDatesDataFromFiles();
            askForReason();

            if(isReady(isExists)) {
                printButton.setDisable(false);
            }
        }
        else {
            tittle = "SECOND HAFT " + selectedDate.getMonth().toString() + " " +
                    selectedDate.getYear() + " FINANCIAL REPORT";
            titleLabel.setText(tittle);

        }
    }

    @FXML
    public void handleOkButton() {
        reasons[dateIndex] = reasonTextField.getText();

        isExists[dateIndex] = true;

        reasonTextField.clear();
        reasonTextField.setPromptText("Enter the reason here");

        askForReason();

        if(isReady(isExists)) {
            askingLabel.setText("All set!");
            reasonTextField.setVisible(false);
            okButton.setVisible(false);
            printButton.setDisable(false);
        }
    }

    public void readDatesDataFromFiles() {
        for(int i = 0; i < numOfDays; i++) {

            LocalDate thisLocalDate = LocalDate.of(selectedDate.getYear(), selectedDate.getMonthValue(), i + 1);

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
        }
    }

    public void askForReason() {
        for(int i = 0; i < numOfDays; i++) {
            if(isExists[i] == false) {
                askingLabel.setText("Why you closed on " + (i + 1) + " " + selectedDate.getMonth() + "?");
                dateIndex = i;
                reasonTextField.setVisible(true);
                reasonTextField.setPromptText("Enter the reason here");
                okButton.setVisible(true);
                break;
            }
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
    public void handlePrintButton() {
        try {
            FileWriter writer = new FileWriter(main.fileDirectory + tittle + ".txt");

            // Check point
            System.out.println("\nWriting haft-monthly report to file...");

            writer.write(tittle + "\n");

//            writeForThisPerson(writer, "Isaac");

            int prefIndex = 0;

            for(int i = 0; i < numOfDays; i++) {
                if(reasons[i] == null) {
                    prefIndex = i;
                }
            }

            // num of X need to be checked
            for(int x = 0; x < 11; x++) {
                writer.write("...........................");
                writer.write(dates.get(prefIndex).getPersons().get(x).getFirstName() + "\n");
                writer.write("Date\t\tBase\tTip\n");

                for(int y = 0; y < numOfDays; y++) {
                    if(reasons[y] == null) {
                        if(dates.get(y).getPersons().get(x).getIndex() == -1) {
                            writer.write(dates.get(y).getDate() + "\tAbsented\n");
                        }
                        else {
                            writer.write(dates.get(y).getDate() + "\t" + dates.get(y).getPersons().get(x).getTotal() + "\t" + dates.get(x).getPersons().get(1).getTip() + "\n");
                        }
                    }
                    else {
                        writer.write(reasons[y] + "\n");
                    }
                }
                writer.write("\n\n");
            }

            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeForThisPerson(FileWriter writer, String firstName) {
        try {
            writer.write(firstName + "\n");
            writer.write("Date\tBase\tTip\n");
            for (int i = 0; i < numOfDays; i++) {
                if(reasons[i] == null) {
                    for (int j = 0; j < dates.get(0).getPersons().size(); j++) {
                        if (dates.get(i).getPersons().get(j).getFirstName().equals(firstName)) {
                            if (dates.get(i).getPersons().get(j).getIndex() != -1) {
                                writer.write(dates.get(i).getDate() + "\t" + dates.get(i).getPersons().get(j).getTotal() + "\t" + dates.get(i).getPersons().get(j).getTip() + "\n");
                            } else {
                                writer.write(dates.get(i).getDate() + "\tAbsented\n");
                            }
                        }
                    }
                }
                else {
                    writer.write(reasons[i] + "\n");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void handleCancelButton() {
        titleLabel.setText("");
        askingLabel.setText("");
        reasonTextField.clear();
        reasonTextField.setVisible(false);
        okButton.setVisible(false);

        main.secondatyStage.close();
    }
}
