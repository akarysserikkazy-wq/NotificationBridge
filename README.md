## Assignment #3 — Bridge pattern
### Student: Serikkazy Akarys
### Group: SE-2514

### About the product.

The application simulates a notification service. A notification has two independent dimensions of variation:

What is sent (Abstraction side): a welcome message, a payment reminder, a security alert.

How it is delivered (Implementor side): Email, SMS, Push.

Without Bridge, every combination would need its own class (WelcomeEmail, WelcomeSms, PaymentReminderPush, ): 3 notification types x 3 delivery channels = 9 concrete classes, and adding one more channel means adding 3 more classes. With Bridge, the two hierarchies are connected by composition, so only 3 + 3 = 6 concrete classes are needed (plus the abstract Notification and the MessageSender interface), and adding one more channel means adding just 1 class. Any notification can be combined with any sender, even at runtime.

### Clean Code Requirements
#### 1. Clear separation of abstraction-side vs. implementation-side responsibilities (no leaking implementor details to the client)
The notification knows only what to say; the sender knows only how to deliver. The client works with the abstraction and never touches delivery details.

    Notification reminder = new PaymentReminderNotification(new SmsSender(), 1000);
    reminder.notifyUser("+7 777 123 45 67");

#### 2. Meaningful names distinguishing Abstraction vs. Implementor roles
Notification vs MessageSender immediately shows which side is the abstraction and which is the implementor. Method names say what they do.

    notification.notifyUser(recipient);
    notification.setSender(new PushSender());
    sender.send(recipient, text);
    
#### 3. Small, focused classes on both sides of the bridge
Each class has one responsibility and one or two short methods. The interface declares a single operation.

    public interface MessageSender {
        void send(String recipient, String text);
    }

    public abstract void notifyUser(String recipient);   - the only thing a notification must define

Fields that never change after construction are private final:

    private final int amount;
    private final String location;
     
#### 4. No duplicated logic between Concrete Implementors
Delivery logic lives only in the *Sender classes. Message text lives only in the *Notification classes. The common behavior (storing and replacing the sender) is written once in Notification and inherited.

    protected Notification(MessageSender sender) {
       this.sender = sender;
    }

    public void setSender(MessageSender sender) {
        this.sender = sender;
    }

#### 5. Backward-compatible design (adding a new Concrete Implementor requires no change to the Abstraction)
Adding a new Concrete Implementor (e.g. TelegramSender) or a new Refined Abstraction (e.g. SecurityAlertNotification) requires only one new file. Notification, MessageSender and all existing classes stay unchanged. This is possible because Notification depends on the MessageSender interface, not on a concrete class.

    protected MessageSender sender;
    Notification alert = new SecurityAlertNotification(new PushSender(), "Almaty");
