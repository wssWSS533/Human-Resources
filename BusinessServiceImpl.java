package dlnu.hrsys.user.impl;

import dlnu.hrsys.user.entity.User;
import dlnu.hrsys.user.exception.UserExistException;

public class BusinessServiceImpl {
	private UserDaoImpl dao=new UserDaoImpl();
	//给WEN层提供注册
	public void register(User user) throws UserExistException {
		boolean b=dao.find(user.getUsername());
		if(b){
			throw new UserExistException();//如果已注册  抛出异常给WEB层处理
		}else{
			dao.add(user);
		}
	}
	//登陆验证
	public User login(String username,String password){
		return dao.find(username,password);
	}
}
