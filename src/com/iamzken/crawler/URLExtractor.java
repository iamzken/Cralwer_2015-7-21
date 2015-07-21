package com.iamzken.crawler;  
 
public class URLExtractor  
{  
    /**  
     * ���ҳ��Դ�����еĳ�����  
     */ 
    public static void getURLByContent(String content)  
    {  
        System.out.println("��ʼ===============================================================================");  
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
 
        System.out.println(UrlQueue.getSize() + "--ץȡ����������");  
        System.out.println(VisitedUrlQueue.getSize() + "--�Ѵ����ҳ����");  
        System.out.println("����===============================================================================");  
    }  
 
} 