import java.util.*;
public class Mapper {
    
    public String bankCode;
    public List<Bank> bankdetail;


    Mapper(String bankCode){
        this.bankCode= bankCode;
        this.bankdetail = new ArrayList<Bank>();
    }

    public void setBankDetail(String port, String BankName){
        bankdetail.add(new Bank(port, BankName));
    }
}



