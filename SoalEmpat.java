import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SoalEmpat{
    public static void main(String[] args){
       try{
            FileReader fileReader = new FileReader(new File("./input.txt"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> inputString = new ArrayList<String>();  
            String line; 

            while((line = bufferedReader.readLine())!=null){
                inputString.add(line);
            }
            Readfile readfile = new Readfile(inputString);
            List<Mapper> returnMapper = readfile.cuttingString();


            Scanner scanner =  new Scanner(System.in);
            System.out.println("Masukan Bank apa yang mau disent "); 
            int number=1;
            for (Mapper bankMapper : returnMapper) {
                System.out.print(number+" ");
                number++;
                System.out.println(bankMapper.bankCode);
            }

            String chooseBankCode = scanner.nextLine();
            
            for (Mapper bankMapper : returnMapper) {
               if(bankMapper.bankCode.equals(chooseBankCode)){
                    bankMapper.bankdetail.forEach((bd)->{
                        System.out.println("ENVI MP Port="+bd.port+" Terpantau offline");
                    });
                    fileReader.close();
                    return;
               }
            }
            System.out.println("Not Found");
            fileReader.close();

       }catch(IOException e){
            
       }

      
        
    }


    public void WriteReport(String bankCode, Mapper mapper){

    }

}