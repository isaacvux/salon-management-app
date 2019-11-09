package salon.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import salon.Main;
import salon.util.BooleanWrapper;

import java.net.URL;
import java.util.ArrayList;
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

    private ArrayList<Button> serviceButtons = new ArrayList<>();

    private ArrayList<Button> paymentMethodButtons = new ArrayList<>();

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cardButton.setOnMouseClicked(e -> handleCardButton());
        cashButton.setOnMouseClicked(e -> handleCashButton());
        giftButton.setOnMouseClicked(e -> handleGiftButton());
        checkButton.setOnMouseClicked(e -> handleCheckButton());

        offButton.setOnMouseClicked(e -> handleOffButton());

        cardTextField.setOnKeyTyped(e -> main.tempTurn.setCard(Double.parseDouble(cardTextField.getText())));
        cashTextField.setOnKeyTyped(e -> main.tempTurn.setCash(Double.parseDouble(cashTextField.getText())));
        giftTextField.setOnKeyTyped(e -> main.tempTurn.setGift(Double.parseDouble(giftTextField.getText())));
        checkTextField.setOnKeyTyped(e -> main.tempTurn.setCheck(Double.parseDouble(checkTextField.getText())));

        offTextField.setOnKeyTyped(e -> handleOffTextField());

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
        powderFillButton.setOnMouseClicked(e -> addService(main.tempTurn.powderFill, 20.0, 20.0, powderFillButton));
        powderFillGelButton.setOnMouseClicked(e -> addService(main.tempTurn.powderFillGel, 35.0, 35.0, powderFillGelButton));

        pedicureBasicButton.setOnMouseClicked(e -> addService(main.tempTurn.pedicureBasic, 26.0, 25.0, pedicureBasicButton));
        pedicureDeluxeButton.setOnMouseClicked(e -> addService(main.tempTurn.pedicureDeluxe, 36.0, 35.0, pedicureDeluxeButton));
        pedicureOasisButton.setOnMouseClicked(e -> addService(main.tempTurn.pedicureOasis, 46.0, 45.0, pedicureOasisButton));
        pedicureOnsenButton.setOnMouseClicked(e -> addService(main.tempTurn.pedicureOnsen, 56.0, 55.0, pedicureOnsenButton));
        pedicureKidButton.setOnMouseClicked(e -> addService(main.tempTurn.pedicureKid, 21.0, 20.0, pedicureKidButton));
        pedicurePrincessButton.setOnMouseClicked(e -> addService(main.tempTurn.pedicurePrincess, 26.0, 25.0, pedicurePrincessButton));
        addPolishToesButton.setOnMouseClicked(e -> addService(main.tempTurn.addPolishToes, 10.0, 10.0, addPolishToesButton));

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
            setTurnTextField();
            tipTextField.selectAll();});
        tipTextField.setOnKeyTyped(e -> handleTipTextfield());

        cardTextField.setOnMouseClicked(e -> cardTextField.selectAll());
        cashTextField.setOnMouseClicked(e -> cashTextField.selectAll());
        giftTextField.setOnMouseClicked(e -> cashTextField.selectAll());
        checkTextField.setOnMouseClicked(e -> cashTextField.selectAll());

        offTextField.setOnMouseClicked(e -> offTextField.selectAll());
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
//        main.writeInformation(main.tempLocalDate);
        setTurnTextField();
    }

    public void handleServiceTextfield() {
//        updateTextField();
        main.tempTurn.setService(Double.parseDouble(serviceTextField.getText()));
        main.tempTurn.setBase(Double.parseDouble(serviceTextField.getText()));

        main.resetServices();
        setServiceButtonStatus();
    }

    public void handleTipTextfield() {
        main.tempTurn.setTip(Double.parseDouble(tipTextField.getText()));

//        updateTextField();
    }

    public void setTurnTextField() {
        baseTextField.setText("" + main.tempTurn.getBase());
        tipTextField.setText("" + main.tempTurn.getTip());
        offTextField.setText("" + main.tempTurn.getOff());

        if(main.tempTurn.hasDiscount.getFlag()) {

            serviceTextField.setText("~" + main.tempTurn.getService());

            if(main.tempTurn.payByCard.getFlag()) {
                cardTextField.setText("~" + main.tempTurn.getCard());
            }
            if(main.tempTurn.payByCash.getFlag()) {
                cashTextField.setText("~" + main.tempTurn.getCash());
            }
            if(main.tempTurn.payByGift.getFlag()) {
                giftTextField.setText("~" + main.tempTurn.getGift());
            }
            if(main.tempTurn.payByCheck.getFlag()) {
                checkTextField.setText("~" + main.tempTurn.getCheck());
            }
        }
        else {
            serviceTextField.setText("" + main.tempTurn.getService());
            cardTextField.setText("" + main.tempTurn.getCard());
            cashTextField.setText("" + main.tempTurn.getCash());
            giftTextField.setText("" + main.tempTurn.getGift());
            checkTextField.setText("" + main.tempTurn.getCheck());
        }

    }

    public void changeButtonsColor(BooleanWrapper buttonIsPressed, Button button) {
        if(buttonIsPressed.getFlag() == false) {
            button.setStyle("-fx: default");
        }
        else {
//            button.setStyle("-fx-background-color: rgb(17,178,235)");
            button.setStyle("-fx-background-color: rgb(50,50,50); -fx-text-fill: white");
        }
    }

    public void handleCardButton(){
        if(main.tempTurn.payByCard.getFlag() == false) {
            main.tempTurn.payByCard.setFlag(true);
            main.tempTurn.setCard(main.tempTurn.getService() - main.tempTurn.getCash() - main.tempTurn.getGift() - main.tempTurn.getCheck());
//            cardTextField.setDisable(false);
        }
        else {
            main.tempTurn.payByCard.setFlag(false);
            main.tempTurn.setCard(0.0);
//            cardTextField.setDisable(true);
        }

        setTurnTextField();
        setPaymentTextFieldStatus();
        setPaymentMethodButtonStatus();

//        main.writeInformation(main.tempLocalDate);
    }

    public void handleCashButton(){
        if(main.tempTurn.payByCash.getFlag() == false) {
            main.tempTurn.payByCash.setFlag(true);
            main.tempTurn.setCash(main.tempTurn.getService() - main.tempTurn.getCard() - main.tempTurn.getGift() - main.tempTurn.getCheck());
//            cashTextField.setDisable(false);
        }
        else {
            main.tempTurn.payByCash.setFlag(false);
            main.tempTurn.setCash(0.0);
//            cashTextField.setDisable(true);
        }

        setTurnTextField();
        setPaymentTextFieldStatus();
        setPaymentMethodButtonStatus();

//        main.writeInformation(main.tempLocalDate);
    }

    public void handleGiftButton(){
        if(main.tempTurn.payByGift.getFlag() == false) {
            main.tempTurn.payByGift.setFlag(true);
            main.tempTurn.setGift(main.tempTurn.getService() - main.tempTurn.getCash() - main.tempTurn.getCard() - main.tempTurn.getCheck());
//            giftTextField.setDisable(false);
        }
        else {
            main.tempTurn.payByGift.setFlag(false);
            main.tempTurn.setGift(0.0);
//            giftTextField.setDisable(true);
        }

        setTurnTextField();
        setPaymentTextFieldStatus();
        setPaymentMethodButtonStatus();

//        main.writeInformation(main.tempLocalDate);
    }

    public void handleCheckButton(){
        if(main.tempTurn.payByCheck.getFlag() == false) {
            main.tempTurn.payByCheck.setFlag(true);
            main.tempTurn.setCheck(main.tempTurn.getService() - main.tempTurn.getCash() - main.tempTurn.getGift() - main.tempTurn.getCard());
//            checkTextField.setDisable(false);
        }
        else {
            main.tempTurn.payByCheck.setFlag(false);
            main.tempTurn.setCheck(0.0);
//            checkTextField.setDisable(true);
        }

        setTurnTextField();
        setPaymentTextFieldStatus();
        setPaymentMethodButtonStatus();

//        main.writeInformation(main.tempLocalDate);
    }

    public void handleOffButton(){
        if(main.tempTurn.hasDiscount.getFlag() == false) {
            main.tempTurn.hasDiscount.setFlag(true);
            main.tempTurn.setOff(5.0);
            main.tempTurn.setBase(main.tempTurn.getBase() - main.tempTurn.getOff());

//            offTextField.setDisable(false);
        }
        else {
            main.tempTurn.hasDiscount.setFlag(false);
            main.tempTurn.setBase(main.tempTurn.getBase() + main.tempTurn.getOff());
            main.tempTurn.setOff(0.0);

//            offTextField.setDisable(true);
        }

        setTurnTextField();
        setPaymentTextFieldStatus();
        setPaymentMethodButtonStatus();

//        main.writeInformation(main.tempLocalDate);
    }

    public void handleOffTextField() {
        main.tempTurn.setOff(Double.parseDouble(offTextField.getText()));
        main.tempTurn.setBase(main.tempTurn.getBase() + 5.0 - main.tempTurn.getOff());
        setTurnTextField();
        setPaymentTextFieldStatus();
    }

    public void setServiceButtonStatus() {
        changeButtonsColor(main.tempTurn.basicMa, basicMaButton);
        changeButtonsColor(main.tempTurn.deluxeMa, deluxeMaButton);
        changeButtonsColor(main.tempTurn.oasisMa, oasisMaButton);
        changeButtonsColor(main.tempTurn.gelMa, gelMaButton);
        changeButtonsColor(main.tempTurn.polishNails, polishNailsButton);

        changeButtonsColor(main.tempTurn.powderFullSet, powderFullSetButton);
        changeButtonsColor(main.tempTurn.powderFullSetGe, powderFullSetGelButton);
        changeButtonsColor(main.tempTurn.powderWhiteTip, powderWhiteTipButton);
        changeButtonsColor(main.tempTurn.powderDipping, powderDippingButton);
        changeButtonsColor(main.tempTurn.powderDippingGel, powderDippingGelButton);
        changeButtonsColor(main.tempTurn.powderFill, powderFillButton);
        changeButtonsColor(main.tempTurn.powderFillGel, powderFullSetGelButton);

        changeButtonsColor(main.tempTurn.pedicureBasic, pedicureBasicButton);
        changeButtonsColor(main.tempTurn.pedicureDeluxe, pedicureDeluxeButton);
        changeButtonsColor(main.tempTurn.pedicureOasis, pedicureOasisButton);
        changeButtonsColor(main.tempTurn.pedicureOnsen, pedicureOnsenButton);
        changeButtonsColor(main.tempTurn.pedicureKid, pedicureKidButton);
        changeButtonsColor(main.tempTurn.pedicurePrincess, pedicurePrincessButton);

        changeButtonsColor(main.tempTurn.addOther, addOtherButton);
        changeButtonsColor(main.tempTurn.addKidGel, addKidGelButton);
        changeButtonsColor(main.tempTurn.addGel, addGelButton);
        changeButtonsColor(main.tempTurn.addDesign, addDesignButton);
        changeButtonsColor(main.tempTurn.addWhiteTip, addWhiteTipButton);
        changeButtonsColor(main.tempTurn.addPolishToes, addPolishToesButton);

        changeButtonsColor(main.tempTurn.waxingLips, waxingLipsButton);
        changeButtonsColor(main.tempTurn.waxingChin, waxingChinButton);
        changeButtonsColor(main.tempTurn.waxingEyebrows, waxingEyebrowsButton);
        changeButtonsColor(main.tempTurn.waxingSideburns, waxingSideburnsButton);
        changeButtonsColor(main.tempTurn.waxingFullFace, waxingFullFaceButton);
        changeButtonsColor(main.tempTurn.waxingUnderArm, waxingUnderArmButton);
        changeButtonsColor(main.tempTurn.waxingFacial, waxingFacialButton);
    }

    public void setPaymentMethodButtonStatus(){
        changeButtonsColor(main.tempTurn.payByCard, cardButton);
        changeButtonsColor(main.tempTurn.payByCash, cashButton);
        changeButtonsColor(main.tempTurn.payByGift, giftButton);
        changeButtonsColor(main.tempTurn.payByCheck, checkButton);

        changeButtonsColor(main.tempTurn.hasDiscount, offButton);
    }

    public void setPaymentTextFieldStatus() {
        if(main.tempTurn.payByCard.getFlag()) {
            cardTextField.setStyle("-fx-background-color: rgb(36,173,88)");
            cardTextField.setDisable(false);
        }
        else {
            cardTextField.setStyle("-fx: default");
            cardTextField.setDisable(true);
        }

        if(main.tempTurn.payByCash.getFlag()) {
            cashTextField.setStyle("-fx-background-color: rgb(16,178,236)");
            cashTextField.setDisable(false);
        }
        else {
            cashTextField.setStyle("-fx: default");
            cashTextField.setDisable(true);
        }

        if(main.tempTurn.payByGift.getFlag()) {
            giftTextField.setStyle("-fx-background-color: rgb(264,190,57)");
            giftTextField.setDisable(false);
        }
        else {
            giftTextField.setStyle("-fx: default");
            giftTextField.setDisable(true);
        }

        if(main.tempTurn.payByCheck.getFlag()) {
            checkTextField.setStyle("-fx-background-color: rgb(235,125,64)");
            checkTextField.setDisable(false);
        }
        else {
            checkTextField.setStyle("-fx: default");
            checkTextField.setDisable(true);
        }

        //off off off
        if(main.tempTurn.hasDiscount.getFlag()) {
            offTextField.setStyle("-fx-background-color: rgb(233,87,68)");
            offTextField.setDisable(false);
        }
        else {
            offTextField.setStyle("-fx: default");
            offTextField.setDisable(true);
        }
    }

    public void setUpTurnScene(){
        setTurnTextField();
        setServiceButtonStatus();
        setPaymentMethodButtonStatus();
        setPaymentTextFieldStatus();
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

//        main.controller.listView_0a.refresh();
//        main.controller.listView_0b.refresh();
//        main.controller.listView_1a.refresh();
//        main.controller.listView_1b.refresh();

        // Turn back to main screen
        main.primaryStage.setScene(main.mainScene);
    }
}
