public class Main {

    public static void main(String[] args) {

        System.out.println("\n*** Case 1: welcome by email ***");

        Notification welcome = new WelcomeNotification(new EmailSender());
        welcome.notifyUser("akaryss@gmail.com");

        System.out.println("\n*** Case 2: payment reminder by SMS ***");

        Notification reminder = new PaymentReminderNotification(new SmsSender(), 1000);
        reminder.notifyUser("+7 775 123 45 67");

        System.out.println("\n*** Case 3: switching sender to PUSH ***");

        reminder.setSender(new PushSender());
        reminder.notifyUser("user-device-01");

        System.out.println("\n*** Case 4: switching welcome to SMS ***");

        welcome.setSender(new SmsSender());
        welcome.notifyUser("+7 700 000 00 00");

        System.out.println("\n*** Case 5: security alert ***");

        Notification alert = new SecurityAlertNotification(new PushSender(), "Almaty");
        alert.notifyUser("user-device-01");
    }
}