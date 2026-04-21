package CyberWinPHP.SuperHardSysten;


import android.content.Context;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;



import com.vsmedia.appstatusbar.VSToast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

public class CommonData {
    public static final int ACTIVITY_GUIDESETTING = 37;

    public static final int ACTIVITY_REQUESTCODE_FILESELECT = 1;

    public static final int ACTIVITY_REQUESTCODE_ITEMSELECT = 2;

    public static final int ACTIVITY_REQUESTCODE_VADURATION = 3;
/*
    public static final int ACTIVITY_RESULTCODE_ADD_ITEM_AUDIO = 1002;

    public static final int ACTIVITY_RESULTCODE_ADD_ITEM_BG = 1000;

    public static final int ACTIVITY_RESULTCODE_ADD_ITEM_FLASH = 1004;

    public static final int ACTIVITY_RESULTCODE_ADD_ITEM_FLASH_WV = 1007;

    public static final int ACTIVITY_RESULTCODE_ADD_ITEM_IMG = 1001;

    public static final int ACTIVITY_RESULTCODE_ADD_ITEM_IMGLOGO = 1008;

    public static final int ACTIVITY_RESULTCODE_ADD_ITEM_TEXTTIMER = 1005;

    public static final int ACTIVITY_RESULTCODE_ADD_ITEM_TEXTVIEW = 1006;

    public static final int ACTIVITY_RESULTCODE_ADD_ITEM_VIDEO = 1003;

    public static final int ACTIVITY_RESULTCODE_AUTOADD_RESOUCE_CANCEL = 16;

    public static final int ACTIVITY_RESULTCODE_AUTOADD_RESOUCE_OK = 15;

    public static final int ACTIVITY_RESULTCODE_CANCEL = 1;

    public static final int ACTIVITY_RESULTCODE_DEVBOXSELECT_OK = 14;

    public static final int ACTIVITY_RESULTCODE_DOWNTEMPLATE = 33;

    public static final int ACTIVITY_RESULTCODE_EDITDEVINFO_CANCEL = 8;

    public static final int ACTIVITY_RESULTCODE_EDITDEVINFO_OK = 9;

    public static final int ACTIVITY_RESULTCODE_FILESELECT_CANCEL = 3;

    public static final int ACTIVITY_RESULTCODE_FILESELECT_OK = 2;

    public static final int ACTIVITY_RESULTCODE_ForumAddItem_CANCEL = 25;

    public static final int ACTIVITY_RESULTCODE_ForumAddItem_OK = 24;

    public static final int ACTIVITY_RESULTCODE_ForumCloseItem_CANCEL = 28;

    public static final int ACTIVITY_RESULTCODE_ForumCloseItem_OK = 29;

    public static final int ACTIVITY_RESULTCODE_Forum_Response_CANCEL = 27;

    public static final int ACTIVITY_RESULTCODE_Forum_Response_OK = 26;

    public static final int ACTIVITY_RESULTCODE_IMAGEEDIT_OK = 35;

    public static final int ACTIVITY_RESULTCODE_ITEMSELECT_CANCEL = 5;

    public static final int ACTIVITY_RESULTCODE_ITEMSELECT_OK = 4;

    public static final int ACTIVITY_RESULTCODE_MAINUSERINFO_CANCEL = 30;

    public static final int ACTIVITY_RESULTCODE_MAINUSERINFO_OK = 31;

    public static final int ACTIVITY_RESULTCODE_NOT_DOWNTEMPLATE = 34;

    public static final int ACTIVITY_RESULTCODE_PKGCREATE_CANCEL = 7;

    public static final int ACTIVITY_RESULTCODE_PKGCREATE_OK = 6;

    public static final int ACTIVITY_RESULTCODE_PROGRAMCTRL_OK = 13;

    public static final int ACTIVITY_RESULTCODE_QRCSCAN_CANCEL = 21;

    public static final int ACTIVITY_RESULTCODE_QRCSCAN_INVALID = 23;

    public static final int ACTIVITY_RESULTCODE_QRCSCAN_OK = 22;

    public static final int ACTIVITY_RESULTCODE_QUERYDURATION_FAILED = 11;

    public static final int ACTIVITY_RESULTCODE_QUERYDURATION_SUCCESS = 10;

    public static final int ACTIVITY_RESULTCODE_RESOURCESELECT_OK = 12;

    public static int APKversion = 0;

    public static String AccessServer;

    public static String Administrator;

    public static boolean AllwinScreenStatus = false;

    public static String AlonePwd;

    public static int AloneScreen2 = 0;

    public static int And_boxs_id = 0;

    public static final String And_boxs_levelStr = "00000000000000000001";

    public static ArrayList<DownItem> Apklist;

    public static String Appdir;

    public static int AutoRebootTime = 0;

    public static int AutoRebootWeek = 0;

    public static final String BILLSDETAIL = "BILLSDETAIL";

    public static final String BILLSTYPE = "BILLSTYPE";

    public static int Batterylevel = 0;

    public static final int CMD_STATUS_NORECEIVE = 1;

    public static final int CMD_STATUS_NOSEND = 0;

    public static final int CMD_STATUS_RECEIVED = 2;

    public static int ChargingPort = 0;

    public static String ChargingSerial;

    public static int CheckPwd = 0;

    public static String City;

    public static boolean CopyFile2HTTPDIR = false;

    public static int CtrlIO = 0;

    public static int CurPageIndex = 0;

    public static boolean Debug_devtype_3d_Screen_mode = false;

    public static boolean Debug_devtype_park_mode = false;

    public static boolean Debug_devtype_people = false;

    public static boolean Debug_devtype_uart_mode = false;

    public static boolean Debug_devtype_voice_mode = false;

    public static int DelayOneHour = 0;

    public static String DevStartPrefix;

    public static int DevType = 0;

    public static ArrayList<DownItem> DownOtherlist;

    public static ArrayList<AdcBaseObject> Downlist;

    public static boolean ENABLE_Obsevable = false;

    public static boolean ENABLE_ZCP_HOST = false;

    public static boolean ENABLE_loginServer = false;

    public static boolean EnableDBWebView = false;

    public static boolean EnableLoadTime = false;

    public static boolean Enable_Error_SignCheck = false;

    public static boolean Enable_delGIPIRecord = false;

    public static String EnvConfig;

    public static int EnvPort = 0;

    public static String EnvSerial;

    public static String ErrorLogName;

    public static final String FILEPAHT_RES_CONFIG = "ptx/config/";

    public static String FILEPATH_MAINSTORAGE;

    public static final String FILEPATH_RES_AUDIO = "ptx/files/audio/";

    public static final String FILEPATH_RES_DATA = "ptx/files/data/";

    public static final String FILEPATH_RES_IMAGE = "ptx/files/image/";

    public static final String FILEPATH_RES_TEMDIR = "/mnt/sdcard/tempdir/";

    public static final String FILEPATH_RES_TEMDIR_DOWNLOAD = "/mnt/sdcard/tempdir/download";

    public static final String FILEPATH_RES_VIDEO = "ptx/files/video/";

    public static ArrayList<String> FILEPATH_SDLIST;

    public static String FILE_DB_ZCP;

    public static String FILE_DB_ZCP_PATH;

    public static String FILE_DOWNLOAD_PATH;

    public static String FILE_RES_DIR;

    public static String FILE_RES_Thumbnail_DIR;

    public static String FILE_RES_UPDATEDOWN_PATH;

    public static boolean FILE_SWF_FORCE_UPDATE = false;

    public static String FILE_SWF_PATH;

    public static String FILE_SWF_VERSION;

    public static String FILE_TEMPLATE_CACHE_PATH;

    public static String FILE_TEMPLATE_EDITMODE_PATH;

    public static String FILE_TEMPLATE_PATH;

    public static final int FM_FILETYPE_AUDIO = 3;

    public static final int FM_FILETYPE_BACKGROUND = 1;

    public static final String[] FM_FILETYPE_DESC = new String[] { "背景", "图片", "音频", "视频", "flash" };

    public static final int FM_FILETYPE_FLASH = 5;

    public static final int FM_FILETYPE_IMG = 2;

    public static final int FM_FILETYPE_VIDEO = 4;

    public static String FileManager_Path_Last;

    public static String HLDIR;

    public static int ImgEffect = 0;

    public static int ImgModeStyle = 0;

    public static boolean IsMissfile = false;

    public static String LogDir;

    public static String LoginServerAddr;

    public static int MOUNTED_SD = 0;

    public static final String MainConfig = "MainConfig.ini";

    public static String Main_Poster_path;

    public static int MarqueFrontSize = 0;

    public static String NetIp;

    public static int NetType = 0;

    public static boolean ObjRun = false;

    public static final int PKG_EDITMODE_ADVANCE_EDITCHANGE = 4;

    public static final int PKG_EDITMODE_ADVANCE_NEWBUILDER = 2;

    public static final int PKG_EDITMODE_EDITCHANGE = 3;

    public static final int PKG_EDITMODE_NEWBUILD = 1;

    public static boolean PM_CHECK_STOCK_IO = false;

    public static boolean PM_OUTOFSTOCK = false;

    public static String PM_QRCODE_HEAD_SLOGAN;

    public static float PM_QRCODE_X = 0.0F;

    public static float PM_QRCODE_Y = 0.0F;

    public static int ParkingType = 0;

    public static String PeopleSign;

    public static String PlayLogo;

    public static String PwdType;

    public static final int Res_PKG_ID = 3;

    public static final String Res_PKG_levelStr = "00000000000000000003";

    public static String Resdir;

    public static final int Resources_Objecttype = 4;

    public static final int Resources_id = 2;

    public static final String Resources_levelStr = "00000000000000000002";

    public static String Respath;

    public static long SD_SIZE_LEVEL_0 = 0L;

    public static long SD_SIZE_LEVEL_1 = 0L;

    public static String SN;

    public static int SaveType = 0;

    public static NetUDP SearchHostUDP;

    public static boolean ShowStorageInfo = false;

    public static ArrayList<String> SubScreenlist;

    public static String SupportAPPVersion;

    public static String SyslogDir;

    public static final int TABACTIVITY_DEVBOXBACK = 32;

    public static final int TABACTIVITY_DataSetChanged = 20;

    public static final int TABACTIVITY_PageBack = 19;

    public static final int TABACTIVITY_ResEditObjActivity_LOADDATA = 17;

    public static final int TABACTIVITY_SingleDevManagerActivity_back = 18;

    public static final int TABACTIVITY_SingleDevManagerActivity_back_DelDev = 36;

    public static String TQDIR;

    public static int UartPort = 0;

    public static String UartSerial;

    public static String UpdataApkStr;

    public static String UsbDisk;

    public static ArrayList<USBitem> UsbMedialist;

    public static ArrayList<String> UsbScreenMusiclist;

    public static ArrayList<String> UsbScreenTextlist;

    public static ArrayList<ArrayList<String>> UsbScreenlist;

    public static String User_Agent;

    public static String User_DeviceID;

    public static String User_Mac;

    public static String User_Ver;

    public static String VistarMediaUrl;

    public static int VocPort = 0;

    public static String VocSerial;

    public static int VoicePort = 0;

    public static String VoiceSerial;

    public static float VoiceValue = 0.0F;

    public static String WMP_APP_DOMAIN;

    public static String WMP_APP_ID;

    public static boolean WMP_PM_QRCODE_FIRST_LOAD = false;

    public static final String WMP_QRCODEURL_FORMAT = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=WMP_APP_ID&redirect_uri=http%3A%2F%2FWMP_APP_DOMAIN%2Fadc%2Fwx_service%2Fwmp_adcloud_enter_to&response_type=code&scope=WMP_SNSAPI_SOCPE&state=WMP_APP_ID_WMP_APP_DEVMAC_0^MTSTARSCENEID&connect_redirect=1#wechat_redirect";

    public static String WMP_SNS_SCOPE;

    public static int WifiPostDelay = 0;

    public static ADCDateTimeUtil adt;

    public static final String advSettingJson = "{\"Setting\":[{\"img\":\"10\",\"name\":\"定时开关机\",\"status\":\"\"},{\"img\":\"11\",\"name\":\"单机播放\",\"status\":\"\"},{\"img\":\"12\",\"name\":\"横竖屏\",\"status\":\"\"},{\"img\":\"13\",\"name\":\"存储\",\"status\":\"\"},{\"img\":\"14\",\"name\":\"同步播放\",\"status\":\"\"},{\"img\":\"15\",\"name\":\"局域网转发\",\"status\":\"\"},{\"img\":\"16\",\"name\":\"音量\",\"status\":\"\"}]}";

    public static final String advSettingJson_en = "{\"Setting\":[{\"img\":\"10\",\"name\":\"Timing\",\"status\":\"\"},{\"img\":\"11\",\"name\":\"standalone\",\"status\":\"\"},{\"img\":\"12\",\"name\":\"Orientation\",\"status\":\"\"},{\"img\":\"13\",\"name\":\"Storage\",\"status\":\"\"},{\"img\":\"14\",\"name\":\"SyncPlay\",\"status\":\"\"},{\"img\":\"15\",\"name\":\"transfer\",\"status\":\"\"},{\"img\":\"16\",\"name\":\"other\",\"status\":\"\"}]}";

    public static String advert_3rd_ad_id;

    public static int alarmduration = 0;

    public static long alltotal = 0L;

    public static String aloneConfig;

    public static String appcfg_id;

    public static String appcfg_name;

    public static String auto_disinfection;

    public static int auto_disinfection_duration = 0;

    public static boolean auto_kaiji = false;

    public static boolean bLcdOffDelay = false;

    public static JSONArray backup_posturl;

    public static final String barScreenbaseSettingJson = "{\"Setting\":[{\"img\":\"0\",\"name\":\"快速设置\",\"status\":\"\"},{\"img\":\"1\",\"name\":\"设备状态\",\"status\":\"\"}]}";

    public static final String barScreenbaseSettingJson_en = "{\"Setting\":[{\"img\":\"0\",\"name\":\"Quick setup\",\"status\":\"\"},{\"img\":\"1\",\"name\":\"Device Status\",\"status\":\"\"}]}";

    public static final String baseSettingJson = "{\"Setting\":[{\"img\":\"0\",\"name\":\"快速设置\",\"status\":\"\"},{\"img\":\"1\",\"name\":\"设备状态\",\"status\":\"\"},{\"img\":\"2\",\"name\":\"网络连接\",\"status\":\"\"},{\"img\":\"2\",\"name\":\"帮助\",\"status\":\"\"}]}";

    public static final String baseSettingJson_en = "{\"Setting\":[{\"img\":\"0\",\"name\":\"Quick setup\",\"status\":\"\"},{\"img\":\"1\",\"name\":\"Device Status\",\"status\":\"\"},{\"img\":\"2\",\"name\":\"Net\",\"status\":\"\"},{\"img\":\"3\",\"name\":\"HELP\",\"status\":\"\"}]}";

    public static String boardModel;

    public static String boot;

    public static String bootDelay;

    public static int boot_time_on = 0;

    public static String cDir;

    public static String c_apkname;

    public static int callNumVolume = 0;

    public static int cameraModel = 0;

    public static boolean cameraRecord = false;

    public static boolean canlogin = false;

    public static int canplay = 0;

    public static Long cbFinishProgram;

    //public static ArrayList<AdcPlayPlanPublish> cbplaylist;

    public static String cdnreqid;

    public static String cfgApkVersion;

    public static int cfgversion = 0;

    public static int change = 0;

    public static boolean changeServer = false;

    public static int changeServerErrorCount = 0;

    public static String change_name;

    public static int checktime = 0;

    public static boolean checkwifi = false;

    public static int clientcount = 0;

    public static String coder_deviceid;

    public static String config;

    public static String config2;

    public static String config3;

    public static String config4;

    public static String config_elevator;

    public static String continueconfig;

    public static int countday = 0;

    public static String cpuid;

    public static AdcPlayExecute curplay;

    public static int currentQRCodeType = 0;

    public static int currentfind = 0;

    public static int currentzhaoshangindex = 0;

    public static int cycle_mode = 0;

    public static String datetime;

    public static String db_cMark;

    public static String db_sdcardDir;

    public static String dbpath;

    public static String dbpath_dir;

    public static String dbzippath;

    public static boolean debug = false;

    public static boolean debugZcBoard = false;

    public static boolean debug_devtype_Environment = false;

    public static boolean debug_devtype_charge_mode = false;

    public static boolean debug_devtype_face_mode = false;

    public static boolean debug_devtype_fueling = false;

    public static boolean debug_devtype_mode = false;

    public static String debugfile;

    public static String defaultDIR;

    public static String defaultDevicecode;

    public static String defaultMainJpg;

    public static String defaultserverAddr;

    public static String defaultserverPort;

    public static String defaultusbJson;

    public static String defaultworktype;

    public static String degree;

    public static int delay = 0;

    public static int delayFinishProgram = 0;

    public static int delayFinishProgram_sub = 0;

    public static int delaySetupTime = 0;

    public static boolean delayinit = false;

    public static int delayinit_count = 0;

    public static int delayuploadTimes = 0;

    public static Handler devHandler;

    public static String dev_name;

    public static String devicecode;

    public static String devmac;

    public static String devmac_true;

    public static int disStyle = 0;

    public static String dis_devicecode;

    public static String dis_serverAddr;

    public static String dis_serverPort;

    public static Boolean dis_update;

    public static int disfloatwindow = 0;

    public static int displayLogo = 0;

    public static final boolean do_sync_system_form_server = true;

    public static int downCount = 0;

    public static int downSpeed = 0;

    public static String downSpeed_endtime;

    public static String downSpeend_endtime2;

    public static int downStatus = 0;

    public static boolean downing = false;

    public static String downloadpath;

    public static String downmsg;

    public static long downtotal = 0L;

    public static boolean enable_template_test_xgx = false;

    public static boolean errorstatus = false;

    public static String errortime;

    public static EthernetItem ethernetItem;

    public static String extSdDir;

    public static String fDir;

    public static String faceConfig;

    public static String faceHeight;

    public static String faceWidth;

    public static boolean face_img_del = false;

    public static boolean faceinit = false;

    public static int faceinitCount = 0;

    public static boolean faceuploadinit = false;

    public static String fileDir;

    public static int fileVersion = 0;

    public static String filedir;

    public static String fileswfpath;

    public static long filterChangeHour = 0L;

    public static boolean finding = false;

    public static boolean findingSub = false;

    public static long findingSubScreenTime = 0L;

    public static int fixed_serverIp = 0;

    public static Long freeSize;

    public static String gameJson;

    public static long gameTime = 0L;

    public static int gamevolume = 0;

    public static String googleTTs;

    public static Handler handler;

    public static boolean hasFaceHardware = false;

    public static long heart3rdTime = 0L;

    public static int height = 0;

    public static String his_ip;

    public static int his_port = 0;

    public static String iflyTTS;

    //public static ImageLoader imageLoader;

    public static int installNum = 0;

    public static boolean isAlonePlay = false;

    public static int isAloneUsePwd = 0;

    public static boolean isAppExit = false;

    public static int isAutoReboot = 0;

    public static boolean isBarScreen = false;

    public static boolean isCdnChangeBit = false;

    public static boolean isCdnDown = false;

    public static boolean isCirclePlay = false;

    public static boolean isContinuePlay = false;

    public static boolean isCopyOldConfig = false;

    public static boolean isDisRealMODEL = false;

    public static boolean isDisplayQRCode = false;

    public static boolean isGameLock = false;

    public static boolean isInstall = false;

    public static int isInstallServices = 0;

    public static String isNeedNewLoginQRCode;

    public static boolean isRegist = false;

    public static boolean isRestorePlay = false;

    public static boolean isTouchImg_fullscreen = false;

    public static boolean isUseGame = false;

    public static boolean isUseGameTime = false;

    public static String isUsePwd;

    public static boolean isUseVs6Name = false;

    public static boolean is_release_version = false;

    public static int is_subscreen_mode = 0;

    public static boolean isfirst = false;

    public static boolean ishdrSupport = false;

    public static boolean island = false;

    public static int islinkPlay = 0;

    public static boolean isswitchprogram = false;

    public static int iszcboard = 0;

    public static boolean iszyboard = false;

    public static String item_url_prefix_variable;

    public static String lastUsbmode;

    public static int lastbatterystatus = 0;

    public static String lastfaceTime;

    public static String lastfaceWatchTime;

    public static String lastfacename;

    public static String lastreal;

    public static double latitude = 0.0D;

    public static String lcd_onoff_cfg;

    //public static LcdOnoffCustomTime.LCDTimeTool lcdonoffTimeTool;

    public static int level_4G = 0;

    public static int level_WIFI = 0;

    public static int lian = 0;

    public static int linkIO = 0;

    public static int linkPlayDefault = 0;

    public static int linkPlayType = 0;

    public static int linkTigger = 0;

    public static String link_alarm;

    public static int link_delay_recovery = 0;

    public static String link_recovery;

    public static int link_replay = 0;

    public static boolean localReStart = false;

    public static int localReStartCount = 0;

    public static String login_key;

    public static double longitude = 0.0D;

    //public static AdcProgramInfo mProgram;

    public static int m_ScreenHeight = 0;

    public static int m_ScreenHeight2 = 0;

    public static int m_ScreenHeight3 = 0;

    public static int m_ScreenHeightoffset = 0;

    public static int m_ScreenWidth = 0;

    public static int m_ScreenWidth2 = 0;

    public static int m_ScreenWidth3 = 0;

  //  public static MainMsgDo mainMsgDo;

    public static String mainjpg;

    public static String mainjpg1;

    public static String mapX;

    public static String mapY;

    public static String mapjson;

    public static String mapstr;

    public static int marquepos = 0;

    public static int mat_play_stat = 0;

    public static int matplaystat_up_interval = 0;

    public static int max_volume = 0;

    public static String mc;

    public static ArrayList<String> medialist;

    public static String msgMapInfo;

   // public static ArrayList<AdcMsgTask> msglist;

    public static boolean msglistLock = false;

    public static String musicusb_Type;

    public static final int nDEVICETYPE_Res_PKG_common = 2;

    public static final int nDEVICETYPE_Res_PKG_template = 3;

    public static final int nOBJECTTYPE_Res_AUDIO = 6;

    public static final int nOBJECTTYPE_Res_ActivityDEV = 26;

    public static final int nOBJECTTYPE_Res_AndBox = 18;

    public static final int nOBJECTTYPE_Res_BACKGROUND = 5;

    public static final int nOBJECTTYPE_Res_COMMONPKG = 15;

    public static final int nOBJECTTYPE_Res_DEVBOXAPKVER = 20;

    public static final int nOBJECTTYPE_Res_DEVBOXSHUTDOWNSCHD = 21;

    public static final int nOBJECTTYPE_Res_FLASH = 10;

    public static final int nOBJECTTYPE_Res_H5TEMPLATE = 31;

    public static final int nOBJECTTYPE_Res_H5TEMPLATEPKG = 30;

    public static final int nOBJECTTYPE_Res_IMG = 8;

    public static final int nOBJECTTYPE_Res_LOGO = 29;

    public static final int nOBJECTTYPE_Res_PKG = 17;

    public static final int nOBJECTTYPE_Res_PKGTEMPLATE = 19;

    public static final int nOBJECTTYPE_Res_PKGTEMPLATE_ADVANCE = 24;

    public static final int nOBJECTTYPE_Res_PlaySchedule = 28;

    public static final int nOBJECTTYPE_Res_SystemAPKVER = 27;

    public static final int nOBJECTTYPE_Res_TEXT = 9;

    public static final int nOBJECTTYPE_Res_TEXTTIMER = 22;

    public static final int nOBJECTTYPE_Res_TEXTVIEW = 23;

    public static final int nOBJECTTYPE_Res_VIDEO = 7;

    public static final int nOBJECTTYPE_Res_WIFIHOTPOINT = 25;

    public static boolean needMapInfo = false;

    public static boolean needuploadPlayCount = false;

    public static String netConfig;

    public static final String netSettingJson = "{\"Setting\":[{\"img\":\"30\",\"name\":\"WIFI设置\",\"status\":\"\"},{\"img\":\"31\",\"name\":\"以太网设置\",\"status\":\"\"}]}";

    public static final String netSettingJson_en = "{\"Setting\":[{\"img\":\"30\",\"name\":\"WIFI\",\"status\":\"\"},{\"img\":\"31\",\"name\":\"eth\",\"status\":\"\"}]}";

    public static String network;

    public static String newcblist;

    public static String newdplist;

    public static String newplaylist;

    public static String newsendkey;

    public static String newtimelist;

    public static int noiseCeiling = 0;

    public static String noisealarm;

    public static boolean nosendmsg = false;

    public static String novideoDir;

    public static String offDir;

    public static int offlineLimit = 0;

    public static int offlineRebootTime = 0;

    public static int offlinecount = 0;

    public static long offlinetime = 0L;

    public static String oldconfig;

    public static String oldconfig1;

    public static String oldsaveDIR;

    public static boolean online = false;

    public static boolean overSea = false;

    public static String packname;

    public static int paperMachineTime = 1030;

    public static String peopleAccessCode;

    public static String peoplePort;

    public static float peopleRealCore = 0.0F;

    public static String peopleServer;

    public static String pid;

    public static ArrayList<AdcBaseObject> planlist;

    public static String playDir;

    public static int playEffect = 0;

    public static ArrayList<String> playJsonlist;

    public static int playModeStyle = 0;

    public static String playPath;

    public static String playScheduleStr;

    public static String playStylePath;

    public static String playTextPath;

    public static int playThreeAD = 0;

    public static int playdefault = 0;

   // public static ArrayList<AdcBaseObject> playlist;

    public static String playscheduleCfg;

    public static int playstatus = 0;

    public static int pm25_thres = 0;

    public static int pm25_thres_L1 = 0;

    public static int pm25_thres_L2 = 0;

    public static int pm25_thres_L3 = 0;

    public static String pm_wmp_qrcodeurl;

    public static int postDelay = 0;

    public static int postErrorLimit = 0;

    public static int postIndex = 0;

    public static String posturl;

    public static boolean printdebugLog = false;

    public static String programId;

    private static int projecttype = 0;

    //public static ArrayList<AdcPlayPlanPublish> protocolList;

    public static String pwd;

    public static int qrcodeXY = 0;

    public static int qrcodedis = 0;

    public static int qrcodetype = 0;

    public static String qrcodeurl;

    public static boolean queryDevRight = false;

    public static boolean reOpenHdmi = false;

    public static int reboot_free_count_max = 0;

    public static int reboot_free_max_tick = 0;

    public static int reboot_free_min_tick = 0;

    public static String reg_qrcodeurl_fmt;

    public static int remote_qrcode = 0;

    public static String remote_qrcode_url;

    public static boolean resetServer_need_upMapInfo = false;

    public static boolean runThread = false;

    public static int runtype = 0;

    public static String sDoubleClickUpdateTxt;

    public static final String sOBJECTTYPE_Res_AUDIO = "音频";

    public static final String sOBJECTTYPE_Res_ActivityDEV = "Activite";

    public static final String sOBJECTTYPE_Res_AndBox = "终端设备";

    public static final String sOBJECTTYPE_Res_BACKGROUND = "背景";

    public static final String sOBJECTTYPE_Res_COMMONPKG = "节目包";

    public static final String sOBJECTTYPE_Res_DEVBOXAPKVER = "终端apk版本";

    public static final String sOBJECTTYPE_Res_DEVBOXSHUTDOWNSCHD = "开关机计划";

    public static final String sOBJECTTYPE_Res_FLASH = "时钟";

    public static final String sOBJECTTYPE_Res_H5TEMPLATE = "模板";

    public static final String sOBJECTTYPE_Res_H5TEMPLATEPKG = "模板节目";

    public static final String sOBJECTTYPE_Res_IMG = "图片";

    public static final String sOBJECTTYPE_Res_LOGO = "LOGO";

    public static final String sOBJECTTYPE_Res_PKG = "节目包";

    public static final String sOBJECTTYPE_Res_PKGTEMPLATE = "包模板";

    public static final String sOBJECTTYPE_Res_PKGTEMPLATE_ADVANCE = "高级模式";

    public static final String sOBJECTTYPE_Res_PlaySchedule = "播放计划";

    public static final String sOBJECTTYPE_Res_SystemAPKVER = "sysAppVersion";

    public static final String sOBJECTTYPE_Res_TEXT = "文本";

    public static final String sOBJECTTYPE_Res_TEXTTIMER = "文本时间";

    public static final String sOBJECTTYPE_Res_TEXTVIEW = "文本字幕";

    public static final String sOBJECTTYPE_Res_VIDEO = "视频";

    public static final String sOBJECTTYPE_Res_WIFIHOTPOINT = "WIFI热点";

    public static final String sResources_Objecttype = "素材";

    public static String saveDIR;

    public static boolean savephoto = false;

    public static String screen2;

    public static String screen2rotation;

    public static boolean screen_img_del = false;

    public static String screenfailjpg;

    public static String screentempDir;

    public static String sdcardDir;

    public static String sdcardTemp;

    public static String secusbJson;

   // public static ArrayList<AdcMsg> sendmsglist;

    public static String serialConfig;

    public static String serverAddr;

    public static String serverPort;

    public static boolean setSetting = false;

    public static String setboot;
    */

