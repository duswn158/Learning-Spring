package com.mvc.updown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mvc.updown.dto.UploadFile;
import com.mvc.updown.validate.FileValidator;


@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;
	
	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}
	
	// upload 하면 요청, 모델객체, 업로드파일(Dto),BindingResult : Validator를 상속받는 클래스에서 객체값을 검증
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
		
		//BindingResult : valitate로 감		
		
		// 업로드한 파일 유효성검사
		// FileValidator에 Autowired 된 필드멤버.애플리케이션 별 개체에 대한 유효성 검사기(validate)
		// jsp에서 전달해준 객체를 받아서 혹시 예외가 발생한다면, FileValidate.java에서 체크한 에러 발생시 지정해준 에러를 발생시켜줄것 ☆프로젝트때 써보기
		fileValidator.validate(uploadFile, result);
		
		// 에러가 있으면 upload로 보냄
		// 에러가 발생하면 BindingResult가 대기하고 있다가 다시 View 즉 upload.jsp에 form:errors path = "mpfile" 부분으로 보내어 화면에 출력한다
		if (result.hasErrors()) {
			return "upload";
		}
		
		// 파일 꺼내옴
		MultipartFile file = uploadFile.getMpfile();
		// 파일 실제이름 가져옴
		String name = file.getOriginalFilename();
		
		// 객체 생성해서 파일 이름과, Desc를 setting
		UploadFile fileObj = new UploadFile();
		fileObj.setName(name);
		fileObj.setDesc(uploadFile.getDesc());
		
		// 바이트 단위 입출력을 위한 최상위 입출력 스트림 클래스
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {	
				// file의 byte Stream을 가져온다
				inputStream = file.getInputStream();
				
				// 경로 확인 : getRealPath
				// request.getSession().getServletContext() 지금 쓰고있는 해당 프로젝트
				// 즉 지금 사용하고있는 프로젝트 위치 찾아오라 + /resources/storage 폴더
				String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
				
				System.out.println("업로드 될 실제 경로 : " + path);
				
				// 경로에 빈 폴더 생성 하기 위한 구문들 (문자열을 추상 경로 이름으로 변환하여 새 File 인스턴스를 만듭니다.)
				File storage = new File(path);
				// 경로가없으면 디렉토리 생성
				if (!storage.exists()) {
					storage.mkdir();
				}
				
				// 경로/파일이름 으로 빈 파일 생성
				File newFile = new File(path + "/" + name);
				// 파일이 없으면 파일 생성
				if (!newFile.exists()) {
					newFile.createNewFile();
				}
				
				// path에 넘어져온 파일의 name,경로 만들어둠
				outputStream = new FileOutputStream(newFile);
				
				int read = 0;
				
				// 파일 사이즈만큼 byte[] 생성
				byte[] b = new byte[(int)file.getSize()];
				
				// 파일 사이즈의 byte[]만큼 반복, 파일 끝까지 반복
				while((read=inputStream.read(b)) != -1 ) {
					// 클라이언트 파일(업로드한 파일)을 복사하기 위해 작성
					outputStream.write(b, 0, read);
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
				try {
					inputStream.close();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}//finally
		
		// fileObj 라는 이름으로 download로 모델객체 넘김
		model.addAttribute("fileObj", fileObj);
		
		return "download";	
	}
	
	@RequestMapping("/download")
	@ResponseBody
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
		
		// byte[] 로 쪼개져 넘어간다
		byte[] down = null;
		
		try {
			// 프로젝트 경로를 가져온다
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			// 경로와, 파일 이름을 합쳐줌
			File file = new File(path + "/" + name);
			
			// 파일을 카피해서 byte 배열에 담는다
			// 아까 storyge에 만들어둔 빈 파일 가져와서 바이트 카피
			down = FileCopyUtils.copyToByteArray(file);
			
			// 파일 이름을 가져온다.
			// UTF-8 즉 한글 인코딩 처리 하는 구문
			String filename = new String(file.getName().getBytes(), "8859_1");
			
			// 파일 이름과 파일 길이를 응답
			// "Content-Disposition", "attachment -> file download 설정 (filename 설정가능)
			// attachment : 해당 브라우저가 파일 다운로드 하는애구나 자동으로 알아들음
			// 즉 파일 다운로드 시키라구 알려주며 파일 이름 설정해둠
			response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
			response.setContentLength(down.length);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// 서버에서 카피한 파일을 다운로드 시켜준다
		return down;
		
	}
	
}
