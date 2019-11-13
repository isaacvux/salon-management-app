package salon.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.*;
import salon.Main;
import javafx.scene.control.*;
import salon.model.Person;
import salon.model.Turn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Boolean isAdjusted;

    private  Image cardImage;
    private  Image cashImage;
    private  Image giftImage;
    private  Image checkImage;
    private  Image offImage;

    @FXML
    public Button historyButton;

    @FXML
    public Button printButton;

    @FXML
    public Button preferencesButton;

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

    // Set 2
    @FXML
    public ComboBox comboBox_2;

    @FXML
    public Button addButton_2;

    @FXML
    public ListView listView_2a;

    @FXML
    public ListView listView_2b;

    @FXML
    public Label infoLabel_2;

    // Set 3
    @FXML
    public ComboBox comboBox_3;

    @FXML
    public Button addButton_3;

    @FXML
    public ListView listView_3a;

    @FXML
    public ListView listView_3b;

    @FXML
    public Label infoLabel_3;

    // Set 4
    @FXML
    public ComboBox comboBox_4;

    @FXML
    public Button addButton_4;

    @FXML
    public ListView listView_4a;

    @FXML
    public ListView listView_4b;

    @FXML
    public Label infoLabel_4;

    // Set 5
    @FXML
    public ComboBox comboBox_5;

    @FXML
    public Button addButton_5;

    @FXML
    public ListView listView_5a;

    @FXML
    public ListView listView_5b;

    @FXML
    public Label infoLabel_5;

    // Set 6
    @FXML
    public ComboBox comboBox_6;

    @FXML
    public Button addButton_6;

    @FXML
    public ListView listView_6a;

    @FXML
    public ListView listView_6b;

    @FXML
    public Label infoLabel_6;

    // Set 7
    @FXML
    public ComboBox comboBox_7;

    @FXML
    public Button addButton_7;

    @FXML
    public ListView listView_7a;

    @FXML
    public ListView listView_7b;

    @FXML
    public Label infoLabel_7;

    // Set 8
    @FXML
    public ComboBox comboBox_8;

    @FXML
    public Button addButton_8;

    @FXML
    public ListView listView_8a;

    @FXML
    public ListView listView_8b;

    @FXML
    public Label infoLabel_8;

    // Set 9
    @FXML
    public ComboBox comboBox_9;

    @FXML
    public Button addButton_9;

    @FXML
    public ListView listView_9a;

    @FXML
    public ListView listView_9b;

    @FXML
    public Label infoLabel_9;

    // Super set

    public ArrayList<ComboBox> comboBoxes = new ArrayList<>();

    public ArrayList<Button> addButtons = new ArrayList<>();

    public ArrayList<ListView> listViews_a = new ArrayList<>();

    public ArrayList<ListView> listViews_b = new ArrayList<>();

    public ArrayList<Label> infoLabels = new ArrayList<>();



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

        comboBoxes.add(comboBox_0);
        comboBoxes.add(comboBox_1);
        comboBoxes.add(comboBox_2);
        comboBoxes.add(comboBox_3);
        comboBoxes.add(comboBox_4);
        comboBoxes.add(comboBox_5);
        comboBoxes.add(comboBox_6);
        comboBoxes.add(comboBox_7);
        comboBoxes.add(comboBox_8);
        comboBoxes.add(comboBox_9);

        addButtons.add(addButton_0);
        addButtons.add(addButton_1);
        addButtons.add(addButton_2);
        addButtons.add(addButton_3);
        addButtons.add(addButton_4);
        addButtons.add(addButton_5);
        addButtons.add(addButton_6);
        addButtons.add(addButton_7);
        addButtons.add(addButton_8);
        addButtons.add(addButton_9);

        listViews_a.add(listView_0a);
        listViews_a.add(listView_1a);
        listViews_a.add(listView_2a);
        listViews_a.add(listView_3a);
        listViews_a.add(listView_4a);
        listViews_a.add(listView_5a);
        listViews_a.add(listView_6a);
        listViews_a.add(listView_7a);
        listViews_a.add(listView_8a);
        listViews_a.add(listView_9a);

        listViews_b.add(listView_0b);
        listViews_b.add(listView_1b);
        listViews_b.add(listView_2b);
        listViews_b.add(listView_3b);
        listViews_b.add(listView_4b);
        listViews_b.add(listView_5b);
        listViews_b.add(listView_6b);
        listViews_b.add(listView_7b);
        listViews_b.add(listView_8b);
        listViews_b.add(listView_9b);

        infoLabels.add(infoLabel_0);
        infoLabels.add(infoLabel_1);
        infoLabels.add(infoLabel_2);
        infoLabels.add(infoLabel_3);
        infoLabels.add(infoLabel_4);
        infoLabels.add(infoLabel_5);
        infoLabels.add(infoLabel_6);
        infoLabels.add(infoLabel_7);
        infoLabels.add(infoLabel_8);
        infoLabels.add(infoLabel_9);

        for(int i = 0; i < comboBoxes.size(); i++) {
            comboBoxes.get(i).setItems(main.date.getPersons());
            comboBoxes.get(i).setStyle("-fx-font-size : 18.0; -fx-font-weight: bold");
        }

