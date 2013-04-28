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
/**
 * The names of the elements in the form are here so that the names of the elements do not need to be memorized
 * @author nickleus
 *
 */
public enum RegistrationElements {
	
	Role("role"),RegisFormName("Registration"),usernameElem("username"),uNameError("usernameError"),
			iniPassID("initialPassword"),confirPassID("confirmPassword"),passErorrID("PasswordError"),
			fNameID("firstname"),fNameError("firstnameError"),sNameID("surname"),sNameError("surnameError"),
			month("month"),day("day"),year("year"),
			bdayError("bdayError"),profilePicID("profPic"),pictureError("pictureError");
	
	private String mask;
	private RegistrationElements(String Themask){this.mask = Themask;}
	@Override
	public String toString(){ return mask;}
}
