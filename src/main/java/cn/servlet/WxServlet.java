package cn.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "WxServlet")
public class WxServlet extends HttpServlet {


    /**
     * 参数	描述
     * signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * timestamp	时间戳
     * nonce	随机数
     * echostr	随机字符串
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        String signature =request.getParameter("signature");
        String timestamp =request.getParameter("timestamp");
        String nonce =request.getParameter("nonce");
        String echostr =request.getParameter("echostr");
//        System.out.println(signature);
////        System.out.println(timestamp);
////        System.out.println(nonce);
////        System.out.println(echostr);
        //校验证请求
        System.out.println("fuck");
        if (Check.check(timestamp,nonce,signature)) {
            System.out.println("接入成功");
            PrintWriter out =response.getWriter();
            out.print(echostr);
            out.flush();
            out.close();
        }else{
            System.out.println("接入失败");
        }
    }

//    /**
//     *
//     * @param timestamp
//     * @param nonce
//     * @param echostr
//     * @return
//     */
//    private static boolean check(String timestamp, String nonce, String echostr) {
//
//         // 1）将token、timestamp、nonce三个参数进行字典序排序
//         //2）将三个参数字符串拼接成一个字符串进行sha1加密
//         //3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
//
//    }
    /*
     *接收消息和事件推送
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletInputStream is=request.getInputStream();
//        byte[] b=new byte[1024];
//        int len;
//        StringBuilder sb =new StringBuilder();
//        while((len=is.read(b))!=-1){
//            sb.append(new String(b,0,len));
//        }
//        System.out.println(sb.toString());
    //处理消息和事件推送
        Map<String,String> requestMap=Check.parseRequest(request.getInputStream());
        System.out.println(requestMap);
    }
}
