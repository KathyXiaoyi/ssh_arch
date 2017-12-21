package ilv.test;

import ilv.model.IlvUser;
import ilv.service.UserServiceI;

import java.sql.Timestamp;
import java.util.UUID;

import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl11;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHibernate {

    public void test() {
        // 获取2个配置文件，其中spring-hibernate.xml配置了SessionFactory
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[] { "classpath:spring.xml",
                        "classpath:spring-hibernate.xml" });
        UserServiceI userService = (UserServiceI) ac.getBean("userService1");
        IlvUser user = new IlvUser();
        //设置UUID主键
        user.setId(UUID.randomUUID().toString());
        user.setRealname("yanglang");
        user.setUsername("superadmin");
        user.setPassword("helloyayaya");
        user.setIslock("1");
        user.setStatus("1");
        user.setCreatetime(new Timestamp(System.currentTimeMillis()));
        userService.save(user);
    }
    
    public static void main(String[] args) {
    	System.out.println("begin");
    	TestHibernate tes1 = new TestHibernate();
    	tes1.test();
	}
}