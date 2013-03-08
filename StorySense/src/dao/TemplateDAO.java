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
	public abstract Template getTemplate(int id);
}
