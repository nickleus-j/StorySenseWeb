/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Query {
    private String Query;
    private ArrayList<String> arrValues;

    public String getQuery() {
        return Query;
    }

    public void setQuery(String Query) {
        this.Query = Query;
    }

    public ArrayList<String> getArrValues() {
        return arrValues;
    }

    public void setArrValues(ArrayList<String> arrValues) {
        this.arrValues = arrValues;
    }
        
}
