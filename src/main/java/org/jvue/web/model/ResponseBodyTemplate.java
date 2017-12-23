package org.jvue.web.model;

public class ResponseBodyTemplate {
    /**
     * 服务器出现异常情况
     * @param data
     * @param message
     * @return
     */
    public ResponseBody create500Template(Object data,String message){
        ResponseBody responseBody=new ResponseBody();
        responseBody.setState(500);
        responseBody.setData(data);
        responseBody.setMessage(message);
        return responseBody;
    }
    /**
     * 服务器调用成功
     * @param data
     * @param message
     * @return
     */
    public ResponseBody create200Template(Object data,String message){
        ResponseBody responseBody=new ResponseBody();
        responseBody.setState(200);
        responseBody.setData(data);
        responseBody.setMessage(message);
        return responseBody;
    }
    /**
     * 需要登陆
     * @param data
     * @param message
     * @return
     */
    public ResponseBody create300Template(Object data,String message){
        ResponseBody responseBody=new ResponseBody();
        responseBody.setState(300);
        responseBody.setData(data);
        responseBody.setMessage(message);
        return responseBody;
    }
    /**
     * 没有找到资源
     * @param data
     * @param message
     * @return
     */
    public ResponseBody create404Template(Object data,String message){
        ResponseBody responseBody=new ResponseBody();
        responseBody.setState(404);
        responseBody.setData(data);
        responseBody.setMessage(message);
        return responseBody;
    }
    /**
     * 没有权限
     * @param data
     * @param message
     * @return
     */
    public ResponseBody create403Template(Object data,String message){
        ResponseBody responseBody=new ResponseBody();
        responseBody.setState(403);
        responseBody.setData(data);
        responseBody.setMessage(message);
        return responseBody;
    }

}
