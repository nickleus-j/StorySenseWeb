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
