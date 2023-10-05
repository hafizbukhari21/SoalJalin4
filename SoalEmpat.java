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
            // voidPrintConsole(returnMapper);
            // System.out.print("Masukan code Bank = ");
            // String chooseBankCode = scanner.nextLine();
            
            for (Mapper bankMapper : returnMapper) {
               if(bankMapper.bankCode.equals(args[0])){
                    bankMapper.bankdetail.forEach((bd)->{
                        System.out.println("ENVI MP Port="+bd.port+" Terpantau offline");
                    });
                    WriteReport(bankMapper);
                    fileReader.close();
                    return;
               }
            }
            System.out.println("Not Found");
            fileReader.close();

       }catch(IOException e){
            
       }

      
        
    }

    public static void voidPrintConsole(List<Mapper> returnMapper){
      int number=1;
       for (Mapper bankMapper : returnMapper) {
                System.out.print(number+" ");
                number++;
                System.out.println(bankMapper.bankCode);
            }
    }


    public static void WriteReport( Mapper mapper){
      try {
        FileWriter myWriter = new FileWriter("Output/"+mapper.bankCode+".txt");
        myWriter.write("Selamat siang Rekan Bank "+mapper.bankCode);

        myWriter.write(System.lineSeparator());
        myWriter.write(System.lineSeparator());

        for(Bank bank : mapper.bankdetail){
            myWriter.write("    -ENVI MP Port "+bank.port+" Terpantau Offline");
            myWriter.write(System.lineSeparator());

        }
        myWriter.write(System.lineSeparator());
        myWriter.write("Terima Kasih");


        myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }

}