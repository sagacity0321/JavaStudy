package Course1;

interface PhoneInterfacee{
    final int TIMEOUT = 10000;
    void sendCall();
    void receiveCall();
    default void printLogo(){
        System.out.println("**Phon**");
    }
}

interface MobilePhoneInterface extends PhoneInterfacee{
    void sendSMS();
    void receiveSMS();
}

interface MP3Interface{
    public void play();
    public void stop();
}

class PDA{
    public int calculate(int x, int y){
        return x+y;
    }
}

class SmartPhone extends PDA implements MobilePhoneInterface, MP3Interface{
    @Override
    public void sendCall(){
        System.out.println("rrr");

    }
    @Override
    public void receiveCall(){
        System.out.println("Calling");

    }
    @Override
    public void sendSMS(){
        System.out.println("send SMS");
    }
    @Override
    public void receiveSMS(){
        System.out.println("receive SMS");
    }

    @Override
    public void play(){
        System.out.println("playing music");
    }
    @Override
    public void stop(){
        System.out.println("stop music");
    }

    public void shedule(){
        System.out.println("일정 관리");
    }
}

public class InterfaceEx2 {
    public static void main(String[] args){
        SmartPhone phone = new SmartPhone();

        phone.printLogo();
        phone.sendCall();
        phone.play();
        System.out.println("3 plus 5 is " + phone.calculate(3,5));
        phone.shedule();
    }
}
