package com.seu.xyd.dao;


import com.seu.xyd.data.User;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;

public interface UserDAO {
    void deleteAllDataONLYFORTEST() throws DBProcessException;
    
    //for user
    long insertUser(User user) throws DBProcessException;
    User selectUser(long id) throws DBProcessException, NoSuchCase;
    User selectUserByAccount(String account) throws DBProcessException, NoSuchCase;
    void deleteUser(long id) throws DBProcessException, NoSuchCase;
    void updateUser(User user) throws DBProcessException, NoSuchCase;

	User[] selectUsers() throws DBProcessException;
	User[] getUserListByShopIdWithPage(String keyWord, int page) throws DBProcessException;
	User getUser(int id) throws DBProcessException, NoSuchCase;
    


}
