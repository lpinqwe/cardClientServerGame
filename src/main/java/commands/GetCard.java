package commands;

import gameLogic.GameRoom;
import model.CommandEntity;

public class GetCard extends IsRoomExist{

    @Override
    public Object execute(CommandEntity cmd) {
        String roomID = cmd.payload;
        String currentTurn;
        if (mroom.findRoomWithRoomID(roomID) != null) {
            GameRoom room = mroom.findRoomWithRoomID(roomID);
            currentTurn = room.getCurrentTurnID();
            if (room.checkPlayer(cmd.userName)) {
                String tmp="";
                tmp+=room.getCardInTurn(cmd.userName) ;
                return tmp;
            }
            return "(" + cmd.userName + ")you not in "+roomID;
        }
        return "wrong room ID";

    }
}
