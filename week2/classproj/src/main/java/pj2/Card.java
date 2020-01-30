/**
 * The class inherit Pattern to create objects with Poker card pattern
 * Adapt from Earlham College CS128 material, originally in Python3
 * Roger Lu
 * 01/2020
 */

package pj2;
import pj2.Pattern;

public class Card extends Pattern{
    private String suit;
    private String rank;
    
    final String suitChoice[] = {"club", "spade", "diamond", "heart"};
    final String rankChoice[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
    
    public Card(){

    }

    public Card(String... element){ 
        setSuit(element);
        setRank(element);
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String... element) {
        this.setElementArray(element);
        for (String i:suitChoice){
            if (i == (this.getElementArray())[0])
                this.suit = i;
        }
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String... element) {
        this.setElementArray(element);
        for (String i:rankChoice){
            if (i == (this.getElementArray())[1])
                this.rank = i;
        }
    }

    public void setRank(String i) {
        this.rank = i;
    }

    public boolean is_face_card(){
        if (this.getRank() == "jack" || this.getRank() == "queen" || this.getRank() == "king")
            return true;
        else
            return false;
    }

    public boolean is_red(){
        if (this.getSuit() == "diamond" || this.getSuit() == "heart")
            return true;
        else
            return false;
    }        

    public boolean is_black(){
        if (this.getSuit() == "club" || this.getSuit() == "spade")
            return true;
        else
            return false;
    }

    public int point_value(){
        int n;
        if (this.getRank() == "jack")
            n = 11;
        else if (this.getRank() == "queen")
            n = 12;
        else if (this.getRank() == "king")
            n = 13;
            else if (this.getRank() == "ace")
            n = 1;
        else
            n = Integer.valueOf(this.getRank()).intValue();
        return n;
    }

    public boolean is_higher_value_than(Card another_card){
        if (this.point_value() == 1 & another_card.point_value() == 1)
            return false;
        else if (this.point_value() == 1)
            return true;
        else if (another_card.point_value() == 1)
            return false;
        else if (this.point_value() > another_card.point_value())
            return true;
        else
            return false;
    }

    public String pretty_string(){
        String p_string = "";
        if (this.getRank() == "jack")
            p_string += "J";
        else if (this.getRank() == "queen")
            p_string += "Q";
        else if (this.getRank() == "king")
            p_string += "K";
        else if (this.getRank() == "ace")
            p_string += "A";
        else
            p_string += this.getRank();
        if (this.getSuit() == "club")
            p_string += "♣";
        else if (this.getSuit() == "spade")
            p_string += "♠";
        else if (this.getSuit() == "diamond")
            p_string += "♢";
        else
            p_string += "♡";
        return p_string;
    }

    public void magic_increment(){
        int index = 0;
        for (String i:rankChoice){
            index += 1;
            if (i == this.getRank())
                break;
        }
        this.setRank(rankChoice[index / 13]);
    }
}