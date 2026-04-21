package CyberWinPHP.Cyber_Helper;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.os.Handler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;

import CyberWinPHP.Cyber_CPU.Cyber_Public_Var;
import CyberWinPHP.Cyber_Plus.Cyber_XMLSample;
import CyberWinPHP.Cyber_Plus.LogToFile;
import CyberWinPHP.Cyber_Plus.cyber_printer_USBPrinter;
import CyberWinPHP.cyber_printerCmdUtils_net;

public class Cyber_PrinterHelper {

    Context mContext;

    public Cyber_PrinterHelper( Context context) {

        mContext = context;
        //人脸初始


    }


    //2020-6-20 刷脸打印类型判断
    private OutputStream out = null;
    private Handler handler = null;
    private Socket s = null;

    public String print_Dishfast_FacePayOrder(String printerdata) {
        //order_detail

        try {

            Cyber_XMLSample c_xml = new Cyber_XMLSample();
          //  HashMap hm = c_xml.split(printerdata);

            HashMap<String,String> hm = c_xml.splitS(printerdata);

            Object okey = "order_detail";

            Object shopnameKEY = "shopname";
            Object order_idkey = "order_id";

            //orderid
            Object orderidkey_long = "orderid";

            String order_detail = hm.get("order_detail");
            String shopname = hm.get("shopname");
            String order_id = hm.get("order_id");
            String orderid_long = hm.get("orderid");//"91057772201909260911244804565";// hm.get(orderidkey_long);
            String order_beizhu = hm.get("beizhu");//.toString();

            String print_content_header = hm.get("print_header");//.toString();
            String print_content_body = hm.get("print_body");//.toString();
            String print_content_footer = hm.get("print_footer");//.toString();

            if (Cyber_Public_Var.cyber_default_printer_type.equals("net")) {
                byte[] cyber_printdtat;



              //  Log.d("cwpd_老打印网络-ori", "网络打印");

                String ip = Cyber_Public_Var.cyberwin_default_printer_net;
                String port = "9100";

                LogToFile.d("刷脸快餐", "ip="+ip);

               // Log.d("cwpd_print-ori", "网络打印-地址" + ip);


                cyber_printdtat = cyber_create_clientPaper_NetFaceFast(printerdata, "orderface");

                s = new Socket(ip, Integer.parseInt(port));

                LogToFile.d("刷脸快餐", "ip 链接状态="+s.isConnected());

                out = s.getOutputStream();
                out.write(cyber_printdtat);

                s.close();
                out.close();

                return "打印完成";
            }


            //兼容windows 模式
            //androi 只打印小票
            cyber_printer_USBPrinter usbPrinter = cyber_printer_USBPrinter.getInstance();
            usbPrinter.initPrinter(mContext,true);
            usbPrinter.cyber_initForPrint();
            // usbPrinter.bold(true);

            usbPrinter.setTextSize(3);
            usbPrinter.setAlign(1);
            usbPrinter.bold(true);
            usbPrinter.printTextNewLine(shopname.toString());
            usbPrinter.setAlign(0);
            usbPrinter.setTextSize(0);
            usbPrinter.printLine(1);
            usbPrinter.bold(false);
            usbPrinter.printTextNewLine("单号：" + order_id.toString());
            usbPrinter.printLine(1);

          //  usbPrinter.printTextNewLine(order_detail.toString());
            usbPrinter.printTextNewLine(print_content_header);
            //usbPrinter.printLine(3);
            usbPrinter.setTextSize(3);

            usbPrinter.printTextNewLine(print_content_body);
           // usbPrinter.printLine(1);
            usbPrinter.setTextSize(0);
            usbPrinter.printTextNewLine(print_content_footer);


            usbPrinter.printLine(1);

            usbPrinter.printTextNewLine(order_beizhu);
            usbPrinter.printLine(5);


            usbPrinter.cutPager();
            //打开钱箱
            usbPrinter.cyber_openDrawer();
            usbPrinter.close();//关闭打印
            usbPrinter.destroyPrinter();
            //destroyPrinter
            //

        }catch (Exception ex){
            LogToFile.d("Printer","打印异常"+ex.getMessage()+";追踪="+ex.getStackTrace()+ex.toString());
        }

        return "打印完成";

    }

