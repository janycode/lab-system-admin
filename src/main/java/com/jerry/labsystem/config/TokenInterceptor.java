package com.jerry.labsystem.config;

import com.jerry.labsystem.pojo.User;
import com.jerry.labsystem.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private UserService<User> userService;

    /**
     * 进入controller方法之前调用
     *
     * @param request  请求
     * @param response 响应
     * @param handler  内容
     * @return boolean
     * @author Jerry(姜源)
     * @date 2026/01/12
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println("preHandle");
        String uri = request.getRequestURI();
        // /login 默认放行
        if (uri.contains("/login")) {
            return true;
        }

        // 处理 token
        String token = request.getHeader(jwtConfig.getHeader());
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(jwtConfig.getHeader());
        }
        if (StringUtils.isEmpty(token)) {
            // 返回401，token不能为空
            sendError(response, "token 不能为空");
            return false;
        }

        Claims tokenClaim = null;
        try {
            // 校验 token 是否有被篡改
            tokenClaim = jwtConfig.getTokenClaim(token);
        } catch (Exception e) {
            // 返回401，token不能为空
            sendError(response, "token 无效");
            return false;
        }

        //缓存当前登录用户名，如redis
        String username = tokenClaim.getSubject();
        // redisUtil...  - redis 中缓存登陆用户 User 对象信息

        //true表示放行，false表示不放行
        return true;
    }

    private void sendError(HttpServletResponse response, String msg) throws IOException {
        response.setStatus(401);
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(msg);
    }
}
