package LLD.atmWithdrawl;

 public abstract class Receiver {
     public static int THOUSAND = 1000;
     public static int FIVE_HUNDRED = 500;
     public static int HUNDRED = 100;
     public static int FIFTY = 50;

     private Receiver nextReceiver;
     public Receiver(Receiver nextReceiver) {
         this.nextReceiver = nextReceiver;
     }

     public String processRequest(Request request) {
         if(nextReceiver != null){
            return nextReceiver.processRequest(request);
         }else{
             return "Something unusual happended";
         }
     }
 }
