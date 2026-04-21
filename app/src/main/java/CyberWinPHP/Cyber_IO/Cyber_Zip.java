package CyberWinPHP.Cyber_IO;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;

public class Cyber_Zip   {
    /**
     * 解压缩zip,带解压进度
     *
     * @param zipFilePath
     * @param desfilePath
     * @param password

     * @param isDeleteZip
     * @throws ZipException
     */
    public static void unZipFile(final String zipFilePath, final String desfilePath, final char[] password,
                                            final boolean isDeleteZip) throws ZipException {
        //char ch[]="hello world!"
        final File zipFile = new File(zipFilePath);

        ZipFile zFile = new ZipFile(zipFile);
       // zFile.setFileNameCharset("utf-8");

        if (!zFile.isValidZipFile()) { //
            throw new ZipException("exception!");
        }
        File destDir = new File(desfilePath);
        if (destDir.isDirectory() && !destDir.exists()) {
            destDir.mkdir();
        }
        if (zFile.isEncrypted()) {
            zFile.setPassword(password); // 设置解压密码
        }
/*
        final ProgressMonitor progressMonitor = zFile.getProgressMonitor();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int precentDone = 0;
                    if (listener == null) {
                        return;
                    }

                    listener.onStart();
                    while (true && !progressMonitor.isCancelAllTasks()) {
                        // 每隔50ms,发送一个解压进度出去
                       // Thread.sleep(50);
                       // precentDone = progressMonitor.getPercentDone();
                      //  listener.onProgress(precentDone);
                        if (precentDone >= 100) {
                            break;
                        }
                    }

                   // listener.onCompleted();
                } catch (InterruptedException e) {
                   // listener.onError(e);
                } finally {
                    if (isDeleteZip) {
                        zipFile.delete();// 将原压缩文件删除
                    }
                }
            }
        });
        thread.start();
        */

        zFile.setRunInThread(false); // true 在子线程中进行解压 , false主线程中解压
        try {
            zFile.extractAll(desfilePath); // 将压缩文件解压到filePath中...
        } catch (Exception e) {
           // progressMonitor.cancelAllTasks();
            //listener.onError(e);
        }
    }

    //2023-11-5 抽取数据资源 无法实现
    /**
     * 解压缩zip,带解压进度
     *
     * @param zipFilePath
     * @param filepath
     * @param password

     * @param password
     * @throws ZipException
     */
    public static void cyberwin_getZipContents(final String zipFilePath,final String filepath,final char[] password
                               ) throws ZipException {

        final File zipFile = new File(zipFilePath);

        ZipFile zFile = new ZipFile(zipFile);
        // zFile.setFileNameCharset("utf-8");

        if (!zFile.isValidZipFile()) { //
            throw new ZipException("exception!");
        }
      //  File destDir = new File(desfilePath);
       // if (destDir.isDirectory() && !destDir.exists()) {
        //    destDir.mkdir();
       // }
        if (zFile.isEncrypted()) {
            zFile.setPassword(password); // 设置解压密码
        }


        zFile.setRunInThread(false); // true 在子线程中进行解压 , false主线程中解压
        try {
            //zFile.extractAll(desfilePath); // 将压缩文件解压到filePath中...
           // zFile.
        } catch (Exception e) {
            // progressMonitor.cancelAllTasks();
            //listener.onError(e);
        }
    }

}
