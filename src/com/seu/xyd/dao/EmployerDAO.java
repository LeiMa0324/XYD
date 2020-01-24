package com.seu.xyd.dao;


import com.seu.xyd.data.Employer;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;

public interface EmployerDAO {
    void deleteAllDataONLYFORTEST() throws DBProcessException;
    
    //for employer
    long insertEmployer(Employer employer) throws DBProcessException;
    Employer selectEmployer(long id) throws DBProcessException, NoSuchCase;
    public Employer[] selectEmployersByShopId(long shopId) throws DBProcessException;
    void deleteEmployer(long id) throws DBProcessException, NoSuchCase;
    void updateEmployer(Employer employer) throws DBProcessException, NoSuchCase;

	Employer[] selectEmployers() throws DBProcessException;
    


}
