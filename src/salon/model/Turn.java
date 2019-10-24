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

        doneServices = new ArrayList<>();
        doneServices.add(basicMa);
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
