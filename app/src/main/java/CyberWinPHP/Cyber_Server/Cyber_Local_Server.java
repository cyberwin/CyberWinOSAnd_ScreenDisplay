package CyberWinPHP.Cyber_Server;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import CyberWinPHP.Cyber_Plus.LogToFile;

public class Cyber_Local_Server extends Cyber_NanoHTTPD {
    public Cyber_Local_Server() throws IOException
    {

        super(19875, new File("."));
        LogToFile.d("网络服务","初始化");
    }

    public Response serve(String uri, String method, Properties header, Properties parms, Properties files )
    {
        LogToFile.d("网络服务","请求"+uri+" 请求方法 method="+method);
        System.out.println( method + " '" + uri + "' " );
        String msg = "<html><body><h1>Hello server</h1>\n";
        if ( parms.getProperty("username") == null )
            msg +=
                    "<form action='?' method='get'>\n" +
                            "  <p>Your name: <input type='text' name='username'></p>\n" +
                            "</form>\n";
        else
            msg += "<p>Hello, " + parms.getProperty("username") + "!</p>";

        msg += "</body></html>\n";
        return new Cyber_NanoHTTPD.Response( HTTP_OK, MIME_HTML, msg );
    }
}
