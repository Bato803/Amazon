public interface Command {

    public void executed();
}
public class Display implements Command {


    @Override
    public void executed() {


        display("ID");

    }


    private void display(String id) {

        Book book = Library.getInstance().find(id);


        System.out.println("Display");

    }


}
public enum Type {


    Tech("Tech"), Natu("Natu");

    private String type;

    Type(String type) {

        this.type = type;
    }


    public static Type getType(String s) {


        for (Type type : Type.values()) {

            if (type.type.equals(s)) {
                return type;
            }
        }

        return null;
    }


}

public enum AccountType {


    Normal("Normal"), VIP("VIP");


    private String type;

    AccountType(String type) {

        this.type = type;
    }


    public static AccountType getAccountType(String s) {

        for (AccountType accountType : AccountType.values()) {

            if (accountType.type.equals(s)) {
                return accountType;
            }
        }

        return null;
    }
}

public class User {

    private long id;
    private String email;

    private String name;

    private AccountType accountType;

    public User(long id, String email, String name, AccountType accountType) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.accountType = accountType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}

public class UserManager {


    private  static UserManager instance = new UserManager();


    public static UserManager getUserManager(){

        return instance;
    }

    private Map<Long, User> users;


    public User addUser(long id, String email, String name, AccountType accountType) {
        if (users.containsKey(id)) {
            return null;

        }
        User user = new User(id, email, name, accountType);
        users.put(id, user);
        return user;

    }


    public boolean remove(User u) {
        return remove(u.getId());

    }


    public boolean remove(long id) {
        if (!users.containsKey(id)) {
            return false;

        }
        users.remove(id);
        return true;

    }


    public User find(long id) {
        return users.get(id);

    }
}


public class Book {
    

    private Type type;
    private String id;
    private String details;

    public Book(Type type, String id, String details) {
        this.type = type;
        this.id = id;
        this.details = details;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
