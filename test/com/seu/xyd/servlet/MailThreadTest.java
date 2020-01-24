package com.seu.xyd.servlet;

import java.util.Calendar;

import org.junit.Test;

import com.seu.xyd.data.User;
import com.seu.xyd.logic.UserLogic;
import com.tn17.util.TimeUtil;

public class MailThreadTest {

	
	
	@Test
    public void testSendEmail() throws Exception {
		
		System.out.println("开始发送邮件。。。");
		
		
			MailThread thread = new MailThread();
			thread.email = "495472338@qq.com";
			thread.msg = "cdscsd ";
			thread.run();
	
		
		System.out.println("邮件发送成功！");
    }
}
