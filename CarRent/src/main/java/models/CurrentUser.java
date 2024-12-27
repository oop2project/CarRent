package models;

public class CurrentUser {
    private static String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        CurrentUser.name = name;
    }
}