    public byte[] cyber_create_clientPaper_NetFaceFast(String printerdata, String report_id) {


        try {


            Cyber_XMLSample c_xml = new Cyber_XMLSample();
            //  HashMap hm = c_xml.split(printerdata);

            HashMap<String,String> hm = c_xml.splitS(printerdata);

            Object okey = "order_detail_android";

            Object shopnameKEY = "shopname";
            Object order_idkey = "order_id";

            //orderid
            Object orderidkey_long = "orderid";

            String order_detail = hm.get("order_detail");
            String shopname = hm.get("shopname");
            String order_id = hm.get("order_id");
         //   String orderid_long = hm.get("orderid");//"91057772201909260911244804565";// hm.get(orderidkey_long);
       //     String order_beizhu = hm.get("beizhu");//.toString();
//
            String print_content_header = hm.get("print_header");//.toString();
            String print_content_body = hm.get("print_body");//.toString();
            String print_content_footer = hm.get("print_footer");//.toString();


            byte[] next2Line = cyber_printerCmdUtils_net.nextLine(2);
            byte[] title = shopname.toString().getBytes("gb2312");// "出餐单（午餐）**万通中心店".getBytes("gb2312");

            byte[] boldOn = cyber_printerCmdUtils_net.boldOn();
            byte[] fontSize2Big = cyber_printerCmdUtils_net.fontSizeSetBig(3);
            byte[] center = cyber_printerCmdUtils_net.alignCenter();
            byte[] Focus = ("单号：" + order_id.toString()).getBytes("gb2312");
            byte[] boldOff = cyber_printerCmdUtils_net.boldOff();
            byte[] fontSize2Small = cyber_printerCmdUtils_net.fontSizeSetSmall(3);


            boldOn = cyber_printerCmdUtils_net.boldOn();
            byte[] fontSize1Big = cyber_printerCmdUtils_net.fontSizeSetBig(2);

            byte[] priceInfo_h = print_content_header.toString().getBytes("gb2312");
            byte[] priceInfo_b = print_content_header.toString().getBytes("gb2312");
            byte[] priceInfo_f = print_content_header.toString().getBytes("gb2312");
            byte[] nextLine = cyber_printerCmdUtils_net.nextLine(1);
            boldOff = cyber_printerCmdUtils_net.boldOff();
            byte[] fontSize1Small = cyber_printerCmdUtils_net.fontSizeSetSmall(2);


            //	byte[] tips_2 = order_beizhu.getBytes("gb2312");

            //	nextLine = cyber_printerCmdUtils_net.nextLine(1);

            byte[] breakPartial = cyber_printerCmdUtils_net.feedPaperCutPartial();


            byte[][] cmdBytes_kit = {
                    title, nextLine,
                    //center, boldOn, fontSize2Big, Focus, boldOff, fontSize2Small, next2Line,
                    center, boldOn, Focus, boldOff, fontSize2Small, next2Line,
                    //nextLine,
                    //center, boldOn, boldOff, nextLine,
                    //next2Line,

                    boldOn,
                    fontSize1Big,// fontSize2Big,

                    priceInfo_h,
                    nextLine,
                    priceInfo_b,
                    nextLine,
                    priceInfo_f,
                    nextLine,

                    boldOff,
                    fontSize1Small,
                    nextLine,
                    next2Line,
                    nextLine,
                    next2Line,
                    center, nextLine,

                    breakPartial
            };
            return cyber_printerCmdUtils_net.byteMerger(cmdBytes_kit);
        } catch (Exception ex) {
            LogToFile.d("刷脸快餐", ex.getMessage());

        }
        return null;

    }

