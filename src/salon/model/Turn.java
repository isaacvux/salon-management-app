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

    public BooleanWrapper payByCard;
    public BooleanWrapper payByCash;
    public BooleanWrapper payByGift;
    public BooleanWrapper payByCheck;

    public BooleanWrapper hasDiscount;

    public BooleanWrapper isPassed;

    // Manicure
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

    private ArrayList<BooleanWrapper> services;

    public Turn(){
        this.service = 0;
        this.base = 0;
        this.tip = 0;

        this.card = 0;
        this.cash = 0;
        this.gift = 0;
        this.check = 0;

        this.off = 0;

        payByCard = new BooleanWrapper(false);
        payByCash = new BooleanWrapper(false);
        payByGift = new BooleanWrapper(false);
        payByCheck = new BooleanWrapper(false);

        hasDiscount = new BooleanWrapper(false);

        isPassed = new BooleanWrapper(false);

        // Manicure Manicure Manicure
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

        services = new ArrayList<>();

        services.add(basicMa);
        services.add(deluxeMa);
        services.add(oasisMa);
        services.add(gelMa);
        services.add(polishNails);

        services.add(powderFullSet);
        services.add(powderFullSetGe);
        services.add(powderWhiteTip);
        services.add(powderDipping);
        services.add(powderDippingGel);
        services.add(powderFill);
        services.add(powderFillGel);

        services.add(pedicureBasic);
        services.add(pedicureDeluxe);
        services.add(pedicureOasis);
        services.add(pedicureKid);
        services.add(pedicurePrincess);
        services.add(pedicureOnsen);

        services.add(addOther);
        services.add(addWhiteTip);
        services.add(addDesign);
        services.add(addGel);
        services.add(addKidGel);
        services.add(addPolishToes);

        services.add(waxingLips);
        services.add(waxingChin);
        services.add(waxingSideburns);
        services.add(waxingFullFace);
        services.add(waxingUnderArm);
        services.add(waxingFacial);
        services.add(waxingEyebrows);
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

    public ArrayList<BooleanWrapper> getServices() {
        return services;
    }

    public void setServices(ArrayList<BooleanWrapper> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return paymentMethod() + "   \t" + (int)base + "\t  |\t" + (int)tip + "\t" + hasDiscount() + isPassed();
    }

    public String checkPoint() {
        return "\nService: " + service + " Base: " + base + " Tip: " + tip + " Off: " + off +
                "\nCard: " + card + " Cash: " + cash + " Gift: " + gift + " Check: " + check;
    }

    public String paymentMethod() {
        if (payByCard.getFlag()) {
            return "V";
        }
        else if (payByCash.getFlag()) {
            return "C";
        }
        else if (payByGift.getFlag()) {
            return "G";
        }
        else if (payByCheck.getFlag()) {
            return "K";
        }
        else if (isPassed.getFlag()) {
            return "X";
        }
        return "";
    }

    public String hasDiscount() {
        if (hasDiscount.getFlag()) {
            return "   off";
        }
        return "";
    }

    public String isPassed() {
        if (isPassed.getFlag()) {
            return "   passed";
        }
        return "";
    }
}
