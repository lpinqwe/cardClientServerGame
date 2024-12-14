package commands;

import interfaces.Command;
import model.CommandEntity;

public class GetRoomList implements Command {
    @Override
    public Object execute(CommandEntity cmd) {
        System.out.println(cmd);
        return null;
    }

}