    public String print_byprintername(String report_id, String printerdata, String printername) {

        //order_detail

        try {

            Cyber_XMLSample c_xml = new Cyber_XMLSample();
            HashMap hm = c_xml.split(printerdata);
            Object okey = "order_detail";

            Object shopnameKEY = "shopname";
            Object order_idkey = "order_id";

            //orderid
            Object orderidkey_long = "orderid";

            Object order_detail = hm.get(okey);
            Object shopname = hm.get(shopnameKEY);
            Object order_id = hm.get(order_idkey);
            Object orderid_long = hm.get(orderidkey_long);//"91057772201909260911244804565";// hm.get(orderidkey_long);
            String order_beizhu = hm.get("beizhu").toString();
            if (Cyber_Public_Var.cyber_default_printer_type == "blue") {

                String print_data = "\n\n";
                print_data += shopname.toString();
                print_data += "\n";
                print_data += "单号：" + order_id.toString();
                print_data += "\n";
                print_data += "================";
                print_data += "\n";
                print_data += order_detail.toString();

                print_data += " \n\n";
                print_data += " 系统： " + orderid_long.toString();
                ;
                print_data += "\n\n\n\n";

                print_data += "  ";

                Cyber_Public_Var.mPrintContent = print_data;
                Cyber_Public_Var.mPrintContent_order_id_loong = orderid_long.toString();

                //	Cyber_Public_Var.mPrintContent_order_id_loong = orderid_long.toString();

                //	print_byprintername_blue(order_detail.toString());
                new ConnectThread(Cyber_Public_Var.mBluetoothAdapter.getRemoteDevice(Cyber_Public_Var.cyber_default_blue_address)).start();

                while (Cyber_Public_Var.cyber_default_printer_print_finish = false) {

                }


                return "打印完成";
            }

            //兼容windows 模式
            //androi 只打印小票
            cyber_printer_USBPrinter usbPrinter = cyber_printer_USBPrinter.getInstance();
            usbPrinter.initPrinter(mContext,true);
            usbPrinter.cyber_initForPrint();
            // usbPrinter.bold(true);

            usbPrinter.setTextSize(3);
            usbPrinter.setAlign(1);
            usbPrinter.bold(true);
            usbPrinter.printTextNewLine(shopname.toString());
            usbPrinter.setAlign(0);
            usbPrinter.setTextSize(0);
            usbPrinter.printLine(1);
            usbPrinter.bold(false);
            usbPrinter.printTextNewLine("单号：" + order_id.toString());
            usbPrinter.printLine(1);

            usbPrinter.printTextNewLine(order_detail.toString());
            //usbPrinter.printTextNewLine("出品员："+"");
            //usbPrinter.printBarCode(orderid_long.toString());
            usbPrinter.printLine(1);
            //	usbPrinter.printBarCode(order_id.toString());
            usbPrinter.printTextNewLine(order_beizhu);
            usbPrinter.printLine(5);


            usbPrinter.cutPager();
            //打开钱箱
            usbPrinter.cyber_openDrawer();
            usbPrinter.close();//关闭打印
            usbPrinter.destroyPrinter();
            //destroyPrinter
            //

        }catch (Exception ex){
            LogToFile.d("Printer","打印异常"+ex.getMessage()+";追踪="+ex.getStackTrace()+ex.toString());
        }

        return "打印完成";

    }
    /**
     * 连接为客户端
     */
    private class ConnectThread extends Thread {
        public ConnectThread(BluetoothDevice device) {
            try {
                Cyber_Public_Var.mmSocket = device.createRfcommSocketToServiceRecord(Cyber_Public_Var.uuid);
            } catch (IOException e) {
                LogToFile.d("蓝牙技术-雪莲", e.getMessage());
                e.printStackTrace();
            }
        }

    }

    //打印 USB
    public  static void Write_Usb(UsbDeviceConnection mUsbDeviceConnection, byte[] bytes, UsbEndpoint printerEp , int TIME_OUT){
          ;
        int b = mUsbDeviceConnection.bulkTransfer(printerEp, bytes, bytes.length, TIME_OUT);
    }

    //网络
    //蓝牙
    public static void Write_Net( OutputStream out,byte[] cyber_printdtat) {
        ;//网络
        // out = s.getOutputStream();
        try {
            out.write(cyber_printdtat);
        } catch (IOException ioex) {
            LogToFile.d("写入数据", ioex.getMessage());
        }
    }



}
