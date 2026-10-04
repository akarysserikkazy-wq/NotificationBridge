public class PushSender implements MessageSender {

    @Override
    public void send(String recipient, String text) {
        System.out.println("[PUSH] to " + recipient + ": " + text);
    }
}