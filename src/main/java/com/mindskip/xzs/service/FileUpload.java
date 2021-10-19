package com.mindskip.xzs.service;


import org.springframework.stereotype.Component;

import java.io.InputStream;
@Component
public interface FileUpload {

    String uploadFile(InputStream inputStream, long size, String extName);

}
