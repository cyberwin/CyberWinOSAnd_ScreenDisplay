package CyberWinPHP.CyberWin_MicroAPP;

import android.net.Uri;
import android.webkit.WebResourceResponse;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import CyberWinPHP.Cyber_CPU.Cyber_Public_Var;

public class CyberWin_MicroAPP_Android {
    public  static InputStream String转换InputStream(String s){
        InputStream reader异常 = null;
        try {
            reader异常 = new ByteArrayInputStream(s.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
           // e.printStackTrace();
        }
        return  reader异常;
    }

    //未来之窗渲染
    public  static WebResourceResponse cyberwin_microapp_提取资源(String 网址){
        String url_md5= Cyber_Public_Var.cyber_md5(网址);
        String url_type= Cyber_Public_Var. cyber_getFileExt(网址);

        Uri 未来之窗url =Uri.parse((String) 网址);
        String 未来之窗协议 = 未来之窗url.getScheme();
        String 未来之窗主机 = 未来之窗url.getHost();


        String App_local_path = Cyber_Public_Var.CyberWin_MicroApp_local_path;
        String 应用=未来之窗主机;
        //String App_loaclrunpath=App_local_path+""+App_name+"/cybewinapp.html";



        // string 未来之窗微app路径 = app_root + "/" + 应用 + "_microapp.cyberphp";
        String 未来之窗微app根目录 = App_local_path + "/";
        String 未来之窗微app路径 = App_local_path + "/" + 应用 + "_microapp.cyberwinmicand";

        File 未来之窗微app根目录dir = new File(未来之窗微app根目录);
        if (未来之窗微app根目录dir.isDirectory() && !未来之窗微app根目录dir.exists()) {
            未来之窗微app根目录dir.mkdir();
        }


        String 前缀过滤  =未来之窗协议+"://"+未来之窗协议+"";

        String 资源路径= 网址.replace(前缀过滤,"");

        String 资源路径_安卓 = 未来之窗url.getPath();



        if((资源路径_安卓.substring(0,1).equals("/")==true)&& (资源路径_安卓.length() > 1)){
            ///cus_res/cyberwin_detch.html
            ///
            资源路径_安卓 = 资源路径_安卓.substring(1);
        }
        if (资源路径_安卓.equals("/") == true)
        {
            资源路径_安卓 = "cybewinapp.html";
        }


        if (网址.indexOf("cyberwin_detch") > -1 )
        {
            String 返回 = "<br><hr>文件：" +资源路径+"";// fileName;
            返回 = 返回+  "<br><hr>资源路径_安卓：" +资源路径_安卓+"";// fileName;
            返回 = 返回+ "<br><hr>Scheme：" + 未来之窗协议;
            返回 = 返回 + "<br><hr>Port：" + 未来之窗url.getPort();
            返回 = 返回 + "<br><hr>Query：" + 未来之窗url.getQuery();
            返回 = 返回 + "<br><hr>Host：" + 未来之窗url.getHost();
            返回 = 返回 + "<br><hr>网址：" + 网址;
            返回 = 返回 + "<br><hr>AbsoluteUri：" + 未来之窗url.getPath();//uri.AbsoluteUri;
           // 返回 = 返回 + "<br><hr>AbsoluteUri：" + 未来之窗url.getQueryParameterNames();//uri.AbsoluteUri;
            //   返回 = 返回 + "Host：" + uri.;
            String mimetype = "text/html";

          //  return ResourceHandler.FromString("未来之窗OS是......额<br><hr>"+ 返回, ".html");
            InputStream reader =CyberWin_MicroAPP_Android.String转换InputStream(返回);
            WebResourceResponse response2 = new WebResourceResponse(mimetype, "UTF-8", reader);
            return response2;
        }


        //  String 未来之窗微app路径 ="file://external_files/"+ App_local_path + "/" + 应用 + "_microapp.cyberwinmicand";

        //  Cyber_Public_Var.Application_StartupPath_Home="file://external_files/"+App_loaclrunpath;




        ZipFile zip = null;
        try {
            final File zipFile = new File(未来之窗微app路径);
            zip = new ZipFile(zipFile);
                        /*
                         if (zipFile.GetEntry(资源路径) == null)
            {
                throw new Exception("CyberWin Error  build 20230828 res not fund microapp, path");
            }

                         */
            if( zip.getEntry(资源路径_安卓)==null){
                String mimetype = "text/html";

                //  WebResourceResponse response2 = new WebResourceResponse(mimetype, "UTF-8", reader);
                String 未来之窗消息 ="CyberWin Error  build 20230828 res not fund microapp, path";
                InputStream reader =CyberWin_MicroAPP_Android.String转换InputStream(未来之窗消息);
                WebResourceResponse response2 = new WebResourceResponse(mimetype, "UTF-8", reader);
                return response2;
            }

            ZipEntry entry1 = zip.getEntry(资源路径_安卓);
            // ZipEntry entry2 = zipFile.GetEntry(name3);
            // Stream inputStream1 = zipFile.GetInputStream(entry1);
            InputStream 压缩app资源InputStream = zip.getInputStream(entry1);

            String 未来之窗app资源mimetype_force="text/html";

            if (url_type.equals("png")) {
                未来之窗app资源mimetype_force = "image/png";
            }
            if (url_type.equals("htm")) {
                未来之窗app资源mimetype_force = "text/html";
            }
            if (url_type.equals("html")) {
                未来之窗app资源mimetype_force = "text/html";
            }
            if (url_type.equals("js")) {
                未来之窗app资源mimetype_force = "text/javascript";
            }

            if (url_type.equals("css")) {
                未来之窗app资源mimetype_force = "text/css";
            }
            if (url_type.equals("bmp")) {
                未来之窗app资源mimetype_force = "image/bmp";
            }
            if (url_type.equals("bmp")) {
                未来之窗app资源mimetype_force = "image/bmp";
            }
            if (url_type.equals("jpg")) {
                未来之窗app资源mimetype_force = "image/jpeg";
            }

            if (url_type.equals("jpeg")) {
                未来之窗app资源mimetype_force = "image/jpeg";
            }

            if (url_type.equals("gif")) {
                未来之窗app资源mimetype_force = "image/gif";
            }

            if (url_type.equals("svg")) {
                未来之窗app资源mimetype_force = "image/svg+xml";
            }



            if (url_type.equals("txt")) {
                未来之窗app资源mimetype_force = "text/plain";
            }

            if (url_type.equals("mp3")) {
                未来之窗app资源mimetype_force = "audio/mpeg";
            }

            if (url_type.equals("mp4")) {
                未来之窗app资源mimetype_force = "video/mp4";
            }


            WebResourceResponse response2 = new WebResourceResponse(未来之窗app资源mimetype_force, "UTF-8", 压缩app资源InputStream);
            return response2;


        } catch (IOException e) {
            // e.printStackTrace();
            String mimetype = "text/html";
            String 未来之窗消息异常 ="CyberWin Error  build 20230828 res not fund microapp, path IOException"+e.getMessage();
            InputStream reader异常 = CyberWin_MicroAPP_Android.String转换InputStream(未来之窗消息异常);
            WebResourceResponse response2 = new WebResourceResponse(mimetype, "UTF-8", reader异常);
            return response2;
        }


    }


}
