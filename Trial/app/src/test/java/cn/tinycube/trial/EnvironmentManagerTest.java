package cn.tinycube.trial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.tinycube.trial.utils.Environment;
import cn.tinycube.trial.utils.EnvironmentManager;

import static org.junit.Assert.*;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午1:50.
 * @email: wangjianbiao@qccr.com
 * @desc:
 */
public class EnvironmentManagerTest {

    private EnvironmentManager environmentManager;
    @Before
    public void setUp() throws Exception {
        environmentManager = EnvironmentManager.get();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testChangeEnvironment() throws Exception {
        environmentManager.$(Environment.TEST_HTTP);
        assertEquals(Environment.TEST_HTTP, environmentManager.environment());
    }


}