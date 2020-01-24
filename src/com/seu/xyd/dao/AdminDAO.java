package com.seu.xyd.dao;


import com.seu.xyd.data.Admin;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;

public interface AdminDAO {
    void deleteAllDataONLYFORTEST() throws DBProcessException;
    
    //for admin
    long insertAdmin(Admin admin) throws DBProcessException;
    Admin selectAdmin(long id) throws DBProcessException, NoSuchCase;
    Admin selectAdminByAccount(String account) throws DBProcessException, NoSuchCase;
    void deleteAdmin(long id) throws DBProcessException, NoSuchCase;
    void updateAdmin(Admin admin) throws DBProcessException, NoSuchCase;

	Admin[] selectAdmins() throws DBProcessException;

	Admin getAdmin(int id) throws DBProcessException, NoSuchCase;
    


}
