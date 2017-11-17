package com.company.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.company.service.iservice.DetailService;
import com.opensymphony.xwork2.ActionSupport;
@Controller("uploadAction")
@Scope("prototype")
public class UploadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Autowired
	private DetailService detailService;
	
	private int uid;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	private List<File> file;
	private List<String> contentType;
	//多文件的名字集合
	private List<String> filename;
	private String result; // 上传的结果信息

	// 注意此处set***对应的是jsp页面<input type="file" name="upload"/>中的upload
	public void setUpload(List<File> file) {
		this.file = file;
	}

	public void setUploadContentType(List<String> contentType) {
		this.contentType = contentType;
	}

	public void setUploadFileName(List<String> filename) {
		this.filename = filename;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return result;
	}

	// 处理
	@Override
	public String execute() throws Exception {
		// 该路径为Tomcat应用服务器中ST项目目录下的images
		//String path = ServletActionContext.getServletContext().getRealPath("E:/images");
		File filePath = new File("D:/EclipseWorkspace/SSHpoject/WebContent/goodsImg/user");

		// 判断是否有该目录，如果没有就创建
		if (!filePath.exists()) {
			filePath.mkdir();
		}
		System.out.println(file + ":" + contentType + ":" + filename);
		
		// uploadFile上传的文件 file服务器放置上传文件的目录 uploadFileName上传文件名称
		// FileUtils.copyFile(file, new File(filePath, filename));
		
		// 由于是文件批量上传，所有需要循环实现文件写入操作
		for(int i = 0; i < file.size(); i++){
			FileUtils.copyFile(file.get(i), new File(filePath, filename.get(i)));
		}
		
		String userfileName = filename.toString().substring(1,filename.toString().length()-1);
		
		String userfilePath = "goodsImg/user/"+userfileName;
		
		detailService.upload(uid, userfilePath);
		
		
		
		return "success";
	}
}
