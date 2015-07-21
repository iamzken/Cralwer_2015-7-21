package com.iamzken.crawler;  
 
import java.util.LinkedList;  
 
public class UrlQueue  
{  
    //≥¨¡¥Ω”∂”¡– 
    public static LinkedList<String> urlQueue = new LinkedList<String>();  
      
    public synchronized static void addURL(String url)  
    {  
        urlQueue.add(url);  
    }  
      
    public synchronized static String getURL()  
    {  
        return urlQueue.removeFirst();  
    }  
      
    public synchronized static boolean isEmpty()  
    {  
        return urlQueue.isEmpty();  
    }  
      
    public  static int getSize()  
    {  
        return urlQueue.size();  
    }  
      
    public  static boolean containsURL(String url)  
    {  
        return urlQueue.contains(url);  
    }  
 
} 