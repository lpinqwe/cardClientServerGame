package commands;

import com.sun.tools.javac.Main;
import gameLogic.GameRoom;
import gameLogic.MainRoom;
import interfaces.Command;
import interfaces.GameCommand;
import model.CommandEntity;

public class IsRoomExist implements GameCommand {
    MainRoom mroom;
    @Override
    public Object execute(CommandEntity cmd) {
        GameRoom tmp = mroom.findRoomWithRoomID(cmd.payload);
        if(tmp !=null){
        return "room exist with ID`s: "+tmp.getRoomID();
        }
        return "room not exist";
    }

    @Override
    public Object setMainRoom(MainRoom mainRoom) {
        this.mroom=mainRoom;
        return null;
    }
}
