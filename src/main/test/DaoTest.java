import com.mafei.job.dao.MultiDAO;
import com.mafei.job.pojo.Device;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * Created by jms on 2017/10/15.
 * 数据库测试
 */
@Test
@ContextConfiguration("classpath:spring/spring-context.xml")
public class DaoTest extends AbstractTestNGSpringContextTests {
    @Resource
    private MultiDAO multiDAO;


    public void testGetDeviceById() {
        String id = "2";
        Device device = multiDAO.getDeviceById(id);
        System.out.println("");

    }


}
