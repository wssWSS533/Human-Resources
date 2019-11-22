package dlnu.hrsys.user.impl;

import dlnu.hrsys.user.entity.User;
import dlnu.hrsys.user.exception.UserExistException;

public class BusinessServiceImpl {
	private UserDaoImpl dao=new UserDaoImpl();
	//��WEN���ṩע��
	public void register(User user) throws UserExistException {
		boolean b=dao.find(user.getUsername());
		if(b){
			throw new UserExistException();//�����ע��  �׳��쳣��WEB�㴦��
		}else{
			dao.add(user);
		}
	}
	//��½��֤
	public User login(String username,String password){
		return dao.find(username,password);
	}
}
