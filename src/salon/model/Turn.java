package salon.model;

import salon.util.BooleanWrapper;

import java.util.ArrayList;


public class Turn {
    private double service;
    private double base;
    private double tip;

    private double card;
    private double cash;
    private double gift;
    private double check;

    private double off;

    public BooleanWrapper basicMa;

    public BooleanWrapper deluxeMa;

    public BooleanWrapper oasisMa;

    public BooleanWrapper gelMa;

    public BooleanWrapper polishNails;

    // Powder Powder Powder
    public BooleanWrapper powderFullSet;

    public BooleanWrapper powderWhiteTip;

    public BooleanWrapper powderFullSetGe;

    public BooleanWrapper powderDipping;

    public BooleanWrapper powderDippingGel;

    public BooleanWrapper powderFill;

    public BooleanWrapper powderFillGel;

    // Pedicure Pedicure Pedicure
    public BooleanWrapper pedicureKid;

    public BooleanWrapper pedicurePrincess;

    public BooleanWrapper pedicureBasic;

    public BooleanWrapper pedicureDeluxe;

    public BooleanWrapper pedicureOasis;

    public BooleanWrapper pedicureOnsen;

    // Additional Additional Additional
    public BooleanWrapper addOther;

    public BooleanWrapper addWhiteTip;

    public BooleanWrapper addDesign;

    public BooleanWrapper addGel;

    public BooleanWrapper addKidGel;

    public BooleanWrapper addPolishToes;

    // Waxing Waxing Waxing
    public BooleanWrapper waxingEyebrows;

    public BooleanWrapper waxingLips;

    public BooleanWrapper waxingChin;

    public BooleanWrapper waxingSideburns;

    public BooleanWrapper waxingFullFace;

    public BooleanWrapper waxingUnderArm;

    public BooleanWrapper waxingFacial;

    private ArrayList<BooleanWrapper> doneServices;

    public Turn(){
        this.service = 0.0;
        this.base = 0.0;
        this.tip = 0.0;

        this.card = 0.0;
        this.cash = 0.0;
        this.gift = 0.0;
        this.check = 0.0;

        this.off = 0.0;

        this.basicMa = new BooleanWrapper(false);

        this.deluxeMa = new BooleanWrapper(false);

        this.oasisMa = new BooleanWrapper(false);

        this.gelMa = new BooleanWrapper(false);

        this.polishNails = new BooleanWrapper(false);

        // Powder Powder Powder
        this.powderFullSet = new BooleanWrapper(false);

        this.powderWhiteTip = new BooleanWrapper(false);

        this.powderFullSetGe = new BooleanWrapper(false);

        this.powderDipping = new BooleanWrapper(false);

        this.powderDippingGel = new BooleanWrapper(false);

        this.powderFill = new BooleanWrapper(false);

        this.powderFillGel = new BooleanWrapper(false);

        // Pedicure Pedicure Pedicure
        this.pedicureKid = new BooleanWrapper(false);

        this.pedicurePrincess = new BooleanWrapper(false);

        this.pedicureBasic = new BooleanWrapper(false);

        this.pedicureDeluxe = new BooleanWrapper(false);

        this.pedicureOasis = new BooleanWrapper(false);

        this.pedicureOnsen = new BooleanWrapper(false);

        // Additional Additional Additional
        this.addOther = new BooleanWrapper(false);

        this.addWhiteTip = new BooleanWrapper(false);

        this.addDesign = new BooleanWrapper(false);

        this.addGel = new BooleanWrapper(false);

        this.addKidGel = new BooleanWrapper(false);

        this.addPolishToes = new BooleanWrapper(false);

        // Waxing Waxing Waxing
        this.waxingEyebrows = new BooleanWrapper(false);

        this.waxingLips = new BooleanWrapper(false);

        this.waxingChin = new BooleanWrapper(false);

        this.waxingSideburns = new BooleanWrapper(false);

        this.waxingFullFace = new BooleanWrapper(false);

        this.waxingUnderArm = new BooleanWrapper(false);

        this.waxingFacial = new BooleanWrapper(false);

        doneServices = new ArrayList<>();
        doneServices.add(basicMa);
        doneServices.add(deluxeMa);
        doneServices.add(oasisMa);
        doneServices.add(gelMa);
        doneServices.add(polishNails);

        doneServices.add(powderFullSet);
        doneServices.add(powderFullSetGe);
        doneServices.add(powderWhiteTip);
        doneServices.add(powderDipping);
        doneServices.add(powderDippingGel);
        doneServices.add(powderFill);
        doneServices.add(powderFillGel);

        doneServices.add(pedicureBasic);
        doneServices.add(pedicureDeluxe);
        doneServices.add(pedicureOasis);
        doneServices.add(pedicureKid);
        doneServices.add(pedicurePrincess);
        doneServices.add(pedicureOnsen);

        doneServices.add(addOther);
        doneServices.add(addWhiteTip);
        doneServices.add(addDesign);
        doneServices.add(addGel);
        doneServices.add(addKidGel);
        doneServices.add(addPolishToes);

        doneServices.add(waxingLips);
        doneServices.add(waxingChin);
        doneServices.add(waxingSideburns);
        doneServices.add(waxingFullFace);
        doneServices.add(waxingUnderArm);
        doneServices.add(waxingFacial);
        doneServices.add(waxingEyebrows);
    }

    public double getService() {
        return service;
    }

    public void setService(double service) {
        this.service = service;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public double getCard() {
        return card;
    }

    public void setCard(double card) {
        this.card = card;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getGift() {
        return gift;
    }

    public void setGift(double gift) {
        this.gift = gift;
    }

    public double getCheck() {
        return check;
    }

    public void setCheck(double check) {
        this.check = check;
    }

    public double getOff() {
        return off;
    }

    public void setOff(double off) {
        this.off = off;
    }

    public BooleanWrapper getBasicMa() {
        return basicMa;
    }

    public void setBasicMa(BooleanWrapper basicMa) {
        this.basicMa = basicMa;
    }

    public ArrayList<BooleanWrapper> getDoneServices() {
        return doneServices;
    }

    public void setDoneServices(ArrayList<BooleanWrapper> doneServices) {
        this.doneServices = doneServices;
    }

    @Override
    public String toString() {
        return base + " + " + tip;
    }

    public String checkPoint() {
        return "\nService: " + service + " Base: " + base + " Tip: " + tip + " Off: " + off +
                "\nCard: " + card + " Cash: " + cash + " Gift: " + gift + " Check: " + check;
    }
}
