package br.com.casado.codigo.loja.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.casado.codigo.loja.commom.Constants;

@Component
public class FileSaver {

	@Autowired
	private HttpServletRequest request;

	public String write(String baseFolder, MultipartFile file){
		try {
			String realPath = request.getServletContext().getRealPath(Constants.FILE_SEPARATOR + baseFolder);
			String path = realPath + Constants.FILE_SEPARATOR + file.getOriginalFilename();
			file.transferTo(new File(path));

			return baseFolder + Constants.FILE_SEPARATOR + file.getOriginalFilename();
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
	}

}
