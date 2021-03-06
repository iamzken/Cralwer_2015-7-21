 package com.iamzken.crawler;  
   
 import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
   
 public class URLContentDownloader  
 {  
   
     /**  
      * 根据URL抓取网页内容  
      * @param url  
      */ 
     @SuppressWarnings({ "resource", "deprecation" })
	public static String getContentByUrl(String url)  
     {  
         //实例化一个HttpClient客户端 
		 HttpClient client = new DefaultHttpClient();  
         HttpGet getHttp = new HttpGet(url);  
   
         String content = null;  
   
         HttpResponse response;  
         try 
         {  
             //获得信息载体 
             response = client.execute(getHttp);  
             HttpEntity entity = response.getEntity();  
   
             VisitedUrlQueue.addURL(url);  
   
             if (entity != null)  
             {  
                 //转化为文本信息 
                 content = EntityUtils.toString(entity);  
   
                 //判断是否符合下载网页源代码到本地的条件 
                 if (URLUtils.needCreateFile(url))  
                 {  
                     URLUtils.createFile(content, url);  
                 }  
             }  
   
         } catch (ClientProtocolException e)  
         {  
             e.printStackTrace();  
         } catch (IOException e)  
         {  
             e.printStackTrace();  
         } finally 
         {  
             client.getConnectionManager().shutdown();  
         }  
           
         return content;  
     }  
   
 } 