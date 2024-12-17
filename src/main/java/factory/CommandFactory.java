package factory;

import com.google.gson.Gson;
import gameLogic.MainRoom;
import interfaces.Command;
import interfaces.GameCommand;
import model.CommandEntity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandFactory {
    final Gson gson = new Gson();
    public Object executeCommand(String cmdData, MainRoom mroom) {
        GameCommand newObj;
        CommandEntity commandEntity = gson.fromJson(cmdData, CommandEntity.class);//deserialise
        System.out.println(commandEntity.cmdType.name());
        Class<?> clazz = commandEntity.cmdType.getValue();

        try {

            Constructor<?> constructor = clazz.getConstructor();
            newObj = (GameCommand) constructor.newInstance(new Object[]{});
            try {
                newObj.setMainRoom(mroom);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            return newObj.execute(commandEntity);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    public Object executeCommand(String cmdData) {
        Command newObj;
        CommandEntity commandEntity = gson.fromJson(cmdData, CommandEntity.class);//deserialise
        System.out.println(commandEntity.cmdType.name());
        Class<?> clazz = commandEntity.cmdType.getValue();

        try {

            Constructor<?> constructor = clazz.getConstructor();
            newObj = (Command) constructor.newInstance(new Object[]{});
            return newObj.execute(commandEntity);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
