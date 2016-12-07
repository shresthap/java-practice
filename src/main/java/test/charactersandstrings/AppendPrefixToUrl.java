package test.charactersandstrings;

/**
 * Created by pshrestha on 12/7/2016.
 */
public class AppendPrefixToUrl {

    private final String forwardSlashRegex = "^/\\S*";
    String damBaseUrl = "https://r-preprod.pb-cdn.com";


    public String appendPathPrefix(String imagePath) {
        if (imagePath == null) {
            return null;
        }
        if (!imagePath.contains("http") || !imagePath.contains(".com")) {

            if (imagePath.matches(forwardSlashRegex)) {
                imagePath = damBaseUrl + imagePath;
            } else {
                imagePath = damBaseUrl + "/" + imagePath;
            }
//            imagePath = config.getDamBaseUrl() + imagePath;

        }
//       else if (imagePath.matches(httpRegex)) {
//            imagePath = imagePath.replaceAll(httpcomRegex, config.getDamBaseUrl());
//        }

        return imagePath;
    }

}
