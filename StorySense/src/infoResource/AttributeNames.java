package infoResource;

public enum AttributeNames {

	user("user"),querylimit("limit"),Level("level"),Story("Story"),
	TemplateLevJsAttri("JsParamlvMinxoxo"),templateID("templateID");
	private String mask;
	private AttributeNames(String Themask){this.mask = Themask;}
	@Override
	public String toString(){ return mask;}
	

	public String getTemplateLevJsAttri(){ return "JsParamlvMinxoxo";}
}
