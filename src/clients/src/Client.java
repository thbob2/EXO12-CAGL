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
        System.out.println("| (1)       print student                                                   |");
        System.out.println("| (2)       add a student                                               |");
        System.out.println("| (3)       destroy a new student                                               |");
        System.out.println("|________________________________(0) Exit___________________________________|");

    }
    public void communicate(){
        while(!isConnected){
            
            try {
                
                socket = new Socket("localhost", 8800);
                System.out.println("connected to server \n what is your request...");
                isConnected = false;
                System.out.println("choose well :  ");
                this.menu();
               
                    switch(new Scanner(System.in).nextInt()){
                        case 0 :{
                            System.out.println("thank you for your service");                        
                            break;
                        }
                        case 1: {
                            System.out.println("Insert the id to look for...");
                            Scanner search = new Scanner(System.in);
                            ObjectOutputStream objectoutstream = new ObjectOutputStream(socket.getOutputStream());
                            objectoutstream.writeObject("print");
                            objectoutstream.writeObject(search);
                            System.out.println("your request has been sent");
                            break;

                        }
                        case 3 : {
                            System.out.println("Insert the id of your target...");
                            Scanner delete = new Scanner(System.in);
                            ObjectOutputStream objectoutstream = new ObjectOutputStream(socket.getOutputStream());
                            objectoutstream.writeObject("delete");
                            objectoutstream.writeObject(delete);
                            System.out.println("your request has been sent");
                            break;
                        }
                        case 2 : {
                            System.out.println("Insert the id ...");
                            Scanner add = new Scanner(System.in);
                            ObjectOutputStream objectoutstream = new ObjectOutputStream(socket.getOutputStream());
                            int mat = add.nextInt();
                            System.out.println("what is the name ? ");
                            String name = add.nextLine().strip();
                            System.out.println("is your last name cool ? ");
                            String lastname = add.nextLine().strip();
                            Student puppet = new Student(mat, name, lastname);
                            objectoutstream.writeObject("add");
                            objectoutstream.writeObject(puppet);
                            break;
                        }
                    }
                
            }catch(Exception e) {
                ExceptionSaver es = new ExceptionSaver() ;
                es.save(e);
            }
        }
    }

    public static void main(String[] args) {
        Client guest = new Client();
        guest.communicate();
    }
}
