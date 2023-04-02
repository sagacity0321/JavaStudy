package Course1;

interface PhoneInterface{
    final int TIMEOUT = 10000;
    void sendCall();
    void receiveCall();
    default void printLogo(){
        System.out.println("**Phon**");
    }
}

class SPhone implements PhoneInterface {
    @Override
    public void sendCall(){
        System.out.println("rrrr");

    }
    @Override
    public void receiveCall(){
        System.out.println("Calling");

    }

    public void flash() {
        System.out.println("Light on");
    }
}
public class InterfaceEx {
    public static void main(String[] args){
        SPhone phone = new SPhone();

        phone.printLogo();
        phone.sendCall();
        phone.receiveCall();
        phone.flash();
    }
}
