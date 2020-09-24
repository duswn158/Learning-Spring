package com.mvc.updown.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvc.updown.dto.UploadFile;

// implements Validator : org.springframework
@Service
//controller 에서 FileValidator 를 호출하는데 호출할때 사용하려고 그냥 Service 어노테이션 걸어둠
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		// 오브젝트로 받아서 업로드 파일(Dto) 형태로 변환해 file 변수에 담는다
		UploadFile file = (UploadFile) target;
		
		// 파일이 없다면
		// 컨트롤러에서 넘어온 유효성검사가 지정한 에러에 걸리면
		// 에러러를 리턴해줄것
		if(file.getMpfile().getSize() == 0) {
			errors.rejectValue("mpfile", "fileNPE", "Please select a file");
		}
		
	}

}
