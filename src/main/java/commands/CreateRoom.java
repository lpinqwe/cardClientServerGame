package commands;

import gameLogic.GameRoom;
import gameLogic.MainRoom;
import interfaces.Command;
import model.CommandEntity;

public class CreateRoom extends IsRoomExist {

    @Override
    public Object execute(CommandEntity cmd) {
        GameRoom tmp = mroom.createRoom(cmd.payload);
        if (tmp != null) {
            return "room created with ID`s " + tmp.getRoomID();
        } else {
            return "already exists";
        }
    }
}
