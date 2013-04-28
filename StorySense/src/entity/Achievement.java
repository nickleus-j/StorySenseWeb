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

public class Achievement {
	private int ID;
	private String Title,Description;
	
	
	public int getID() {return ID;}
	public void setID(int iD) {ID = iD;}
	public String getTitle() {return Title;}
	public void setTitle(String title) {Title = title;}
	public String getDescription() {return Description;}
	public void setDescription(String description) {Description = description;}
	
}
