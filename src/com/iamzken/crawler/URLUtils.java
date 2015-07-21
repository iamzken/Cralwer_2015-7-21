package com.iamzken.crawler;  
 
import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStreamWriter;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
 
public class URLUtils  
{  
 
    /**  
     * 匹配超链接的正则表达式  
     */ 
    private static String pat = Sites.siteToFetch+".*";  
    private static Pattern pattern = Pattern.compile(pat);  
 
    private static BufferedWriter writer = null;  
 
    public static String[] splitUrl(String url)  
    {  
        return url.split("/");  
    }  
 
    /**  
     * 判断是否需要创建文件  
     * @param url  
     */ 
    public static boolean needCreateFile(String url)  
    {  
        Matcher matcher = pattern.matcher(url);  
 
        return matcher.matches();  
    }  
 
    /**  
     * 创建对应文件  
     * @param content  
     * @param url  
     */ 
    public static void createFile(String content, String url)  
    {  
        String[] elems = splitUrl(url);  
        StringBuffer path = new StringBuffer();  
 
        File file = null;  
        for (int i = 1; i < elems.length; i++)  
        {  
            if (i != elems.length - 1)  
            {  
 
                path.append(elems[i]);  
                path.append(File.separator);  
 
            }  
 
            if (i == elems.length - 1)  
            {  
                Pattern pattern = Pattern.compile("\\w+\\.[a-zA-Z]+");  
                Matcher matcher = pattern.matcher(elems[i]);  
                if ((matcher.matches()))  
                {  
                	file = new File("D:/crawler" + File.separator + path.toString());  
                    if (!file.exists())  
                    {  
                        file.mkdirs();  
                    }  
                    file = new File("D:/crawler" + File.separator + path.toString()  
                            + File.separator + elems[i]);  
                    try 
                    {  
                        file.createNewFile();  
                        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));  
                        writer.write(content);  
                        writer.flush();  
                        writer.close();  
                        System.out.println("创建文件成功");  
                    } catch (IOException e)  
                    {  
                        e.printStackTrace();  
                    }  
 
                }  
            }  
 
        }  
    }  
 
    /**  
     * 获取页面的超链接并将其转换为正式的a标签  
     * @param url  
     */ 
    public static String getFullURLPath(String url)  
    {  
        //内部链接最终转化为完整的链接格式 
        String resultURL = null;  
        //判断是否为外部链接 
        if (url.startsWith("http://") || url.startsWith("https://"))  
        {  
            resultURL = url;  
        } else 
        {  
            //如果是内部链接,则补充完整的链接地址,其他的格式忽略不处理,如：a href="#" 
            if (url.startsWith("/"))  
            {  
            	resultURL = Sites.siteToFetch + url;  
            }else if(url.startsWith("./")){
            	resultURL = Sites.siteToFetch + url.substring(1); 
            } 
        }  
 
        return resultURL;  
    }  
 
} 