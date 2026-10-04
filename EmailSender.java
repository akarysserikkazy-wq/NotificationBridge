public class EmailSender implements MessageSender {

    @Override
    public void send(String recipient, String text) {
        System.out.println("[EMAIL] to " + recipient + ": " + text);
    }
}