/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Lenovo
 */
public class Relation {
    private String Concept1;
    private String Concept2;
    private String Relationship;
    private int confidence_percentage;
    private int total_score;
    private int times_validated;

    public String getConcept1() {
        return Concept1;
    }

    public void setConcept1(String Concept1) {
        this.Concept1 = Concept1;
    }

    public String getConcept2() {
        return Concept2;
    }

    public void setConcept2(String Concept2) {
        this.Concept2 = Concept2;
    }

    public String getRelationship() {
        return Relationship;
    }

    public void setRelationship(String Relationship) {
        this.Relationship = Relationship;
    }

    public int getConfidence_percentage() {
        return confidence_percentage;
    }

    public void setConfidence_percentage(int confidence_percentage) {
        this.confidence_percentage = confidence_percentage;
    }

    public int getTimes_validated() {
        return times_validated;
    }

    public void setTimes_validated(int times_validated) {
        this.times_validated = times_validated;
    }

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }
    
    
}