//        comboBox_0.setItems(main.date.getPersons());
//        comboBox_0.setStyle("-fx-font-size : 18.0; -fx-font-weight: bold");
//
//        comboBox_1.setItems(main.date.getPersons());
//        comboBox_1.setStyle("-fx-font-size : 18.0; -fx-font-weight: bold");
//
//        comboBox_2.setItems(main.date.getPersons());
//        comboBox_2.setStyle("-fx-font-size : 18.0; -fx-font-weight: bold");
//
//        comboBox_3.setItems(main.date.getPersons());
//        comboBox_3.setStyle("-fx-font-size : 18.0; -fx-font-weight: bold");
//
//        comboBox_4.setItems(main.date.getPersons());
//        comboBox_4.setStyle("-fx-font-size : 18.0; -fx-font-weight: bold");
//
//        comboBox_5.setItems(main.date.getPersons());
//        comboBox_5.setStyle("-fx-font-size : 18.0; -fx-font-weight: bold");
//
//        comboBox_6.setItems(main.date.getPersons());
//        comboBox_6.setStyle("-fx-font-size : 18.0; -fx-font-weight: bold");
//
//        comboBox_7.setItems(main.date.getPersons());
//        comboBox_7.setStyle("-fx-font-size : 18.0; -fx-font-weight: bold");
//
//        comboBox_8.setItems(main.date.getPersons());
//        comboBox_8.setStyle("-fx-font-size : 18.0; -fx-font-weight: bold");
//
//        comboBox_9.setItems(main.date.getPersons());
//        comboBox_9.setStyle("-fx-font-size : 18.0; -fx-font-weight: bold");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // initialize method is called before setMain method

        isAdjusted = false;

