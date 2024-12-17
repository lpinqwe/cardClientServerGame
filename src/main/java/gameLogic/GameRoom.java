package gameLogic;

import gameLogic.utils.Card;
import gameLogic.utils.ZbiorCardForOczko;

import java.util.*;

public class GameRoom {
    public String getRoomID() {

        return roomID;
    }

    String roomID;
    String userIDTurn;
    ZbiorCardForOczko zbKart;
    HashMap<String, Integer> userlist;

    GameRoom(String roomID) {
        this.roomID = roomID;
        this.zbKart = new ZbiorCardForOczko();
        this.userlist = new HashMap<>();
    }

    public String playersCount(String playerID) {
        return "" + userlist.get(playerID);
    }

    public boolean checkPlayer(String playerID) {
        return userlist.containsKey(playerID);
    }

    public String connectUser(String userID) {
        if (userlist.containsKey(userID)) {
            return "already in";
        }
        if (userlist.size() < 4) {
            userlist.put(userID, 0);
            return "successful entering in room: " + roomID;
        }
        if(userIDTurn == null){
            userIDTurn = userID;
        }
        return "to much people";
    }

    public String countPlayers() {
        return userlist.size() + "/4";
    }

    public boolean currentTurnCheck(String userID) {
        if(userIDTurn == null){
            userIDTurn = userID;
        }
        if (userID.equals(userIDTurn)) {
            return true;
        }
        return false;
    }
    public String getCurrentTurnID(){
        return userIDTurn;
    }
    public void nextTurn() {
        // Get the list of users
        List<String> users = new ArrayList<>(userlist.keySet());

        // Find the index of the current user
        int currentIndex = users.indexOf(userIDTurn);

        // Calculate the next index, wrapping around if necessary
        int nextIndex = (currentIndex + 1) % users.size();

        // Update userIDTurn to the next user
        userIDTurn = users.get(nextIndex);

        if(zbKart.zbior.isEmpty()){
            zbKart.utworz();
            zbKart.potasuj();
        }
    }


    public static void increaseValue(Map<String, Integer> map, String key, int val) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + val);
        }
    }
    public static void wyzeruj(Map<String, Integer> map, String key) {
        if (map.containsKey(key)) {
            map.put(key, 0);
        }
    }

    public String getCardInTurn(String userID) {
        String cardGetted;
        if (currentTurnCheck(userID)) {
            Card tmp = zbKart.getCard();
            increaseValue(userlist,userID,tmp.getCost());
            cardGetted = "you got "+tmp.getType()+" with cost "+tmp.getCost();
            if(userlist.get(userID)>21){
                String tmpString = "you loose->you got"+userlist.get(userID);
                wyzeruj(userlist,userID);
                return cardGetted+"\n"+tmpString;
            }
            nextTurn();
            return cardGetted;
        }
        return "not your turn "+" current turn is "+getCurrentTurnID();

    }
    //+UID map (up to 4) {UID:count }
    //+players count
    //+connect me method
    //+String roomID
    //koloda kart list maybe
    //var UID turn
    //check is what player want to do is ok method
    //game loop


}
