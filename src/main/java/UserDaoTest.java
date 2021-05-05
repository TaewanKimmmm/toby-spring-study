import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import woowastudy.tobyspringstudy.user.dao.DaoFactory;
import woowastudy.tobyspringstudy.user.dao.UserDao;

public class UserDaoTest {
    public static void main(String[] args) {
        // DaoFactory를 설정정보로 사용하는 ApplicationContext 오브젝트를 만든다.
        // @Configuration 어노테이션이 붙은 자바 코드를 설정정보로 사용하도록 하였다.
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        //ApplicationContext 객체의 getBean() 메서드로 UserDao 오브젝트를 가져올 수 있게 되었다.
        UserDao dao = context.getBean("userDao", UserDao.class);
    }
}
