import com.google.gson.Gson;
import factory.CommandFactory;

public class App {
    public static void main(String[] args) {
        final Gson gson = new Gson();

        String aa = "{\n" +
                "  \"cmdType\":\"NO_ACTION\",\n" +
                "  \"payload\": \"oinononon\"\n" +
                "}";
        String aa2 = "{\n" +
                "  \"cmdType\":\"NO_ACTION\",\n" +
                "  \"payload\": \"oinononon\"\n" +
                "}";

        String fioTest = "{\n" +
                "  \"cmdType\":\"FIO_TEST\",\n" +
                "  \"payload\":\"  {\\\"name\\\": \\\"myName\\\",\\n    \\\"surname\\\": \\\"mySurname\\\"\\n  }\"\n" +
                "\n" +
                "}";


        CommandFactory factory = new CommandFactory();
        //factory.executeCommand(aa);
        String resp = gson.toJson(factory.executeCommand(fioTest));
        System.out.println(resp);


    }
}
