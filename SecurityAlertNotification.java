public class SecurityAlertNotification extends Notification {

    private final String location;

    public SecurityAlertNotification(MessageSender sender, String location) {
        super(sender);
        this.location = location;
    }

    @Override
    public void notifyUser(String recipient) {
        sender.send(recipient, "Security alert: new login from " + location + ".");
    }
}