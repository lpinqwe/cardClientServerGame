package gameLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainRoom {
    String roomName = "diziała";
    //list of room (up to ...)
    //create new room method
    List<GameRoom> gameRoomList = new ArrayList<>();

    //CREATE_ROOM
    public GameRoom createRoom(String roomID) {
        if(findRoomWithRoomID(roomID)!=null){
            return null;
        }
        GameRoom tmpRoom = new GameRoom(roomID);
        gameRoomList.add(tmpRoom);
        return tmpRoom;
    }
    //IS_ROOM_EXIST
    public GameRoom findRoomWithRoomID(String roomID){
        for (GameRoom room : gameRoomList) {
            if (Objects.equals(room.roomID, roomID)) {
                return room;
            }
        }
        return null;
    }
    //CONNECT_ME_TO_ROOM_WITH_ID
    public String connectToRoom(String userID, String roomID) {
        GameRoom tmp;
        tmp = findRoomWithRoomID(roomID);
        if(tmp == null){
            return "wrong room ID";
        }
        return tmp.connectUser(userID);
    }

    public String getListOfRooms(){
        StringBuilder tmp = new StringBuilder();
        for(GameRoom gameRoom:gameRoomList){
            tmp.append(gameRoom.getRoomID());
            tmp.append(", ");
        }
        return tmp.toString();
    }
    @Override
    public String toString() {
        return null;
    }
}