    public static Handler shandler;

    public static boolean showServicesWaring = false;

    public static boolean showStatusBar = false;

    public static boolean showdebuginfo = false;

    public static boolean startup = false;

    public static String stroge;

    public static boolean subscreen_program_exists = false;

    public static int syncBaute = 0;

    public static ArrayList<String> syncList;

    public static int syncMode = 0;

    public static int syncMode_subscreen = 0;

    public static String syncSerial;

    public static int syncStyle = 0;

    public static boolean sync_program_audio_priority = false;

    public static boolean sync_program_video_priority = false;

    public static boolean sync_program_video_priority_permit_send_syncmsg = false;

    public static final String sysSettingJson = "{\"Setting\":[{\"img\":\"20\",\"name\":\"菜单语言\",\"status\":\"\"},{\"img\":\"21\",\"name\":\"开机启动\",\"status\":\"未设置\"},{\"img\":\"22\",\"name\":\"系统安全\",\"status\":\"未设置\"},{\"img\":\"23\",\"name\":\"系统重置\",\"status\":\"\"},{\"img\":\"24\",\"name\":\"软件版本\",\"status\":\"\"}]}";

    public static final String sysSettingJson_en = "{\"Setting\":[{\"img\":\"20\",\"name\":\"Audio Volume\",\"status\":\"\"},{\"img\":\"21\",\"name\":\"power\",\"status\":\"empty\"},{\"img\":\"22\",\"name\":\"security\",\"status\":\"empty\"},{\"img\":\"23\",\"name\":\"sys reset\",\"status\":\"\"},{\"img\":\"24\",\"name\":\"software ver\",\"status\":\"\"}]}";

