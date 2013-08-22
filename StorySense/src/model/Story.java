/*******************************************************************************
 *Copyright (c) 2013 IBM Corporation and others.
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    IBM Corporation - initial API and implementation
 *******************************************************************************/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

import entity.Relation;

/**
 *
 * @author Lenovo
 */
public class Story implements Serializable{
    
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
