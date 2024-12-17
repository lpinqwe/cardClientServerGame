package commands;

import interfaces.Command;
import interfaces.GameCommand;
import model.CommandEntity;

public class GetRoomList extends IsRoomExist {
    @Override
    public Object execute(CommandEntity cmd) {
        return mroom.getListOfRooms();
    }

}
