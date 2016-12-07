package test.charactersandstrings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pshrestha on 12/7/2016.
 */
public class EmailAddressValidation {

    private Pattern pattern;
    private Matcher matcher;

//    private static final String EMAIL_PATTERN =
//            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String EMAIL_PATTERN = "^([0-9a-zA-Z_\\.\\'\\-]+)*@[0-9a-zA-Z\\-]+[a-zA-Z\\.]+$";

    public void testEmailAddressValidation() {
        pattern = Pattern.compile(EMAIL_PATTERN);
        String email = "test@testcom";
        matcher = pattern.matcher(email);
        System.out.println(matcher.matches());

    }
}
