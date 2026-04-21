package CyberWinPHP.Cyber_Server;


//import fi.iki.elonen.NanoHTTPD;

import static org.nanohttpd.protocols.http.response.Response.newChunkedResponse;
import static org.nanohttpd.protocols.http.response.Response.newFixedLengthResponse;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.webkit.MimeTypeMap;

import com.ynwlzc.framework.cyberwinosand_ScreenDisplay.FullscreenActivity;

import org.nanohttpd.protocols.http.IHTTPSession;
import org.nanohttpd.protocols.http.NanoHTTPD;
import org.nanohttpd.protocols.http.request.Method;
import org.nanohttpd.protocols.http.response.IStatus;
import org.nanohttpd.protocols.http.response.Response;
import org.nanohttpd.protocols.http.response.Status;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import CyberWinPHP.Cyber_CPU.Cyber_Public_Function;
import CyberWinPHP.Cyber_CPU.Cyber_Public_Var;
import CyberWinPHP.Cyber_Plus.Cyber_JsPrinterStandard;
import CyberWinPHP.Cyber_Plus.LogToFile;
import CyberWinPHP.SmartScreen.CyberWin_Smart_CommonFunction;

public class Cyber_Server_Web extends NanoHTTPD
{

  // extends  NanoHTTPD {


     //   private List<SharedFile> fileList;//用于分享的文件列表

    public Cyber_Server_Web(int port) {
            super(port);
            try {
                String password = "ssltest";
                LogToFile.d_windows("网络服务","Cyber_Server_Web",  "端口="+ port);
               // this.start();
               // Cyber_Server_Web.st
             //  ServerRunner.run(Cyber_Server_Web.class);
            } catch (Exception ex) {
                LogToFile.d_windows("网络服务","Cyber_Server_Web", "启动失败Couldn't start server" + ex.getMessage());

            }

        }


