package com.asm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.UUID;

@Service
public class UploadFileService {
    @Autowired
    ServletContext app;
    public File save(MultipartFile file) {
        //C:\Users\PC\Desktop\angular\asmj5\asset\img
        String folderPath = "C:\\Users\\PC\\Desktop\\angular\\AssignmentsJava5\\src\\main\\resources\\static\\img";
        File dir = new File(folderPath);

        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdirs();
        }
        File savedFile = null;
        try {

            String uuid = UUID.randomUUID().toString();
            String fileName =file.getOriginalFilename();
            System.out.println(fileName+"fule");
            savedFile = new File(dir, fileName);
            file.transferTo(savedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedFile;
    }
}
