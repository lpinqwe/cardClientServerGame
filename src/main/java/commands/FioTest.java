package commands;

import com.google.gson.Gson;
import interfaces.Command;
import model.CommandEntity;

import static model.enums.CommandType.RESPONSE_FIO_TEST;

public class FioTest implements Command {

    public class Fio{
        String name;
        String surname;
    }
    final Gson gson = new Gson();

    @Override
    public Object execute(CommandEntity cmd) {
        System.out.println(cmd);
        System.out.println(cmd.payload);

        Fio newFio = gson.fromJson(cmd.payload, Fio.class);//deserialise
        System.out.println(newFio.name);
        newFio.name = "from EXE";
        CommandEntity cmdRes = new CommandEntity();
        cmdRes.cmdType=RESPONSE_FIO_TEST;
        cmdRes.payload = gson.toJson(newFio);
        return cmdRes;
    }

}

