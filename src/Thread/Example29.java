package Thread;
class Account{
    private int total = 5000;
    private int index = 1;
    synchronized void withdraw(String name){
        if (total > 0) {
            System.out.println(name +"님이" + index + "번째 인출을 하였습니다.");
            total -= 1000;
            System.out.println(name + "님이" + index + "번째 인출을 하여 남은 금액은" + total + " 입니다.");
            index ++;
        }else {
            System.out.println(name + "님이 인출을 시도하였으나, 금액 부족입니다. 남은 금액은 "+ total +"입니다.");
        }
    }
    int getTotal(){
        return total;
    }

}
class Customer extends Thread{
    Account _Account;
    Customer(Account _Account, String Name){
        this._Account = _Account;
        setName(Name);
    }

    @Override
    public void run() {
        while(true){
            _Account.withdraw(getName());
            if(_Account.getTotal() <= 0)
                break;
        }
    }
}
public class Example29 {
    public static void main(String[] args) {
        Account _Account = new Account();
        new Customer(_Account, "첫째").start();
        new Customer(_Account, "둘째").start();
        new Customer(_Account, "셋째").start();
        new Customer(_Account, "넷째").start();
        new Customer(_Account, "다섯째").start();

    }
}
