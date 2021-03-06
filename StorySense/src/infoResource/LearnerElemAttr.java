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

public class LearnerElemAttr {

	public String getLearnerSummaryID(){return "LearnerSummary";}
	public String getScoreSummaryID(){return "storyScoreTbl";}
	public String getStoryIdParameter(){ return "paramAcom";}
	public String getLearnerTableDefId(){return "tableBorder3";}
	public String getUserParamName(){ return "viewedUser";}
	public String getNotificationPanelId(){return "notificationPanel";}
	public String getNotifPanelId(String suffix){return "notificationPanel"+suffix;}
	public String notificationListId(String suffix){return "notificationList"+suffix;}
	/*LearnerHomeSample.jsp*/
}
