package woowastudy.tobyspringstudy.user.dao;

public class DaoFactory { // ConnectionMaker와 UserDao 오브젝트를 만들고 연결하여 반환한다.
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
