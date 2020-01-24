package com.seu.xyd.dao;


import com.seu.xyd.data.RechargeRecord;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;

public interface RechargeRecordDAO {
    void deleteAllDataONLYFORTEST() throws DBProcessException;
    
    //for rechargeRecord
    long insertRechargeRecord(RechargeRecord rechargeRecord) throws DBProcessException;
    RechargeRecord selectRechargeRecord(long id) throws DBProcessException, NoSuchCase;
    RechargeRecord[] selectRechargeRecordByUserId(long userId, int page) throws DBProcessException;
    void deleteRechargeRecord(long id) throws DBProcessException, NoSuchCase;
    void updateRechargeRecord(RechargeRecord rechargeRecord) throws DBProcessException, NoSuchCase;

	RechargeRecord[] selectRechargeRecords() throws DBProcessException;

	RechargeRecord getRechargeRecord(int id) throws DBProcessException, NoSuchCase;

	int getRecordCountByUserId(long userId) throws DBProcessException;
    


}
