package interfaces;

import gameLogic.MainRoom;
import model.CommandEntity;

public interface GameCommand extends Command{

    Object setMainRoom (MainRoom mainRoom);


}
