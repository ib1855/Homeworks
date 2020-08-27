package accountServer;

public class AccountServer implements AccountServerI {
    private int usersLimit;
    private int usersCount;

    public AccountServer(){
        this.usersLimit = 10;
        this.usersCount = 0;
    }

    @Override
    public void addNewUser() {
        this.usersCount++;
    }

    @Override
    public void removeUser() {
        this.usersCount--;
    }

    @Override
    public int getUsersLimit() {
        return usersLimit;
    }

    @Override
    public void setUsersLimit(int usersLimit) {
        this.usersLimit = usersLimit;
    }

    @Override
    public int getUsersCount() {
        return usersCount;
    }
}
