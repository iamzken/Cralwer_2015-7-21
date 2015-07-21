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
     * ƥ�䳬���ӵ�������ʽ  
     */ 
    private static String pat = Sites.siteToFetch+".*";  
    private static Pattern pattern = Pattern.compile(pat);  
 
    private static BufferedWriter writer = null;  
 
    public static String[] splitUrl(String url)  
    {  
        return url.split("/");  
    }  
 
    /**  
     * �ж��Ƿ���Ҫ�����ļ�  
     * @param url  
     */ 
    public static boolean needCreateFile(String url)  
    {  
        Matcher matcher = pattern.matcher(url);  
 
        return matcher.matches();  
    }  
 
    /**  
     * ������Ӧ�ļ�  
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
                        System.out.println("�����ļ��ɹ�");  
                    } catch (IOException e)  
                    {  
                        e.printStackTrace();  
                    }  
 
                }  
            }  
 
        }  
    }  
 
    /**  
     * ��ȡҳ��ĳ����Ӳ�����ת��Ϊ��ʽ��a��ǩ  
     * @param url  
     */ 
    public static String getFullURLPath(String url)  
    {  
        //�ڲ���������ת��Ϊ���������Ӹ�ʽ 
        String resultURL = null;  
        //�ж��Ƿ�Ϊ�ⲿ���� 
        if (url.startsWith("http://") || url.startsWith("https://"))  
        {  
            resultURL = url;  
        } else 
        {  
            //������ڲ�����,�򲹳����������ӵ�ַ,�����ĸ�ʽ���Բ�����,�磺a href="#" 
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