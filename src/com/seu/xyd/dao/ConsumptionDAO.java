package com.seu.xyd.dao;


import com.seu.xyd.data.Consumption;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;

public interface ConsumptionDAO {
    void deleteAllDataONLYFORTEST() throws DBProcessException;
    
    //for consumption
    long insertConsumption(Consumption consumption) throws DBProcessException;
    Consumption selectConsumption(long id) throws DBProcessException, NoSuchCase;
    public Consumption[] selectConsumptionsByShopId(long shopId) throws DBProcessException;
    void deleteConsumption(long id) throws DBProcessException, NoSuchCase;
    void updateConsumption(Consumption consumption) throws DBProcessException, NoSuchCase;

	Consumption[] selectConsumptions() throws DBProcessException;
    


}
