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
    public Button deluxeMaButton;

    @FXML
    public Button oasisMaButton;

    @FXML
    public Button gelMaButton;

    @FXML
    public Button polishNailsButton;

    // Powder Powder Powder
    @FXML
    public Button powderFullSetButton;

    @FXML
    public Button powderWhiteTipButton;

    @FXML
    public Button powderFullSetGelButton;

    @FXML
    public Button powderDippingButton;

    @FXML
    public Button powderDippingGelButton;

    @FXML
    public Button powderFillButton;

    @FXML
    public Button powderFillGelButton;

    // Pedicure Pedicure Pedicure
    @FXML
    public Button pedicureKidButton;

    @FXML
    public Button pedicurePrincessButton;

    @FXML
    public Button pedicureBasicButton;

    @FXML
    public Button pedicureDeluxeButton;

    @FXML
    public Button pedicureOasisButton;

    @FXML
    public Button pedicureOnsenButton;

    // Additional Additional Additional
    @FXML
    public Button addOtherButton;

    @FXML
    public Button addWhiteTipButton;

    @FXML
    public Button addDesignButton;

    @FXML
    public Button addGelButton;

    @FXML
    public Button addKidGelButton;

    @FXML
    public Button addPolishToesButton;

    // Waxing Waxing Waxing
    @FXML
    public Button waxingEyebrowsButton;

    @FXML
    public Button waxingLipsButton;

    @FXML
    public Button waxingChinButton;

    @FXML
    public Button waxingSideburnsButton;

    @FXML
    public Button waxingFullFaceButton;

    @FXML
    public Button waxingUnderArmButton;

    @FXML
    public Button waxingFacialButton;

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        basicMaButton.setOnMouseClicked(e -> addService(main.tempTurn.basicMa, 13.0, 13.0, basicMaButton));
        deluxeMaButton.setOnMouseClicked(e -> addService(main.tempTurn.deluxeMa, 18.0, 18.0, deluxeMaButton));
        oasisMaButton.setOnMouseClicked(e -> addService(main.tempTurn.oasisMa, 25.0, 25.0, oasisMaButton));
        gelMaButton.setOnMouseClicked(e -> addService(main.tempTurn.gelMa, 30.0,30.0, gelMaButton));
        polishNailsButton.setOnMouseClicked(e -> addService(main.tempTurn.polishNails, 8.0, 8.0, polishNailsButton));

        powderFullSetButton.setOnMouseClicked(e -> addService(main.tempTurn.powderFullSet, 30.0, 30.0, powderFullSetButton));
        powderFullSetGelButton.setOnMouseClicked(e -> addService(main.tempTurn.powderFullSetGe, 45.0, 45.0, powderFullSetGelButton));
        powderWhiteTipButton.setOnMouseClicked(e -> addService(main.tempTurn.powderWhiteTip, 35.0, 35.0, powderWhiteTipButton));
        powderDippingButton.setOnMouseClicked(e -> addService(main.tempTurn.powderDipping, 35.0, 35.0, powderDippingButton ));
        powderDippingGelButton.setOnMouseClicked(e -> addService(main.tempTurn.powderDippingGel, 40.0, 40.0, powderDippingGelButton));
        powderFillButton.setOnMouseClicked(e -> addService(main.tempTurn.powderFill, 20.0, 20.0, powderDippingButton));
        powderDippingGelButton.setOnMouseClicked(e -> addService(main.tempTurn.powderDippingGel, 35.0, 35.0, powderDippingGelButton));

        pedicureBasicButton.setOnMouseClicked(e -> addService(main.tempTurn.pedicureBasic, 26.0, 25.0, pedicureBasicButton));
        pedicureDeluxeButton.setOnMouseClicked(e -> addService(main.tempTurn.pedicureDeluxe, 36.0, 35.0, pedicureDeluxeButton));
        pedicureOasisButton.setOnMouseClicked(e -> addService(main.tempTurn.pedicureOasis, 46.0, 45.0, pedicureOasisButton));
        pedicureOnsenButton.setOnMouseClicked(e -> addService(main.tempTurn.pedicureOnsen, 56.0, 55.0, pedicureOnsenButton));
        pedicureKidButton.setOnMouseClicked(e -> addService(main.tempTurn.pedicureKid, 21.0, 20.0, pedicureKidButton));
        pedicurePrincessButton.setOnMouseClicked(e -> addService(main.tempTurn.pedicurePrincess, 26.0, 25.0, pedicurePrincessButton));
        addPolishToesButton.setOnMouseClicked(e -> addService(main.tempTurn.addPolishToes, 10.0, 10.0, pedicurePrincessButton));

        addWhiteTipButton.setOnMouseClicked(e -> addService(main.tempTurn.addWhiteTip, 5.0, 5.0, addWhiteTipButton));
        addDesignButton.setOnMouseClicked(e -> addService(main.tempTurn.addDesign, 5.0, 5.0, addDesignButton));
        addGelButton.setOnMouseClicked(e -> addService(main.tempTurn.addGel, 15.0, 15.0, addGelButton));
        addKidGelButton.setOnMouseClicked(e -> addService(main.tempTurn.addKidGel, 10.0, 10.0, addKidGelButton));
        addOtherButton.setOnMouseClicked(e -> addService(main.tempTurn.addOther, 5.0, 5.0, addOtherButton));

        waxingEyebrowsButton.setOnMouseClicked(e -> addService(main.tempTurn.waxingEyebrows, 8.0, 8.0, waxingEyebrowsButton));
        waxingLipsButton.setOnMouseClicked(e -> addService(main.tempTurn.waxingLips, 7.0, 7.0, waxingLipsButton));
        waxingChinButton.setOnMouseClicked(e -> addService(main.tempTurn.waxingChin, 10.0, 10.0, waxingChinButton));
        waxingSideburnsButton.setOnMouseClicked(e -> addService(main.tempTurn.waxingSideburns, 15.0, 15.0, waxingSideburnsButton));
        waxingUnderArmButton.setOnMouseClicked(e -> addService(main.tempTurn.waxingUnderArm, 25.0, 25.0, waxingUnderArmButton));
        waxingFullFaceButton.setOnMouseClicked(e -> addService(main.tempTurn.waxingFullFace, 35.0, 35.0, waxingFullFaceButton));
        waxingFacialButton.setOnMouseClicked(e -> addService(main.tempTurn.waxingFacial, 55.0, 55.0, waxingFacialButton));

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
            button.setStyle("-fx-background-color: rgb(50,50,50); -fx-text-fill: white");
        }
    }

