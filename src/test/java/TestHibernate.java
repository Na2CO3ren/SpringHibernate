import com.robin.spring.hibernate.service.BookShopCashier;
import com.robin.spring.hibernate.service.BookShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestHibernate {
    @Autowired
    private BookShopService bookShopService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BookShopCashier bookShopCashier;

    @Test
    public void testConnection() {
        System.out.println(dataSource);
    }

    @Test
    public void testBookShopService() {
        bookShopService.purchase("robin","1001");
    }

    @Test
    public void testBookShopCashier() {
        bookShopCashier.checkout("robin", Arrays.asList("1001","1002"));
    }
}
