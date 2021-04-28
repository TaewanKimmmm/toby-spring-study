package woowastudy.tobyspringstudy.user.dao;

public class DaoFactory { // ConnectionMaker와 UserDao 오브젝트를 만들고 연결하여 반환한다.
    public UserDao userDao() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
