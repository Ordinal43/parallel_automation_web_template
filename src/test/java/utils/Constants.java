package utils;

import static utils.Helpers.ENV;

public class Constants {
    public static final String MAIN_URL = ENV("MAIN_URL");
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String SRC_TEST_RESOURCES = USER_DIR + "/src/test/resources";
    public static final String TEST_DATA_FILENAME = ".test_data";
}
