import java.util.*;
public class CRC {
    public static void main(String[] args) {
        String data,divisor;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data");
        data=sc.nextLine();
        System.out.println("Enter generator");
        divisor=sc.nextLine();
        String appenddata=data;
        for(int i=0;i<divisor.length()-1;i++)
        appenddata=appenddata+"0";
        int datalen=appenddata.length();
        int divisorlen=divisor.length();
        int databits[]=new int[datalen];
        int divbits[]=new int[divisorlen];
        for(int i=0;i<datalen;i++)
        databits[i]=appenddata.charAt(i)-'0';
        for(int i=0;i<divisorlen;i++)
        divbits[i]=divisor.charAt(i)-'0';
        for(int i=0;i<datalen-divisorlen+1;i++){
            if(databits[i]==1){
                for(int j=0;j<divisorlen;j++){
                    databits[i+j]=databits[i+j]^divbits[j];
                }
            }
        }
        String tramcode=data;
        for(int i=datalen-divisorlen+1;i<datalen;i++){
            tramcode=tramcode+databits[i];
        }
        System.out.println("the recived code word is : "+tramcode);
        System.out.println("enter recived codeword");
        String recvcode=sc.nextLine();
        if(tramcode.equals(recvcode)){
            System.out.println("the recived codeword contains no errors");
            System.exit(0);
        }
        System.out.println("the recived codeword contains errors");
    }
}