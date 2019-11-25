package com.lhb.springboot.mapper;

import com.lhb.springboot.entities.Images;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 08:50 2019/11/13
 */
//@Mapper
public interface ImageMapper {

    int uploadImage(Images images);

    List<Images> getAllImages(Images images);

}
