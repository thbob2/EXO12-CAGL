package clients.src;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/** 
 * ! P1 
 * */
public class Client {
    private Socket socket = null ;
    private ObjectInputStream inputStream = null;
    private ObjectOutputStream outputStream = null;
    private boolean isConnected = false;

    public Client(){}
    private  void menu(){
        System.out.println("|***********************************MENU************************************|");
        System.out.println("|_____________________________Choose number_________________________________|");
        System.out.println("| (1) print student                                                         |");
        System.out.println("| (2) destroy a student                                                     |");
        System.out.println("| (3) add a new student                                                     |");
        System.out.println("|                                (0) Exit                                   |");
        System.out.println("|______________________________Developer Options____________________________|");
        System.out.println("| (7) Print Exceptions log                                                  |");
    }
    public void communicate(){
        while(!isConnected){
            
            try {
                
                socket = new Socket("localhost", 8800);
                System.out.println("connected to server \n what is your request...");
                isConnected = false;
                System.out.println("choose well :  ");
                this.menu();
                Boolean ok = true;
                Scanner choice = new Scanner(System.in);
                while(ok){
                    switch(choice.nextInt()){
                        case 0 :
                            System.out.println("thank you for your service");
                            ok = false;                        
                            break;
                    }
                }
            }catch(Exception e) {
                ExceptionSaver es = new ExceptionSaver() ;
                es.save(e);
            }
        }
    }
}
