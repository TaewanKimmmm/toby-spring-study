package woowastudy.tobyspringstudy.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Application Context 또는 Bean Factory가 사용할 설정정보라는 표시
public class DaoFactory { // ConnectionMaker와 UserDao 오브젝트를 만들고 연결하여 반환한다.
    @Bean // 오브젝트 생성을 담당하는 IOC용 메서드라는 표시
    // userDao라는 메서드명은, 추후에 ApplicationContext에 등록된 빈의 이름이 된다.
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

//    public AccountDao accountDao() {
//        return new AccountDao(connectionMaker());
//    }
//
//    public MessageDao messageDao() {
//        return new MessageDao(connectionMaker());
//    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
