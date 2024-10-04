package com.practise.pratcise.serviceimpl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.practise.pratcise.entity.files;
import com.practise.pratcise.repository.fileRepo;
import com.practise.pratcise.service.fileService;

@Service
public class fileServiceImpl implements fileService {

	@Autowired
	private fileRepo frepo;

	@Override
	public files storeFile(MultipartFile file) throws IOException {

		String fileName = file.getOriginalFilename();
		String fileType = file.getContentType();
		byte[] data = file.getBytes();

		files fl = new files(fileName, fileType, data);

		return frepo.save(fl);
	}

	@Override
	public files read(long id) {
		Optional<files> fl = frepo.findById(id);

		if (fl.isPresent()) {
			return fl.get();
		} else {
			return null;
		}

	}

	@Override
	public files downloadFile(long id) throws Exception {
		// TODO Auto-generated method stub
		return frepo.findById(id)
				.orElseThrow(() -> new Exception("File not found with id " + id));
	}
}
