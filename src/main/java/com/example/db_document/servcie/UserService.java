package com.example.db_document.servcie;

import com.example.db_document.mapper.UserMapper;
import com.example.db_document.model.dto.RegisterRequest;
import com.example.db_document.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserService(){
    }

//先写个用名称登录的
    public User login(String account, String password){
        if (account == null || (account = account.trim()).isEmpty()) {
            throw new IllegalArgumentException("账号不能为空");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("密码不能为空");
        }

        User user = userMapper.selectByAccount(account);
        if (user == null){
            throw new IllegalArgumentException("用户不存在");
        }
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("账号或密码错误"); // 或者返回 null
        }

        System.out.println("登录成功，欢迎 " + user.getNickname());
        user.setPassword(null); // 登录成功后，不返回密码，确保安全
        return user;
    }

    public void register(RegisterRequest req) {
        if (req.getPhoneNum() != null && !req.getPhoneNum().isBlank()) {
            this.registerByPhone(req.getPhoneNum(), req.getPassword());
        } else {
            this.registerByEmail(req.getEmail(), req.getPassword());
        }
    }

    public void registerByPhone(String phone, String password) {
        if (phone == null || (phone = phone.trim()).isEmpty()) {
            throw new IllegalArgumentException("电话号码不能为空");
        }
        //中国大陆手机号判断
        String phoneRegex = "^1[3-9]\\d{9}$";
        if (!java.util.regex.Pattern.matches(phoneRegex, phone)) {
            throw new IllegalArgumentException("电话号码格式不正确");
        }

        // 检查手机号是否重复
        User existUser = userMapper.selectByPhone(phone); // 调用接口方法
        if (existUser != null) {
            throw new RuntimeException("该号码已被注册");
        }

//        if (nickname == null || (nickname = nickname.trim()).isEmpty()) {
//            throw new IllegalArgumentException("昵称不能为空");
//        }
//        User nameUser = userMapper.selectByNickname(nickname);
//        if (nameUser != null) {
//            throw new RuntimeException("该昵称已被使用");
//        }
        User newUser = new User();
        newUser.setPhoneNum(phone);
        String nickname = generateByUUID();
        newUser.setNickname(nickname);
        // 实际开发中密码必须加密，不能存明文！
        // newUser.setPassword(passwordEncoder.encode(password));
        newUser.setPassword(password);
        userMapper.insert(newUser);
        System.out.println("注册成功，新用户ID是: " + newUser.getId());
    }

    public void registerByEmail(String email, String password) {
        if (email == null || (email = email.trim()).isEmpty()) {
            throw new IllegalArgumentException("邮箱不能为空");
        }

        String emailRegex = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
        if (!java.util.regex.Pattern.matches(emailRegex, email)) {
            throw new IllegalArgumentException("邮箱格式不正确");
        }

        // 检查邮箱是否重复
        User existUser = userMapper.selectByEmail(email); // 调用接口方法
        if (existUser != null) {
            throw new RuntimeException("该邮箱已被注册");
        }

//        if (nickname == null || (nickname = nickname.trim()).isEmpty()) {
//            throw new IllegalArgumentException("昵称不能为空");
//        }
//        User nameUser = userMapper.selectByNickname(nickname);
//        if (nameUser != null) {
//            throw new RuntimeException("该昵称已被使用");
//        }

        // 没有重复，就开始创建一个新的user
        User newUser = new User();
        String nickname = generateByUUID();
        newUser.setEmail(email);
        newUser.setNickname(nickname);
        // 实际开发中密码必须加密，不能存明文！
        // newUser.setPassword(passwordEncoder.encode(password));
        newUser.setPassword(password);
        userMapper.insert(newUser);
        // 因为配置了 keyProperty="id"，执行完上面这行后，
        // newUser.getId() 就会自动变成数据库生成的 ID (比如 1001)
        System.out.println("注册成功，新用户ID是: " + newUser.getId());
    }

    public static String generateByUUID() {
        // 截取 UUID 的前8位，足够随机且不长
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return "User_" + uuid.substring(0, 8);
    }
}