        @Override
        public Response serve(IHTTPSession session) {
            String  url= session.getUri();

            Map<String, String> cwpd_headers=session.getHeaders();
            Method method = session.getMethod();

            Map<String, String> parms = session.getParms();

            InputStream is= session.getInputStream();
            String is_str= Cyber_Public_Function.Inputstr2Str_Reader(is,"utf-8");

            String s_h= Cyber_Public_Function.getMapToString(cwpd_headers);

            String s_p= Cyber_Public_Function.getMapToString(parms);

            LogToFile.d_windows("网络服务","Cyber_Server_Web",  "网络="+ url);


            ///o2o/store.php?g=Merchant&c=Store&a=ajax_shop_goods
            String CONST_URL_SHOP_A="/CyberWinAPP/Pos/Merchant/Store/ajax_shop_goods";
            String CONST_URL_SHOP_At="/CyberWinAPP/Pos/Merchant/Store/KV";
            String CONST_URL_SHOP_getconfig="/CyberWinAPP/Pos/Merchant/Pay/getMertchantInfo";
            if(url.equals(CONST_URL_SHOP_A)){

                StringBuilder builder_o2o = new StringBuilder();
                builder_o2o.append("\n" +
                        "{\"err_code\":0,\"data\":[{\"sort_name\":\"\\u4e3b\\u98df\",\"goods_list\":[{\"goods_id\":\"12\",\"sort_id\":\"8\",\"store_id\":\"72\",\"name\":\"\\u9762\\u6761\",\"unit\":\"\\u4efd\",\"label\":\"\",\"old_price\":\"0.00\",\"price\":\"8.00\",\"vip_price\":\"0.00\",\"image\":\"000\\/000\\/077,58b1b684d060b.jpg\",\"des\":\"\",\"last_time\":\"1488041604\",\"sort\":\"0\",\"sell_count\":\"91\",\"status\":\"1\",\"sell_mouth\":\"0\",\"number\":\"12\",\"stock_num\":\"1028.00\",\"goods_sn\":\"12\",\"buying_price\":\"0.00\",\"goods_barcodes\":null,\"is_hot\":\"0\",\"third_no\":null,\"third_sort_no\":null},{\"goods_id\":\"13\",\"sort_id\":\"8\",\"store_id\":\"72\",\"name\":\"\\u997a\\u5b50\",\"unit\":\"\\u4efd\",\"label\":\"\",\"old_price\":\"0.00\",\"price\":\"10.00\",\"vip_price\":\"0.00\",\"image\":\"000\\/000\\/077,58b1ba98adcea.png\",\"des\":\"\",\"last_time\":\"1488042646\",\"sort\":\"0\",\"sell_count\":\"101\",\"status\":\"1\",\"sell_mouth\":\"0\",\"number\":\"13\",\"stock_num\":\"3400.00\",\"goods_sn\":\"13\",\"buying_price\":\"0.00\",\"goods_barcodes\":null,\"is_hot\":\"0\",\"third_no\":null,\"third_sort_no\":null},{\"goods_id\":\"14\",\"sort_id\":\"8\",\"store_id\":\"72\",\"name\":\"\\u5357\\u74dc\\u997c\",\"unit\":\"\\u4efd\",\"label\":\"\",\"old_price\":\"0.00\",\"price\":\"15.00\",\"vip_price\":\"0.00\",\"image\":\"000\\/000\\/077,58b1badf08954.jpg\",\"des\":\"\",\"last_time\":\"1488042717\",\"sort\":\"0\",\"sell_count\":\"44\",\"status\":\"1\",\"sell_mouth\":\"0\",\"number\":\"14\",\"stock_num\":\"488.00\",\"goods_sn\":\"14\",\"buying_price\":\"0.00\",\"goods_barcodes\":null,\"is_hot\":\"0\",\"third_no\":null,\"third_sort_no\":null},{\"goods_id\":\"15\",\"sort_id\":\"8\",\"store_id\":\"72\",\"name\":\"\\u9975\\u4e1d\",\"unit\":\"\\u4efd\",\"label\":\"\",\"old_price\":\"0.00\",\"price\":\"7.00\",\"vip_price\":\"0.00\",\"image\":\"000\\/000\\/077,58b1bc822625a.jpg\",\"des\":\"\",\"last_time\":\"1488043137\",\"sort\":\"0\",\"sell_count\":\"19\",\"status\":\"1\",\"sell_mouth\":\"0\",\"number\":\"15\",\"stock_num\":\"498.00\",\"goods_sn\":\"15\",\"buying_price\":\"0.00\",\"goods_barcodes\":null,\"is_hot\":\"0\",\"third_no\":null,\"third_sort_no\":null},{\"goods_id\":\"19\",\"sort_id\":\"8\",\"store_id\":\"72\",\"name\":\"\\u8fa3\\u6761\",\"unit\":\"\\u6761\",\"label\":\"\",\"old_price\":\"0.00\",\"price\":\"0.01\",\"vip_price\":\"0.00\",\"image\":\"\",\"des\":\"\",\"last_time\":\"1486803697\",\"sort\":\"0\",\"sell_count\":\"3\",\"status\":\"1\",\"sell_mouth\":\"0\",\"number\":\"19\",\"stock_num\":\"99.00\",\"goods_sn\":\"19\",\"buying_price\":\"0.00\",\"goods_barcodes\":null,\"is_hot\":\"0\",\"third_no\":null,\"third_sort_no\":null}]},{\"sort_name\":\"\\u7092\\u83dc\",\"goods_list\":[{\"goods_id\":\"18\",\"sort_id\":\"9\",\"store_id\":\"72\",\"name\":\"\\u5c0f\\u7092\",\"unit\":\"\\u4efd\",\"label\":\"\",\"old_price\":\"0.00\",\"price\":\"22.00\",\"vip_price\":\"0.00\",\"image\":\"\",\"des\":\"\",\"last_time\":\"1485968438\",\"sort\":\"0\",\"sell_count\":\"2\",\"status\":\"1\",\"sell_mouth\":\"0\",\"number\":\"18\",\"stock_num\":\"199.00\",\"goods_sn\":\"18\",\"buying_price\":\"0.00\",\"goods_barcodes\":null,\"is_hot\":\"0\",\"third_no\":null,\"third_sort_no\":null}]},{\"sort_name\":\"\\u51c9\\u83dc\",\"goods_list\":[{\"goods_id\":\"16\",\"sort_id\":\"10\",\"store_id\":\"72\",\"name\":\"\\u82b1\\u751f\",\"unit\":\"\\u4efd\",\"label\":\"\",\"old_price\":\"0.00\",\"price\":\"3.00\",\"vip_price\":\"0.00\",\"image\":\"\",\"des\":\"\",\"last_time\":\"1485968282\",\"sort\":\"0\",\"sell_count\":\"5\",\"status\":\"1\",\"sell_mouth\":\"0\",\"number\":\"16\",\"stock_num\":\"1297.00\",\"goods_sn\":\"16\",\"buying_price\":\"0.00\",\"goods_barcodes\":null,\"is_hot\":\"0\",\"third_no\":null,\"third_sort_no\":null},{\"goods_id\":\"17\",\"sort_id\":\"10\",\"store_id\":\"72\",\"name\":\"\\u8c46\\u8150\\u76ae\",\"unit\":\"\\u4efd\",\"label\":\"\",\"old_price\":\"0.00\",\"price\":\"5.00\",\"vip_price\":\"0.00\",\"image\":\"\",\"des\":\"\",\"last_time\":\"1485968334\",\"sort\":\"0\",\"sell_count\":\"6\",\"status\":\"1\",\"sell_mouth\":\"0\",\"number\":\"17\",\"stock_num\":\"298.00\",\"goods_sn\":\"17\",\"buying_price\":\"0.00\",\"goods_barcodes\":null,\"is_hot\":\"0\",\"third_no\":null,\"third_sort_no\":null}]},{\"sort_name\":\"\\u4e0a\\u8863\",\"goods_list\":[{\"goods_id\":\"20\",\"sort_id\":\"11\",\"store_id\":\"72\",\"name\":\"\\u6bdb\\u8863\",\"unit\":\"\\u4ef6\",\"label\":\"\",\"old_price\":\"0.00\",\"price\":\"100.00\",\"vip_price\":\"0.00\",\"image\":\"\",\"des\":\"\",\"last_time\":\"1487170717\",\"sort\":\"0\",\"sell_count\":\"13\",\"status\":\"1\",\"sell_mouth\":\"0\",\"number\":\"20\",\"stock_num\":\"90.00\",\"goods_sn\":\"20\",\"buying_price\":\"0.00\",\"goods_barcodes\":null,\"is_hot\":\"0\",\"third_no\":null,\"third_sort_no\":null}]}]}");
                return newFixedLengthResponse(builder_o2o.toString());
            }
            if(url.equals(CONST_URL_SHOP_At)){

                StringBuilder builder_AT = new StringBuilder();
                builder_AT.append("<!DOCTYPE html><html><body>");
                builder_AT.append("CyberWin Server 未来之窗软件悠然收银!");
                builder_AT.append("<br>您能看到此页面，说明未来之窗运行正常 no define");
                return newFixedLengthResponse(builder_AT.toString());
            }

            if(url.equals(CONST_URL_SHOP_getconfig)){

                StringBuilder builder_AT = new StringBuilder();
                builder_AT.append("<!DOCTYPE html><html><body>");
                builder_AT.append("CyberWin Server 未来之窗软件悠然收银!");
                builder_AT.append("<br>商户信息");
                builder_AT.append("<br>设备信息："+ Cyber_Public_Var.cwpd_device_sn);
                builder_AT.append("<br>商户信息："+ Cyber_Public_Var.cwpd_loadMerchant_config_raw);
                return newFixedLengthResponse(builder_AT.toString());
            }

            //2022-7-27 指令
            if(url.indexOf("cyberber_handle=command")>0){
                StringBuilder builder = new StringBuilder();
               // builder.append("<!DOCTYPE html><html><body>");
              //  builder.append("CyberWin Server 未来之窗软件悠然收银!");
              //  builder.append("<br>地址"+url+" no define");
              //  builder.append("<br>头"+s_h+" <hr>");

              //  builder.append("<br>参数："+s_p+" <hr>");
              //  builder.append("<br>"+is_str+" <hr>");



                //is_str
                String  command_action=parms.get("action").toString().toLowerCase(Locale.ROOT);
                String  password=parms.get("password").toString().trim();
                String  param1=parms.get("param1").toString().trim();
                String  param2=parms.get("param2").toString().trim();
                String  param3=parms.get("param3").toString().trim();

                Cyber_JsPrinterStandard jsStandardPlug=  new Cyber_JsPrinterStandard(
                        Cyber_Public_Var.m_cpu, Cyber_Public_Var.cyber_main_instance);

                String syspsw=jsStandardPlug.cwpd_system_get("DeviceSync","password","20225578-2019");
                syspsw=syspsw.trim();


                builder.append("{");

                builder.append("\"command_action\":\""+command_action+"\"");
                builder.append(",\"password\":\""+password+"\"");
                builder.append(",\"param1\":\""+param1+"\"");
                builder.append(",\"param2\":\""+param2+"\"");
                builder.append(",\"param3\":\""+param3+"\"");
                if(syspsw.equals(password)==false){
                    builder.append(",\"verify\":\""+"密码错误"+"\"");
                    builder.append("}");



                    //builder.append("</body></html>\n");
                    return newFixedLengthResponse(builder.toString());
                }else{
                    builder.append(",\"verify\":\""+"密码正确"+"\"");
                }
                builder.append(",\"client_sn\":\""+Cyber_Public_Var.client_sn+"\"");
                //sethome
                if(command_action.equals("setsoftconfig")==true){

                    jsStandardPlug.cwpd_system_set(param1,param2,param3,"20225578-2019");
                    builder.append(",\"message\":\""+"设置系统"+"\"");
                }

                if(command_action.equals("getsoftconfig")==true){

                     String ret=  jsStandardPlug.cwpd_system_get(param1,param2,"20225578-2019");
                    builder.append(",\"data\":\""+ret+"\"");

                    builder.append(",\"message\":\""+"读取配置"+"\"");

                }

                if(command_action.equals("restart")==true){
                    Intent intent = new Intent(Cyber_Public_Var.cyber_main_instance, FullscreenActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Cyber_Public_Var.cyber_main_instance.startActivity(intent);
                    android.os.Process.killProcess(android.os.Process.myPid());

                }

                if(command_action.equals("shutdownapp")==true){
                    //关闭软件
                    System.exit(0);

                }

                //切换画面
                if(command_action.equals("syncscreen")==true){
                    //关闭软件
                    String weburl=param1;
                    if(param1.startsWith("cyberwin_app://")){
                        String App_name=param1.replaceFirst("cyberwin_app://","");
                        String App_local_path = Cyber_Public_Var.App_local_path;
                        String App_loaclrunpath=App_local_path+""+App_name+"/cybewinapp.html";
                        weburl="file://external_files/"+App_loaclrunpath;

                    }
                    builder.append(",\"data\":\""+weburl+"\"");


                    builder.append(",\"message\":\""+"同步画面"+"\"");

                    jsStandardPlug.cyber_openinhome(weburl);

                }

                if(command_action.equals("speakqueue")==true){

                     jsStandardPlug.Dish_PlayQueueCall(param1);
                    builder.append(",\"data\":\""+param1+"\"");






                    builder.append(",\"message\":\""+"设备播报"+"\"");

                }
                if(command_action.equals("speakblyw")==true){

                    jsStandardPlug.Work_PlayBLYW(param1);
                    builder.append(",\"data\":\""+param1+"\"");






                    builder.append(",\"message\":\""+"设备播报"+"\"");

                }



                if(command_action.equals("speaktext")==true){

                   String speakret= jsStandardPlug.speakText(param1);
                    builder.append(",\"data\":\""+param1+"\"");

                    builder.append(",\"result\":["+speakret+"]");

                    SpeakText=param1;

                    SpeakThread thread = new SpeakThread();
                    Thread mThread = new Thread(thread);

                     mThread.start();



                    builder.append(",\"message\":\""+"设备播报"+"\"");

                }

                if(command_action.equals("printertest")==true){

                   // CyberWin_JsStandardPlug.speakText(param1);

                    String data_ss =  "<?xml version=\"1.0\"?><root><print_type>结账单</print_type><shopname>未来之窗店</shopname><order_id>rrrrrrrr</order_id><orderid>rrrrrrrr</orderid><order_no>单号：P17021500003</order_no><bill_time>2016-04-26 02:30:49</bill_time><beizhu>备注</beizhu><clerk_name>11</clerk_name><clerk_id>11</clerk_id><order_detail>"+param1+"中碗米线    5    8.0     40.0 \n花生   6\n南瓜饼</order_detail></root>";

                    jsStandardPlug.print_byprintername("",data_ss,"");

                    builder.append(",\"data\":\""+param1+"\"");

                    builder.append(",\"message\":\""+"USB打印测试"+"\"");

                }

                //2022-7-27 下载APP
                //切换画面
                if(command_action.equals("download_apppackage")==true){
                    //关闭软件


                    builder.append(",\"data\":\""+param1+"地址"+param3+"\"");

                    builder.append(",\"message\":\""+"下载应用"+"\"");

                    jsStandardPlug.cyber_download_apppackage(param1,param2,param3);

                }
                if(command_action.equals("download_microapppackage")==true){
                    //关闭软件


                    builder.append(",\"data\":\""+param1+"地址"+param3+"\"");

                    builder.append(",\"message\":\""+"下载应用"+"\"");

                    jsStandardPlug.cyber_download_microapppackage(param1,param2,param3);

                }

                //2022-9-15 删除
                if(command_action.equals("sysstem_delete_cache")==true){
                    //关闭软件


                    //builder.append(",\"data\":\""+param1+"地址"+param3+"\"");



                  //  jsStandardPlug.cyber_download_apppackage(param1,param2,param3);

                    String CyberWinPHP_Path=  Cyber_Public_Var.App_localcache_resource_path;//

                    File filecache  = new File(CyberWinPHP_Path);;
                    jsStandardPlug.deleteFile(filecache);
                    builder.append(",\"data\":\""+"删除路径"+CyberWinPHP_Path+"\"");
                    builder.append(",\"message\":\""+"删除缓存"+"\"");

                }


                if(command_action.equals("sysstem_getdevicesn")==true){
                    //关闭软件



                   String client_sn=   Cyber_Public_Var.client_sn;
                    builder.append(",\"data\":\""+client_sn+"\"");
                    builder.append(",\"message\":\""+"设备sn"+"\"");

                }

                if(command_action.equals("device_connect_wifi")==true){

                    jsStandardPlug.device_connect_wifi(param1,param2);
                    builder.append(",\"message\":\""+"连接wifi"+param1+"\"");
                }

                if(command_action.equals("device_create_wifiap")==true){

                    jsStandardPlug.device_create_wifiap(param1,param2);
                    builder.append(",\"message\":\""+"创建热点"+param1+"\"");
                }

                if(command_action.equals("cyber_downHometocache")==true){

                 String doenloadtocache =    jsStandardPlug.cyber_downHomeToCache();
                    builder.append(",\"message\":\""+"离线主app"+doenloadtocache+"\"");
                }

                //





                //
                builder.append("}");



                //builder.append("</body></html>\n");
                return newFixedLengthResponse(builder.toString());
            }


            //2024-12-03
            if(url.indexOf("cyberber_smartscreen=command")>0) {
                StringBuilder builder = new StringBuilder();
                String  智慧大屏幕指令=parms.get("action").toString().toLowerCase(Locale.ROOT);

                if(智慧大屏幕指令.equals("readfile")==true){
                    String  param1=parms.get("param1").toString().trim();
                    //String  param2=parms.get("param2").toString().trim();
                    String 文件路径=Cyber_Public_Var.CyberWin_智能屏幕路径+"/"+param1;

                    Context context = Cyber_Public_Var.m_cpu;
                    String mimeType = getMimeType(context, param1);
                    String 扩展名 = CyberWin_Smart_CommonFunction.东方仙盟_系统_获取扩展名(param1);

                    File file = new File(文件路径);  // 去除开头的 '/'

                    if (file.exists() && file.isFile()) {
                        try (FileInputStream fis = new FileInputStream(file)) {
                           // String mimeType = "text/plain";  // 根据实际文件类型设置 MIME 类型
                          // IStatus 状态= new IStatus();
                         //  long 文件大小 = fis.available();
                            //long 文件大小2 = data.getBytes().length;
                           // I.st
                           // return new Response(Status.OK, mimeType, fis,文件大小);
                          //  return Response.newFixedLengthResponse(Status.OK,mimeType,fis);
                       //2024-12-04
                            if(扩展名.equals("mp4")==true) {
                               // Response 大文件resp = Response.newFixedLengthResponse(Status.OK, mimeType, fis,file.length());
                                //大文件resp.addHeader("Content-Disposition", "attachment; filename=" + file.getName());
                               // return 大文件resp;
                               // Response 大文件mp4resp = Response.newChunkedResponse(Status.OK, mimeType, fis);
                                //大文件mp4resp.addHeader("Content-Disposition", "inline");
                                // 发送结束块
                              //  大文件mp4resp.send("");
                              //  Response 大文件mp4resp = Response.newFixedLengthResponse(Status.OK, mimeType, fis,file.length());
                              //  serveVideoFile(session);
                              //  return 大文件mp4resp;

                              //  var videoFile = File("path/to/your/local/video.mp4");//需要更换成你的视频文件路径
                                // 获取请求头中的 Range 字段
                                /*
                                Map<String, String> headers = new HashMap<>();
                                headers.put("Content - Type", "video/mp4");

                                String rangeHeader = session.getHeaders().get("range");
                                if (rangeHeader!= null) {
                                    long startByte, endByte;
                                    if (rangeHeader.startsWith("bytes=")) {
                                        rangeHeader = rangeHeader.substring("bytes=".length());
                                        int minusIndex = rangeHeader.indexOf('-');
                                        if (minusIndex > 0) {
                                            startByte = Long.parseLong(rangeHeader.substring(0, minusIndex));
                                            endByte = Long.parseLong(rangeHeader.substring(minusIndex + 1));
                                        } else {
                                            startByte = Long.parseLong(rangeHeader);
                                            endByte = file.length() - 1;
                                        }
                                    } else {
                                        // 不支持的范围请求格式，返回整个视频
                                        startByte = 0;
                                        endByte = file.length() - 1;
                                    }
                                    long contentLength = endByte - startByte + 1;
                                    headers.put("Content - Length", "" + contentLength);
                                    headers.put("Content - Range", "bytes " + startByte + "-" + endByte + "/" + file.length());
                                    return newChunkedResponse(Status.PARTIAL_CONTENT, "video/mp4", new FileInputStream(file) {
                                        @Override
                                        public void close() throws IOException {
                                            // 这里可以根据需要进行一些额外的关闭操作
                                        }

                                        @Override
                                        public int read(byte[] b, int off, int len) throws IOException {
                                           int  pos = 0;
                                            if (pos < startByte) {
                                                long skipped = skip(startByte - pos);
                                                if (skipped < startByte - pos) {
                                                    return - 1;
                                                }
                                            }
                                            return super.read(b, off, len);
                                        }
                                    });
                                } else {
                                    // 没有范围请求，返回整个视频
                                    FileInputStream fis2= new FileInputStream(file);

                                    return newChunkedResponse(Status.OK, "video/mp4", fis2);
                                }
                                ///////////////////
                                *
                                 */
                               // Map<String, String> headers = new HashMap<>();
                              //  headers.put("Content-Type", "video/mp4");

                                /* 33次
                                long fileLength = file.length();
                                Response response = newChunkedResponse(Status.OK, "video/mp4", fis);
                                response.addHeader("Content-Length", String.valueOf(fileLength));
                                response.addHeader("Cache-Control", "public, max-age=3600");  // 示例缓存策略，可按需调整
                                return response;
                                */

                                File videoFile = new File(文件路径);

                                Map<String, String> headers = session.getHeaders();
                                String rangeHeader = headers.get("range");
                                try {
                                    long fileLength = videoFile.length();
                                    if (rangeHeader!= null) {
                                        // 处理范围请求（用于实现断点续传、进度展示等）
                                        long startPos = 0;
                                        long endPos = fileLength - 1;
                                        if (rangeHeader.startsWith("bytes=")) {
                                            StringTokenizer tokenizer = new StringTokenizer(rangeHeader.substring("bytes=".length()), "-");
                                            startPos = Long.parseLong(tokenizer.nextToken().trim());
                                            if (tokenizer.hasMoreTokens()) {
                                                endPos = Long.parseLong(tokenizer.nextToken().trim());
                                            }
                                        }
                                        long contentLength = endPos - startPos + 1;
                                        RandomAccessFile raf = new RandomAccessFile(videoFile, "r");
                                        raf.seek(startPos);
                                        InputStream inputStream = new FileInputStream(raf.getFD());
                                        Response response = newChunkedResponse(Status.PARTIAL_CONTENT, "video/mp4", inputStream);//contentLength
                                        response.addHeader("Content-Range", "bytes " + startPos + "-" + endPos + "/" + fileLength);
                                        response.addHeader("Content-Length", String.valueOf(contentLength));
                                        return response;
                                    } else {
                                        // 普通的完整视频请求
                                        FileInputStream fis2 = new FileInputStream(videoFile);
                                        Response response = newChunkedResponse(Status.OK, "video/mp4", fis2);
                                        response.addHeader("Content-Length", String.valueOf(fileLength));
                                        response.addHeader("Accept-Ranges", "bytes");  // 告知客户端支持范围请求
                                        return response;
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    return newFixedLengthResponse(Status.NOT_FOUND, "text/plain", "Error handling video file request");
                                }
                                //2024-12-07-34

                            }else{


                                byte[] fileContent = new byte[(int) file.length()];
                                fis.read(fileContent);

                                return newFixedLengthResponse(Status.OK, mimeType, fileContent);
                            }



                        } catch (IOException e) {
                           // return new Response(Status.INTERNAL_ERROR, MIME_PLAINTEXT, "cyberwin Error reading file",512);
                            builder.append("<br>读取错误"+e.getMessage()+" <hr>");
                            return newFixedLengthResponse(builder.toString());

                        }


                    } else {
                       // return new Response(Status.NOT_FOUND, MIME_PLAINTEXT, "cyberwin File not found",512);
                    }

                    //jsStandardPlug.cwpd_system_set(param1,param2,param3,"20225578-2019");
                   // builder.append(",\"message\":\""+"设置系统"+"\"");

                    builder.append("<!DOCTYPE html><html><body>");
                    builder.append("CyberWin Server 未来之窗软件悠然收银!");
                    builder.append("<br>地址"+url+" no define");
                    builder.append("<br>头"+s_h+" <hr>");

                    builder.append("<br>参数："+s_p+" <hr>");
                    builder.append("<br>"+is_str+" <hr>");
                    builder.append("<br>mimeType="+mimeType+" <hr>");

                    builder.append("<br>不存在："+文件路径+" <hr>");
                    return newFixedLengthResponse(builder.toString());
                }

                //2024-12-19 根目录读取
                if(智慧大屏幕指令.equals("readrootfile")==true){
                    {
                        String  param1=parms.get("param1").toString().trim();
                        //String  param2=parms.get("param2").toString().trim();
                        String 根目录 = Environment.getExternalStorageDirectory().getAbsolutePath();
                        String 文件路径=根目录+"/"+param1;

                        Context context = Cyber_Public_Var.m_cpu;
                        String mimeType = getMimeType(context, param1);
                        String 扩展名 = CyberWin_Smart_CommonFunction.东方仙盟_系统_获取扩展名(param1);

                        File file = new File(文件路径);  // 去除开头的 '/'

                        if (file.exists() && file.isFile()) {
                            try (FileInputStream fis = new FileInputStream(file)) {


                                //2024-12-04
                                if(扩展名.equals("mp4")==true) {





                                    File videoFile = new File(文件路径);

                                    Map<String, String> headers = session.getHeaders();
                                    String rangeHeader = headers.get("range");
                                    try {
                                        long fileLength = videoFile.length();
                                        if (rangeHeader!= null) {
                                            // 处理范围请求（用于实现断点续传、进度展示等）
                                            long startPos = 0;
                                            long endPos = fileLength - 1;
                                            if (rangeHeader.startsWith("bytes=")) {
                                                StringTokenizer tokenizer = new StringTokenizer(rangeHeader.substring("bytes=".length()), "-");
                                                startPos = Long.parseLong(tokenizer.nextToken().trim());
                                                if (tokenizer.hasMoreTokens()) {
                                                    endPos = Long.parseLong(tokenizer.nextToken().trim());
                                                }
                                            }
                                            long contentLength = endPos - startPos + 1;
                                            RandomAccessFile raf = new RandomAccessFile(videoFile, "r");
                                            raf.seek(startPos);
                                            InputStream inputStream = new FileInputStream(raf.getFD());
                                            Response response = newChunkedResponse(Status.PARTIAL_CONTENT, "video/mp4", inputStream);//contentLength
                                            response.addHeader("Content-Range", "bytes " + startPos + "-" + endPos + "/" + fileLength);
                                            response.addHeader("Content-Length", String.valueOf(contentLength));
                                            return response;
                                        } else {
                                            // 普通的完整视频请求
                                            FileInputStream fis2 = new FileInputStream(videoFile);
                                            Response response = newChunkedResponse(Status.OK, "video/mp4", fis2);
                                            response.addHeader("Content-Length", String.valueOf(fileLength));
                                            response.addHeader("Accept-Ranges", "bytes");  // 告知客户端支持范围请求
                                            return response;
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        return newFixedLengthResponse(Status.NOT_FOUND, "text/plain", "Error handling video file request");
                                    }
                                    //2024-12-07-34

                                }else{


                                    byte[] fileContent = new byte[(int) file.length()];
                                    fis.read(fileContent);

                                    return newFixedLengthResponse(Status.OK, mimeType, fileContent);
                                }



                            } catch (IOException e) {
                                // return new Response(Status.INTERNAL_ERROR, MIME_PLAINTEXT, "cyberwin Error reading file",512);
                                builder.append("<br>读取错误"+e.getMessage()+" <hr>");
                                return newFixedLengthResponse(builder.toString());

                            }


                        } else {
                            // return new Response(Status.NOT_FOUND, MIME_PLAINTEXT, "cyberwin File not found",512);
                        }



                        builder.append("<!DOCTYPE html><html><body>");
                        builder.append("CyberWin Server 未来之窗软件悠然收银!");
                        builder.append("<br>地址"+url+" no define");
                        builder.append("<br>头"+s_h+" <hr>");

                        builder.append("<br>参数："+s_p+" <hr>");
                        builder.append("<br>"+is_str+" <hr>");
                        builder.append("<br>mimeType="+mimeType+" <hr>");

                        builder.append("<br>不存在："+文件路径+" <hr>");
                        return newFixedLengthResponse(builder.toString());
                    }
                }

            }




            StringBuilder builder = new StringBuilder();
            builder.append("<!DOCTYPE html><html><body>");
            builder.append("CyberWin Server 未来之窗软件悠然收银!");
            builder.append("<br>地址"+url+" no define");
            builder.append("<br>头"+s_h+" <hr>");

            builder.append("<br>参数："+s_p+" <hr>");
            builder.append("<br>"+is_str+" <hr>");

            //is_str


            //



            builder.append("</body></html>\n");
            return newFixedLengthResponse(builder.toString());
        }



    private String SpeakText="";
    class SpeakThread implements Runnable {
        public void run() {
            //执行数据操作，不涉及到UI
            Cyber_JsPrinterStandard jsStandardPlug = new Cyber_JsPrinterStandard(
                    Cyber_Public_Var.m_cpu, Cyber_Public_Var.cyber_main_instance);
            String speakret = jsStandardPlug.speakText(SpeakText);
        }
    }


    /*
    //对于请求根目录的，返回分享的文件列表
    public Response responseRootPage(IHTTPSession session){
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPER html><html><body>");
        builder.append("<ol>");
        for(int i = 0 , len = fileList.size(); i < len ; i++){
            File file = new File(fileList.get(i).getPath());
            if(file.exists()){
                //文件及下载文件的链接，定义了一个文件类，这里使用getPath方法获得路径，使用getName方法获得文件名
                builder.append("<li> <a href=\""+file.getPath()+"\">"+file.getName()+"</a></li>");
            }
        }
       // builder.append("<li>分享文件数量：  "+fileList.size()+"</li>");
        builder.append("</ol>");
        builder.append("</body></html>\n");
        //回送应答
        return Response.(String.valueOf(builder));
    }
    */
    //对于请求文件的，返回下载的文件
    /*
    public Response responseFile(IHTTPSession session){
        try {
            //uri：用于标示文件资源的字符串，这里即是文件路径
            String uri = session.getUri();
            //文件输入流
            FileInputStream fis = new FileInputStream(uri);
            // 返回OK，同时传送文件，为了安全这里应该再加一个处理，即判断这个文件是否是我们所分享的文件，避免客户端访问了其他个人文件
            return Response.newFixedLengthResponse(Response.Status.OK,"application/octet-stream",fis,fis.available());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response404(session,null);
    }

     */
    public static String getMimeType(Context context, String filePath) {
        String extension = MimeTypeMap.getFileExtensionFromUrl(filePath);
        if (extension!= null) {
            MimeTypeMap mime = MimeTypeMap.getSingleton();
            return mime.getMimeTypeFromExtension(extension.toLowerCase());
        }
        return "application/octet-stream";
    }

    //页面不存在，或者文件不存在时
    public Response response404(IHTTPSession session,String url) {
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html><html>body>");
        builder.append("Sorry,Can't Found" + url + " !");
        builder.append("</body></html>\n");
        return newFixedLengthResponse(builder.toString());
    }
     }




