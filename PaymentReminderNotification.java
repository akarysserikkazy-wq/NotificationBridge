public class PaymentReminderNotification extends Notification {

    private final int amount;

    public PaymentReminderNotification(MessageSender sender, int amount) {
        super(sender);
        this.amount = amount;
    }

    @Override
    public void notifyUser(String recipient) {
        sender.send(recipient, "Reminder: please pay " + amount + " tg.");
    }
}