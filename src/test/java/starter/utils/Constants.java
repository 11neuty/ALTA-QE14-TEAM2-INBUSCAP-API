package starter.utils;

  
public class Constants {
        public static String DIR = System.getProperty("user.dir");
        public static String BASE_URL = "https://inbuscap-server.my.id/";
        public static String JSON = DIR + "/src/test/resources/JSON";
        public static String REQ_BODY = JSON + "/ReqBody/";
        public static String JSON_SCHEMA = JSON + "/JsonSchema/";
        public static String FORM = DIR + "/src/test/resources/FORM";
        public static String AVATAR = FORM + "/Avatar/";
        public static String KTP = FORM + "/KTP/";
        public static String NPWP = FORM + "/NPWP/";
        public static String IMAGE = FORM + "/IMAGE/";
        public static String PROPOSAL = FORM + "/PROPOSAL/";
        public static String REPORT = FORM + "/REPORT/";
        public static String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ5MzA4MzcsImlhdCI6MTcxNDkyMDAzNywiaWQiOiIxMTMiLCJpc19hY3RpdmUiOjEsImlzX2FkbWluIjpmYWxzZX0.83KL_309TdNVD7e-qqbltSLdEqqMx_gbVGJix1N1xA4";
        public static String TOKEN_USER = "Bearer " + TOKEN;
    }

