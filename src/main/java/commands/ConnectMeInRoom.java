package commands;

import gameLogic.GameRoom;
import model.CommandEntity;

public class ConnectMeInRoom extends IsRoomExist{
    @Override
    public Object execute(CommandEntity cmd) {
        String roomID = cmd.payload;
        GameRoom room = mroom.findRoomWithRoomID(roomID);

        if(room!=null){

        String answer = room.connectUser(cmd.userName);
        return answer;
        };
        return "not exists room with id: "+roomID;
    }
}
