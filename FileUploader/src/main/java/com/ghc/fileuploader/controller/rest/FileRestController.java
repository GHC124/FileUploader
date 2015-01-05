package com.ghc.fileuploader.controller.rest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ghc.fileuploader.controller.util.Endpoint;
import com.ghc.fileuploader.dto.request.FileRequest;
import com.ghc.fileuploader.service.util.ServiceUtil;

@Controller
public class FileRestController {
	private LinkedList<FileRequest> files = new LinkedList<FileRequest>();

	@RequestMapping(value = Endpoint.REST + ServiceUtil.FILE_UPLOAD, method = RequestMethod.POST)
	@ResponseBody
	public List<FileRequest> upload(MultipartHttpServletRequest request,
			HttpServletResponse response) {
		// 1. build an iterator
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;

		// 2. get each file
		while (itr.hasNext()) {

			// 2.1 get next MultipartFile
			mpf = request.getFile(itr.next());
			System.out.println(mpf.getOriginalFilename() + " uploaded! "
					+ files.size());

			// 2.2 if files > 10 remove the first from the list
			if (files.size() >= 10)
				files.pop();

			// 2.3 create new fileMeta
			FileRequest fileRequest = new FileRequest();
			fileRequest.setFileName(mpf.getOriginalFilename());
			fileRequest.setFileSize(mpf.getSize() / 1024 + " Kb");
			fileRequest.setFileType(mpf.getContentType());

			try {
				// copy file to local disk
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(
						"D:\\GHC_\\temp\\files\\" + mpf.getOriginalFilename()));

			} catch (IOException e) {
				e.printStackTrace();
			}
			// 2.4 add to files
			files.add(fileRequest);
		}
		// result will be like this
		return files;
	}
	
	
}
