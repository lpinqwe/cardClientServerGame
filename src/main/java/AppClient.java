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
    public static void main(String[] args) {
        Client cli = new Client();
        cli.runCli(fioTest);

    }
}
