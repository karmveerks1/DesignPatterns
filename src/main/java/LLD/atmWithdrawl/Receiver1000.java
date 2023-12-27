package LLD.atmWithdrawl;

public class Receiver1000 extends Receiver{
    public Receiver1000(Receiver nextReceiver) {
        super(nextReceiver);
    }

    @Override
    public String processRequest(Request request) {
        int amount = request.getAmount();
        while(amount >= Receiver.THOUSAND){
            amount = amount - Receiver.THOUSAND;
        }
        if(amount == 0){
            return "Money is Withdrawn successfully";
        }else{
            return super.processRequest(request);
        }
    }
}
