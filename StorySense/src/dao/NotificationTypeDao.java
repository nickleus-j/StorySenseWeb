package dao;

import entity.NotificationType;
import java.util.List;

public abstract class NotificationTypeDao {

	public abstract void insertNotificationType(NotificationType given);
	public abstract void updateNotificationType(NotificationType given);
	public abstract List<NotificationType> getNotificationTypes();
	public abstract NotificationType getNotificationType(int id);
}
