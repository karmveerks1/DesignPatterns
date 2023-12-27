package LLD.atmWithdrawl;

public class Receiver500 extends Receiver{

    public Receiver500(Receiver nextReceiver) {
        super(nextReceiver);
    }

    @Override
    public String processRequest(Request request) {
        int amount = request.getAmount();
        while(amount >= Receiver.FIVE_HUNDRED){
            amount = amount - Receiver.FIVE_HUNDRED;
        }
        if(amount == 0){
            return "Money is Withdrawn successfully";
        }else{
            return super.processRequest(request);
        }
    }
}
