package salon.view;

import javafx.css.Selector;
import javafx.css.Style;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import salon.Main;
import salon.model.Person;
import salon.model.Turn;
import salon.util.BooleanWrapper;
import salon.util.DoubleWrapper;
import salon.util.IntWrapper;

import java.net.URL;
import java.util.ResourceBundle;

public class TurnController implements Initializable {

    private Main main;

    public TurnController(){}

    // Information
    @FXML
    public TextField serviceTextField;

    @FXML
    public TextField baseTextField;

    @FXML
    public TextField tipTextField;

    // Payment Method buttons
    @FXML
    public Button cardButton;

    @FXML
    public Button cashButton;

    @FXML
    public Button giftButton;

    @FXML
    public Button checkButton;

    // Payment Method textFields
    @FXML
    public TextField cardTextField;

    @FXML
    public TextField cashTextField;

    @FXML
    public TextField giftTextField;

    @FXML
    public TextField checkTextField;

    // Off section
    @FXML
    public TextField offTextField;

    @FXML
    public Button offButton;

    // Panel buttons
    @FXML
    public Button deleteButton;

    @FXML
    public Button doneButton;

    @FXML
    public Button cancelButton;

    // Add service buttons Add service buttons
    // Medicure Medicure Medicure
    @FXML
    public Button basicMaButton;

    @FXML
    public Button deluxeMa;

    @FXML
    public Button OasisMa;

    @FXML
    public Button gelMa;

    @FXML
    public Button polishNails;

    // Powder Powder Powder
    @FXML
    public Button powderFullSet;

    @FXML
    public Button powderWhiteTip;

    @FXML
    public Button powderFullSetGel;

    @FXML
    public Button powderDipping;

    @FXML
    public Button powderDippingGel;

    @FXML
    public Button powderFill;

    @FXML
    public Button powderFillGel;

    // Pedicure Pedicure Pedicure
    @FXML
    public Button pedicureKid;

    @FXML
    public Button pedicurePrincess;

    @FXML
    public Button pedicureBasic;

    @FXML
    public Button pedicureDeluxe;

    @FXML
    public Button pedicureOasis;

    @FXML
    public Button pedicureOnsen;

    // Additional Additional Additional
    @FXML
    public Button addOther;

    @FXML
    public Button addWhiteTip;

    @FXML
    public Button addDesign;

    @FXML
    public Button addGel;

    @FXML
    public Button addKidGel;

    @FXML
    public Button addPolishToes;

    // Waxing Waxing Waxing
    @FXML
    public Button waxingEyebrows;

    @FXML
    public Button waxingLips;

    @FXML
    public Button waxingChin;

    @FXML
    public Button waxingSideburns;

    @FXML
    public Button waxingFullFace;

    @FXML
    public Button waxingUnderArm;

    @FXML
    public Button waxingFacial;

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        basicMaButton.setOnMouseClicked(e -> addService(main.tempTurn.basicMa, 13.0, 13.0, basicMaButton));

        serviceTextField.setOnMouseClicked(e -> serviceTextField.selectAll());
        serviceTextField.setOnKeyTyped(e -> handleServiceTextfield());

