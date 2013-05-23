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
package entity;

public class Concept {

	private int ConceptID;
	private String Word_phrase,Frequency ;
	
	/*
	private Concept(){};
	
	Frequency
	public Concept getInstance(){return new Concept();}
	
	public Concept getInstance(String value){
		Word_phrase=value;
		return new Concept();
	}

	/*
	 * accessors and modifiers
	 */
	public int getConceptID() {return ConceptID;}
	public void setConceptID(int conceptID) {ConceptID = conceptID;}
	public String getWord_phrase() {return Word_phrase;}
	public void setWord_phrase(String word_phrase) {Word_phrase = word_phrase;}
	public String getFrequency() {return Frequency;}
	public void setFrequency(String frequency) {Frequency = frequency;}
	
	
	
	
}
