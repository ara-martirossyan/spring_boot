package com.aralmighty.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.lang.reflect.Method;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.aralmighty.App;
import com.aralmighty.service.FileService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebAppConfiguration
@Transactional
public class FileServiceTest {
	
	@Autowired
	private FileService fileService;
	
	@Value("${photo.upload.directory}")
	private String photoUploadDirectory;
	
	@Test
	public void testGetExtension() throws Exception {
		Method method = FileService.class.getDeclaredMethod("getFileExtension", String.class);
		method.setAccessible(true);
		
		assertEquals("Should be png", "png", (String)method.invoke(fileService, "test.png"));
		assertEquals("Should be doc", "doc", (String)method.invoke(fileService, "s.doc"));
		assertEquals("Should be jpeg", "jpeg", (String)method.invoke(fileService, "file.jpeg"));
		assertNull("Should be png", (String)method.invoke(fileService, "xyz"));
	}
	
	@Test
	public void testisImageExtension() throws Exception {
		Method method = FileService.class.getDeclaredMethod("isImageExtension", String.class);
		method.setAccessible(true);
		
		assertTrue("png should valid", (Boolean)method.invoke(fileService, "png"));
		assertTrue("PNG should valid", (Boolean)method.invoke(fileService, "PNG"));
		assertTrue("jpg should valid", (Boolean)method.invoke(fileService, "jpg"));
		assertTrue("jpeg should valid", (Boolean)method.invoke(fileService, "jpeg"));
		assertTrue("gif should valid", (Boolean)method.invoke(fileService, "gif"));
		assertTrue("GIF should valid", (Boolean)method.invoke(fileService, "GIF"));
		assertFalse("doc should be invalid", (Boolean)method.invoke(fileService, "doc"));
		assertFalse("jpg3 should be invalid", (Boolean)method.invoke(fileService, "jpg3"));
		assertFalse("gi should be invalid", (Boolean)method.invoke(fileService, "gi"));
	}
	
	@Test
	public void testCreatSubdirectory() throws Exception {
		Method method = FileService.class.getDeclaredMethod("makeSubdirectory", String.class, String.class);
		method.setAccessible(true);
		
		for (int i = 0; i < 10000; i++) {
			File created = (File)method.invoke(fileService, photoUploadDirectory, "photo");
			assertTrue("Directory should exist" + created.getAbsolutePath(), created.exists());
		}
	}

}
