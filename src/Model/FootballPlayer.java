/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Vu Dai Duong
 */
public class FootballPlayer {
    private String name;
    private int birthYear;
    private int index;
    private String position;

    public FootballPlayer(){
    }

    public FootballPlayer(String name, int birthYear, int index, String position) {
        this.name = name;
        this.birthYear = birthYear;
        this.index = index;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "FootballPlayer{" + "name=" + name + ", birthYear=" + birthYear + ", index=" + index + ", position=" + position + '}';
    }
    
    
}