    public static String tDir;

    public static TimerTask task;

    public static HashSet<AsyncTask> taskCollection;

    public static String tempDir;

    public static String templateDir;

    public static String template_Path;

    public static String template_Path_em;

    public static String template_cache_Path;

    public static ArrayList<String> templatelist;

   // public static ArrayList<DownItem> templist;

    public static String tempwd;

    public static boolean test;

    public static boolean testdownspeed;

   // public static ArrayList<ThreeDownItem> threeMediaItemlist;

   // public static ArrayList<ThreeDownItem> threeMedialist;

   // public static ArrayList<ThreeDownItem> threeMediaplaylist;

    //public static ArrayList<ThreeDownItem> threeMtstarProtocolList;

    public static int threeplayindex;

    public static long threeplayinterval;

   // public static ArrayList<AdcBaseObject> threeplaylist;

    public static long threeplaytime;

    public static String thumbnailpath;

   // public static CustomTime.TimeTool timeTool;

    public static Timer timer;

    public static String timing;

    public static String timing_stime;

    public static long tmppwdtime;

    public static String trackerurl;

    public static String transferAddr;

    public static String transferApName;

    public static String transferApPsw;

    public static String transferParam;

    public static String transferServer;

    public static String transferType;

    public static String txtusb_bgcolor;

