//package com.yannyao.blog.config.shiro;
//
//        import com.yannyao.blog.bean.Permission;
//        import com.yannyao.blog.bean.Role;
//        import com.yannyao.blog.bean.User;
//        import com.yannyao.blog.mapper.PermissionMapper;
//        import com.yannyao.blog.service.UserService;
//        import org.apache.log4j.LogManager;
//        import org.apache.shiro.SecurityUtils;
//        import org.apache.shiro.authc.*;
//        import org.apache.shiro.authz.AuthorizationInfo;
//        import org.apache.shiro.authz.SimpleAuthorizationInfo;
//        import org.apache.shiro.realm.AuthorizingRealm;
//        import org.apache.shiro.session.Session;
//        import org.apache.shiro.subject.PrincipalCollection;
//        import org.slf4j.Logger;
//        import org.slf4j.LoggerFactory;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.beans.factory.annotation.Value;
//        import org.springframework.stereotype.Service;
//
//        import java.util.Arrays;
//        import java.util.HashSet;
//        import java.util.Set;
//
//@Service
//public class MyRealm extends AuthorizingRealm {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(MyRealm.class);
//
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    /**
//     * 大坑！，必须重写此方法，不然Shiro会报错
//     */
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof JWTToken;
//    }
//
//    /**
//     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String username = JWTUtil.getUsername(principals.toString());
//        User user = null;
//        try {
//            user = userService.getByUsername(username);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.addRole("1");
////        Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
////        simpleAuthorizationInfo.addStringPermissions(permission);
//        return simpleAuthorizationInfo;
//    }
//
//    /**
//     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
//        String token = (String) auth.getCredentials();
//        // 解密获得username，用于和数据库进行对比
//        String username = JWTUtil.getUsername(token);
//        if (username == null) {
//            throw new AuthenticationException("token invalid");
//        }
//
//        User userBean = null;
//        try {
//            userBean = userService.getByUsername(username);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (userBean == null) {
//            throw new AuthenticationException("User didn't existed!");
//        }
//
//        if (! JWTUtil.verify(token, username, userBean.getPassword())) {
//            throw new AuthenticationException("Username or password error");
//        }
//
//        return new SimpleAuthenticationInfo(token, token, "my_realm");
//    }
//}