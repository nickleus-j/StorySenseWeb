package entity;

public class ConfigValues {

	private int valueID;
	private String settingName,Value;
	
	public int getValueID() {
		return valueID;
	}
	public void setValueID(int valueID) {
		this.valueID = valueID;
	}
	public String getSettingName() {
		return settingName;
	}
	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	
	public String getConfidenceSettingName(){return "Confidence_THRESHOLD";}
}
