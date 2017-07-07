package cn.dface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by akun on 2017/7/7.
 */
@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    @CachePut(value="people",key="#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.print("为ID，key为："+p.getId()+"数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value="people",key="#person.id")
    public void remove(Long id) {
        System.out.print("删除了ID为："+id+"数据的缓存");
        personRepository.delete(id);
    }

    @Override
    @Cacheable(value="people",key="#person.id")
    public Person findOne(Person person) {
        Person p = personRepository.findOne(person.getId());
        System.out.print("为ID为："+person.getId()+"数据做了缓存");
        return p;
    }
}
