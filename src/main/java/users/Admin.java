package users;

import utils.Access;

public class Admin extends Users{
    private static final Access access = Access.FULL;



    public static Access getAccess() {
        return access;
    }

}
