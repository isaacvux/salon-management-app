package salon;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import salon.model.Date;
import salon.model.Person;
import salon.model.Turn;
import salon.util.BooleanWrapper;
import salon.view.Controller;
import salon.view.HistoryController;
import salon.view.PrintController;
import salon.view.TurnController;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;

public class Main extends Application {

    public Stage primaryStage;
    public Stage secondatyStage;

    public Scene mainScene;
    public Scene turnScene;
    public Scene printScene;
    public Scene historyScene;

    public Controller controller;
    public TurnController turnController;
    public PrintController printController;
    public HistoryController historyController;

    public Date date = new Date();

    public LocalDate tempLocalDate;

    public Person tempPerson;
    public ObservableList<Turn> tempList;
    public Turn tempTurn;
    public Label tempLabel;

    public Main() {}

    @Override
    public void start(Stage primaryStage) {
        tempLocalDate = LocalDate.now();

        if(checkForFile(tempLocalDate)) {
            System.out.println("Today file exists.");
            readInformation(tempLocalDate, date);
        }
        else {
            System.out.println("Today file doesn't exist yet.");
            createNewSetOfObjects();
            writeInformation(tempLocalDate);
        }

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Oasis Nails : " + date.getDate());

        secondatyStage = new Stage();

        // Set the application icon.
//        this.primaryStage.getIcons().add(new Image("file:resources/images/address_book_32.png"));

        try {
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("view/main.fxml"));
            Parent root1 = mainLoader.load();
            mainScene = new Scene(root1);
//            mainScene.getStylesheets().add("/salon/skin/JMetroLightTheme.css");
            controller = mainLoader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FXMLLoader turnLoader = new FXMLLoader(getClass().getResource("view/turn.fxml"));
            Parent root2 = turnLoader.load();
            turnScene = new Scene(root2);
//            mainScene.getStylesheets().add("/main/darkTheme.css");
            turnController = turnLoader.getController();
            turnController.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FXMLLoader printLoader = new FXMLLoader(getClass().getResource("view/print.fxml"));
            Parent root3 = printLoader.load();
            printScene = new Scene(root3);
//            mainScene.getStylesheets().add("/main/darkTheme.css");
            printController = printLoader.getController();
            printController.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FXMLLoader historyLoader = new FXMLLoader(getClass().getResource("view/history.fxml"));
            Parent root4 = historyLoader.load();
            historyScene = new Scene(root4);
//            mainScene.getStylesheets().add("/main/darkTheme.css");
            historyController = historyLoader.getController();
            historyController.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        restoreGUI();

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void readPersonList() {
        System.out.println("\nReading person list...");
        try {
            File myFile = new File("/Users/isaacvu/Desktop/employeesList.txt");

            FileReader fileReader = new FileReader(myFile);

            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;

            String[] tokens = new String[2];

            int index = 0;

            while((line = reader.readLine()) != null) {
                tokens[index] = line;

                index++;

                if(index == 2) {
                    date.getPersons().add(new Person(tokens[0], tokens[1]));
                    index = 0; // reset arguments' index
                }
            }
            reader.close();

            /* Check point */
            for(int i = 0; i < date.getPersons().size(); i++) {
                System.out.println(date.getPersons().get(i));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readInformation(LocalDate localDate, Date thisDate) {
        System.out.println("\n\nLoading information to application...");
        System.out.println("\n\nReading from file...");
        try {
            File myFile = new File("/Users/isaacvu/Desktop/" + localDate + ".txt");

            FileReader fileReader = new FileReader(myFile);

            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;

            line = reader.readLine();
            thisDate.setDate(LocalDate.of(Integer.parseInt(line.substring(0,4)),
                    Integer.parseInt(line.substring(5,7)), Integer.parseInt(line.substring(8,10))));
            System.out.println("Date: " + thisDate.getDate());
            line = reader.readLine();
            line = reader.readLine();

            while(line != null) {
                if("..........".equals(line)) {
                    Person person = new Person();

                    tempPerson = person;

                    readPerson(reader, thisDate, person);

                    line = reader.readLine();

                    System.out.println("Reading " + tempPerson.getFirstName() + "....");
                }
                if(".....".equals(line)){
                    Turn turn = new Turn();

                    readTurn(reader, tempPerson.getTurns(), turn);

                    line = reader.readLine();

                    System.out.println("Reading " + tempPerson.getFirstName() + "'s turn....");
                }
                if("-----".equals(line)){
                    Turn turn = new Turn();

                    readTurn(reader, tempPerson.getBonuses(), turn);

                    line = reader.readLine();

                    System.out.println("Reading " + tempPerson.getFirstName() + "'s bonus....");
                }

            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readPerson(BufferedReader reader, Date thisDate, Person person) {
        try {
            person.setFirstName(reader.readLine());
            person.setLastName(reader.readLine());
            person.setIndex(Integer.parseInt(reader.readLine()));
            person.setTotal(Double.parseDouble(reader.readLine()));
            person.setTip(Double.parseDouble(reader.readLine()));

            thisDate.getPersons().add(person);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readTurn(BufferedReader reader, ObservableList<Turn> list, Turn turn) {
        try {
            turn.setBase(Double.parseDouble(reader.readLine()));
            turn.setService(Double.parseDouble(reader.readLine()));
            turn.setTip(Double.parseDouble(reader.readLine()));

            turn.setCard(Double.parseDouble(reader.readLine()));
            turn.setCash(Double.parseDouble(reader.readLine()));
            turn.setGift(Double.parseDouble(reader.readLine()));
            turn.setCheck(Double.parseDouble(reader.readLine()));

            turn.setOff(Double.parseDouble(reader.readLine()));

            turn.setBasicMa(new BooleanWrapper(Boolean.parseBoolean(reader.readLine())));

            list.add(turn);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeInformation(LocalDate thisDate){
        try {
            FileWriter writer = new FileWriter("/Users/isaacvu/Desktop/" + thisDate + ".txt");

            writer.write("" + date.getDate() + "\n" + "Report" + "\n");

            System.out.println("\nWriting to file...");

            for(int i = 0; i < date.getPersons().size(); i++) {
                writePerson(writer, date.getPersons().get(i));
                writer.write("\n");
                for(int j = 0; j < date.getPersons().get(i).getTurns().size(); j++) {
                    writer.write(".....");
                    writer.write("\n");
                    writeTurn(writer,date.getPersons().get(i).getTurns().get(j));
                    writer.write("\n");
                }
                for(int z = 0; z < date.getPersons().get(i).getBonuses().size(); z++) {
                    writer.write("-----");
                    writer.write("\n");
                    writeTurn(writer,date.getPersons().get(i).getBonuses().get(z));
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writePerson(FileWriter writer, Person person) {
        try {
            writer.write(".........." + "\n");
            writer.write(person.getFirstName());
            writer.write("\n");
            writer.write(person.getLastName());
            writer.write("\n");
            writer.write("" + person.getIndex());
            writer.write("\n");
            writer.write("" + person.getTotal());
            writer.write("\n");
            writer.write("" + person.getTip());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeTurn(FileWriter writer, Turn turn) {
        try {
            writer.write("" + turn.getService());
            writer.write("\n");
            writer.write("" + turn.getBase());
            writer.write("\n");
            writer.write("" + turn.getTip());
            writer.write("\n");

            writer.write("" + turn.getCard());
            writer.write("\n");
            writer.write("" + turn.getCash());
            writer.write("\n");
            writer.write("" + turn.getGift());
            writer.write("\n");
            writer.write("" + turn.getCheck());
            writer.write("\n");

            writer.write("" + turn.getOff());
            writer.write("\n");

            writer.write("" + turn.getBasicMa().getFlag());
//            writer.write("\n");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createNewSetOfObjects() {
        date.setDate(tempLocalDate);
        readPersonList();
    }

    public boolean checkForFile(LocalDate thisDate) {
        File temp = new File("/Users/isaacvu/Desktop/" + thisDate + ".txt");

        boolean exists = temp.exists();

        if(exists) {
            return true;
        }
        else {
            return false;
        }
    }

    public void restoreGUI(){
        for(int i = 0; i < controller.comboBoxes.size(); i++) {
            controller.comboBoxes.get(i).setValue(null);
            controller.addButtons.get(i).setDisable(true);
            controller.listViews_a.get(i).setItems(null);
            controller.listViews_b.get(i).setItems(null);
            controller.infoLabels.get(i).setText("");
        }
//        controller.comboBox_0.setValue(null);
//        controller.addButton_0.setDisable(true);
//        controller.listView_0a.setItems(null);
//        controller.listView_0b.setItems(null);
//        controller.infoLabel_0.setText("");
//
//        controller.comboBox_1.setValue(null);
//        controller.addButton_1.setDisable(true);
//        controller.listView_1a.setItems(null);
//        controller.listView_1b.setItems(null);
//        controller.infoLabel_1.setText("");

        for(int i = 0; i < date.getPersons().size(); i++) {
            if(date.getPersons().get(i).getIndex() == 0) {
                controller.comboBox_0.getSelectionModel().select(date.getPersons().get(i));
            }
            if(date.getPersons().get(i).getIndex() == 1) {
                controller.comboBox_1.getSelectionModel().select(date.getPersons().get(i));
            }
            if(date.getPersons().get(i).getIndex() == 2) {
                controller.comboBox_2.getSelectionModel().select(date.getPersons().get(i));
            }
            if(date.getPersons().get(i).getIndex() == 3) {
                controller.comboBox_3.getSelectionModel().select(date.getPersons().get(i));
            }
            if(date.getPersons().get(i).getIndex() == 4) {
                controller.comboBox_4.getSelectionModel().select(date.getPersons().get(i));
            }
            if(date.getPersons().get(i).getIndex() == 5) {
                controller.comboBox_5.getSelectionModel().select(date.getPersons().get(i));
            }
            if(date.getPersons().get(i).getIndex() == 6) {
                controller.comboBox_6.getSelectionModel().select(date.getPersons().get(i));
            }
            if(date.getPersons().get(i).getIndex() == 7) {
                controller.comboBox_7.getSelectionModel().select(date.getPersons().get(i));
            }
            if(date.getPersons().get(i).getIndex() == 8) {
                controller.comboBox_8.getSelectionModel().select(date.getPersons().get(i));
            }
            if(date.getPersons().get(i).getIndex() == 9) {
                controller.comboBox_9.getSelectionModel().select(date.getPersons().get(i));
            }
        }
    }

    public void resetDoneServices() {
        for(int i = 0; i < tempTurn.getDoneServices().size(); i++) {
            tempTurn.getDoneServices().get(i).setFlag(false);
        }
    }
}
