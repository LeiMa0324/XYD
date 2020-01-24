package com.seu.xyd.logic;

import javax.servlet.ServletException;

import org.junit.Test;

import com.seu.xyd.data.Shop;
import com.seu.xyd.data.User;
import com.tn17.mysql.DBProcessException;

public class ShopLogicTest {
	@Test
	public void initShopData() throws DBProcessException, ServletException{
		final ShopLogic sL = ShopLogic.getInstance();
		Shop shop = new Shop();
		shop.setName("文星广场洗衣店");
		shop.setAccount("wenxing");
		shop.setPw("12345");
		shop.setDesc("这里是描述数据。。。。。");
		shop.setImg("test.jpg");
		shop.setAddrProvince("江苏省");
		shop.setAddrCity("苏州市");
		shop.setAddrArea("吴中区");
		shop.setAddrDesc("独墅湖高教区文星广场");
		shop.setCoordinateX(120.748293);
		shop.setCoordinateY(31.282029);
		shop.setPhoneNum("1324342w32");
		shop.setState(0);
		
		sL.insertShop(shop);
		
		shop.setName("白鹭园洗衣店");
		shop.setAccount("bailuyuan");
		shop.setPw("12345");
		shop.setDesc("这里是描述数据。。。。。");
		shop.setImg("test.jpg");
		shop.setAddrProvince("江苏省");
		shop.setAddrCity("苏州市");
		shop.setAddrArea("吴中区");
		shop.setAddrDesc("翠薇街 ");
		shop.setCoordinateX(120.729752);
		shop.setCoordinateY(31.278449);
		shop.setPhoneNum("1324342w32");
		shop.setState(0);
		
		sL.insertShop(shop);
		
		shop.setName("苏大洗衣店");
		shop.setAccount("suda");
		shop.setPw("12345");
		shop.setDesc("这里是描述数据。。。。。");
		shop.setImg("test.jpg");
		shop.setAddrProvince("江苏省");
		shop.setAddrCity("苏州市");
		shop.setAddrArea("吴中区");
		shop.setAddrDesc("苏大 ");
		shop.setCoordinateX(120.740532);
		shop.setCoordinateY(31.279683);
		shop.setPhoneNum("1324342w32");
		shop.setState(0);
		
		sL.insertShop(shop);
		shop.setName("圆融洗衣店");
		shop.setAccount("yuanrong");
		shop.setPw("12345");
		shop.setDesc("这里是描述数据。。。。。");
		shop.setImg("test.jpg");
		shop.setAddrProvince("江苏省");
		shop.setAddrCity("苏州市");
		shop.setAddrArea("吴中区");
		shop.setAddrDesc("月光码头 ");
		shop.setCoordinateX(120.729896);
		shop.setCoordinateY(31.324608);
		shop.setPhoneNum("1324342w32");
		shop.setState(0);
		
		sL.insertShop(shop);
		shop.setName("大裤衩洗衣店");
		shop.setAccount("dakucha");
		shop.setPw("12345");
		shop.setDesc("这里是描述数据。。。。。");
		shop.setImg("test.jpg");
		shop.setAddrProvince("江苏省");
		shop.setAddrCity("苏州市");
		shop.setAddrArea("吴中区");
		shop.setAddrDesc("大裤衩 ");
		shop.setCoordinateX(120.683903);
		shop.setCoordinateY(31.324731);
		shop.setPhoneNum("1324342w32");
		shop.setState(0);
		
		sL.insertShop(shop);
		shop.setName("火车站洗衣店");
		shop.setAccount("huochezhan");
		shop.setPw("12345");
		shop.setDesc("这里是描述数据。。。。。");
		shop.setImg("test.jpg");
		shop.setAddrProvince("江苏省");
		shop.setAddrCity("苏州市");
		shop.setAddrArea("吴中区");
		shop.setAddrDesc("火车站");
		shop.setCoordinateX(120.6175);
		shop.setCoordinateY(31.324731);
		shop.setPhoneNum("1324342w32");
		shop.setState(0);
		
		sL.insertShop(shop);
		
		shop.setName("观前街洗衣店");
		shop.setAccount("guanqianjie");
		shop.setPw("12345");
		shop.setDesc("这里是描述数据。。。。。");
		shop.setImg("test.jpg");
		shop.setAddrProvince("江苏省");
		shop.setAddrCity("苏州市");
		shop.setAddrArea("吴中区");
		shop.setAddrDesc("观前街");
		shop.setCoordinateX(120.631873);
		shop.setCoordinateY(31.316834);
		shop.setPhoneNum("1324342w32");
		shop.setState(0);
		
		sL.insertShop(shop);
		shop.setName("狮子山洗衣店");
		shop.setAccount("shizishan");
		shop.setPw("12345");
		shop.setDesc("这里是描述数据。。。。。");
		shop.setImg("test.jpg");
		shop.setAddrProvince("江苏省");
		shop.setAddrCity("苏州市");
		shop.setAddrArea("吴中区");
		shop.setAddrDesc("狮子山");
		shop.setCoordinateX(120.552391);
		shop.setCoordinateY(31.295977);
		shop.setPhoneNum("1324342w32");
		shop.setState(0);
		
		sL.insertShop(shop);
		shop.setName("木渎洗衣店");
		shop.setAccount("mudu");
		shop.setPw("12345");
		shop.setDesc("这里是描述数据。。。。。");
		shop.setImg("test.jpg");
		shop.setAddrProvince("江苏省");
		shop.setAddrCity("苏州市");
		shop.setAddrArea("吴中区");
		shop.setAddrDesc("木渎");
		shop.setCoordinateX(120.527669);
		shop.setCoordinateY(31.284004);
		shop.setPhoneNum("1324342w32");
		shop.setState(0);
		
		sL.insertShop(shop);
		shop.setName("独墅湖公园洗衣店");
		shop.setAccount("dushuhu");
		shop.setPw("12345");
		shop.setDesc("这里是描述数据。。。。。");
		shop.setImg("test.jpg");
		shop.setAddrProvince("江苏省");
		shop.setAddrCity("苏州市");
		shop.setAddrArea("吴中区");
		shop.setAddrDesc("独墅湖公园");
		shop.setCoordinateX(120.715667);
		shop.setCoordinateY(31.254003);
		shop.setPhoneNum("1324342w32");
		shop.setState(0);
		
		sL.insertShop(shop);
		
		shop.setName("留园洗衣店");
		shop.setAccount("留园");
		shop.setPw("12345");
		shop.setDesc("这里是描述数据。。。。。");
		shop.setImg("test.jpg");
		shop.setAddrProvince("江苏省");
		shop.setAddrCity("苏州市");
		shop.setAddrArea("吴中区");
		shop.setAddrDesc("留园公园");
		shop.setCoordinateX(120.599246);
		shop.setCoordinateY(31.32177);
		shop.setPhoneNum("1324342w32");
		shop.setState(0);
		
		sL.insertShop(shop);
	}
	
}