    public static String txtusb_color;

    public static String txtusb_fontsize;

    public static String txtusb_movespeed;

    public static String txtusb_movetype;

    public static String txtusb_transparent;

    public static String uDir;

    public static String uid;

    public static String updateDir;

    private static String updateServerAddr;

    private static String updateServerAddr_debug;

    public static String update_downPath;

    public static boolean updateapk;

    public static String upload_faceimg_trd;

    public static int usbDatecolor;

    public static String usbDatehour24;

    public static int usbDatepos;

    public static int usbDatesize;

    public static String usbImgTime;

    public static String usbJson;

    public static String usbShowDate;

    public static String usbShowDevice;

    public static String usbShowTime;

    public static int usbSource;

    public static String usbmode;

    public static String usbmode_subscreen;

    public static String useUsb_Music;

    public static String useUsb_Text;

    public static boolean useWorkTime;

    public static int userchange;

    public static ArrayList<String> validmedialist;

    public static ArrayList<String> validprogramlist;

    public static String version;

    public static String version_code;

    public static String version_id;

    public static int version_mode;

    public static String version_prefix;

    public static String version_str;

    public static int videoLevel;

    public static float voc_thres;

    public static float voc_thres_L1;

    public static float voc_thres_L2;

    public static float voc_thres_L3;