        tipTextField.setOnMouseClicked(e -> {
            serviceTextField.setText("" + main.tempTurn.getService());
            baseTextField.setText("" + main.tempTurn.getBase());
            tipTextField.selectAll();});
        tipTextField.setOnKeyTyped(e -> handleTipTextfield());

//        cardButton.setStyle("-fx-background-color: rgb(78,169,112)");
        cardButton.setOnMouseClicked(e -> handleCardButton());
        cardTextField.setOnMouseClicked(e -> cardTextField.selectAll());
        cardTextField.setOnKeyTyped(e -> handleCardTextField());

//        cashButton.setStyle("-fx-background-color: rgb(62,139,195)");
        cashButton.setOnMouseClicked(e -> handleCashButton());
        cashTextField.setOnMouseClicked(e -> cashTextField.selectAll());
        cashTextField.setOnKeyTyped(e -> handleCashTextField());

//        giftButton.setStyle("-fx-background-color: rgb(241,175,73)");

//        checkButton.setStyle("-fx-background-color: rgb(177,91,46)");

//        offButton.setStyle("-fx-background-color: rgb(233,87,68)");
        offButton.setOnMouseClicked(e -> handleOffButton());
        offTextField.setOnMouseClicked(e -> offTextField.selectAll());
        offTextField.setOnKeyTyped(e -> handleOffTextField());
    }

    public void addService(BooleanWrapper buttonIsPressed, double thisService, double thisBase, Button button) {
        if(buttonIsPressed.getFlag() == false) {
            buttonIsPressed.setFlag(true);

            main.tempTurn.setService(main.tempTurn.getService() + thisService);
            main.tempTurn.setBase(main.tempTurn.getBase() + thisBase);

//            button.setStyle("-fx-background-color: rgb(17,178,235)");
            button.setStyle("-fx-background-color: rgb(50,50,50); -fx-text-fill: white");
        }
        else {
            buttonIsPressed.setFlag(false);

            main.tempTurn.setService(main.tempTurn.getService() - thisService);
            main.tempTurn.setBase(main.tempTurn.getBase() - thisBase);

            button.setStyle("-fx: default");
        }
        main.writeInformation(main.tempLocalDate);
        updateTextField();
    }

    public void handleServiceTextfield() {
//        updateTextField();
        main.tempTurn.setService(Double.parseDouble(serviceTextField.getText()));
        main.tempTurn.setBase(Double.parseDouble(serviceTextField.getText()));

        main.resetDoneServices();
        updateServiceButtonColor();
    }

    public void handleTipTextfield() {
        main.tempTurn.setTip(Double.parseDouble(tipTextField.getText()));

//        updateTextField();
    }

    public void handleCardButton() {
        main.tempTurn.setCard(main.tempTurn.getService() - main.tempTurn.getCash()
                - main.tempTurn.getGift() - main.tempTurn.getCheck());

        cardTextField.setEditable(true);
        updateTextField();
        updatePaymentTextFieldColor();
    }

    public void handleCardTextField() {
        main.tempTurn.setCard(Double.parseDouble(cardTextField.getText()));
    }

    public void handleCashButton() {
        main.tempTurn.setCash(main.tempTurn.getService() - main.tempTurn.getCard()
                - main.tempTurn.getGift() - main.tempTurn.getCheck());
        cashTextField.setEditable(true);
        updateTextField();
        updatePaymentTextFieldColor();
    }

    public void handleCashTextField() {
        main.tempTurn.setCash(Double.parseDouble(cashTextField.getText()));
    }

    public void handleOffButton() {
        main.tempTurn.setOff(5.0);
        main.tempTurn.setBase(main.tempTurn.getBase() - main.tempTurn.getOff());
        main.tempTurn.setService(main.tempTurn.getService() - 15.0);

        offTextField.setEditable(true);

        handleCardButton();

        updateTextField();
        updatePaymentTextFieldColor();
    }

    public void handleOffTextField() {
        main.tempTurn.setOff(Double.parseDouble(offTextField.getText()));

        updatePaymentTextFieldColor();
    }

    public void updateTextField() {
        serviceTextField.setText("" + main.tempTurn.getService());
        baseTextField.setText("" + main.tempTurn.getBase());
        tipTextField.setText("" + main.tempTurn.getTip());

        cardTextField.setText("" + main.tempTurn.getCard());
        cashTextField.setText("" + main.tempTurn.getCash());
        giftTextField.setText("" + main.tempTurn.getGift());
        checkTextField.setText("" + main.tempTurn.getCheck());

        offTextField.setText("" + main.tempTurn.getOff());
    }

    public void changeServiceButtonsColor(BooleanWrapper buttonIsPressed, Button button) {
        if(buttonIsPressed.getFlag() == false) {
            button.setStyle("-fx: default");
        }
        else {
//            button.setStyle("-fx-background-color: rgb(17,178,235)");
            button.setStyle("-fx-background-color: rgb(81,187,169)");
        }
    }

    public void updateServiceButtonColor() {
        changeServiceButtonsColor(main.tempTurn.basicMa, basicMaButton);
    }

    public void updatePaymentTextFieldColor() {
        if (main.tempTurn.getCard() > 0.0) {
            cardTextField.setStyle("-fx-background-color: rgb(78,169,112)");
        }
        else {
            cardTextField.setStyle("-fx: default");
        }

        if (main.tempTurn.getCash() > 0.0) {
            cashTextField.setStyle("-fx-background-color: rgb(62,139,195)");
        }
        else {
            cashTextField.setStyle("-fx: default");
        }

        //off off off
        if (main.tempTurn.getOff() > 0.0) {
            offTextField.setStyle("-fx-background-color: rgb(233,87,68)");
        }
        else {
            offTextField.setStyle("-fx: default");
        }
    }

    public void updateTurnScene(){
        updateTextField();
        updateServiceButtonColor();
        updatePaymentTextFieldColor();
    }

    @FXML
    public void handleCancelButton() {
        main.primaryStage.setScene(main.mainScene);
    }

    @FXML
    public void handleDeleteButton() {
        if(main.tempList != null) {
            main.tempList.remove(main.tempTurn);
            main.writeInformation(main.tempLocalDate);
        }

        main.controller.updateInfo();

        // Turn back to main screen
        main.primaryStage.setScene(main.mainScene);
    }

    @FXML
    public void handleDoneButton() {
//        main.controller.updatePersonInfo(main.tempPerson, main.tempTurnInfo, main.tempMoneyInfo);
        if(main.controller.isAdjusted == false) {
            if (main.tempTurn.getBase() + main.tempTurn.getOff() >= 25.00) {
                main.tempPerson.getTurns().add(main.tempTurn);
            } else {
                main.tempPerson.getBonuses().add(main.tempTurn);
            }
        }
        else {
            main.controller.isAdjusted = false;
        }

        main.controller.updateInfo();

        main.writeInformation(main.tempLocalDate);

        main.controller.listView_0a.refresh();
        main.controller.listView_0b.refresh();
        main.controller.listView_1a.refresh();
        main.controller.listView_1b.refresh();

        // Turn back to main screen
        main.primaryStage.setScene(main.mainScene);
    }
}
