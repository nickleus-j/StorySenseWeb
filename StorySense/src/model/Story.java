/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

import entity.Relation;

/**
 *
 * @author Lenovo
 */
public class Story {
    
    private String sStory;
    private ArrayList<ArrayList<Relation>> Assertions;
    private ArrayList<Relation> RelationRules;
    private ArrayList<Question> Question;
    private int blanks;

    public int getBlanks() {
        return blanks;
    }

    public void setBlanks(int blanks) {
        this.blanks = blanks;
    }

    public ArrayList<Relation> getRelationRules() {
        return RelationRules;
    }

    public void setRelationRules(ArrayList<Relation> RelationRules) {
        this.RelationRules = RelationRules;
    }
    
    public ArrayList<ArrayList<Relation>> getAssertions() {
        return Assertions;
    }

    public void setAssertions(ArrayList<ArrayList<Relation>> arrAssertions) {
        this.Assertions = arrAssertions;
    }

    public String getsStory() {
        return sStory;
    }

    public void setsStory(String sStory) {
        this.sStory = sStory;
    }

    public ArrayList<model.Question> getQuestion() {
        return Question;
    }

    public void setQuestion(ArrayList<model.Question> Question) {
        this.Question = Question;
    }

    
    
    
    
    
}
