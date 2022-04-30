package com.youfan;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.LogType;
import com.youfan.enums.YeWuType;
import com.youfan.liuLiang.log.AppProductCartLog;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class AppProductCartGenerateData {

    static Random random = new Random();
    private static int[] days  = new int[]{3,4,5,6};
    private static  String[] operatorTypees = new String[]{"0","1"};
    private static String[] userIds = new String[]{"1","2"};
    private static String[] deviceIds = new String[]{"deviceId1","deviceId2"};
    static long openTimeStamp = genernateDateData(new Date());
    private static String openTimeStampstring = openTimeStamp+"";//打开时间
    private static String leaveTimeStamp = (openTimeStamp+10*1000l)+"";//退出时间
    private static String[] appPlatforms = new String[]{"andriod","ios"};//平台，安卓，IOS
    private static String[] deviceStyles = new String[]{"红米6","小米7","华为荣耀6"};//型号
    private static String[] brands = new String[]{"华为","小米","苹果"};//品牌
    private static String[] screenSizes = new String[]{"200*400","600*1000"} ;//分辨率
    private static String[] osTypes = new String[]{"andriod4.5","andriod5.6","ios5","iso6","iso7"};//操作系统

    private static String[] pindaoIds = new String[]{"1","2"};//频道id
    private static String[] productTypeIs = new String[]{"2","3"};//产品类别id
    private static String[] productIds = new String[]{"1","2","3"};//产品id
    static long opertortimeStamp = genernateDateData(new Date());
    private static String opertortime = opertortimeStamp+"";//操作的时间
    private static String[] ips = new String[]{"192.168.4.5","192.168.4.6"};//用户app访问的ip
    private static String[] countrys = new String[]{"china"};//国家
    private static String[] provinces = new String[]{"guangdong","beijing","shanghai"};//省
    private static String[] citys = new String[]{"shenzheng","beijing","shanghai"};//市
    private static String[] networks = new String[]{"wifi","4G"};//网络方式
    private static String[] yunYinShangs = new String[]{"联通","移动","电信"};//运营商
    private static String[] appVersions = new String[]{"4.5.1","4.5.6","6.7.4"};//app版本
    private static String[] appChannels = new String[]{"安卓市场","小米市场"};//渠道
    private static String[] divecetypes = new String[]{"计算机","移动设备","其他"};//设备类型


    private static AppProductCartLog genernateData(){
        AppProductCartLog appProductCartLog = new AppProductCartLog();
        appProductCartLog.setUserId(userIds[random.nextInt(userIds.length)]);
        appProductCartLog.setDeviceId(deviceIds[random.nextInt(deviceIds.length)]);
        appProductCartLog.setAppPlatform(appPlatforms[random.nextInt(appPlatforms.length)]);
        appProductCartLog.setDeviceStyle(deviceStyles[random.nextInt(deviceStyles.length)]);
        appProductCartLog.setBrand(brands[random.nextInt(brands.length)]);
        appProductCartLog.setScreenSize(screenSizes[random.nextInt(screenSizes.length)]);
        appProductCartLog.setOsType(osTypes[random.nextInt(osTypes.length)]);
        appProductCartLog.setProductTypeId(productTypeIs[random.nextInt(productTypeIs.length)]);
        appProductCartLog.setProductId(productIds[random.nextInt(productIds.length)]);
        appProductCartLog.setPindaoId(pindaoIds[random.nextInt(pindaoIds.length)]);
        appProductCartLog.setIp(ips[random.nextInt(ips.length)]);
        appProductCartLog.setCountry(countrys[random.nextInt(countrys.length)]);
        appProductCartLog.setProvince(provinces[random.nextInt(provinces.length)]);
        appProductCartLog.setCity(citys[random.nextInt(citys.length)]);
        appProductCartLog.setNetwork(networks[random.nextInt(networks.length)]);
        appProductCartLog.setYunYinShang(yunYinShangs[random.nextInt(yunYinShangs.length)]);
        appProductCartLog.setAppVersion(appVersions[random.nextInt(appVersions.length)]);
        appProductCartLog.setAppChannel(appChannels[random.nextInt(appChannels.length)]);
        appProductCartLog.setOpenTimeStamp(openTimeStampstring);
        appProductCartLog.setLeaveTimeStamp(leaveTimeStamp);
        appProductCartLog.setOperatorTime(opertortime);
        appProductCartLog.setOperatorType(operatorTypees[random.nextInt(operatorTypees.length)]);
        appProductCartLog.setLogType(LogType.APP);
        appProductCartLog.setYeWuType(YeWuType.PRODUCTCART);
        appProductCartLog.setDeviceType(divecetypes[random.nextInt(divecetypes.length)]);
        return  appProductCartLog;

    }

    private static long genernateDateData(Date date){
        Calendar now = Calendar.getInstance();

        now.setTime(date);

        now.set(Calendar.DATE, now.get(Calendar.DATE) + days[random.nextInt(days.length)]);
        long resultTime = now.getTime().getTime();

        return resultTime;
    }
    private static void postHttpMethod(String urlpath,String data){
        try {
            URL url = new URL(urlpath);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setInstanceFollowRedirects(true);
            urlConnection.setUseCaches(true);
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setConnectTimeout(1000 * 5);
            urlConnection.connect();
            OutputStream outputStream = urlConnection.getOutputStream();
            outputStream.write(data.getBytes("utf-8"));
            outputStream.flush();
            outputStream.close();
            InputStream inputStream = urlConnection.getInputStream();
            int httpCode = urlConnection.getResponseCode();
            byte[] inputdata = new byte[1024];
            StringBuffer stringBuffer = new StringBuffer();
            while(inputStream.read(inputdata,0,1024) != -1){
                stringBuffer.append(new String (inputdata));
            }
            System.out.println(httpCode);
            System.out.println(stringBuffer.toString());
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        for(int i =0;i<20;i++){
            AppProductCartLog appProductCartLog = genernateData();
            System.out.println(JSONObject.toJSON(appProductCartLog));
            postHttpMethod("http://127.0.0.1:8091/collect/data",JSONObject.toJSONString(JSONObject.toJSON(appProductCartLog)));
        }

    }
}
