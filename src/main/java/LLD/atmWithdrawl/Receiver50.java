package LLD.atmWithdrawl;

public class Receiver50 extends Receiver{

    public Receiver50(Receiver nextReceiver) {
        super(nextReceiver);
    }

    @Override
    public String processRequest(Request request) {
        int amount = request.getAmount();
        while(amount >= Receiver.FIFTY){
            amount = amount - Receiver.FIFTY;
        }
        if(amount == 0){
            return "Money is Withdrawn successfully";
        }else{
            return "Not Enough Fund";
        }
    }
}
