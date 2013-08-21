package dao;

import entity.NotifMessage;
import java.util.List;

public abstract class NotificationMessageDao {

	public abstract void insertNotificationMessage(NotifMessage given);
	public abstract void updateNotificationMessage(NotifMessage given);
	public abstract List<NotifMessage> getAllNotifMsgs();
	public abstract List<NotifMessage> getUserMessages(int userID);
	public abstract List<NotifMessage> getUserMessages(int userID,int maximumMessageAge);
	public abstract List<NotifMessage> getMessagesOfNotice(int notifId);
	public abstract List<NotifMessage> getMessagesForType(int typeID);
}
