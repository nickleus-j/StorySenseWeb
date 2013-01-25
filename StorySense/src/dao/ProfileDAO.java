package dao;

import java.util.List;

import entity.Profile;
import entity.User;

public abstract class ProfileDAO {

	public abstract void addProfile(Profile profile);
	public abstract void setProfile(Profile profile);
	public abstract Profile getProfile(User u);
	public abstract Profile getProfile(int account);
	public abstract List<String> getLeaderPicUrl();
}
