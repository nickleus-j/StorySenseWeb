/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

import entity.Relation;

/**
 *
 * @author Lenovo
 */
public class Question implements Serializable{
    private Relation Relation = new Relation();
    private String Question;
    private String Option1;
    private String Option2;

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String Option1) {
        this.Option1 = Option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String Option2) {
        this.Option2 = Option2;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public entity.Relation getRelation() {
        return Relation;
    }

    public void setRelation(entity.Relation Relation) {
        this.Relation = Relation;
    }
    
    
}
