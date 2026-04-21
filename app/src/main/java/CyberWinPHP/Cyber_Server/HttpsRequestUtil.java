package CyberWinPHP.Cyber_Server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import CyberWinPHP.Cyber_Plus.LogToFile;


public class HttpsRequestUtil {
   // private static Logger logger = LoggerFactory.getLogger(HttpsRequestUtil.class);

    // 获取access_token接口的地址（GET） 限200（次/天）
    public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    // 菜单创建（POST） 限100（次/天）
    public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
        if(requestUrl.startsWith("https://")) {
           return httpRequest_ssl(requestUrl,requestMethod,outputStr);
        }else{
            return httpRequest_nossl(requestUrl,requestMethod,outputStr);
        }
    }

    public static String httpRequest_nossl(String requestUrl, String requestMethod, String outputStr) {
        //  JSONObject jsonObject = null;

        //  LogToFile.d_windows("网络","网络测试","数据提交url:"+requestUrl);
        //  LogToFile.d_windows("网络","网络测试","数据提交方式:"+requestMethod);
        //  LogToFile.d_windows("网络","网络测试","数据提交内容:"+outputStr);
        LogToFile.d_windows("网络NOSSL","网络测试","地址："+requestUrl);

        //2022增加技术
        HttpURLConnection httpUrlConn;


        String cwpd_ret="";
        StringBuffer buffer = new StringBuffer();
        try {



            //打开连接
            URL url = new URL(requestUrl);
            httpUrlConn = (HttpURLConnection) url.openConnection();




            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            //未来之窗不缓存技术
            httpUrlConn.setRequestProperty("Cache-Control", "no-cache");

            //超时设置
            //50秒 原来10秒
            httpUrlConn.setConnectTimeout(10000);
            httpUrlConn.setReadTimeout(10000);

            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)){
                httpUrlConn.connect();
            }
            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            //jsonObject = JSONObject.fromObject(buffer.toString());
            cwpd_ret=buffer.toString();
        } catch (ConnectException ce) {
            // logger.error("Weixin server connection timed out.");
            LogToFile.d_windows("网络NOSSL","网络测试","请求失败"+ce.getMessage());
            return "cyber-error:connerr";
        }
        catch(SocketTimeoutException ste) {
            LogToFile.d_windows("网络NOSSL","网络测试","请求失败 超时"+ste.getMessage());
            return "cyber-error:timeout";
        }
        //unknownhostexception
        catch(UnknownHostException ukne) {
            LogToFile.d_windows("网络NOSSL","网络测试","请求失败 超时"+ukne.getMessage());
            return "cyber-error:unknow";
        }
        catch (Exception e) {
            // logger.error("https request error:{}", e);
            LogToFile.d_windows("网络NOSSL","网络测试","请求异常:"+e.getMessage()+e.getStackTrace()+e.toString());
            return "cyber-error:e";

        }
        finally {
            // httpUrlConn.disconnect();
            //httpUrlConn.disconnect();
        }
        //LogToFile.d("网络测试","请求结果"+cwpd_ret);

        return cwpd_ret;
    }

        public static String httpRequest_ssl(String requestUrl, String requestMethod, String outputStr) {
      //  JSONObject jsonObject = null;

      //  LogToFile.d_windows("网络","网络测试","数据提交url:"+requestUrl);
      //  LogToFile.d_windows("网络","网络测试","数据提交方式:"+requestMethod);
      //  LogToFile.d_windows("网络","网络测试","数据提交内容:"+outputStr);
        //2022增加技术
        HttpsURLConnection httpUrlConn;


        String cwpd_ret="";
        StringBuffer buffer = new StringBuffer();
        try {

            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            //SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            //2019-10-24 未来之窗
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, tm, new SecureRandom());

            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            //打开连接
            URL url = new URL(requestUrl);
            httpUrlConn = (HttpsURLConnection) url.openConnection();


                //只有sll 加载证书 否则不加载
                httpUrlConn.setSSLSocketFactory(ssf);


            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            //未来之窗不缓存技术
            httpUrlConn.setRequestProperty("Cache-Control", "no-cache");

            //超时设置
            //50秒 原来10秒
            httpUrlConn.setConnectTimeout(10000);
            httpUrlConn.setReadTimeout(10000);

            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)){
                httpUrlConn.connect();
            }
            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            //jsonObject = JSONObject.fromObject(buffer.toString());
            cwpd_ret=buffer.toString();
        } catch (ConnectException ce) {
            // logger.error("Weixin server connection timed out.");
            LogToFile.d_windows("网络SSL","网络测试","请求失败"+ce.getMessage());
            return "cyber-error:connerr";
        }
        catch(SocketTimeoutException ste) {
            LogToFile.d_windows("网络SSL","网络测试","请求失败 超时"+ste.getMessage());
            return "cyber-error:timeout";
        }
        //unknownhostexception
        catch(UnknownHostException ukne) {
            LogToFile.d_windows("网络SSL","网络测试","请求失败 超时"+ukne.getMessage());
            return "cyber-error:unknow";
        }
        catch (Exception e) {
            // logger.error("https request error:{}", e);
            LogToFile.d_windows("网络SSL","网络测试","请求异常:"+e.getMessage()+e.getStackTrace()+e.toString());
            return "cyber-error:e";

        }
        finally {
           // httpUrlConn.disconnect();
            //httpUrlConn.disconnect();
        }
        //LogToFile.d("网络测试","请求结果"+cwpd_ret);

        return cwpd_ret;
    }
    /**
     * 发起https请求并获取结果
     *
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    /*
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {

            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new SecureRandom());

            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            //打开连接
            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);

            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)){
                httpUrlConn.connect();
            }
            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
           // logger.error("Weixin server connection timed out.");
        } catch (Exception e) {
           // logger.error("https request error:{}", e);
        }
        return jsonObject;
    }

     */



    /**
     * 获取access_token
     * 微信服务器会返回json格式的数据：{"access_token":"ACCESS_TOKEN","expires_in":7200}
     * @param appid 凭证
     * @param appsecret 密钥
     * @return
     */
    /*
    public static AccessToken getAccessToken(String appid, String appsecret) {
        AccessToken accessToken = null;
        String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
        // 如果请求成功
        if (null != jsonObject) {
            try {
                accessToken = new AccessToken();
                accessToken.setAccessToken(jsonObject.getString("access_token"));
                accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
            } catch (JSONException e) {
                accessToken = null;
                // 获取token失败
              //  logger.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return accessToken;
    }
    */



    /**
     * 创建菜单
     *
     * @param menu 菜单实例
     * @param accessToken 有效的access_token
     * @return 0表示成功，其他值表示失败
     */
    /*
    public static int createMenu(Menu menu, String accessToken) {
        int result = 0;

        // 拼装创建菜单的url
        String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
        // 将菜单对象转换成json字符串
        String jsonMenu = JSONObject.fromObject(menu).toString();
        // 调用接口创建菜单
        JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);

        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                result = jsonObject.getInt("errcode");
               // logger.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }

        return result;
    }

   */




}

