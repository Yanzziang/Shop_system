package util;

import vo.User;

public class UserInfo {
    public static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User newUser) {
        user = newUser;
    }

}
