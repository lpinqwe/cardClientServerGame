package gameLogic.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZbiorCardForOczko {
    /*
    dziewiątka 	0 pkt.
    dziesiątka 	10 pkt.
    walet 	2 pkt.
    dama 	3 pkt.
    król 	4 pkt.
    as 	11 pkt.
    */
    public List<Card> zbior = new ArrayList<>();

    public void utworz() {
        for (int i =0;i<4;i++){
            this.zbior.add(new Card(2, "walet"));
            this.zbior.add(new Card(3, "dama"));
            this.zbior.add(new Card(4, "krol"));
            this.zbior.add(new Card(11, "as"));
            this.zbior.add(new Card(0, "dziewiatka"));
            this.zbior.add(new Card(10, "dziesiatka"));
        }
    }


    public void potasuj() {
        Collections.shuffle(zbior);
    }

    public ZbiorCardForOczko() {
        this.utworz();
        this.potasuj();
    }

    public Card getCard() {
        if (!zbior.isEmpty()) {
            return zbior.remove(0);
        }
        return null;
    }
}
