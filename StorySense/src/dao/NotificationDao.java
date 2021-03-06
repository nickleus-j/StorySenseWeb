package dao;

import entity.Notification;
import java.util.List;

public abstract class NotificationDao {

	public abstract void insertNotification(Notification given);
	public abstract void updateNotification(Notification given);
	public abstract void updateNotificationView(int notificationID,String viewed);
	public abstract List<Notification> getAllNotifications();
	public abstract Notification getNotification(int id);
	public abstract List<Notification> getUserNotifications(int userID);
	public abstract List<Notification> getUserNotifications(int userID,int maximumNotifAge);
	public abstract boolean doesUserHaveUnviwedNotifications(int userID);
	public abstract Notification getLatestNotification(int userID);
}
