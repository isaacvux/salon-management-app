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
import salon.view.*;
import javafx.scene.control.*;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.prefs.Preferences;

public class Main extends Application {

    public Stage primaryStage;
    public Stage secondatyStage;

    public Scene mainScene;
    public Scene turnScene;
    public Scene printScene;
    public Scene historyScene;
    public Scene preferencesScene;

    public Controller controller;
    public TurnController turnController;
    public PrintController printController;
    public HistoryController historyController;
    public PreferencesController preferencesController;

    public String fileDirectory;

    public Date date = new Date();

    public LocalDate tempLocalDate;

    public Person tempPerson;
    public ObservableList<Turn> tempList;
    public Turn tempTurn;
    public Label tempLabel;
    public ListView tempListView_a;
    public ListView tempListView_b;
    public ListView tempListView;

    public Main() {}

    @Override
    public void start(Stage primaryStage) {
        fileDirectory = "/Users/isaacvu/OneDrive - Oklahoma City Community College/Data/";
//        fileDirectory = "C:\\Users\\oasis\\OneDrive - Oklahoma City Community College\\Data\\";

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

        try {
            FXMLLoader preferencesLoader = new FXMLLoader(getClass().getResource("view/preferences.fxml"));
            Parent root5 = preferencesLoader.load();
            preferencesScene = new Scene(root5);
//            mainScene.getStylesheets().add("/main/darkTheme.css");
            preferencesController = preferencesLoader.getController();
            preferencesController.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        restoreGUI();

        primaryStage.setScene(mainScene);
        primaryStage.show();
//        primaryStage.setFullScreen(true);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void readPersonList() {
        System.out.println("\nReading person list...");
        try {
            File myFile = new File(fileDirectory + "employeesList.txt");

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
            File myFile = new File(fileDirectory + localDate + ".txt");

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
            turn.setService(Double.parseDouble(reader.readLine()));
            turn.setBase(Double.parseDouble(reader.readLine()));
            turn.setTip(Double.parseDouble(reader.readLine()));

            turn.setCard(Double.parseDouble(reader.readLine()));
            turn.setCash(Double.parseDouble(reader.readLine()));
            turn.setGift(Double.parseDouble(reader.readLine()));
            turn.setCheck(Double.parseDouble(reader.readLine()));

            turn.setOff(Double.parseDouble(reader.readLine()));

            turn.payByCard.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.payByCash.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.payByGift.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.payByCheck.setFlag(Boolean.parseBoolean(reader.readLine()));

            turn.hasDiscount.setFlag(Boolean.parseBoolean(reader.readLine()));

            turn.isPassed.setFlag(Boolean.parseBoolean(reader.readLine()));

            // Manicure
            turn.basicMa.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.deluxeMa.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.oasisMa.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.gelMa.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.polishNails.setFlag(Boolean.parseBoolean(reader.readLine()));

            // Powder
            turn.powderFullSet.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.powderFullSetGe.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.powderWhiteTip.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.powderDipping.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.powderDippingGel.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.powderFill.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.powderFillGel.setFlag(Boolean.parseBoolean(reader.readLine()));

            // Pedicure
            turn.pedicureKid.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.pedicurePrincess.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.pedicureBasic.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.pedicureDeluxe.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.pedicureOasis.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.pedicureOnsen.setFlag(Boolean.parseBoolean(reader.readLine()));

            // Addition
            turn.addOther.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.addWhiteTip.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.addDesign.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.addGel.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.addKidGel.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.addPolishToes.setFlag(Boolean.parseBoolean(reader.readLine()));

            // Waxing
            turn.waxingEyebrows.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.waxingLips.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.waxingChin.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.waxingSideburns.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.waxingFullFace.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.waxingUnderArm.setFlag(Boolean.parseBoolean(reader.readLine()));
            turn.waxingFacial.setFlag(Boolean.parseBoolean(reader.readLine()));

            list.add(turn);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeInformation(LocalDate thisDate){
        try {
            FileWriter writer = new FileWriter(fileDirectory + thisDate + ".txt");

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

            // payment methods
            writer.write("" + turn.payByCard.getFlag());
            writer.write("\n");
            writer.write("" + turn.payByCash.getFlag());
            writer.write("\n");
            writer.write("" + turn.payByGift.getFlag());
            writer.write("\n");
            writer.write("" + turn.payByCheck.getFlag());
            writer.write("\n");

            // off
            writer.write("" + turn.hasDiscount.getFlag());
            writer.write("\n");

            // is passed
            writer.write("" + turn.isPassed.getFlag());
            writer.write("\n");

            // manicure
            writer.write("" + turn.basicMa.getFlag());
            writer.write("\n");
            writer.write("" + turn.deluxeMa.getFlag());
            writer.write("\n");
            writer.write("" + turn.oasisMa.getFlag());
            writer.write("\n");
            writer.write("" + turn.gelMa.getFlag());
            writer.write("\n");
            writer.write("" + turn.polishNails.getFlag());
            writer.write("\n");

            // Powder
            writer.write("" + turn.powderFullSet.getFlag());
            writer.write("\n");
            writer.write("" + turn.powderFullSetGe.getFlag());
            writer.write("\n");
            writer.write("" + turn.powderWhiteTip.getFlag());
            writer.write("\n");
            writer.write("" + turn.powderDipping.getFlag());
            writer.write("\n");
            writer.write("" + turn.powderDippingGel.getFlag());
            writer.write("\n");
            writer.write("" + turn.powderFill.getFlag());
            writer.write("\n");
            writer.write("" + turn.powderFillGel.getFlag());
            writer.write("\n");

            // Pedicure
            writer.write("" + turn.pedicureKid.getFlag());
            writer.write("\n");
            writer.write("" + turn.pedicurePrincess.getFlag());
            writer.write("\n");
            writer.write("" + turn.pedicureBasic.getFlag());
            writer.write("\n");
            writer.write("" + turn.pedicureDeluxe.getFlag());
            writer.write("\n");
            writer.write("" + turn.pedicureOasis.getFlag());
            writer.write("\n");
            writer.write("" + turn.pedicureOnsen.getFlag());
            writer.write("\n");

            // Addition
            writer.write("" + turn.addOther.getFlag());
            writer.write("\n");
            writer.write("" + turn.addWhiteTip.getFlag());
            writer.write("\n");
            writer.write("" + turn.addDesign.getFlag());
            writer.write("\n");
            writer.write("" + turn.addGel.getFlag());
            writer.write("\n");
            writer.write("" + turn.addKidGel.getFlag());
            writer.write("\n");
            writer.write("" + turn.addPolishToes.getFlag());
            writer.write("\n");

            // Waxing
            writer.write("" + turn.waxingEyebrows.getFlag());
            writer.write("\n");
            writer.write("" + turn.waxingLips.getFlag());
            writer.write("\n");
            writer.write("" + turn.waxingChin.getFlag());
            writer.write("\n");
            writer.write("" + turn.waxingSideburns.getFlag());
            writer.write("\n");
            writer.write("" + turn.waxingFullFace.getFlag());
            writer.write("\n");
            writer.write("" + turn.waxingUnderArm.getFlag());
            writer.write("\n");
            writer.write("" + turn.waxingFacial.getFlag());
//            writer.write("\n"); // don't put a new line at the end


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createNewSetOfObjects() {
        date.setDate(tempLocalDate);
        readPersonList();
    }

    public boolean checkForFile(LocalDate thisDate) {
        File temp = new File(fileDirectory + thisDate + ".txt");

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
            controller.infoLabels.get(i).setStyle("-fx: default");
        }

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


    public void resetServices() {
        for(int i = 0; i < tempTurn.getServices().size(); i++) {
            tempTurn.getServices().get(i).setFlag(false);
        }
    }
}
