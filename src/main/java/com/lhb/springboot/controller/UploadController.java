package com.lhb.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhb.springboot.code.RetResponse;
import com.lhb.springboot.code.RetResult;
import com.lhb.springboot.entities.Images;
import com.lhb.springboot.mapper.ImageMapper;
import com.lhb.springboot.utils.FileUtils;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 07:57 2019/11/13
 */
//@Controller
@RestController
public class UploadController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    ImageMapper imageMapper;

    @RequestMapping("/test")
    public RetResult<Images> test(){
        Images images = new Images("图片");
        return RetResponse.makeOKRsp(images);
    }
    @PostMapping("/image")
    public String upload(@RequestParam("file") MultipartFile file, Map<String, Object> map, Images images){


        if(!file.isEmpty()){

        // 要上传的目标文件存放路径
        String localPath = "/Develop/Files/Photos";
        String compressPath = "/Develop/Files/comp";
        // 上传成功或者失败的提示
        String msg = "";
        File file11 = new File(compressPath);
        if (!file11.exists()) {
            file11.mkdirs();
        }

        File file1 = new File(localPath);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        if (FileUtils.upload(file, localPath, file.getOriginalFilename())){
            // 上传成功，给出页面提示
            msg = "成功";
        }else {
            msg = "失败";

        }

        try {
            FileUtils.saveImg(file,localPath);
            logger.info("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] str = StringUtils.split(file.getOriginalFilename(),".");
        String compressImg=str[0]+"150×100.jpg";
        try {
            Thumbnails.of(localPath+"/"+file.getOriginalFilename())
                    .size(150,100)
                    .toFile(compressPath+"/"+compressImg);
            FileUtils.saveImg(file,compressPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        images.setImgName(file.getOriginalFilename());
        images.setImgUuid(UUID.randomUUID().toString());
        images.setImgUrl(localPath);
        images.setImgZipurl(compressImg);
        images.setMsg(msg);
        imageMapper.uploadImage(images);
        // 显示图片
        map.put("msg", msg);
        map.put("fileName", file.getOriginalFilename());
        return "redirect:/images";
        }else{
            map.put("msg1","请选择文件!");
            return "image/add";
        }
    }
    @GetMapping("/toUpload")
    public String toUpload(){
        return "image/add";
    }

//    @GetMapping("/images")
//    public String list(Map<String,Object> map,Images images){
//
//        List<Images> allImages = imageMapper.getAllImages(images);
//        map.put("images",allImages);
//        return "image/list";
//    }
    @GetMapping("/images")
    public String listCategory(Model m,Images image, @RequestParam(value = "start", defaultValue = "0") int start,
                               @RequestParam(value = "size", defaultValue = "3") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<Images> cs=imageMapper.getAllImages(image);
        PageInfo<Images> page = new PageInfo<>(cs);
        m.addAttribute("images", page);
        return "image/list";
    }
}
