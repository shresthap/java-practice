package test.charactersandstrings;

import org.apache.commons.lang3.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * Created by pshrestha on 12/7/2016.
 */
public class EscapeCharacterTest {

    public void testEscapeCharacter() throws Exception {
        String str = "< > \" &";
        System.out.println("Original : " + str);
        String results = StringEscapeUtils.escapeHtml4(str);
        System.out.println(results);
    }


    public void testEscape() throws UnsupportedEncodingException {
//        System.out.println(StringEscapeUtils.escapeHtml4("Get up to $200 on a Visa<sup>®</sup> Prepaid Card"));
//        System.out.println(URLEncoder.encode("Get up to $200 on a Visa<sup>®</sup> Prepaid Card", "ASCII"));
//        System.out.println(JcrUtil.escapeIllegalJcrChars("Get up to $200 on a Visa<sup>®</sup> Prepaid Card"));
        System.out.println(escapeChar("Get up to $200 on a Visa<sup>®</sup> Prepaid Card © ™"));


    }

    public static String escapeChar(String aText){
        final StringBuilder result = new StringBuilder();
        final StringCharacterIterator iterator = new StringCharacterIterator(aText);
        char character =  iterator.current();
        while (character != CharacterIterator.DONE ){
//            if (character == '®') {
//                result.append("&reg;");
//            } else if(character == '™'){
//                result.append("&trade;");
//            } else if(character == '©'){
//                result.append("&copy;");
//            }
//            else {
//                //the char is not a special one
//                //add it to the result as is
//                result.append(character);
//            }
            switch (character) {
                case '®':
                    result.append("&reg;");
                    break;
                case '™':
                    result.append("&trade;");
                    break;
                case '©':
                    result.append("&copy;");
                    break;
                default:
                    result.append(character);
                    break;
            }
            character = iterator.next();
        }
        return result.toString();
    }

    public void testStringSplit() {
        String test = null;
        System.out.println(test.split("//.")[0]);
    }

}
