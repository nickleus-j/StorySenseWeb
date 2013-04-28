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
package infoResource;

public enum AttributeNames {

	user("user"),querylimit("limit"),Level("level"),Story("Story"),Learner("learner"),
	TemplateLevJsAttri("JsParamlvMinxoxo"),templateID("templateID");
	private String mask;
	private AttributeNames(String Themask){this.mask = Themask;}
	@Override
	public String toString(){ return mask;}
	

	public String getTemplateLevJsAttri(){ return "JsParamlvMinxoxo";}
}
