package cn.edu.seu.lone.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("执行了loadUserByUsername方法");
        // 1.查询数据库单盘用户名是否存在，不存在跑出 UsernameNotFoundException
        if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 2.把查询出来的密码进行解析，或者直接把密码放入构造方法
        String password = passwordEncoder.encode("123456");

        return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}