//        try {
//            cardImage = new Image(new FileInputStream("/Users/isaacvu/Desktop/Data/card.png"));
//            cashImage= new Image(new FileInputStream("/Users/isaacvu/Desktop/Data/cash.png"));
//            giftImage = new Image(new FileInputStream("/Users/isaacvu/Desktop/Data/gift.png"));
//            checkImage = new Image(new FileInputStream("/Users/isaacvu/Desktop/Data/check.png"));
//            offImage = new Image(new FileInputStream("/Users/isaacvu/Desktop/Data/off.png"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        // Set 0
        comboBox_0.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> choosingName((Person) oldValue, (Person) newValue, 0, comboBox_0, addButton_0, listView_0a, listView_0b, infoLabel_0));

        addButton_0.setOnAction(e -> handleAddTurnButton(0, listView_0a, listView_0b, infoLabel_0));

        listView_0a.setOnMouseClicked(e -> setTempPersonByListView(0));
        listView_0b.setOnMouseClicked(e -> setTempPersonByListView(0));

        listView_0a.setOnKeyPressed(e -> handleListView(e, listView_0a, main.tempPerson.getTurns(),0, infoLabel_0));
        listView_0b.setOnKeyPressed(e -> handleListView(e, listView_0b, main.tempPerson.getBonuses(),0, infoLabel_0));

        // Set 1
        comboBox_1.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> choosingName((Person) oldValue, (Person) newValue, 1, comboBox_1, addButton_1, listView_1a, listView_1b, infoLabel_1));

        addButton_1.setOnAction(e -> handleAddTurnButton(1,listView_1a, listView_1b, infoLabel_1));

        listView_1a.setOnMouseClicked(e -> setTempPersonByListView(1));
        listView_1b.setOnMouseClicked(e -> setTempPersonByListView(1));

        listView_1a.setOnKeyPressed(e -> handleListView(e, listView_1a, main.tempPerson.getTurns(),1, infoLabel_1));
        listView_1b.setOnKeyPressed(e -> handleListView(e, listView_1b, main.tempPerson.getBonuses(),1, infoLabel_1));

        // Set 2
        comboBox_2.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> choosingName((Person) oldValue, (Person) newValue,2 , comboBox_2,addButton_2, listView_2a, listView_2b, infoLabel_2));

        addButton_2.setOnAction(e -> handleAddTurnButton(2,listView_2a, listView_2b, infoLabel_2));

        listView_2a.setOnMouseClicked(e -> setTempPersonByListView(2));
        listView_2b.setOnMouseClicked(e -> setTempPersonByListView(2));

        listView_2a.setOnKeyPressed(e -> handleListView(e, listView_2a, main.tempPerson.getTurns(),2, infoLabel_2));
        listView_2b.setOnKeyPressed(e -> handleListView(e, listView_2b, main.tempPerson.getBonuses(),2, infoLabel_2));

        // Set 3
        comboBox_3.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> choosingName((Person) oldValue, (Person) newValue,3, comboBox_3, addButton_3, listView_3a, listView_3b, infoLabel_3));

        addButton_3.setOnAction(e -> handleAddTurnButton(3,listView_3a, listView_3b, infoLabel_3));

        listView_3a.setOnMouseClicked(e -> setTempPersonByListView(3));
        listView_3b.setOnMouseClicked(e -> setTempPersonByListView(3));

        listView_3a.setOnKeyPressed(e -> handleListView(e, listView_3a, main.tempPerson.getTurns(),3, infoLabel_3));
        listView_3b.setOnKeyPressed(e -> handleListView(e, listView_3b, main.tempPerson.getBonuses(),3, infoLabel_3));

        // Set 4
        comboBox_4.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> choosingName((Person) oldValue, (Person) newValue,4, comboBox_4, addButton_4, listView_4a, listView_4b, infoLabel_4));

        addButton_4.setOnAction(e -> handleAddTurnButton(4, listView_4a, listView_4b, infoLabel_4));

        listView_4a.setOnMouseClicked(e -> setTempPersonByListView(4));
        listView_4b.setOnMouseClicked(e -> setTempPersonByListView(4));

        listView_4a.setOnKeyPressed(e -> handleListView(e, listView_4a, main.tempPerson.getTurns(),4, infoLabel_4));
        listView_4b.setOnKeyPressed(e -> handleListView(e, listView_4b, main.tempPerson.getBonuses(),4, infoLabel_4));

        // Set 5
        comboBox_5.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> choosingName((Person) oldValue, (Person) newValue, 5, comboBox_5, addButton_5, listView_5a, listView_5b, infoLabel_5));

        addButton_5.setOnAction(e -> handleAddTurnButton(5, listView_5a, listView_5b, infoLabel_5));

        listView_5a.setOnMouseClicked(e -> setTempPersonByListView(5));
        listView_5b.setOnMouseClicked(e -> setTempPersonByListView(5));

        listView_5a.setOnKeyPressed(e -> handleListView(e, listView_5a, main.tempPerson.getTurns(),5, infoLabel_5));
        listView_5b.setOnKeyPressed(e -> handleListView(e, listView_5b, main.tempPerson.getBonuses(),5, infoLabel_5));

        // Set 6
        comboBox_6.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> choosingName((Person) oldValue, (Person) newValue, 6, comboBox_6, addButton_6, listView_6a, listView_6b, infoLabel_6));

        addButton_6.setOnAction(e -> handleAddTurnButton(6, listView_6a, listView_6b, infoLabel_6));

        listView_6a.setOnMouseClicked(e -> setTempPersonByListView(6));
        listView_6b.setOnMouseClicked(e -> setTempPersonByListView(6));

        listView_6a.setOnKeyPressed(e -> handleListView(e, listView_6a, main.tempPerson.getTurns(),6, infoLabel_6));
        listView_6b.setOnKeyPressed(e -> handleListView(e, listView_6b, main.tempPerson.getBonuses(),6, infoLabel_6));

        // Set 7
        comboBox_7.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> choosingName((Person) oldValue, (Person) newValue,7, comboBox_7, addButton_7, listView_7a, listView_7b, infoLabel_7));

        addButton_7.setOnAction(e -> handleAddTurnButton(7, listView_7a, listView_7b, infoLabel_7));

        listView_7a.setOnMouseClicked(e -> setTempPersonByListView(7));
        listView_7b.setOnMouseClicked(e -> setTempPersonByListView(7));

        listView_7a.setOnKeyPressed(e -> handleListView(e, listView_7a, main.tempPerson.getTurns(),7, infoLabel_7));
        listView_7b.setOnKeyPressed(e -> handleListView(e, listView_7b, main.tempPerson.getBonuses(),7, infoLabel_7));

        // Set 8
        comboBox_8.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> choosingName((Person) oldValue, (Person) newValue, 8, comboBox_8, addButton_8, listView_8a, listView_8b, infoLabel_8));

        addButton_8.setOnAction(e -> handleAddTurnButton(8, listView_8a, listView_8b, infoLabel_8));

        listView_8a.setOnMouseClicked(e -> setTempPersonByListView(8));
        listView_8b.setOnMouseClicked(e -> setTempPersonByListView(8));

        listView_8a.setOnKeyPressed(e -> handleListView(e, listView_8a, main.tempPerson.getTurns(),8, infoLabel_8));
        listView_8b.setOnKeyPressed(e -> handleListView(e, listView_8b, main.tempPerson.getBonuses(),8, infoLabel_8));

        // Set 9
        comboBox_9.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> choosingName((Person) oldValue, (Person) newValue, 9, comboBox_9, addButton_9, listView_9a, listView_9b, infoLabel_9));

        addButton_9.setOnAction(e -> handleAddTurnButton(9, listView_9a, listView_9b, infoLabel_9));

        listView_9a.setOnMouseClicked(e -> setTempPersonByListView(9));
        listView_9b.setOnMouseClicked(e -> setTempPersonByListView(9));

        listView_9a.setOnKeyPressed(e -> handleListView(e, listView_9a, main.tempPerson.getTurns(),9, infoLabel_9));
        listView_9b.setOnKeyPressed(e -> handleListView(e, listView_9b, main.tempPerson.getBonuses(),9, infoLabel_9));
    }

    public void choosingName(Person oldPerson, Person newPerson, int index, ComboBox comboBox, Button addButton, ListView listView_a, ListView listView_b, Label thisLabel) {
        ///
        if(isNotRepeated(newPerson, index)) {
            if (newPerson != null) {
                main.tempPerson = newPerson;

                newPerson.setIndex(index);

                listView_a.setItems(newPerson.getTurns());

                listView_a.setStyle("-fx-font-size : 16.0");

                listView_b.setItems(newPerson.getBonuses());

                listView_b.setStyle("-fx-font-size : 16.0");

                addButton.setDisable(false);

                thisLabel.setStyle("-fx-background-color: rgb(253,191,45); -fx-font-size : 18.0; -fx-font-weight: bold");

                main.tempLabel = thisLabel;

//                main.tempLabel.setStyle("-fx-font-weight: bold");

                updateInfo();

                System.out.println("\n" + newPerson.getFirstName() + " is logging in...");

                // save point
                main.writeInformation(main.tempLocalDate);
            }

            if(isNotRepeated(oldPerson,index)) {
                if (oldPerson != null) {
                    oldPerson.setIndex(-1);
                }
            }

            System.out.println("The list is now...");

            for (int i = 0; i < main.date.getPersons().size(); i++) {
                System.out.print(main.date.getPersons().get(i).toString());
                System.out.println(": " + main.date.getPersons().get(i).getIndex());
            }
        }
        else {
            System.out.println("we here");
//            comboBox.getButtonCell().setText("Name");
//            comboBox.getButtonCell().setItem(null);
        }

    }

    public boolean isNotRepeated(Person thisPerson, int index) {
        for (int i = 0; i < index; i++) {
            if (comboBoxes.get(i).getSelectionModel().getSelectedItem() != null) {
                if(comboBoxes.get(i).getSelectionModel().getSelectedItem().equals(thisPerson)) {
//                    System.out.println(thisPerson.getFirstName() + " has already logged in.");
                    return false;
                }
            }
        }
        for (int i = (index + 1); i < comboBoxes.size(); i++) {
            if (comboBoxes.get(i).getSelectionModel().getSelectedItem() != null) {
                if(comboBoxes.get(i).getSelectionModel().getSelectedItem().equals(thisPerson)) {
//                    System.out.println(thisPerson.getFirstName() + " has already logged in.");
                    return false;
                }
            }
        }
        return true;
    }

    public void handleAddTurnButton(int index, ListView thisListView_a, ListView thisListView_b, Label thisLabel) {
        for (int i = 0; i < main.date.getPersons().size(); i++) {
            if (main.date.getPersons().get(i).getIndex() == index) {
                System.out.println("\nAdding turn for " + main.date.getPersons().get(i).getFirstName());

                // Set temporary person and turn
                main.tempPerson = main.date.getPersons().get(i);
                Turn turn = new Turn();
                main.tempTurn = turn;
            }
        }

//        main.tempListView_a = thisListView_a;
//        main.tempListView_b = thisListView_b;

        main.tempLabel = thisLabel;

        main.turnController.setUpTurnScene();

        main.primaryStage.setScene(main.turnScene);
    }

    public void setTempPersonByListView(int index){
        for (int i = 0; i < main.date.getPersons().size(); i++) {
            if (main.date.getPersons().get(i).getIndex() == index) {

                // Set temporary person
                main.tempPerson = main.date.getPersons().get(i);
            }
        }
    }

    public void handleListView(KeyEvent e, ListView thisListView, ObservableList<Turn> list, int index, Label thisLabel) {
        if (e.getCode().toString().equals("ENTER")) {

            main.tempList = list;

            isAdjusted = true;

//            for (int i = 0; i < main.date.getPersons().size(); i++) {
//                if (main.date.getPersons().get(i).getIndex() == index) {
//
//                    // Set temporary person and turn
//                    main.tempPerson = main.date.getPersons().get(i);
//                }
//            }
            System.out.println("\nAdjusting for " + main.tempPerson.getFirstName() + "...");

            main.tempTurn = main.tempList.get(thisListView.getSelectionModel().getSelectedIndex());

            thisListView.getSelectionModel().select(-1);


//            main.tempListView = thisListView;

            main.tempLabel = thisLabel;

            main.turnController.setUpTurnScene();

            main.primaryStage.setScene(main.turnScene);
        }
    }

    @FXML
    public void handlePrintButton() {
        main.secondatyStage.setScene(main.printScene);
        main.secondatyStage.setTitle("Print Report");
        main.secondatyStage.showAndWait();
    }

    @FXML
    public void handleHistoryButton() {
        main.secondatyStage.setScene(main.historyScene);
        main.secondatyStage.setTitle("History");
        main.secondatyStage.showAndWait();
    }

    @FXML
    public void handlePreferencesButton() {
        main.secondatyStage.setScene(main.preferencesScene);
        main.secondatyStage.setTitle("Preferences");
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

        main.tempLabel.setText((int)main.tempPerson.getTotal() + "\t   |\t   " + (int)main.tempPerson.getTip());
    }

    public void updateListView(ListView thisListView) {
//        thisListView.setCellFactory(param -> new ListCell<Turn>() {
//            private ImageView imageView = new ImageView();
//           if( == true)
//                    imageView.setImage(cardImage);
//                setText(name);
//                setGraphic(imageView);
//            if (empty) {
//                setText(null);
//                setGraphic(null);
//            } else {

//            }
//            @Override
//            public void updateItem(String name, boolean empty) {
//                super.updateItem(name, empty);
//                if (empty) {
//                    setText(null);
//                    setGraphic(null);
//                } else {
//                    if(main.tempTurn.payByCard.getFlag() == true)
//                        imageView.setImage(cardImage);
//                    setText(name);
//                    setGraphic(imageView);
//                }
//            }
//        });
    }
}
