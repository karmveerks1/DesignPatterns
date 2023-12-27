package LLD.atmWithdrawl;

public class Request {
    private int amount;
    private int accountNumber;
    private int passWord;

    public Request(int amount, int accountNumber, int passWord) {
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.passWord = passWord;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPassWord() {
        return passWord;
    }

    public void setPassWord(int passWord) {
        this.passWord = passWord;
    }
}
