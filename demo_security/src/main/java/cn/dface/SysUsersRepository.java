package cn.dface;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by akun on 2017/7/11.
 */
public interface SysUsersRepository extends JpaRepository<SysUser,Long>{

    SysUser findByUsername(String username);
}