    public static int volume;

    public static String volume_task;

    //public static VSStatusObservable vsObsevable;

    public static VSToast vsToast;

    public static String weather;

    public static int width;

    public static Handler wifiHandler;

    public static String wifiProgramIp;

    public static int wifiStatus;

    public static long workCloseTime;

    public static long workOffsetTime;

    public static String worktime_ON_OFF_SCREEN;

    public static String worktime_str;

    public static String worktype;

    public static int xiansu;

    public static String zcfile;

    //public static ZCcloudDataHelper zcpdb;

    public static int zhaoshang;

    public static int zhaoshangcount;

    public static int zhaoshangindex;

    static {
        /*
        needuploadPlayCount = true;
        delayuploadTimes = 60;
        degree = "0";
        faceWidth = "640";
        faceHeight = "480";
        setSetting = false;
        defaultusbJson = "{\"elementcount\":\"1\",\"scenename\":\"单机模板_usb\",\"scenetime\":\"10\",\"width\":910,\"height\":512,\"scalewidth\":\"16\",\"scaleheight\":\"9\",\"backcolor\":\"#ffffff\",\"second_screen_orientation\":\"0\",\"datalist\":[{\"id\":\"mixed_1\",\"class\":\"element mixed ui-draggable ui-draggable-handle ui-resizable\",\"title\":\"\",\"from\":\"wmp_video_img_edit\",\"style\":\"usb\",\"x\":0,\"y\":0,\"width\":910,\"height\":512,\"delay\":\"5\",\"curimglist\":[{\"type\":\"img\",\"itemType\":0,\"src\":\"http://mtstar.68ip.net:6080/adc/i/20190523/_1558609741427652573793@78@77@000001.png\",\"source\":\"http://mtstar.68ip.net:6080/adc/i/20190523/1558609741427652573793@78@77@000001.jpg\",\"name\":\"管理员-图片\",\"long\":\"5\",\"attrid\":\"1558609741427509835716@78@77@000001\",\"mh\":311,\"resolution\":\"1152x482\",\"fileSize\":\"42499\"}],\"imgsrc\":\"http://mtstar.68ip.net:6080/adc/i/20190523/_1558609741427652573793@78@77@000001.png\"}]}";
        usbJson = "{\"elementcount\":\"1\",\"scenename\":\"单机模板_usb\",\"scenetime\":\"10\",\"width\":910,\"height\":512,\"scalewidth\":\"16\",\"scaleheight\":\"9\",\"backcolor\":\"#ffffff\",\"second_screen_orientation\":\"0\",\"datalist\":[{\"id\":\"mixed_1\",\"class\":\"element mixed ui-draggable ui-draggable-handle ui-resizable\",\"title\":\"\",\"from\":\"wmp_video_img_edit\",\"style\":\"usb\",\"x\":0,\"y\":0,\"width\":910,\"height\":512,\"delay\":\"5\",\"curimglist\":[{\"type\":\"img\",\"itemType\":0,\"src\":\"http://mtstar.68ip.net:6080/adc/i/20190523/_1558609741427652573793@78@77@000001.png\",\"source\":\"http://mtstar.68ip.net:6080/adc/i/20190523/1558609741427652573793@78@77@000001.jpg\",\"name\":\"管理员-图片\",\"long\":\"5\",\"attrid\":\"1558609741427509835716@78@77@000001\",\"mh\":311,\"resolution\":\"1152x482\",\"fileSize\":\"42499\"}],\"imgsrc\":\"http://mtstar.68ip.net:6080/adc/i/20190523/_1558609741427652573793@78@77@000001.png\"}]}";
        secusbJson = "{\"elementcount\":\"1\",\"scenename\":\"单机模板_usb\",\"scenetime\":\"10\",\"width\":910,\"height\":512,\"scalewidth\":\"16\",\"scaleheight\":\"9\",\"backcolor\":\"#ffffff\",\"second_screen_orientation\":\"0\",\"datalist\":[{\"id\":\"mixed_1\",\"class\":\"element mixed ui-draggable ui-draggable-handle ui-resizable\",\"title\":\"\",\"from\":\"wmp_video_img_edit\",\"style\":\"usb\",\"x\":0,\"y\":0,\"width\":910,\"height\":512,\"delay\":\"5\",\"curimglist\":[{\"type\":\"img\",\"itemType\":0,\"src\":\"http://mtstar.68ip.net:6080/adc/i/20190523/_1558609741427652573793@78@77@000001.png\",\"source\":\"http://mtstar.68ip.net:6080/adc/i/20190523/1558609741427652573793@78@77@000001.jpg\",\"name\":\"管理员-图片\",\"long\":\"5\",\"attrid\":\"1558609741427509835716@78@77@000001\",\"mh\":311,\"resolution\":\"1152x482\",\"fileSize\":\"42499\"}],\"imgsrc\":\"http://mtstar.68ip.net:6080/adc/i/20190523/_1558609741427652573793@78@77@000001.png\"}]}";
        gameJson = "{\"elementcount\":\"1\",\"scenename\":\"全屏网页\",\"itemId\":\"1653632777329517708680@25537@77@000001\",\"bsdm\":\"0\",\"second_screen_orientation\":\"0\",\"scalewidth_snd\":\"16\",\"scaleheight_snd\":\"9\",\"scenetime\":\"36000\",\"scenetime_ms\":\"36000000\",\"scenetime_ms_compensation\":\"36000000\",\"scenetimeMode\":\"0\",\"sync_video_priority\":1,\"width\":960,\"height\":540,\"scalewidth\":\"16\",\"scaleheight\":\"9\",\"backcolor\":\"#ffffff\",\"secondscreen_scenetime\":\"0\",\"datalist\":[{\"id\":\"webpage_1\",\"class\":\"element webpage border  ui-draggable ui-draggable-handle ui-resizable\",\"title\":\"\",\"zIndex\":1,\"from\":\"webpage_edit\",\"style\":\"top: 0px; left: 0px; display: block; width: 960px; height: 540px; position: absolute; z-index: 1; background-color: transparent;\",\"x\":0,\"y\":0,\"width\":960,\"height\":540,\"wideViewPort\":\"1\",\"curimglist\":[{\"type\":\"webpage\",\"url\":\"file:///storage/emulated/0/game/index.html\",\"style\":\"1\",\"long\":\"600\",\"reloadtime\":\"0\",\"tool\":\"0\"}]}]}";
        templatelist = new ArrayList<String>();
        UsbScreenlist = new ArrayList<ArrayList<String>>();
        UsbScreenTextlist = new ArrayList<String>();
        SubScreenlist = new ArrayList<String>();
        UsbScreenMusiclist = new ArrayList<String>();
        syncMode = 0;
        syncStyle = 0;
        syncMode_subscreen = 0;
        syncSerial = "/dev/ttyS1";
        syncBaute = 9600;
        syncList = new ArrayList<String>();
        transferType = "0";
        transferServer = "0";
        transferAddr = "0";
        transferApName = "mtstar1234";
        transferApPsw = "mtstar1234";
        transferParam = "";
        offlineRebootTime = 0;
        MarqueFrontSize = 50;
        marquepos = 0;
        iszcboard = -1;
        boardModel = "";
        debug_devtype_mode = false;
        debug_devtype_charge_mode = false;
        debug_devtype_face_mode = false;
        Debug_devtype_uart_mode = false;
        Debug_devtype_park_mode = false;
        Debug_devtype_voice_mode = false;
        Debug_devtype_3d_Screen_mode = false;
        debug_devtype_Environment = false;
        Debug_devtype_people = false;
        debug_devtype_fueling = false;
        is_subscreen_mode = 0;
        subscreen_program_exists = false;
        WMP_APP_ID = "wxe6303bacce65b066";
        WMP_APP_DOMAIN = "www.mtstar.net";
        WMP_SNS_SCOPE = "snsapi_base";
        remote_qrcode = 0;
        remote_qrcode_url = "";
        WMP_PM_QRCODE_FIRST_LOAD = false;
        DevType = 0;
        ParkingType = 0;
        callNumVolume = 1;
        PM_CHECK_STOCK_IO = true;
        PM_OUTOFSTOCK = false;
        PM_QRCODE_X = -0.5F;
        PM_QRCODE_Y = -0.5F;
        PM_QRCODE_HEAD_SLOGAN = "扫一扫有惊喜";
        needMapInfo = false;
        resetServer_need_upMapInfo = false;
        mapjson = "";
        msgMapInfo = "";
        mapstr = "";
        mapX = "0";
        mapY = "0";
        screen2 = "0";
        screen2rotation = "0";
        SupportAPPVersion = "1";
        appcfg_id = "";
        appcfg_name = "";
        cfgApkVersion = "";
        displayLogo = 0;
        isRegist = false;
        isAlonePlay = true;
        isCdnDown = true;
        isCdnChangeBit = false;
        cdnreqid = "";
        isRestorePlay = true;
        errorstatus = false;
        errortime = "";
        NetIp = "";
        City = "";
        island = true;
        NetType = 0;
        level_4G = 0;
        level_WIFI = 0;
        version_prefix = "MTSTAR";
        version_code = "";
        UpdataApkStr = "";
        version_id = "";
        version_str = "";
        version_mode = 0;
        fileVersion = 0;
        postDelay = 30;
        postErrorLimit = 5;
        WifiPostDelay = 3000;
        DelayOneHour = 3600000;
        enable_template_test_xgx = false;
        ENABLE_loginServer = true;
        timer = null;
        mainMsgDo = null;
        handler = null;
        wifiHandler = null;
        Batterylevel = 0;
        sync_program_video_priority = false;
        sync_program_audio_priority = false;
        googleTTs = "com.google.android.tts";
        iflyTTS = "com.iflytek.speechcloud";
        packname = "";
        debugZcBoard = false;
        sync_program_video_priority_permit_send_syncmsg = false;
        shandler = null;
        task = null;
        isAppExit = false;
        zcpdb = null;
        ShowStorageInfo = true;
        db_sdcardDir = "mnt/sdcard/";
        adt = null;
        db_cMark = "";
        isNeedNewLoginQRCode = "1";
        cpuid = "";
        devmac = "aa:bb:cc:dd:ee:ff";
        devmac_true = "";
        serverAddr = "www.mtstar.net";
        defaultserverAddr = "www.mtstar.net";
        defaultserverPort = "80";
        defaultDevicecode = "88888";
        defaultworktype = "0";
        changeServer = false;
        changeServerErrorCount = 0;
        cfgversion = 0;
        SN = "";
        APKversion = 10;
        online = false;
        offlineLimit = 0;
        offlinecount = 0;
        offlinetime = 0L;
        dev_name = "未命名设备";
        change_name = "0";
        serverPort = "80";
        dis_devicecode = "";
        dis_serverPort = "80";
        dis_serverAddr = "www.mtstar.net";
        dis_update = Boolean.valueOf(false);
        devicecode = "88888";
        worktype = "0";
        canlogin = false;
        weather = "";
        datetime = "";
        PlayLogo = "";
        volume = 20;
        max_volume = 100;
        gamevolume = 0;
        lcd_onoff_cfg = "";
        timing = "";
        timing_stime = "";
        worktime_str = "";
        worktime_ON_OFF_SCREEN = "";
        lastUsbmode = "0";
        usbmode = "0";
        usbmode_subscreen = "0";
        cycle_mode = 0;
        usbImgTime = "5";
        useUsb_Text = "0";
        txtusb_movetype = "1";
        txtusb_movespeed = "1";
        txtusb_bgcolor = "0";
        txtusb_color = "#FF0000";
        txtusb_transparent = "1";
        txtusb_fontsize = "36";
        useUsb_Music = "0";
        musicusb_Type = "0";
        network = "";
        stroge = "0";
        boot = "1";
        bootDelay = "0";
        setboot = "0";
        pwd = "Szlucky888";
        tempwd = "123456";
        tmppwdtime = 0L;
        wifiStatus = 0;
        MOUNTED_SD = 0;
        UsbDisk = "";
        downSpeed = 1280;
        boot_time_on = 0;
        mat_play_stat = 0;
        matplaystat_up_interval = 300;
        pid = "";
        uid = "";
       // mProgram = null;
        testdownspeed = false;
        downSpeed_endtime = "";
        downSpeend_endtime2 = "";
       // Downlist = new ArrayList<AdcBaseObject>();
        playJsonlist = new ArrayList<String>();
        medialist = new ArrayList<String>();
       // templist = new ArrayList<DownItem>();
     //   protocolList = new ArrayList<AdcPlayPlanPublish>();
      //  threeMediaItemlist = new ArrayList<ThreeDownItem>();
       // threeMedialist = new ArrayList<ThreeDownItem>();
       // threeMediaplaylist = new ArrayList<ThreeDownItem>();
       // threeMtstarProtocolList = new ArrayList<ThreeDownItem>();
        heart3rdTime = 0L;
        downCount = 0;
       // UsbMedialist = new ArrayList<USBitem>();
        //sendmsglist = new ArrayList<AdcMsg>();
      //  msglist = new ArrayList<AdcMsgTask>();
       // planlist = new ArrayList<AdcBaseObject>();
      //  Apklist = new ArrayList<DownItem>();
       // DownOtherlist = new ArrayList<DownItem>();
        validprogramlist = new ArrayList<String>();
        validmedialist = new ArrayList<String>();
        debug = false;
      //  playlist = new ArrayList<AdcBaseObject>();
       // threeplaylist = new ArrayList<AdcBaseObject>();
        threeplayindex = 0;
        threeplaytime = 0L;
        threeplayinterval = 60000L;
        advert_3rd_ad_id = "";
        disfloatwindow = 1;
        checktime = 180000;
        playThreeAD = 0;
        checkwifi = false;
        volume_task = "";
        cbplaylist = new ArrayList<AdcPlayPlanPublish>();
        curplay = null;
        playstatus = 0;
        finding = false;
        isCirclePlay = false;
        findingSub = false;
        findingSubScreenTime = 0L;
        isfirst = true;
        nosendmsg = false;
        clientcount = 0;
        his_ip = "";
        his_port = -1;
        wifiProgramIp = "";
        trackerurl = "";
        posturl = "";
        backup_posturl = null;
        fixed_serverIp = 1;
        item_url_prefix_variable = "";
        reboot_free_count_max = 2;
        reboot_free_max_tick = 65000;
        reboot_free_min_tick = 26400;
        upload_faceimg_trd = "1";
        postIndex = 0;
        downStatus = 0;
        delay = 10;
        countday = 5;
        currentfind = 0;
        delaySetupTime = 500;
        CheckPwd = 0;
        delayFinishProgram = 0;
        delayFinishProgram_sub = 0;
        cbFinishProgram = Long.valueOf(0L);
        playdefault = 0;
        test = false;
        canplay = 0;
        zhaoshang = 0;
        zhaoshangindex = -1;
        zhaoshangcount = 0;
        currentzhaoshangindex = 0;
        SaveType = 0;
        isInstallServices = 1;
        showServicesWaring = false;
        msglistLock = false;
        printdebugLog = false;
        is_release_version = true;
        AccessServer = "http://192.168.3.100:8080/zycdevroute/register/getinfo.html";
        LoginServerAddr = "";
        defaultDIR = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
        oldsaveDIR = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "savedir.ini";
        saveDIR = defaultDIR + File.separator + "savedir.ini";
        zcfile = "/zyplayer";
        sdcardDir = "/mnt/extsd" + zcfile;
        ErrorLogName = "error.log";
        SyslogDir = "";
        templateDir = "";
        extSdDir = "";
        playDir = "";
        freeSize = Long.valueOf(1073741824L);
        oldconfig = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "config2.ini";
        LogDir = defaultDIR + "/Log/";
        width = 1920;
        height = 1080;
        isCopyOldConfig = false;
        playscheduleCfg = defaultDIR + "/playschedule.ini";
        config = defaultDIR + "config.ini";
        config2 = defaultDIR + "/config2.ini";
        config3 = defaultDIR + "/config3.ini";
        config4 = defaultDIR + "/config.ini";
        config_elevator = defaultDIR + "/config5.ini";
        debugfile = defaultDIR + "/debug.txt";
        continueconfig = defaultDIR + "/continueconfig.ini";
        oldconfig1 = defaultDIR + "/oldconfig";
        aloneConfig = defaultDIR + "/alone.ini";
        mc = defaultDIR + File.separator + "key.ini";
        tempDir = defaultDIR + "/temp/";
        savephoto = false;
        screentempDir = defaultDIR + "/screentemp/";
        fileDir = defaultDIR + "/files/";
        TQDIR = defaultDIR + "/tq";
        HLDIR = defaultDIR + "/hl";
        updateDir = defaultDIR + "/update/";
        offDir = defaultDIR + "/off/";
        novideoDir = defaultDIR + "/";
        tDir = defaultDIR + "/temp";
        fDir = defaultDIR + "/files";
        uDir = defaultDIR + "/update";
        cDir = defaultDIR + "/camera";
        sdcardTemp = defaultDIR + "/temp/";
        AloneScreen2 = 0;
        playModeStyle = 0;
        playEffect = 0;
        ImgModeStyle = 0;
        ImgEffect = 0;
        playPath = sdcardDir + "/zcfile/";
        playStylePath = playPath + "/full/";
        playTextPath = playStylePath + "/text/";
        isInstall = true;
        installNum = 0;
        startup = true;
        updateapk = false;
        showStatusBar = true;
        EnableDBWebView = true;
        EnableLoadTime = true;
        c_apkname = "xinxifabu";
        Main_Poster_path = "/data/main_poster.png";
        ENABLE_ZCP_HOST = false;
        coder_deviceid = "860499020724004_HUAWEI G525-U00";
        dbpath = "zcCloud";
        defaultMainJpg = "";
        mainjpg = "main.png";
        mainjpg1 = "main1.png";
        screenfailjpg = "fail.png";
        dbzippath = "zcpress/db/zcpdata.zip";
        netConfig = "Config.cfg";
        EnvConfig = "EnvConfig.cfg";
        PeopleSign = "People.cfg";
        serialConfig = "Serial.cfg";
        faceConfig = "Face.CFG";
        thumbnailpath = "zcpress/res/thumbnail/";
        update_downPath = "zcpress/res/zc_download/";
        dbpath_dir = "db/";
        Appdir = "zcplay";
        Resdir = "res";
        Respath = "";
        filedir = "files";
        fileswfpath = "zcpress/res/swf/";
        downloadpath = "zcpress/res/download/";
        template_Path = "zcpress/res/template/";
        template_cache_Path = "zcpress/res/tempcache/";
        template_Path_em = "zcpress/res/template_em/";
        SD_SIZE_LEVEL_0 = 1024L;
        SD_SIZE_LEVEL_1 = 512L;
        CopyFile2HTTPDIR = false;
        FILE_RES_DIR = "/mnt/sdcard2/ZDoc/zcpress/res/files/";
        FILE_RES_Thumbnail_DIR = "/mnt/sdcard2/ZDoc/zcpress/res/thumbnail/";
        FILE_DB_ZCP = "/mnt/sdcard2/ZDoc/zccloudplay/db/zcpdata.db";
        FILE_DB_ZCP_PATH = "/mnt/sdcard2/ZDoc/zccloudplay/db/";
        FILE_SWF_PATH = "/mnt/sdcard2/ZDoc/zcpress/res/swf/";
        FILE_SWF_VERSION = "0.0.04";
        FILE_SWF_FORCE_UPDATE = false;
        FILE_DOWNLOAD_PATH = "/mnt/sdcard2/ZDoc/zcpress/res/download/";
        FILE_RES_UPDATEDOWN_PATH = "/mnt/sdcard2/ZDoc/zcpress/res/zc_download/";
        FILE_TEMPLATE_PATH = "/mnt/sdcard2/ZDoc/zcpress/res/template/";
        FILE_TEMPLATE_CACHE_PATH = "/mnt/sdcard2/ZDoc/zcpress/res/tempcache/";
        FILE_TEMPLATE_EDITMODE_PATH = "/mnt/sdcard2/ZDoc/zcpress/res/template_em/";
        FILEPATH_MAINSTORAGE = "/mnt/sdcard/";
        FILEPATH_SDLIST = new ArrayList<String>();
        lian = 15;
        xiansu = -1;
        downtotal = 0L;
        alltotal = 0L;
        showdebuginfo = true;
        FileManager_Path_Last = "/mnt/";
        Administrator = "admin";
        vsToast = null;
        DevStartPrefix = "ZCTec_";
        SearchHostUDP = new NetUDP(6080);
        queryDevRight = true;
        Enable_Error_SignCheck = false;
        m_ScreenWidth = 1920;
        m_ScreenHeight = 1080;
        m_ScreenHeightoffset = 0;
        m_ScreenWidth2 = -1;
        m_ScreenHeight2 = -1;
        m_ScreenWidth3 = -1;
        m_ScreenHeight3 = -1;
        qrcodedis = 0;
        reg_qrcodeurl_fmt = "";
        qrcodetype = 2;
        qrcodeXY = 2;
        qrcodeurl = "";
        cameraModel = 0;
        localReStart = false;
        localReStartCount = 10;
        User_DeviceID = "";
        login_key = "";
        useWorkTime = true;
        workCloseTime = 180000L;
        workOffsetTime = 240000L;
        User_Ver = "zcmedia/www.zckj.net (" + Build.MODEL + ")";
        User_Agent = "AndroidCoreMedia/4.2.2 (CPU OS 3_3_0 like Linux; zh_cn)";
        User_Mac = "";
        And_boxs_id = 1;
        ENABLE_Obsevable = false;
       // vsObsevable = null;
        CurPageIndex = 0;
        ObjRun = true;
        devHandler = null;
        Enable_delGIPIRecord = false;
       //imageLoader = null;
        taskCollection = null;
        downing = false;
        change = 0;
        downmsg = "";
        delayinit = false;
        delayinit_count = 0;
        IsMissfile = false;
        faceinit = false;
        peopleServer = "119.45.26.246";
        peoplePort = "8778";
        peopleAccessCode = "zckj2023";
        peopleRealCore = 0.6F;
        faceinitCount = 0;
        faceuploadinit = false;
        ChargingSerial = "/dev/ttyS4";
        ChargingPort = 115200;
        UartSerial = "/dev/ttyS1";
        UartPort = 9600;
        VoiceSerial = "/dev/ttyS0";
        VoicePort = 9600;
        VoiceValue = 0.0F;
        VocSerial = "/dev/ttyS0";
        VocPort = 9600;
        EnvSerial = "/dev/ttyS7";
        EnvPort = 9600;
        isAutoReboot = 0;
        AutoRebootWeek = 0;
        AutoRebootTime = 2;
        usbShowDate = "0";
        usbShowDevice = "0";
        usbShowTime = "0";
        usbDatehour24 = "1";
        usbDatepos = 0;
        usbDatesize = 2;
        usbDatecolor = -16777216;
        usbSource = 0;
        isAloneUsePwd = 0;
        AlonePwd = "";
        updateServerAddr = "http://192.168.3.100:8080/zycloud/";
        updateServerAddr_debug = "http://192.168.3.101:8900/";
        projecttype = 0;
        currentQRCodeType = 0;
        isDisplayQRCode = true;
        videoLevel = 23;
        islinkPlay = 0;
        linkIO = 0;
        linkPlayType = 0;
        linkPlayDefault = 0;
        linkTigger = 1;
        link_alarm = "0";
        link_recovery = "1";
        link_delay_recovery = 0;
        link_replay = 0;
        runtype = 0;
        disStyle = 1;
        screen_img_del = false;
        face_img_del = false;
        isBarScreen = false;
        overSea = false;
        isUseVs6Name = false;
        isUsePwd = "1";
        PwdType = "0";
        isContinuePlay = true;
        ishdrSupport = false;
        isTouchImg_fullscreen = false;
        isswitchprogram = true;
        lastbatterystatus = -1;
        isUseGame = false;
        reOpenHdmi = false;
        isUseGameTime = true;
        gameTime = 0L;
        isGameLock = false;
        userchange = 0;
        noisealarm = "0";
        noiseCeiling = 60;
        alarmduration = 10;
        CtrlIO = 1;
        hasFaceHardware = false;
        iszyboard = false;
        isDisRealMODEL = false;
        lastfacename = "";
        lastfaceTime = "";
        lastfaceWatchTime = "";
        lastreal = "";
        AllwinScreenStatus = true;
        auto_disinfection = "1";
        auto_disinfection_duration = 0;
        auto_kaiji = true;
        pm25_thres = 250;
        voc_thres = 1.2F;
        filterChangeHour = 2000L;
        pm25_thres_L1 = 0;
        pm25_thres_L2 = 35;
        pm25_thres_L3 = 250;
        voc_thres_L1 = 0.0F;
        voc_thres_L2 = 0.3F;
        voc_thres_L3 = 1.2F;
        cameraRecord = false;
        programId = "";
        sDoubleClickUpdateTxt = "0";
        longitude = 0.0D;
        latitude = 0.0D;
        VistarMediaUrl = "https://api.vistarmedia.com/api/v1/get_ad/json";
        */
    }

