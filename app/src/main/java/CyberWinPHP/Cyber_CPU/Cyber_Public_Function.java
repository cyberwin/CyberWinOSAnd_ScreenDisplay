package CyberWinPHP.Cyber_CPU;



import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import CyberWinPHP.Cyber_Plus.Cyber_XMLSample;
import CyberWinPHP.Cyber_Plus.LogToFile;
import CyberWinPHP.Cyber_Server.HttpsRequestUtil;
import CyberWinPHP.Cyber_Structure.Cyber_Package_PayClientPos;
import CyberWinPHP.Cyber_Structure.Cyber_ReturnMessage;

public class Cyber_Public_Function {
    /**
     *
     * Map转String
     * @param map
     * @return
     */
    public static String getMapToString(Map<String,String> map){
        Set<String> keySet = map.keySet();
        //将set集合转换为数组
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        //给数组排序(升序)
        Arrays.sort(keyArray);
        //因为String拼接效率会很低的，所以转用StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyArray.length; i++) {
            // 参数值为空，则不参与签名 这个方法trim()是去空格
            if ((String.valueOf(map.get(keyArray[i]))).trim().length() > 0) {
                sb.append(keyArray[i]).append(":").append(String.valueOf(map.get(keyArray[i])).trim());
            }
            if(i != keyArray.length-1){
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /**
     *
     * String转map
     * @param str
     * @return
     */
    public static Map<String,Object> getStringToMap(String str) {
        //根据逗号截取字符串数组
        String[] str1 = str.split(",");
        //创建Map对象
        Map<String, Object> map = new HashMap<>();
        //循环加入map集合
        for (int i = 0; i < str1.length; i++) {
            //根据":"截取字符串数组
            String[] str2 = str1[i].split(":");
            //str2[0]为KEY,str2[1]为值
            map.put(str2[0], str2[1]);
        }
        return map;
    }


    /**
     * 利用BufferedReader实现Inputstream转换成String <功能详细描述>
     *
     * @param in
     * @return String
     */

    public static String Inputstr2Str_Reader(InputStream in, String encode)
    {

        String str = "";
        try
        {
            if (encode == null || encode.equals(""))
            {
                // 默认以utf-8形式
                encode = "utf-8";
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, encode));
            StringBuffer sb = new StringBuffer();

            while ((str = reader.readLine()) != null)
            {
                sb.append(str).append("\n");
            }
            return sb.toString();
        }
        catch (UnsupportedEncodingException e1)
        {
            e1.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return str;
    }



    public static String CyberWinApp_Protocol_Package(HashMap<String,String> data ) {
        /*
        if(!is_array($data)){
            return $data;
        }
        */
        String xml ="";
        /*
        foreach ($data as $key => $val) {
            is_numeric($key) && $key = "item id=\"$key\"";
            $xml    .=  "CyberPHP->Param:".$key."CyberPHP->Value:";
            $xml    .=  ( is_array($val) || is_object($val)) ? data_to_donetQueryFormat($val) : $val;
            list($key, ) = explode(' ', $key);
            // $xml    .=  "</$key>";
        }
        */
        for (String key : data.keySet()) {
            //System.out.println("key= "+ key + " and value= " + map.get(key));
            xml    +=  "CyberPHP->Param:"+key+"CyberPHP->Value:"+ data.get(key);
        }

        return xml;
    }

    public static HashMap<String,String> CyberWinApp_Protocol_unPackage(  String data ) {

        HashMap<String,String> ret_un =new HashMap<String,String>();

        String[] firstdata_array= data.split("CyberPHP->Param:");
        for (String v :firstdata_array) {
            //二级分离技术
            String[] second_split=v.split("CyberPHP->Value:");
            //2024-12-18
            if(second_split.length<2){
                //无法分离字符串抛弃
                continue;
            }
            if((second_split[0]=="")&&(second_split[1]=="")){
            }else{
                // $cyber_data[$second_split[0]]=$second_split[1];
                ret_un.put(second_split[0],second_split[1]);
            }
        }


        return ret_un;
    }

    //未来之窗支付接口heti
    public static HashMap<String,String> getCWPDPayConfig() {
        //应该大于5 ，是个随意数字
        if (Cyber_Public_Var.cwpd_pay_allparamorder.length() > 5) {

            Cyber_ReturnMessage ret_s = new Cyber_ReturnMessage("1", "成功");

            Cyber_XMLSample c_xml = new Cyber_XMLSample();
            HashMap<String, String> cwpd_hm = c_xml.splitS(Cyber_Public_Var.cwpd_pay_allparamorder);
            //增加支付参数
            if( cwpd_hm.containsKey("wlzc_client_merchant_platform")==true){

            }else{
                cwpd_hm.put("wlzc_client_merchant_platform",Cyber_Public_Var.cwpd_pay_wlzc_client_system_wlzc_client_merchant_platform);

            }
            if( cwpd_hm.containsKey("wlzc_client_merchant_id")==true){

            }else{
                cwpd_hm.put("wlzc_client_merchant_id",Cyber_Public_Var.cwpd_pay_wlzc_client_system_wlzc_client_merchant_id);

            }
//wlzc_client_merchant_id
            //2022-6-28
            //  if( cwpd_hm.containsKey("wlzc_client_store_id")==true){

            // }else{
            cwpd_hm.put("wlzc_client_store_id",Cyber_Public_Var.cwpd_pay_wlzc_client_system_wlzc_client_store_id);

            // }



            //强制增加设备id
            // String ANDROID_ID = Settings.System.getString(mContext.getContentResolver(), Settings.System.ANDROID_ID);

            cwpd_hm.put("wlzc_client_sn", Cyber_Public_Var.cwpd_device_sn);



            return cwpd_hm;
        } else {
            return new HashMap<String, String>();

        }

    }


    public static String cyber_clientpospay( String price,  String barcode) {


        String url = "https://51.onelink.ynwlzc.cn/o2o/cwpd_pay_pos.cwas/clienttype/andrid";
        //https://51.onelink.ynwlzc.cn/o2o/cwpd_pay_pos.cwas";

        String requestMethod = "POST";

        Cyber_Package_PayClientPos cpplp = new Cyber_Package_PayClientPos();
        cpplp.setdevice_sn(Cyber_Public_Var.Application_POs_dev_sn);
        cpplp.setauth_code(barcode);
        cpplp.setPrice(price);
        String outputStr = JSON.toJSONString(cpplp);
        ;

        // outputStr="0000000000000000";

        //未来之窗重新打包
        //  HashMap<String, String> map_facepay_raw =Cyber_Public_Function.getCWPDPayConfig();
        //   map_facepay_raw.put("rawdata", rawdata);
        //   outputStr = Cyber_Public_Function.CyberWinApp_Protocol_Package(map_facepay_raw);

        LogToFile.d("Pay", outputStr);

        String cwpd_ret = HttpsRequestUtil.httpRequest(url, requestMethod, outputStr);


        return cwpd_ret;
    }



}
