import com.xlmkit.plugin.maven.AbstractModelGeneratorMojo;
import com.xlmkit.plugin.maven.ModelGenerator;
import com.xlmkit.plugin.maven.ModelGeneratorConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import java.io.File;
import java.util.Arrays;

/**
 * @Author: 蔡小龙
 * @Date: 2021/3/12 09:13
 * @Description:
 */
@Slf4j
public class AbstractModelGeneratorMojoTest extends AbstractMojoTestCase {
    /**
     * @throws Exception if any
     */
    public void testSomething() throws Exception {
//        MavenExecutionResult
        File pom = getTestFile("/project-to-test.xml");
        assertNotNull(pom);
        log.info("{}", pom.getAbsolutePath());
        assertTrue(pom.exists());

        AbstractModelGeneratorMojo myMojo = (AbstractModelGeneratorMojo) lookupMojo("generate", pom);
        myMojo.setPackageName("mysql");
        myMojo.setDistPath("my-test");
        myMojo.setJdbcUrl(
                "jdbc:mysql://10.111.200.13:3306/proxy_server?zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&useSSL=false");
        myMojo.setJdbcUsername("proxy_server");
        myMojo.setJdbcPassword("proxy_server");


        assertNotNull(myMojo);
        myMojo.execute();
//        RepositorySystem
    }
}
