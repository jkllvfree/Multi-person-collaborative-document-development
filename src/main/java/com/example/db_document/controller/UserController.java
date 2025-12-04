package com.example.db_document.controller;

import com.example.db_document.model.dto.LoginRequest;
import com.example.db_document.model.dto.RegisterRequest;
import com.example.db_document.pojo.JsonResult;
import com.example.db_document.pojo.User;
import com.example.db_document.servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public JsonResult<User> register(@RequestBody RegisterRequest req) {    //这里用jsonObject可以吗
        try{
            userService.register(req);
            return JsonResult.success(null);
        }catch(IllegalArgumentException e) {
            return JsonResult.error(e.getMessage());
        }catch(RuntimeException e){
            return JsonResult.error(e.getMessage());
        }
        catch (Exception e) {
            return JsonResult.error("系统内部错误");
        }
    }


    @PostMapping("/login")
    public JsonResult<User> login(@RequestBody LoginRequest req) {
        try{
            User user = userService.login(req.getAccount(), req.getPassword());
            user.setPassword(null);
            return JsonResult.success(user);
        }catch (IllegalArgumentException e) {
            return JsonResult.error(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("系统内部错误");
        }
    }
}
