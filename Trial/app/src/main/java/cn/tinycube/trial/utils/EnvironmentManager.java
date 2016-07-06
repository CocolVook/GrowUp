package cn.tinycube.trial.utils;

/**
 * @author: WangJianbiao
 * @time: 16/5/2-下午1:30.
 * @email: wangjianbiao@qccr.com
 * @desc: 环境管理
 */
public class EnvironmentManager {

    private EnvironmentManager() {
    }

    private static EnvironmentManager instance;

    public static EnvironmentManager get() {
        if (instance == null) {
            synchronized (EnvironmentManager.class) {
                if (instance == null) {
                    instance = new EnvironmentManager();
                }
            }
        }
        return instance;
    }


    private String environment;

    /**
     * 获取环境
     */
    public String environment() {
        return environment;
    }

    /**
     * 改变环境
     * {@see Environment}
     */
    public void $(@Environment String environment) {
        this.environment = environment;
    }

    /**
     * 设置一个新的环境
     */
    public void setNewEnvironment(String environment) {
        this.environment = environment;
    }

    public void clearHistory() {
    }


}
