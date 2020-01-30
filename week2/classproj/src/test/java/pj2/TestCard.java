package pj2;

/**
 * Test for the same project
 */
public class TestCard{
    public static void main(String[] args) {
        
        Card card = new Card("diamond","ace");
        System.out.println(card.getSuit());
        System.out.println(card.getRank());

        Card fiveDiamond = new Card("diamond","5");
        Card aceSpade = new Card("spade", "ace");
        Card tenClub = new Card("club", "10");
        Card kingHeart = new Card("heart", "king");

        System.out.println(aceSpade.is_higher_value_than(fiveDiamond));
        System.out.println(aceSpade.is_higher_value_than(tenClub));
        System.out.println(aceSpade.is_higher_value_than(kingHeart));
        System.out.println(aceSpade.is_higher_value_than(aceSpade));

        System.out.println(fiveDiamond.is_higher_value_than(fiveDiamond));
        System.out.println(fiveDiamond.is_higher_value_than(tenClub));
        System.out.println(fiveDiamond.is_higher_value_than(kingHeart));
        System.out.println(fiveDiamond.is_higher_value_than(aceSpade));

        System.out.println(tenClub.is_higher_value_than(fiveDiamond));
        System.out.println(tenClub.is_higher_value_than(tenClub));
        System.out.println(tenClub.is_higher_value_than(kingHeart));
        System.out.println(tenClub.is_higher_value_than(aceSpade));

        System.out.println(kingHeart.is_higher_value_than(fiveDiamond));
        System.out.println(kingHeart.is_higher_value_than(tenClub));
        System.out.println(kingHeart.is_higher_value_than(kingHeart));
        System.out.println(kingHeart.is_higher_value_than(aceSpade));
    }
}
