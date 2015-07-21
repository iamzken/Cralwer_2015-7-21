package com.iamzken.crawler;  
 
import java.util.HashSet;  
 
/**  
 * 已访问url队列  
 * @author iamzken 
 *  
 */ 
public class VisitedUrlQueue  
{  
    public static HashSet<String> visitedUrlQueue = new HashSet<String>();  
 
    public synchronized static void addURL(String url)  
    {  
        visitedUrlQueue.add(url);  
    }  
 
    public synchronized static boolean containsURL(String url)  
    {  
        return visitedUrlQueue.contains(url);  
    }  
 
    public synchronized static int getSize()  
    {  
        return visitedUrlQueue.size();  
    }  
} 
