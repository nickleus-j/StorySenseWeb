package infoResource;

public class ReviewerResource {

	public String[] getSatisfactionOptions(){
		String[] options={"Unsatisfactory","Almost Satisfactory","Satisfactory",
				"Above Satisfactory","Excellent"};
		
		return options;
	}
	public String getSatisfactionBoxId(){return "quality";}
	public String getStoryIDParameter(){return "acomID";}
}
