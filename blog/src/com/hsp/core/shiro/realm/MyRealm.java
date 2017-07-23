package com.hsp.core.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.hsp.admin.pojo.User;
import com.hsp.admin.service.IUserService;
import com.hsp.base.enums.UserStatus;
/**
 * shiro身份信息realm
 * @author hsp
 *
 */
public class MyRealm extends AuthorizingRealm{

	@Autowired
	IUserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username=(String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userService.findRoles(username));
		authorizationInfo.setStringPermissions(userService.findPermissions(username));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username=(String) token.getPrincipal();
		User user=userService.getUserByUsername(username);
		if(user==null){
			throw new UnknownAccountException();
		}
		if(UserStatus.LOCKED.equals(user.getIslock())){
			throw new LockedAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
				user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getUsername()),getName());
		return authenticationInfo;
	}

	

}
