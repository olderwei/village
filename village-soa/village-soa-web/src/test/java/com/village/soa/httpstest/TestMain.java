package com.village.soa.httpstest;

//对接口进行测试
public class TestMain {
    private String url = "https://village.com";
    private String charset = "utf-8";
    private HttpClientUtil httpClientUtil = null;

    public TestMain(){
        httpClientUtil = new HttpClientUtil();
    }

    public void test(){
        String httpOrgCreateTest = url + "/api/account/addAccount";
//        Map<String,String> createMap = new HashMap<String,String>();
//        createMap.put("phone","*****");
//        createMap.put("accountNickName","*****");
        Object json = "{\"phone\":\"12\", \"accountNickName\":\"赵六\" }";
        String httpOrgCreateTestRtn = httpClientUtil.doPostJson(httpOrgCreateTest, json, charset);
        System.out.println("result:" + httpOrgCreateTestRtn);
    }

    public static void main(String[] args){
        TestMain main = new TestMain();
        main.test();
    }
}
