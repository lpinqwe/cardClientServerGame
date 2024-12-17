import model.enums.CommandType;

import java.util.Scanner;

public class BeginAPP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("choose Server Client mode");
        String mode = scanner.nextLine();
        if(mode.equals("Server")){
            ServerForGame srv = new ServerForGame();
            srv.runServer();
        }
        if(mode.equals("Client")){
            System.out.println("Enter command USERID:");
            String userID = scanner.nextLine();

            Client cli = new Client();
            String currentRoom = "";

            ClientSupportCommands help = new ClientSupportCommands(userID);

            //App Loop
            while(true){

                System.out.println("your Room: "+currentRoom);
                System.out.println("your userID: "+userID);
                System.out.println("available server commands: ");
                System.out.println(CommandType.getAvailableCommands());
                cli.runCli(help.getCMD());


            }


        }
    }
}
