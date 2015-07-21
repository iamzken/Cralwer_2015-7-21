package com.iamzken.crawler;  
 
public class UrlHandler implements Runnable  
{  
    /**  
     * 下载对应页面,并分析出页面对应的URL,放在未访问队列中。  
     * @param url  
     */ 
    public void handleURL(String url)  
    {  
            URLExtractor.getURLByContent(URLContentDownloader.getContentByUrl(url));  
    }  
          
    public void run()  
    {  
        while(!UrlQueue.isEmpty())  
        {  
        	handleURL(UrlQueue.getURL());  
        }  
    }  
} 