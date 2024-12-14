package commands;

import interfaces.Command;
import model.CommandEntity;

public class NoAction implements Command{

        @Override
        public Object execute(CommandEntity cmd) {
            System.out.println(cmd);
            System.out.println(cmd.payload);
            return true;
        }


    }
