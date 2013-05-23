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
package dao;

import java.util.List;

import entity.Concept;


public abstract class ConceptDAO {

	public abstract void AddConcept(String Word_Phrase);
	public abstract List<Concept> getConcepts();
	public abstract List<Concept> getConceptWithMatchingTitle(String concept);
	public abstract Concept getConcept(String concept);
	public abstract void updateFrequency(String concept,int freq);
	public abstract Concept getPopularConcept();
}
