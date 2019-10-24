package salon.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Person {

    private String firstName;
    private String lastName;

    private int index;

    private double total;
    private double tip;

    private ObservableList<Turn> turns;
    private ObservableList<Turn> bonuses;

    public Person() {
        this.index = -1;

        this.total = 0.0;
        this.tip = 0.0;

        this.turns = FXCollections.observableArrayList();
        this.bonuses = FXCollections.observableArrayList();
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.index = -1;

        this.total = 0.0;
        this.tip = 0.0;

        this.turns = FXCollections.observableArrayList();
        this.bonuses = FXCollections.observableArrayList();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public ObservableList<Turn> getTurns() {
        return turns;
    }

    public void setTurns(ObservableList<Turn> turns) {
        this.turns = turns;
    }

    public ObservableList<Turn> getBonuses() {
        return bonuses;
    }

    public void setBonuses(ObservableList<Turn> bonuses) {
        this.bonuses = bonuses;
    }

    @Override
    public String toString(){
        return firstName;
    }
}
