package com.softtron.softtronvodeo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.softtron.softtronvodeo.dao.Category;

@RestController
public class UploadController {
	@Autowired
	Category category;
	@RequestMapping(path = "/helloworld")
	public String helloworld() {
		System.out.println(category.getCategory());
		return "helloworl222d";
	}
	@RequestMapping(path = "/upload",method = RequestMethod.POST)
	public String upload(@RequestParam("file")MultipartFile file) {
		if(file.isEmpty()) {
			return "上传文件失败";
		}
		String filename = file.getOriginalFilename();
		String filePath = "E:\\";
		System.out.println(filePath+filename);
		File dest = new File(filePath+filename);
		try {
			file.transferTo(dest);
			return "上传成功";
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "上传失败";
	}
	@RequestMapping(path = "/uploadall",method = RequestMethod.POST)
	public String uploadall(HttpServletRequest request) {
//		获取项目路径，加上upload来将文件放入项目根目录下
		List<MultipartFile> files  = null;
		System.out.println(request.getSession().getServletContext().getRealPath("/")+"upload\\");
//		解决没有上传文件，request没有办法强转MultipartHttpServletRequest的问题
		if(request instanceof MultipartHttpServletRequest) {
		files =  ((MultipartHttpServletRequest)request).getFiles("file");
		}else {
			return "上传文件为空";
		}
		String filepath = "E://upload//";
		for(MultipartFile file : files) {
//			解决上传文件的内容为空的问题
			if(file.isEmpty()) {
				return "其中有文件为空";
			}
			String OriginalfileName = file.getOriginalFilename();
			String fileName = UUID.randomUUID().toString().substring(6, 16)+file.getOriginalFilename();
			File dest = new File(filepath+fileName);
			try {
				file.transferTo(dest);
//				int i =1/0;
			} catch (Exception  e) {
				e.printStackTrace();
				return "在"+OriginalfileName+"处上传文件失败";
			}
		}
		return "上传文件成功";
	}
}