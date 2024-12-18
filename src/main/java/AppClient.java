/*
import model.CommandEntity;

import model.enums.CommandType;

import java.util.Scanner;

public class AppClient {

    String aa = "{\n" +
            "  \"cmdType\":\"NO_ACTION\",\n" +
            "  \"payload\": \"oinononon\"\n" +
            "}";
    String aa2 = "{\n" +
            "  \"cmdType\":\"NO_ACTION\",\n" +
            "  \"payload\": \"oinononon\"\n" +
            "}";

    static String fioTest = "{\n" +
            "  \"cmdType\":\"FIO_TEST\",\n" +
            "  \"payload\":\"  {\\\"name\\\": \\\"myName\\\",\\n    \\\"surname\\\": \\\"mySurname\\\"\\n  }\"\n" +
            "\n" +
            "}";

    static String createRoom = "{\n" +
            "  \"cmdType\":\"CREATE_ROOM\",\n" +
            "  \"payload\":\"newROOMID_test1\"\n" +
            "}\n";
    static String createRoom2 = "{\n" +
            "  \"cmdType\":\"CREATE_ROOM\",\n" +
            "  \"payload\":\"newROOMID_test2\"\n" +
            "}\n";
    static String isExist = "{\n" +
            "  \"cmdType\":\"IS_ROOM_EXIST\",\n" +
            "  \"payload\":\"newROOMID_test1\"\n" +
            "}";
    static String isExistNOT = "{\n" +
            "  \"cmdType\":\"IS_ROOM_EXIST\",\n" +
            "  \"payload\":\"newROOMID_testFALSE\"\n" +
            "}";
    static String roomList = "{\n" +
            "  \"cmdType\":\"ROOM_LIST\"\n" +
            "  \n" +
            "}";
    static String connectMeIntoRoom = "{\n" +
            "  \"cmdType\":\"CONNECT_ME_IN_ROOM_WITH_ID\",\n" +
            "  \"payload\": \"newROOMID_test1\",\n" +
            "  \"userName\": \"userID_1212\"\n" +
            "}\n";
    static String getCount ="{\n" +
            "  \"cmdType\":\"GET_MY_CURRENT_COUNT\",\n" +
            "  \"payload\": \"newROOMID_test1\",\n" +
            "  \"userName\": \"userID_1212\"\n" +
            "}\n";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command USERID:");
        String userID = scanner.nextLine();

        Client cli = new Client();
        String currentRoom = "";

        ClientSupportCommands help = new ClientSupportCommands(userID);
        cli.runCli(roomList);

        //App Loop
        while(true){

            System.out.println("your Room: "+currentRoom);
            System.out.println("your userID: "+userID);
            System.out.println("available server commands: ");
            System.out.println(CommandType.getAvailableCommands());
            cli.runCli(help.getCMD());


        }


        cli.runCli(isExist);
        cli.runCli(roomList);
        cli.runCli(getCount);
        cli.runCli(connectMeIntoRoom);
        cli.runCli(createRoom);
        cli.runCli(createRoom2);

        cli.runCli(connectMeIntoRoom);
        cli.runCli(connectMeIntoRoom);
        cli.runCli(getCount);

        cli.runCli(createRoom);
        cli.runCli(roomList);
        cli.runCli(isExist);
        cli.runCli(isExistNOT);


    }
}
*/