package com.lyt.shiro.handlers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shiro")
public class ShiroHandler {
	
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, 
			@RequestParam("rememberme") String rememberme){
		// 1.获取当前的 Subject. 调用 SecurityUtils.getSubject();
        Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.isAuthenticated()) {
        	// 2.把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // rememberme
            System.out.println( "rememberme 是 ：" + rememberme);
            if(rememberme.equals("on")){
            	token.setRememberMe(true);//这个是记住用户，当用户登出之后才会取消
            }else{
            	token.setRememberMe(false);//这个是记住用户，当用户登出之后才会取消
            }
            
            try {
//            	System.out.println("1. 获取到的用户名是：" + username + "， hashCode是：" + token.hashCode());
            	// 执行登录. 
                currentUser.login(token);
            } 
            // ... catch more exceptions here (maybe custom ones specific to your application?
            // 所有认证时异常的父类. 
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            	System.out.println("登录失败: " + ae.getMessage());
            }
        }
		
		return "redirect:/list.jsp";
	}
	
	@RequestMapping("/testShiroAnnotation")
	public String testShiroAnnotation(){
		return "redirect:/index.jsp";
	}
}
