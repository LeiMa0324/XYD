package com.seu.xyd.servlet;


import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.seu.xyd.data.Order;
import com.seu.xyd.data.ReceiverInfo;
import com.seu.xyd.data.RechargeRecord;
import com.seu.xyd.data.User;
import com.seu.xyd.data.XYDErrors;
import com.seu.xyd.logic.LogicUtil;
import com.seu.xyd.logic.UserLogic;
import com.tn17.logic.LogicException;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;

/**
 * Servlet implementation class userServlet
 */
public class UserServlet extends XYDServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7418032213105965975L;
    final UserLogic uL = UserLogic.getInstance();

	@Override
	String process(HttpServletRequest request) throws LogicException,
			DBProcessException, ServletException {
		Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("response");
        Element result = root.addElement("result");
        
        XYDWebOP op = XYDWebOP.valueOfName(UIUtil.getParam(request, XYDWebParam.OP));
        switch (op) {
        case SIGIN: {
            sigin(request, result);
            break;
        }
        case LOGOUT: {
            logout(request,result);
            break;
        }
        case REGISTER:{
        	register(request,result);
        	break;
        }
        case FIND_PWD_STEP1:{
        	finfPwdStep1(request,result);
        	break;
        }
        case FIND_PWD_STEP2:{
        	finfPwdStep2(request,result);
        	break;
        }
        case FIND_PWD_STEP3:{
        	finfPwdStep3(request,result);
        	break;
        }
        case MODIFY_INFO:{
        	modifyInfo(request,result);
        	break;
        }
        case MODIFY_PWD:{
        	modifyPwd(request,result);
        	break;
        }
        case GET_USERINFO:{
        	getUserinfo(request,result);
        	break;
        }
        case GET_USER_LIST_BY_KEYWORD://张雅南
        {
        	getUserListByKeyword(request,result);
        	break;
        	
        }
        case GET_USER_WITH_ADMIN://张雅南
        {
        	GetUserWithAdmin(request,result);
        	break;
        	
        }
        case CHARGE_MONEY:{
        	chargeMoney(request,result);
        	break;
        }
        case GET_RECORD_LIST:{
        	getRecordList(request,result);
        	break;
        }
        case GET_ADDERSS_LIST:{
        	getAddressList(request,result);
        	break;
        }
        case MAKE_DEFAULT_ADDRESS:{
        	makeDefaultAddress(request,result);
        	break;
        }
        case DELETE_ADDRESS:{
        	deleteRecAddress(request,result);
        	break;
        }
        case MODIFY_ADDRESS:{
        	modifyAddress(request,result);
        	break;
        }
        case ADD_ADDRESS:{
        	addAddress(request,result);
        	break;
        }
        case GET_ADDRESS_BY_ID:{
        	getAddressById(request,result);
        	break;
        }
        default:
            assert false:"no such op"+op.getName();
            break;
        }
        
        return result.asXML();
	}
	
	//张海越-通过收货地址id获取收货地址
	private void getAddressById(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		int recId = UIUtil.getParamInInt(request, XYDWebParam.REC_ID);
		ReceiverInfo receiverInfo = uL.getReceiverInfoById(recId);
		UIUtil.appendReceiverInfoToXML(receiverInfo, result);
		
	}

	//张海越-新增收货地址
	private void addAddress(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		ReceiverInfo receiverInfo = new ReceiverInfo();
		User user = UIUtil.getLogonUser(request.getSession());
		String recProv = UIUtil.getParam(request, XYDWebParam.RECPROV);
		String recCity = UIUtil.getParam(request, XYDWebParam.RECCITY);
		String recArea = UIUtil.getParam(request, XYDWebParam.RECAREA);
		String recAddrDetail = UIUtil.getParam(request, XYDWebParam.RECADDRDETAIL);
		String recName = UIUtil.getParam(request, XYDWebParam.RECNAME);
		String recPhoneNum = UIUtil.getParam(request, XYDWebParam.RECPHONENUM);
		receiverInfo.setRecAddrDetail(recAddrDetail);
		receiverInfo.setRecProv(recProv);
		receiverInfo.setRecCity(recCity);
		receiverInfo.setRecArea(recArea);
		receiverInfo.setRecName(recName);
		receiverInfo.setRecPhonenum(recPhoneNum);
		receiverInfo.setId(user.getId());
		uL.insertNewReceiverInfo(receiverInfo);
		
	}


	//张海越-删除收货地址
	private void deleteRecAddress(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		int id = UIUtil.getParamInInt(request, XYDWebParam.REC_ID);		
		User user = UIUtil.getLogonUser(request.getSession());
		user = uL.getUser((int) user.getId());
		if(user.getDefReceiverInfoId() == id){
			user.setDefReceiverInfoId(0);
			uL.updateUser(user);
		}		
		uL.deleteReceiverInfo(id);
		
	}

	
	//张海越-修改收货地址
	private void modifyAddress(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		int id = UIUtil.getParamInInt(request, XYDWebParam.REC_ID);
		String recProv = UIUtil.getParam(request, XYDWebParam.RECPROV);
		String recCity = UIUtil.getParam(request, XYDWebParam.RECCITY);
		String recArea = UIUtil.getParam(request, XYDWebParam.RECAREA);
		String recAddrDetail = UIUtil.getParam(request, XYDWebParam.RECADDRDETAIL);
		String recName = UIUtil.getParam(request, XYDWebParam.RECNAME);
		String recPhoneNum = UIUtil.getParam(request, XYDWebParam.RECPHONENUM);
		if(id == 0){
			User user = UIUtil.getLogonUser(request.getSession());
			ReceiverInfo receiverInfo = new ReceiverInfo();
			receiverInfo.setUserId(user.getId());
			receiverInfo.setRecAddrDetail(recAddrDetail);
			receiverInfo.setRecProv(recProv);
			receiverInfo.setRecCity(recCity);
			receiverInfo.setRecArea(recArea);
			receiverInfo.setRecName(recName);
			receiverInfo.setRecPhonenum(recPhoneNum);
			uL.insertNewReceiverInfo(receiverInfo);
		}else{						
			ReceiverInfo receiverInfo = uL.getReceiverInfoById(id);
			receiverInfo.setRecAddrDetail(recAddrDetail);
			receiverInfo.setRecProv(recProv);
			receiverInfo.setRecCity(recCity);
			receiverInfo.setRecArea(recArea);
			receiverInfo.setRecName(recName);
			receiverInfo.setRecPhonenum(recPhoneNum);
			uL.updateReceiverInfoById(receiverInfo);
		}
			
	}
		

	
	//张雅南-按关键字搜索用户
	private void getUserListByKeyword(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		
//		String keyword=UIUtil.getParam(request, XYDWebParam.KEYWORD);
//		System.out.println(keyword);
		String keywordString = UIUtil.getParam(request, XYDWebParam.SEARCH_USER_KEYWORD);
		int page = UIUtil.getParamInInt(request,  XYDWebParam.USER_PAGE);
		User []user = uL.getUsersWithKeyWord(keywordString, page);
		for(int i =0;i<user.length;i++)
		{
		UIUtil.appendUserToXML(user[i], result);
		}


	}
	//张雅南-获取所有用户
	private void GetUserWithAdmin(HttpServletRequest request, Element result)throws ServletException, DBProcessException {
		
		User[] users = uL.getUserList();
	
		for(User user : users){
			UIUtil.appendUserToXML(user, result);
	}
	}
	

	//张海越-设置默认地址
	private void makeDefaultAddress(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		int id = UIUtil.getParamInInt(request, XYDWebParam.REC_ID);
		User user = UIUtil.getLogonUser(request.getSession());
		user = uL.getUser((int) user.getId());
		user.setDefReceiverInfoId(id);
		uL.updateUser(user);
		
	}

	//张海越-获取地址列表
	private void getAddressList(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		User user = UIUtil.getLogonUser(request.getSession());
		ReceiverInfo[] receiverInfos = uL.getReceiverInfoListByUserId((int) user.getId());
		user = uL.getUser((int) user.getId());
		UIUtil.appendUserToXML(user, result);
		for(ReceiverInfo receiverInfo : receiverInfos){
			UIUtil.appendReceiverInfoToXML(receiverInfo, result);
		}
		
	}

	//张海越-账户充值
	private void chargeMoney(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		double balance = UIUtil.getParamInFloat(request, XYDWebParam.CHARHEMOPNEY);
		User user = UIUtil.getLogonUser(request.getSession());
		user = uL.getUser((int) user.getId());
		RechargeRecord record = new RechargeRecord();
		record.setUserId(user.getId());
		record.setAmount(balance);
		uL.insertChargeRecord(record);
		balance += user.getBalance();
		user.setBalance(balance);
		uL.updateUser(user);
	}

	//张海越-获取用户充值历史
	private void getRecordList(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		int page=UIUtil.getParamInInt(request, XYDWebParam.PAGE);
		User user = UIUtil.getLogonUser(request.getSession());
		RechargeRecord[] records = uL.getRecordListByUserId((int) user.getId(),page);	
		int total = uL.getRecordCountByUserId((int) user.getId());
		result.addAttribute("total", total+"");
		for(RechargeRecord record : records){
			UIUtil.appendChargeRecordToXML(record, result);
		}
		
	}

	//张海越-获取用户信息
	private void getUserinfo(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		User user = UIUtil.getLogonUser(request.getSession());
		user = uL.getUser((int) user.getId());
		UIUtil.appendUserToXML(user, result);
	}

	

	//张海越-修改密码
	private void modifyPwd(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		String pw = UIUtil.getParam(request, XYDWebParam.PW);
		String pwNew = UIUtil.getParam(request, XYDWebParam.PW_NEW);
		User user = UIUtil.getLogonUser(request.getSession());
		user = uL.getUser((int) user.getId());
		if(!user.getPw().equals(pw)){
			throw new ServletException("原密码填写错误");
		}else{
			user.setPw(pwNew);
			uL.updateUser(user);
			UIUtil.logoutSafely(request.getSession());
		}

	}

	//张海越-修改个人信息
	private void modifyInfo(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		String email = UIUtil.getParam(request, XYDWebParam.EMAIL);
		String phone = UIUtil.getParam(request, XYDWebParam.PHONE);
		User user = UIUtil.getLogonUser(request.getSession());
		user = uL.getUser((int) user.getId());
		user.setEmail(email);
		user.setPhoneNum(phone);
		uL.updateUser(user);
	}


	private void finfPwdStep3(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		String account = UIUtil.getParam(request, XYDWebParam.ACCOUNT);
		String pw = UIUtil.getParam(request, XYDWebParam.PW);
		String num = UIUtil.getParam(request, XYDWebParam.NUM);
		uL.setNewPwd(request,account, pw, num);
	}


	private void finfPwdStep2(HttpServletRequest request, Element result) throws ServletException {
		String num = UIUtil.getParam(request, XYDWebParam.NUM);
		uL.checkIdentifyNum(request, num);
	}


	private void finfPwdStep1(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		String account = UIUtil.getParam(request, XYDWebParam.ACCOUNT);
		String email = UIUtil.getParam(request, XYDWebParam.EMAIL);
		uL.sendEmailAndWriteSession(request, account, email);
	}


	private void register(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		String account = UIUtil.getParam(request, XYDWebParam.ACCOUNT);
		String pw = UIUtil.getParam(request, XYDWebParam.PW);
		String email = UIUtil.getParam(request, XYDWebParam.EMAIL);
		String phone = UIUtil.getParam(request, XYDWebParam.PHONE);
		User user = new User();
		user.setAccount(account);
		user.setPw(pw);
		user.setEmail(email);
		user.setPhoneNum(phone);
		uL.registerUser(user);
	}

	private void sigin(HttpServletRequest request, Element result) throws ServletException, LogicException, DBProcessException {
		// 
		String account = UIUtil.getParam(request, XYDWebParam.ACCOUNT);
		String pw = UIUtil.getParam(request, XYDWebParam.PW);
		User user = uL.signIn(account);
		
		if(user.getPw().equals(pw)){
			HttpSession session = request.getSession(false);
			session.setAttribute(UIUtil.SESSION_ATTRIBUTE_KEY_FOR_ROLE, UIUtil.SESSION_ATTRIBUTE_KEY_FOR_USER);
	        session.setAttribute(UIUtil.SESSION_ATTRIBUTE_KEY_FOR_USER, user);
	        
		}
		else
		{
			throw LogicUtil.createException(XYDErrors.SIGN_IN_FAIL);
		}
	}
	private void logout(HttpServletRequest request, Element result)
	{
        UIUtil.logoutSafely(request.getSession());
    }
	
	

}
