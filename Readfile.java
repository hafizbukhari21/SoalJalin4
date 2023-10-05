import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class Readfile {
    public List<String> listData;
    public List<Mapper>mappers;

    Readfile(List<String> gettinglistData){
        this.listData = gettinglistData;
    }


    public void gettingBankList(){
        
    }

    public List<Mapper> cuttingString(){
         this.mappers= new CopyOnWriteArrayList<Mapper>();
        for (String data:listData){
            String[] kata = data.split(";");
            String bankCode = kata[0];
            String port = kata[2];
            String BankName = kata[3];

            if(mappers.size()==0){
                this.mappers.add(initializeMap(bankCode, port, BankName));
            }

            else {
                Mapper tempMapper = null;

                //Checking If Bank Exist or not
                for(Mapper map:this.mappers){
                    if(bankCode.equals(map.bankCode)){
                        tempMapper = map;
                        break;
                    }
                }

                //If Bank not exisit create node baru
                if(tempMapper==null){
                     mappers.add(initializeMap(bankCode, port, BankName));
                }
                //if bank exist just update the mapper detail
                else{
                    tempMapper.bankdetail.add(new Bank(port, BankName));
                }
            }
           
        }
        

        return this.mappers;

    }

  

    private Mapper initializeMap(String bankCode, String port, String BankName){
        Mapper map = new Mapper(bankCode);
        map.setBankDetail(port, BankName);
        return map;

            
    }
}
