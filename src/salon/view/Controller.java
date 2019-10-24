package salon.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import salon.Main;
import javafx.scene.control.*;
import salon.model.Person;
import salon.model.Turn;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Boolean isAdjusted;

    @FXML
    public Button mainDashButton;

    @FXML
    public Button historyButton;

    @FXML
    public Button printButton;

    // Set 0
    @FXML
    public ComboBox comboBox_0;

    @FXML
    public Button addButton_0;

    @FXML
    public ListView listView_0a;

    @FXML
    public ListView listView_0b;

    @FXML
    public Label infoLabel_0;


    // Set 1
    @FXML
    public ComboBox comboBox_1;

    @FXML
    public Button addButton_1;

    @FXML
    public ListView listView_1a;

    @FXML
    public ListView listView_1b;

    @FXML
    public Label infoLabel_1;

    // Reference to the main application.
    private Main main;


    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    public Controller() {
    }

    public void setMain(Main main) {
        this.main = main;

        comboBox_0.setItems(main.date.getPersons());
        comboBox_0.setStyle("-fx-font-size : 18.0; -fx-font-weight: bold");
        comboBox_1.setItems(main.date.getPersons());
        comboBox_1.setStyle("-fx-font-size : 18.0; -fx-font-weight: bold");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // initialize method is called before setMain method

        isAdjusted = false;

        // Set 0
        comboBox_0.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> choosingName((Person) oldValue, (Person) newValue, 0, addButton_0, listView_0a, listView_0b, infoLabel_0));

        addButton_0.setOnAction(e -> handleAddTurnButton(0, infoLabel_0));

        listView_0a.setOnKeyPressed(e -> handleListView(e, listView_0a, main.tempPerson.getTurns(),0, infoLabel_0));
        listView_0b.setOnKeyPressed(e -> handleListView(e, listView_0b, main.tempPerson.getBonuses(),0, infoLabel_0));

        // Set 1
        comboBox_1.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> choosingName((Person) oldValue, (Person) newValue, 1, addButton_1, listView_1a, listView_1b, infoLabel_1));

        addButton_1.setOnAction(e -> handleAddTurnButton(1, infoLabel_1));

        listView_1a.setOnKeyPressed(e -> handleListView(e, listView_1a, main.tempPerson.getTurns(),1, infoLabel_1));
        listView_1b.setOnKeyPressed(e -> handleListView(e, listView_1b, main.tempPerson.getBonuses(),1, infoLabel_1));
    }

    public void choosingName(Person oldPerson, Person newPerson, int index, Button addButton, ListView listView_a, ListView listView_b, Label thisLabel) {
        if(newPerson != null) {
            main.tempPerson = newPerson;

            newPerson.setIndex(index);

            listView_a.setItems(newPerson.getTurns());

            listView_a.setStyle("-fx-font-size : 16.0");

            listView_b.setItems(newPerson.getBonuses());

            listView_b.setStyle("-fx-font-size : 16.0");

            addButton.setDisable(false);

            thisLabel.setStyle("-fx-background-color: rgb(253,191,45)");

            main.tempLabel = thisLabel;

            updateInfo();

            System.out.println("\n" + newPerson.getFirstName() + " is logging in...");

            // save point
            main.writeInformation(main.tempLocalDate);
        }
        if(oldPerson != null) {
            oldPerson.setIndex(-1);
            // save point
//            main.writeInformation(main.tempLocalDate);
        }

//        updatePersonInfo(main.tempPerson, main.tempTurnInfo, main.tempMoneyInfo);

        System.out.println("The list is now...");

        for(int i = 0; i < main.date.getPersons().size(); i++) {
            System.out.print(main.date.getPersons().get(i).toString());
            System.out.println(": " + main.date.getPersons().get(i).getIndex());
        }

        if(comboBox_1.getSelectionModel().getSelectedItem() == null) {
            System.out.println("There you go bro...");
        }


    }

    public void handleAddTurnButton(int index, Label thisLabel) {
        for (int i = 0; i < main.date.getPersons().size(); i++) {
            if (main.date.getPersons().get(i).getIndex() == index) {
                System.out.println("\nAdding turn for " + main.date.getPersons().get(i).getFirstName());

                // Set temporary person and turn
                main.tempPerson = main.date.getPersons().get(i);
                Turn turn = new Turn();
                main.tempTurn = turn;
            }
        }

        main.tempLabel = thisLabel;

        main.turnController.updateTurnScene();

        main.primaryStage.setScene(main.turnScene);
    }

    public void handleListView(KeyEvent e, ListView listView, ObservableList<Turn> list, int index, Label thisLabel) {
        if (e.getCode().toString().equals("ENTER")) {

            main.tempList = list;

            isAdjusted = true;

            for (int i = 0; i < main.date.getPersons().size(); i++) {
                if (main.date.getPersons().get(i).getIndex() == index) {

                    // Set temporary person and turn
                    main.tempPerson = main.date.getPersons().get(i);
                    System.out.println("\nAdjusting for " + main.date.getPersons().get(i).getFirstName() + "...");
                    main.tempTurn = main.tempList.get(listView.getSelectionModel().getSelectedIndex());
                }
            }

            main.tempLabel = thisLabel;

            main.turnController.updateTurnScene();

            main.primaryStage.setScene(main.turnScene);
        }
    }

//    public void updatePersonInfo(Person person, Label turnInfo, Label moneyInfo) {
//        double total = 0.0;
//        double tip = 0.0;
//        int numOfTurns = 0;
//        int numOfBonuses = 0;
//
//        for(int i = 0; i < person.getTurns().size(); i++) {
//
//            total += person.getTurns().get(i).getBase();
//            tip += person.getTurns().get(i).getTip();
//
//            if((person.getTurns().get(i).getBase() + person.getTurns().get(i).getOff()) >= 25.00) {
//                numOfTurns ++;
//            }
//        }
//
//        numOfBonuses = person.getTurns().size() - numOfTurns;
//
//        person.setTotal(total);
//        person.setTip(tip);
//
//        if(main.tempTurnInfo != null && main.tempMoneyInfo != null) {
//            moneyInfo.setText("Total: $" + person.getTotal() + "\nTip:     $" + person.getTip());
//
//            turnInfo.setText("Turns:       " + numOfTurns + "\nBonuses: " + numOfBonuses);
//        }
//    }

    @FXML
    public void handlePrintButton() {
        main.secondatyStage.setScene(main.printScene);
        main.secondatyStage.showAndWait();
    }

    @FXML
    public void handleHistoryButton() {
        main.secondatyStage.setScene(main.historyScene);
        main.secondatyStage.showAndWait();
    }

    public void updateInfo() {
        double total = 0.0;
        double tip = 0.0;

        for(int i = 0; i < main.tempPerson.getTurns().size(); i++) {
            total += main.tempPerson.getTurns().get(i).getBase();
            tip += main.tempPerson.getTurns().get(i).getTip();
        }

        for(int i = 0; i < main.tempPerson.getBonuses().size(); i++) {
            total += main.tempPerson.getBonuses().get(i).getBase();
            tip += main.tempPerson.getBonuses().get(i).getTip();
        }

        main.tempPerson.setTotal(total);
        main.tempPerson.setTip(tip);

        main.tempLabel.setText(main.tempPerson.getTotal() + " + " + main.tempPerson.getTip());
    }
}
