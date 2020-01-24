package com.seu.xyd.dao;


import com.seu.xyd.data.ReceiverInfo;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;

public interface ReceiverInfoDAO {
    void deleteAllDataONLYFORTEST() throws DBProcessException;
    
    //for ReceiverInfo
    long insertReceiverInfo(ReceiverInfo receiverInfo) throws DBProcessException;
    ReceiverInfo selectReceiverInfo(long id) throws DBProcessException, NoSuchCase;
    void deleteReceiverInfo(long id) throws DBProcessException, NoSuchCase;
    void updateReceiverInfo(ReceiverInfo receiverInfo) throws DBProcessException, NoSuchCase;
	ReceiverInfo[] selectReceiverInfos() throws DBProcessException;
	ReceiverInfo[] selectReceiverInfosByUserId(long UserId) throws DBProcessException;

	



}
