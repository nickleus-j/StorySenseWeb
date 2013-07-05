/*******************************************************************************
 *Copyright (c) 2013 StorySense
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickleus Jimenez
 *******************************************************************************/
package dao;

import java.util.List;

import entity.Template;

public abstract class TemplateDAO {

	public abstract void addTemplate(Template giventemplate);
	public abstract void updateTemplate(Template giventemplate);
	public abstract void changeStoryURL(int ID,String newURL);
	public abstract void changeRelationalURL(int ID,String newURL);
	public abstract void changeTemplateName(int ID,String newURL);
	public abstract List<Template> getTemplatebyLevel(int minimumLevel);
	public abstract List<Template> getTemplatebyScore(int minimumPoints);
	public abstract List<Template> getTemplatebyName(String Name);
	public abstract List<Template> getAlltemplates();
	public abstract List<Template> getAlltemplatesOfAuthor(int authorId);
	public abstract List<Template> getGroupedtemplates();
	public abstract Template getTemplate(int id);
}
