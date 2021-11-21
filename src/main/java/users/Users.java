package users;

import transport.Transport;

public abstract class Users {
String login;//e-mail
String password;
Class<? extends Transport> transport;
}
