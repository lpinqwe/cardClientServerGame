package model.enums;

import commands.FioTest;
import commands.GetRoomList;
import commands.NoAction;

public enum CommandType {

    ROOM_LIST(GetRoomList.class),
    CHECK_ROOM(GetRoomList.class),
    NO_ACTION(NoAction.class),
    FIO_TEST(FioTest.class),
    RESPONSE_FIO_TEST(FioTest.class);

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
}
