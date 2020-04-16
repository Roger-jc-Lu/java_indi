package Jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
    public static void main(String[] args) throws JsonProcessingException {
        Card fiveDiamond = new Card("diamond","5");
        Card aceSpade = new Card("spade", "ace");
        Card tenClub = new Card("club", "10");
        Card kingHeart = new Card("heart", "king");
        Card card = new Card("diamond","ace");

        ObjectMapper objectMapper = new ObjectMapper();

        String json1 = objectMapper.writeValueAsString(fiveDiamond);
        String json2 = objectMapper.writeValueAsString(aceSpade);
        String json3 = objectMapper.writeValueAsString(tenClub);
        String json4 = objectMapper.writeValueAsString(kingHeart);
        String json5 = objectMapper.writeValueAsString(card);
        
        System.out.println(json1);
        System.out.println(json2);
        System.out.println(json3);
        System.out.println(json4);
        System.out.println(json5);
    }
}