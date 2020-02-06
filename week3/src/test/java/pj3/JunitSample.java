package pj3;

/*import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import week2.classproj.src.main.java.pj2.Card;
import static org.junit.jupiter.api.Assertions.assertTrue;
*/
import org.junit.Test;
import pj3.Card;
import static org.junit.Assert.*;

//@DisplayName("test cases for Card")
class JunitSample {
    private final Card fiveDiamond = new Card("diamond","5");
    private final Card aceSpade = new Card("spade", "ace");
    private final Card tenClub = new Card("club", "10");
    private final Card kingHeart = new Card("heart", "king");
    private final Card card = new Card("diamond","ace");

    @Test
    
    void getSuitTest() {
        assertEquals("diamond", card.getSuit());
        assertEquals("ace", card.getRank());
    }

    void groupedAssertions() {

        assertTrue(aceSpade.is_higher_value_than(fiveDiamond));
        assertTrue(aceSpade.is_higher_value_than(tenClub));
        assertTrue(aceSpade.is_higher_value_than(kingHeart));
        assertFalse(aceSpade.is_higher_value_than(kingHeart));

        assertFalse(fiveDiamond.is_higher_value_than(fiveDiamond));
        assertFalse(fiveDiamond.is_higher_value_than(tenClub));
        assertFalse(fiveDiamond.is_higher_value_than(kingHeart));
        assertFalse(fiveDiamond.is_higher_value_than(aceSpade));

        assertTrue(tenClub.is_higher_value_than(fiveDiamond));
        assertFalse(tenClub.is_higher_value_than(tenClub));
        assertFalse(tenClub.is_higher_value_than(kingHeart));
        assertFalse(tenClub.is_higher_value_than(aceSpade));

        assertTrue(kingHeart.is_higher_value_than(fiveDiamond));
        assertTrue(kingHeart.is_higher_value_than(tenClub));
        assertFalse(kingHeart.is_higher_value_than(kingHeart));
        assertFalse(kingHeart.is_higher_value_than(aceSpade));
    }
}