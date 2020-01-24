package com.seu.xyd.servlet;


import com.seu.xyd.data.User;
import com.seu.xyd.logic.MailService;
import com.tn17.logic.LogicException;
import com.tn17.util.ArrayUtil;
import com.tn17.util.CommonUtil;

/**
 * 只限于发送分配考生的通知邮件。
 * 
 * @author Taurus Ning, Chuanzheng Wang
 *
 */
public class MailThread  extends Thread {
	public String email = "";
	public String msg="";

	@Override
	public void run() {
		try {
//			UserLogic l = UserLogic.getInstance();
//			HRStaff hr = l.getHRStaff(hrId);
//			CustomerOrg org = l.getCustomerOrg(hr.getOrgId());
//			
//			for (int i = 0; i < ids.length; i++) {
//				int testerId = ids[i];
//				Tester tester = l.getTester(testerId);
//				//如果在分配考生时未填写邮箱则跳过发送通知邮件
//				if(tester.getEmail().length()==0)
//					continue;
//				
//				String url = UIUtil.getTesterUrl(tester);
//				String content = generateEmailContent(tester, url, org, hr.getName());
//				sendNoticeMail(tester, content);
//			}
			String content = generateEmailContent(msg);
			sendNoticeMail(email, content);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}
	
	public static String generateEmailContent(String msg) {
//		String rlt = String.format(pattern, tester.getName(), url, url);
//		rlt += String.format(comment, org.getCommentInNoticeMail());
//		rlt += String.format(footter, org.getName(), "测评部");
		String rlt = "您的验证码是："+msg;
		return rlt;
	}
	
	public final static String pattern = "<pre>%s, 您好！\n\n邀请您参加管理潜质测评。\n\n测评时，请保持身心状态俱佳，处于安静无扰的环境。请务必使用如下浏览器，以确保测试顺利：\n1）谷歌浏览器（下载地址：http://www.skycn.com/soft/appid/881.html）\n2）苹果safari\n3）IE10及以上版本\n4）最新版火狐浏览器\n\n请按照顺序进行答题，不允许跳题作答。\n测验的各部分单独计时，请您在规定时间内尽快答题，如超时，系统会自动进入下一部分。如果您中途有事离开，请点击页面右上方【暂时离开】，防止测验超时。 \n\n请您点击下面的链接，按提示完成注册，参与测评。祝您测评愉快！\n\n<a href='%s'>%s</a>\n\n测评中遇到任何操作问题，欢迎垂询百中咨询，联系电话：010-62247464转8001。</pre>";
	public final static String comment = "<pre>%s</pre>";
	public final static String footter = "<pre>%s\n%s</pre>";

//	/**
//	 * TODO 只用到tester.mail, 这个包装多余
//	 * @param tester
//	 * @param text
//	 * @throws LogicException
//	 */
//	public void sendNoticeMail(Tester tester, String text) throws LogicException {
//		String mailTitle = "人才测评通知-百中咨询";
//		String hostUser = CommonUtil.getPropertyValue("host_user", "com.bestgains.quiz.config.config");
//		if(!hostUser.equals("server"))
//			mailTitle = "Notice on ebugging Bestgains by " + hostUser;
//		MailService.sendMail(mailTitle, text, tester.getEmail());
//		
//		//TODO 发邮件不涉及Tester状态的改变？
//	}
	public void sendNoticeMail(String email, String text) throws LogicException {
		String mailTitle = "阳光洗衣-服务系统";
		
		MailService.sendMail(mailTitle, text, email);
		
		//TODO 发邮件不涉及Tester状态的改变？
	}
}
