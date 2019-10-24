package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int iD;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	public InstructorDetail () {
		
	}

	public InstructorDetail(String youtubeChanell, String hobby) {
		this.youtubeChannel = youtubeChanell;
		this.hobby = hobby;
	}
	
	
	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getYoutubeChanell() {
		return youtubeChannel;
	}

	public void setYoutubeChanell(String youtubeChanell) {
		this.youtubeChannel = youtubeChanell;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [iD=" + iD + ", youtubeChanell=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
}
