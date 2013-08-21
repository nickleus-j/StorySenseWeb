package dao;

import entity.ConfigValues;

public abstract class ConfigValuesDAO {

	public abstract void insertSetting(ConfigValues config);
	public abstract void updateSetting(ConfigValues config);
	public abstract String getStringValue(String settingName);
	public abstract int getIntValue(String settingName);
}
