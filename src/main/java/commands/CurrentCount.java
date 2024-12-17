package commands;

import gameLogic.GameRoom;
import model.CommandEntity;

public class CurrentCount extends IsRoomExist {
    @Override
    public Object execute(CommandEntity cmd) {
        String roomID = cmd.payload;
        if (mroom.findRoomWithRoomID(roomID) != null) {
            GameRoom room = mroom.findRoomWithRoomID(roomID);
            if (room.checkPlayer(cmd.userName)) {
                return "(" + cmd.userName + ")yours current count is " + room.playersCount(cmd.userName);
            }
            return "(" + cmd.userName + ")you not in "+roomID;
        }
        return "wrong room ID";

    }
}