//    ********************
//    * check this out
//    ********************

    public void updateServiceButtonColor() {
        changeServiceButtonsColor(main.tempTurn.basicMa, basicMaButton);
        changeServiceButtonsColor(main.tempTurn.deluxeMa, deluxeMaButton);
        changeServiceButtonsColor(main.tempTurn.oasisMa, oasisMaButton);
        changeServiceButtonsColor(main.tempTurn.gelMa, gelMaButton);
        changeServiceButtonsColor(main.tempTurn.polishNails, polishNailsButton);

        changeServiceButtonsColor(main.tempTurn.powderFullSet, powderFullSetButton);
        changeServiceButtonsColor(main.tempTurn.powderFullSetGe, powderFullSetGelButton);
        changeServiceButtonsColor(main.tempTurn.powderWhiteTip, powderWhiteTipButton);
        changeServiceButtonsColor(main.tempTurn.powderDipping, powderDippingButton);
        changeServiceButtonsColor(main.tempTurn.powderDippingGel, powderDippingGelButton);
        changeServiceButtonsColor(main.tempTurn.powderFill, powderFillButton);
        changeServiceButtonsColor(main.tempTurn.powderFillGel, powderFullSetGelButton);

        changeServiceButtonsColor(main.tempTurn.pedicureBasic, pedicureBasicButton);
        changeServiceButtonsColor(main.tempTurn.pedicureDeluxe, pedicureDeluxeButton);
        changeServiceButtonsColor(main.tempTurn.pedicureOasis, pedicureOasisButton);
        changeServiceButtonsColor(main.tempTurn.pedicureOnsen, pedicureOnsenButton);
        changeServiceButtonsColor(main.tempTurn.pedicureKid, pedicureKidButton);
        changeServiceButtonsColor(main.tempTurn.pedicurePrincess, pedicurePrincessButton);

        changeServiceButtonsColor(main.tempTurn.addOther, addOtherButton);
        changeServiceButtonsColor(main.tempTurn.addKidGel, addKidGelButton);
        changeServiceButtonsColor(main.tempTurn.addGel, addGelButton);
        changeServiceButtonsColor(main.tempTurn.addDesign, addDesignButton);
        changeServiceButtonsColor(main.tempTurn.addWhiteTip, addWhiteTipButton);
        changeServiceButtonsColor(main.tempTurn.addPolishToes, addPolishToesButton);

        changeServiceButtonsColor(main.tempTurn.waxingLips, waxingLipsButton);
        changeServiceButtonsColor(main.tempTurn.waxingChin, waxingChinButton);
        changeServiceButtonsColor(main.tempTurn.waxingEyebrows, waxingEyebrowsButton);
        changeServiceButtonsColor(main.tempTurn.waxingSideburns, waxingSideburnsButton);
        changeServiceButtonsColor(main.tempTurn.waxingFullFace, waxingFullFaceButton);
        changeServiceButtonsColor(main.tempTurn.waxingUnderArm, waxingUnderArmButton);
        changeServiceButtonsColor(main.tempTurn.waxingFacial, waxingFacialButton);
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
