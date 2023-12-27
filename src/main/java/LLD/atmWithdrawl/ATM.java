package LLD.atmWithdrawl;

public class ATM {
    public static void main(String[] args) {
        Receiver receiver = new Receiver1000(new Receiver500(new Receiver100(new Receiver50(null))));
        Request request = new Request(1255,123456,123);
        System.out.println(receiver.processRequest(request));
    }
}
