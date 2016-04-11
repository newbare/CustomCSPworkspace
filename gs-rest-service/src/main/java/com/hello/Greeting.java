package com.hello;

/**
 * Hello world!
 *
 */
public class Greeting 
{
    private final long id;
    private String content;
	public Greeting(long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getId() {
		return id;
	}
    
}
