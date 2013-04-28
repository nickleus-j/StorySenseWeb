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

import entity.Relationship;


public abstract class RelationshipDAO {

	public abstract void addRelationship(String Relationship,String Sentence);
	public abstract String getRelationshipSentence(String Relationship);
	public abstract List<Relationship> getRelationships();
	//public abstract Relationship getMatchingRelationship(String Relationship);
}
