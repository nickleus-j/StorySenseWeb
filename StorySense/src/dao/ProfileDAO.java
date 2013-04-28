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

import entity.Profile;
import entity.User;

public abstract class ProfileDAO {

	public abstract void addProfile(Profile profile);
	public abstract void setProfile(Profile profile);
	public abstract Profile getProfile(User u);
	public abstract Profile getProfile(int account);
	public abstract List<String> getLeaderPicUrl();
}
