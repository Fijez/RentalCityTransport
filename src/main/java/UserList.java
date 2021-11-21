import org.h2.engine.User;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static List<User> userList = new ArrayList<>();

    public UserList() {
    }

    public static void addToUserList(User user) {
        userList.add(user);
    }

    public static List<User> getUserList() {
        return userList;
    }
}
