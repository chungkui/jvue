package org.jvue.security;

import java.util.ArrayList;
import java.util.List;

public class JvUrlPermissionUtil {
    static List <String> list=new ArrayList<>();
    static {
        list.add("/upms/login/userinfo");
        list.add("/upms/login/success");

    }
    public static boolean isWhite(String  uri){
        for(String wuri:list){
            if(wuri.equals(uri)){
                return true;
            }
        }
        return false;
    };
}
