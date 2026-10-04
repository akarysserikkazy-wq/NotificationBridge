public class SmsSender implements MessageSender {

    @Override
    public void send(String recipient, String text) {
        System.out.println("[SMS] to " + recipient + ": " + text);
    }
}