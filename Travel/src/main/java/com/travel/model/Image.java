package com.travel.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Image {
@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "uuid2")
@Column(length=50)
private String id;
private String fileName;
private String fileType;
@Lob
private byte[] data;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
public String getFileType() {
	return fileType;
}
public void setFileType(String fileType) {
	this.fileType = fileType;
}
public byte[] getData() {
	return data;
}
public void setData(byte[] data) {
	this.data = data;
}
@Override
public String toString() {
	return "Image [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", data=" + Arrays.toString(data)
			+ "]";
}
public Image( String fileName, String fileType, byte[] data) {
	super();
	this.fileName = fileName;
	this.fileType = fileType;
	this.data = data;
}
public Image(String id, String fileName, String fileType, byte[] data) {
	super();
	this.id = id;
	this.fileName = fileName;
	this.fileType = fileType;
	this.data = data;
}
public Image() {
	super();
}

}
