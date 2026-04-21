package CyberWinPHP.Cyber_Structure;

import java.lang.ref.PhantomReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Cyber_Package_PayClientPos {
    //未来之窗支付pos 客户端结构体
    //非未来之窗app4.0

  public   String out_trade_no;
    public   String auth_code = "";
    public String device_sn="0";
    public  String price="";
    public String version="2";
    public String pay_type="cyberwincloudpay";
    public String appid = "cwpd_pos";
    public String pay_action="create";
    public String messgae="";


  public Cyber_Package_PayClientPos(){
      //time() . mt_rand(11111111, 99999999) . date('YmdHis');

      SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
      String formatStr =formatter.format(new Date());
      Random rand = new Random();
      int rnd=rand.nextInt(99999999)+ 11111111;
      out_trade_no=gettime()+String.valueOf(rnd)+formatStr;
  }

  public  void setPrice(String _price){
      price=_price;
  }

    public  void setauth_code(String _value){
        auth_code=_value;
    }

    public  void setdevice_sn(String _value){
        device_sn=_value;
    }

  public  String gettime(){
      String dateTime;

     long time= System.currentTimeMillis();

      return String.valueOf(time/ 100000);
  }



}
