package worker;

public enum AttributeNames {

	user("user"),querylimit("limit"),Level("level");
	private String mask;
	private AttributeNames(String Themask){this.mask = Themask;}
	@Override
	public String toString(){ return mask;}
}
