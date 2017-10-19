package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	static long millisecondOfOneDay = 1000*60*60*24;
	
	public static java.sql.Date util2sql(java.util.Date d){
		return new java.sql.Date(d.getTime());
	}
	  /**
     * ��ȡ���죬���Ұ�ʱ���֣���ͺ��붼��0. ��Ϊͨ�����ڿؼ���ȡ�������ڣ�����û��ʱ����ͺ���ġ�
     * @return
     */
	public static Date today(){
		//���õ���ģʽ��ȡ��������Calendar.getInstance();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	/**
     * ��ȡ�³���ʹ��Calendar��ȡ���µ�һ�졣 ��ͳ������һ����Ϣ��ʱ�򣬲鿴���µ��������ݣ���ʵ���Ǵ����ݿ���ȥ��
     * �ӱ��µ�һ�쵽���һ������ݲ�������ٽ��м�ͳ�ƣ�������Ҫһ����ȡ���µ�һ��ķ�����
     * @return
     */
	public static Date monthBegin(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		//��������µĵ�һ��
		c.set(Calendar.DATE, 1);
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		return c.getTime();//����Date�ͣ�calendar�ࣩ
	}
	 /**
     * ��ȡ��ĩ
     * @return
     */
	public static Date monthEnd(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONTH, 1);//�¸����³�
		c.add(Calendar.DATE, -1);//�¸����³�-1������������һ��
		
		return c.getTime();
	}
	/**
     * ��ȡ����һ���ж�����
     * @return
     */
	public static int thisMonthTotalDay(){
		long lastDayMilliSeconds = monthEnd().getTime();
		long firstDayMilliSeconds = monthBegin().getTime();
		
		return (int)((lastDayMilliSeconds-firstDayMilliSeconds)/millisecondOfOneDay)+1;
	}
	 /**
     *��ȡ���»�ʣ������ 
     * @return
     */
	public static int thisMonthLeftDay(){
		long lastDayMilliSeconds = monthEnd().getTime();
		long toDayMilliSeconds = today().getTime();
		return (int)((lastDayMilliSeconds-toDayMilliSeconds)/millisecondOfOneDay)+1;
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtil.today());
		System.out.println(DateUtil.monthBegin());
		System.out.println(DateUtil.monthEnd());
		System.out.println(thisMonthLeftDay());
		System.out.println(thisMonthTotalDay());
	}
	
	
	
	
}
