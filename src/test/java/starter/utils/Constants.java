package starter.utils;


import starter.stepdef.UsersStepDef;

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
        public static String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ5ODg2MDcsImlhdCI6MTcxNDk3NzgwNywiaWQiOiIxMTUiLCJpc19hY3RpdmUiOjEsImlzX2FkbWluIjpmYWxzZX0.OkWm-5NqljbB43hMPm5ifXczSUC0uV5YBSfmWXUEdBY";
        public static String TOKEN_USER = "Bearer " + UsersStepDef.TOKEN_RECIPIENT;
    }

