package com.iamzken.crawler;  
 
public class UrlHandler implements Runnable  
{  
    /**  
     * ���ض�Ӧҳ��,��������ҳ���Ӧ��URL,����δ���ʶ����С�  
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