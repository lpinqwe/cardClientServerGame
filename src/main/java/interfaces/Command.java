package interfaces;

import model.CommandEntity;

public interface Command {
    Object execute(CommandEntity cmd);
}
