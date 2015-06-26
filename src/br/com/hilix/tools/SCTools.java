package br.com.hilix.tools;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class SCTools
{
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random rnd = new Random();
    private static final String RESOURCE_CONFIG = "br/com/supportcomm/block/resources/config";

    public static boolean isNullOrEmpty(List<?> lista)
    {
        if (lista == null || lista.isEmpty())
        {
            return true;
        }
        return false;
    }

    public static boolean isNullOrBlank(List<?> list)
    {
        if (list == null || list.isEmpty())
        {
            return true;
        }
        return false;
    }

    public static boolean isNullOrBlank(Object obj)
    {
        if (obj == null || obj.toString().equals(""))
        {
            return true;
        }
        return false;
    }

    public static String getDataExtenso(Date data)
    {
        SimpleDateFormat df = new SimpleDateFormat("EEEEEE ',' dd ' de 'MMMM ' de ' yyyy");
        return df.format(data);
    }

    public static String randomString(int len)
    {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static Timestamp getActualTimestamp()
    {

        return null;
    }

    public static String getConfigMessage(String content)
    {
        // return ResourceBundle.getBundle(RESOURCE_CONFIG, new Locale("pt", "BR")).getString(content);
        return ResourceBundle.getBundle(RESOURCE_CONFIG, new Locale("en")).getString(content);
    }

    public static String getDateTimeIsoFormatted()
    {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(date);
    }
    
    public static String getDateIsoFormatted()
    {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(date);
    }
}
