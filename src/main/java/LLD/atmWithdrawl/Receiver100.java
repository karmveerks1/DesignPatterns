package LLD.atmWithdrawl;

public class Receiver100 extends Receiver{

    public Receiver100(Receiver nextReceiver){
        super(nextReceiver);
    }

    @Override
    public String processRequest(Request request) {
        int amount = request.getAmount();
        while(amount >= Receiver.HUNDRED){
            amount = amount - Receiver.HUNDRED;
        }
        if(amount == 0){
            return "Money is Withdrawn successfully";
        }else{
            return super.processRequest(request);
        }
    }
}
