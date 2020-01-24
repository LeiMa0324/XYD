package com.seu.xyd.logic;

import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

import com.seu.xyd.dao.DAOFactory;
import com.seu.xyd.dao.ReceiverInfoDAO;
import com.seu.xyd.dao.RechargeRecordDAO;
import com.seu.xyd.dao.UserDAO;
import com.seu.xyd.data.ReceiverInfo;
import com.seu.xyd.data.RechargeRecord;
import com.seu.xyd.data.User;
import com.seu.xyd.data.XYDErrors;
import com.seu.xyd.servlet.MailThread;
import com.seu.xyd.servlet.UIUtil;
import com.tn17.logic.LogicException;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;
import com.tn17.util.TimeUtil;
public class UserLogic {
    private static UserLogic instance = null;
    private final UserDAO uDao = DAOFactory.getUserDAO();
    private final RechargeRecordDAO rechargeRecordDao = DAOFactory.getRechargeRecordDAO();
    private final ReceiverInfoDAO receiverInfoDao = DAOFactory.getReceiverInfoDAO();
    
    private UserLogic() {
        // lock it
    }
    

    public synchronized static UserLogic getInstance() {
        if (instance == null) {
            instance = new UserLogic();
        }
        return instance;
    }
    
    public User signIn(String account) throws LogicException, DBProcessException {
        try {
            User user = uDao.selectUserByAccount(account);            
            return user;
        } catch (NoSuchCase e) {
            throw LogicUtil.createException(XYDErrors.NO_SUCH_USER);
        }
    }

	public void addUser(User user) throws DBProcessException {
		uDao.insertUser(user);
		
	}

	public User[] getUserList() throws DBProcessException {
		User[] users = uDao.selectUsers();
		return users;
	}

	public User getUser(int id) throws DBProcessException, ServletException{
		try {
			return uDao.getUser(id);
		} catch (NoSuchCase e) {
			throw new ServletException("找不到数据");
		}
	}

	public void updateUser(User user) throws DBProcessException, ServletException{
		try {
			uDao.updateUser(user);
		} catch (NoSuchCase e) {
			throw new ServletException("找不到数据");
		}
		
	}

	public void deleteUser(int id) throws DBProcessException, ServletException {
		try {
			uDao.deleteUser(id);
		} catch (NoSuchCase e) {
			throw new ServletException("找不到数据");
		}
		
	}

	public User getUserByAccount(String account) throws ServletException, DBProcessException {
		try {
			 return uDao.selectUserByAccount(account);
		} catch (NoSuchCase e) {
			throw new ServletException("找不到数据");
		}
	}

	public synchronized void registerUser(User user) throws DBProcessException, ServletException {
		try {
			uDao.selectUserByAccount(user.getAccount());
		} catch (NoSuchCase e) {
			uDao.insertUser(user);
			return;
		}
		throw new ServletException("账号已存在");
		
	}

	public synchronized void  sendEmailAndWriteSession(HttpServletRequest request, String account, String email) throws DBProcessException, ServletException {
		try {
			 User user = uDao.selectUserByAccount(account);
			 if(!email.equals(user.getEmail())){
				 throw new ServletException("您输入的账号和邮箱不匹配");
			 }else{
			 	 //System.out.println("---------------------"+TimeUtil.parseTime(Calendar.getInstance())+"--------------------");
				 String msg = UIUtil.getRandomMsg();
				 HttpSession session = request.getSession(false);
				 session.setAttribute(UIUtil.SESSION_ATTRIBUTE_KEY_FOR_MSG, msg);
				
				 MailThread thread = new MailThread();
				 thread.email = email;
				 thread.msg = msg;
				 thread.run();
				 //System.out.println("---------------------"+TimeUtil.parseTime(Calendar.getInstance())+"--------------------");
			 }
			 
		} catch (NoSuchCase e) {
			throw new ServletException("您输入的账号有误");
		}
		
		
		
		
	}

	public void checkIdentifyNum(HttpServletRequest request, String num) throws ServletException {
		HttpSession session = request.getSession(false);
		String sessionNum = (String)session.getAttribute(UIUtil.SESSION_ATTRIBUTE_KEY_FOR_MSG);
		if(sessionNum!=null&&sessionNum.equals(num)){
			return;
		}else{
			throw new ServletException("您输入的验证码有误");
		}
	}

	public void setNewPwd(HttpServletRequest request, String account,
		String pw, String num) throws ServletException, DBProcessException {
		HttpSession session = request.getSession(false);
		String sessionNum = (String)session.getAttribute(UIUtil.SESSION_ATTRIBUTE_KEY_FOR_MSG);
		if(sessionNum!=null&&sessionNum.equals(num)){
			try {
				User user = uDao.selectUserByAccount(account);
				user.setPw(pw);
				uDao.updateUser(user);
			} catch ( NoSuchCase e) {
				throw new ServletException("您的操作有误，请刷新页面重新操作");
			}
		}else{
			throw new ServletException("您的操作有误，请刷新页面重新操作");
		}
		
	}

	
	//张海越-分页获取充值历史列表
	public RechargeRecord[] getRecordListByUserId(int id, int page) throws DBProcessException {
		return rechargeRecordDao.selectRechargeRecordByUserId(id, page);

	}
	//张海越-插入充值记录
	public void insertChargeRecord(RechargeRecord record) throws DBProcessException{
		rechargeRecordDao.insertRechargeRecord(record);
	}

    //张海越-获取充值记录条数
	public int getRecordCountByUserId(int id) throws DBProcessException{
		return rechargeRecordDao.getRecordCountByUserId(id);
	}

	//张海越-获取收货地址列表
	public ReceiverInfo[] getReceiverInfoListByUserId(int id) throws DBProcessException {
		return receiverInfoDao.selectReceiverInfosByUserId(id);
	}

	/*
	 * 张海越-删除收货地址
	 */
	public void deleteReceiverInfo(int id) throws DBProcessException, ServletException {
		
		try {
			receiverInfoDao.deleteReceiverInfo(id);
		} catch (NoSuchCase e) {
			throw new ServletException("删除收货地址出错");
		}
	}


	/*
	 * 张海越-新增收货地址
	 */
	public void insertNewReceiverInfo(ReceiverInfo receiverInfo) throws DBProcessException {
		receiverInfoDao.insertReceiverInfo(receiverInfo);
		
	}


	public void updateReceiverInfoById(ReceiverInfo receiverInfo) throws DBProcessException, ServletException {
		try {
			receiverInfoDao.updateReceiverInfo(receiverInfo);
		} catch (NoSuchCase e) {
			throw new ServletException("更新收货地址数据");
		}
		
	}


	public ReceiverInfo getReceiverInfoById(int id) throws DBProcessException, ServletException {
		try {
			return receiverInfoDao.selectReceiverInfo(id);
		} catch (NoSuchCase e) {
			throw new ServletException("未找到收货地址数据");
		}
	}

	//张雅南--按关键字搜索用户
	public User[] getUsersWithKeyWord(String keyWord, int page) throws DBProcessException {
		return uDao.getUserListByShopIdWithPage( keyWord,page);
	}


	

}