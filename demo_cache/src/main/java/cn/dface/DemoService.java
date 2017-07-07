package cn.dface;

/**
 * Created by akun on 2017/7/7.
 */
public interface DemoService {

    public Person save(Person person);

    public void remove(Long id);

    public Person findOne(Person person);
}