    public static void checkMaxVolume() {
      //  if (volume > max_volume)
        //    volume = max_volume;
    }

    public static Camera getCameraInstance() {
        Camera camera = null;

            return camera;

    }

    public static int getChanState() {
        return 1;
    }

    public static String getLoginKey() {
        return "";//login_key;
    }

    public static String getPropStr(String paramString) {
        String str = "";
        if (!false)
            try {
                Class<?> clazz = Class.forName("android.os.SystemProperties");
                return (String)clazz.getDeclaredMethod("get", new Class[] { String.class }).invoke(clazz, new Object[] { paramString });
            } catch (Exception exception) {
              //  ThrowableExtension.printStackTrace(exception);
                return "";
            }
        return str;
    }

    public static int getServiceVersion(Context paramContext) {
        try {
            return (paramContext.getPackageManager().getPackageInfo("com.linux.basics", 0)).versionCode;
        } catch (Exception exception) {
            return 0;
        }
    }

    public static String getUpdateServerAddr() {
        return "";//is_release_version ? updateServerAddr : updateServerAddr_debug;
    }

    public static String getUpdateServerAddr_Release() {
        return updateServerAddr;
    }

    public static String getapk_vertxt() {
        return "";//!is_release_version ? "verjson_debug.txt" : "verjson_sign.txt";
    }
/*
    public static void init() {
        switch (projecttype) {
            default:
                disfloatwindow = 1;
                screen2 = "0";
                usbSource = 0;
                DevType = 0;
                runtype = 0;
                if (overSea) {
                    serverAddr = "one.mtstar.net";
                    return;
                }
                break;
            case 1:
                disfloatwindow = 1;
                screen2 = "1";
                usbSource = 1;
                if (overSea) {
                    serverAddr = "one.mtstar.net";
                    return;
                }
                break;
            case 2:
                disfloatwindow = 1;
                runtype = 1;
                DevType = 10;
                if (overSea) {
                    serverAddr = "one.mtstar.net";
                    return;
                }
                break;
            case 3:
                disfloatwindow = 1;
                runtype = 2;
                DevType = 11;
                if (overSea) {
                    serverAddr = "one.mtstar.net";
                    return;
                }
                break;
            case 4:
                disfloatwindow = 0;
                screen2 = "0";
                usbSource = 2;
                DevType = 0;
                runtype = 0;
                if (overSea) {
                    serverAddr = "one.mtstar.net";
                    return;
                }
                break;
        }
        serverAddr = "www.mtstar.net";
    }
*/

    public static void send_adjust_RemainAudioPlayTime(int paramInt) {
        //if (sync_program_audio_priority && !isCirclePlay) {
            Message message = Message.obtain();
            message.what = 160;
            Bundle bundle = new Bundle();
            bundle.putString("ms", String.valueOf(paramInt));
            message.setData(bundle);
           // handler.sendMessage(message);
       // }
    }



    public static void setProperty(String paramString1, String paramString2) {

    }
}


/* Location:              D:\wlzc_institute\wlzc\wlzc1-dex2jar.jar!\com\zcad\\util\CommonData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
