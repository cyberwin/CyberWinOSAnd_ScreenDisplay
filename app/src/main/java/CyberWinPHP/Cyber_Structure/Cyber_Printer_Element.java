package CyberWinPHP.Cyber_Structure;

//打印元素
public class Cyber_Printer_Element {
    public   int font_size; //打印字体大小
    public   boolean isBold =false;
    public int nextLine=0; //下一行
    public  boolean underline=false;

    public int alignment=1;//对其方式

    public String text="";

    //2022-3-9
    public String cwpd_type="text";//qrcode barcode text pic
    public int width=0;//宽度 用于标注图片，条码，二维码
    public int height=0;//宽度 用于标注图片，条码，二维码

    public int x=0;//宽度 用于标注图片，条码，二维码
    public int y=0;//宽度 用于标注图片，条码，二维码

    public Cyber_Printer_Element(){

    }
}
