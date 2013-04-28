package infoResource;

public class ReviewerResource {

	public String[] getSatisfactionOptions(){
		String[] options={"Unsatisfactory","Almost Satisfactory","Satisfactory",
				"Above Satisfactory","Excellent"};
		
		return options;
	}
	public String getSatisfactionBoxId(){return "quality";}
	public String getStoryIDParameter(){return "acomID";}
	public String getTemplateLevForm(){ return "levelTry";}
	public String getTemplateLevBoxId(){ return "levelTry";}
	public String getTemplateLevelRadioID(){return "strinctLevel";}
	public String getTemplateMinLevelRadioID(){return "atLeastLevel";}
	public String getTemplateLevJsAttri(){ return "JsParamlvMinxoxo";}
}
