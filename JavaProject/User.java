import java.io.Serializable;

public class User{
   String UserAccount,AccountPassWord;
   int balance=22000;
   public User(String userAccount,String password,int balance){
       this.AccountPassWord=password;
       this.UserAccount=userAccount;
       this.balance=balance;
   }
    public User( String userAccount, String accountPassWord) {
        UserAccount = userAccount;
        AccountPassWord = accountPassWord;
    }

    @Override
    public String toString() {
        return ", UserAccount='" + UserAccount + '\'' +
                ", AccountPassWord='" + AccountPassWord + '\'' +
                '}';
    }
}
