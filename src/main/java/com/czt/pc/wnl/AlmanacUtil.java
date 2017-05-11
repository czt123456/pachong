package com.czt.pc.wnl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * 抓取核心配置文件
 * @author Administrator
 *
 */
public class AlmanacUtil {
//	/**
//	 * 单例工具类
//	 */
//	private AlmanacUtil(){
//		
//	}
	
	/**
	 * 获取万年历信息
	 * @return
	 */
	public static Almanac getAlmanac(){
		String url="http://tools.2345.com/rili.htm";
		String html=pichDate(url);
		Almanac almanac =analyzeHtmlByString(html);
		return almanac;
		
	}

	/**
	 * 使用jsoup解析网页信息
	 * @param html
	 * @return
	 */
	private static Almanac analyzeHtmlByString(String html) {
		// TODO Auto-generated method stub
		
		String solarDate,lunarDate,chineseAra,should,avoid=" ";
		Document document =Jsoup.parse(html);
		
		//公历时间，直接获取系统时间
		solarDate=getSolarDate();
		
		//农历时间,从2345获取
		Element eLunarDate =document.getElementById("info_nong");
		lunarDate=eLunarDate.child(0).html().substring(1,3)+eLunarDate.html().substring(11);
		
		//天干地支纪年法
		Element eChineseAra=document.getElementById("info_chang");
		chineseAra=eChineseAra.text().toString();
		
		//yi
		should=getSuggestion(document,"yi");
		
		//ji
		avoid=getSuggestion(document,"ji");
		
		Almanac almanac =new Almanac(solarDate, lunarDate, chineseAra, should, avoid);
		return almanac;
	}

	private static String getSuggestion(Document document, String id) {
		// TODO Auto-generated method stub
		Element element =document.getElementById(id);
		Elements elements =element.getElementsByTag("a");
		StringBuffer sb =new StringBuffer();
		
		for(Element e:elements){
			sb.append(e.text()+" ");
		}
		return sb.toString();
	}

	private static String getSolarDate() {
        Calendar calendar = Calendar.getInstance();
        Date solarDate = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 EEEE");
        return formatter.format(solarDate);
	}

	/**
	 * 抓取页面的信息
	 * @param url
	 * @return
	 */
	private static String pichDate(String url) {
		// TODO Auto-generated method stub
		/**
		 * HttpClient最基本的执行Http方法
		 */
		CloseableHttpClient httpclient =HttpClients.createDefault();
		try {
			HttpGet httpGet=new HttpGet(url);
			CloseableHttpResponse httpResponse=httpclient.execute(httpGet);
			
			try{
				//获取响应实体
			HttpEntity entity = httpResponse.getEntity();
			if(entity!=null){
				//打印响应实体
				return EntityUtils.toString(entity);
			}
			}finally{
			httpResponse.close();
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
