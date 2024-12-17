package model.enums;

import commands.*;

public enum CommandType {
    PASS_TURN(PassTurn.class),
    ROOM_LIST(GetRoomList.class),
    CHECK_ROOM(GetRoomList.class),
    //NO_ACTION(NoAction.class),
    //FIO_TEST(FioTest.class),
    //RESPONSE_FIO_TEST(FioTest.class),
    IS_ROOM_EXIST(IsRoomExist.class),
    GET_MY_CURRENT_COUNT(CurrentCount.class),
    CONNECT_ME_IN_ROOM_WITH_ID(ConnectMeInRoom.class),

    GET_ONE_CARD(GetCard.class),
    CREATE_ROOM(CreateRoom.class);
    //1 show room list ROOM_LIST +
    //2 enter in room +
    //3 get card+
    //4 pass
    //5 exit room
    //6 Create room CREATE_ROOM +
    // 7 IS_ROOM_EXIST +
    //CONNECT_ME_TO_ROOM_WITH_ID +
    //GET_MY_CURRENT_COUNT +

    private Class type;

    CommandType(Class value) {
        this.type = value;
    }

    public Class getValue() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }

    public static String getAvailableCommands() {
        StringBuilder commands = new StringBuilder();
        for (CommandType command : CommandType.values()) {
            commands.append(command.name()).append("\n");
        }
        return commands.toString();
    }

}
