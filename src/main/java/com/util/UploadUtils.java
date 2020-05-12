package com.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

public class UploadUtils {

    public static String getImgUrl(MultipartFile file, HttpServletRequest request){
        //获取文件名称
        String fileName = file.getOriginalFilename();
        //获取文件的扩展名
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        // 新文件名
        String newFileName = UUID.randomUUID().toString().replaceAll("-", "") + "."+ext;
        //获取图片上传路径
        String UploadUrl = request.getSession().getServletContext().getRealPath("/static/images/");
        //文件上传
        File f = new File(UploadUrl,newFileName);
        //判断路径是否存在，不存在则创建
        if(!f.exists()){
            f.mkdirs();
        }
        System.out.println();
        if(!ext.equals("jpg")&&!ext.equals("png")){
            return "上传文件只能是jpg或png格式！";
        }
        //判断上传文件是否为空
        if(!file.isEmpty()){
            try {
                file.transferTo(f);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            return "未接收到文件，请重新尝试！";
        }
        return "/static/images/"+newFileName;
    }
}
