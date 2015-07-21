package com.iamzken.crawler;

import java.sql.SQLException;

public class Test  
{  
  public static void main(String[] args) throws SQLException  
  {  
      String url = Sites.siteToFetch;  
      UrlQueue.addURL(url);  
      
      UrlHandler[] urlHandlers = new UrlHandler[UrlQueue.getSize()];  
        
      for(int i = 0 ; i < UrlQueue.getSize() ; i++)  
      {  
    	  urlHandlers[i] = new UrlHandler();  
          new Thread(urlHandlers[i]).start();  
      }  
 
  }  
} 