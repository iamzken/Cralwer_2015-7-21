package com.iamzken.crawler;  
 
public class URLExtractor  
{  
    /**  
     * 获得页面源代码中的超链接  
     */ 
    public static void getURLByContent(String content)  
    {  
        System.out.println("开始===============================================================================");  
        String[] contents = content.split("href=\"");  
        for (int i = 1; i < contents.length; i++)  
        {  
            int end = contents[i].indexOf("\"");  
 
            String url = URLUtils.getFullURLPath(contents[i].substring(0,end));
 
            if (url != null)  
            {  
 
                if (!UrlQueue.containsURL(url) && !VisitedUrlQueue.containsURL(url))  
                {  
                    UrlQueue.addURL(url);  
                }  
            }  
            System.out.println(url);
        }  
 
        System.out.println(UrlQueue.getSize() + "--抓取到的连接数");  
        System.out.println(VisitedUrlQueue.getSize() + "--已处理的页面数");  
        System.out.println("结束===============================================================================");  
    }  
 
} 