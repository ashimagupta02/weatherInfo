package utils;

public class BaseUrl {

	public static String url_1;
    public static String url_2;
    private static String dir = System.getProperty("user.dir");

    public static String getUserDirectory() {
        return dir;
    }
    
    public static void initializeProperties() {
    	PropertyUtil.getInstance().load("config.properties");
    	url_1 = PropertyUtil.getInstance().getValue("url_1");
    	url_2 = PropertyUtil.getInstance().getValue("url_2");
    }
}