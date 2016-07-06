package cn.tinycube.trial.entity;

/**
 * @author: WangJianbiao
 * @time: 16/4/29-上午10:50.
 * @email: wangjianbiao@qccr.com
 * @desc: 类别分类
 */
public class Category {


    public Category(int id, String title, Class<?> target) {
        this.id = id;
        this.title = title;
        this.target = target;
    }

    public Category() {
    }

    public Category(CategoryEnum categoryEnum) {
        this.id = categoryEnum.getId();
        this.title = categoryEnum.getTitle();
        this.target = categoryEnum.getTarget();
    }

    private int id;
    private String title;
    private Class<?> target;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class<?> getTarget() {
        return target;
    }

    public void setTarget(Class<?> target) {
        this.target = target;
    }
}
