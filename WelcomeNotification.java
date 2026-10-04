public class WelcomeNotification extends Notification {

    public WelcomeNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void notifyUser(String recipient) {
        sender.send(recipient, "Welcome! Thanks for joining us.");
    }
}