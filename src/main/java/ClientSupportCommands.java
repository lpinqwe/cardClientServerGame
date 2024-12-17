import java.util.Scanner;

public class ClientSupportCommands {
    Scanner scanner = new Scanner(System.in);
    String userID;
    ClientSupportCommands (String UID){
        userID = UID;
    }
    String tmp = "{\n" +
            "  \"cmdType\":\"GET_MY_CURRENT_COUNT\",\n" +
            "  \"payload\": \"newROOMID_test1\",\n" +
            "  \"userName\": \"userID_1212\"\n" +
            "}";

    public String helper(String commandType, String payload, String userID) {
        return "{\n" +
                "  \"cmdType\":" + commandType + ",\n" +
                "  \"payload\": " + payload + ",\n" +
                "  \"userName\": " + userID + "\n" +
                "}";
    }

    public String getCMD() {
        System.out.println("Enter command TYPE:");
        String typeCMD = scanner.nextLine();
        System.out.println("Enter command PAYLOAD:");
        String payload = scanner.nextLine();


        return helper(typeCMD,payload,userID);
    }

}
