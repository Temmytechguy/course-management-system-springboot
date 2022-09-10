package com.temmytechie.coursems.storage.entity;

public class ImageDataBuilder  {
	
	  private Long id;
		
		private String name;
		
		private String type;
		
		private byte[] imageData;

		public ImageDataBuilder() {
			
		}
		
		public static ImageDataBuilder builder()
		{
			return new ImageDataBuilder();
		}
		public ImageDataBuilder addId(Long id)
		{
			this.id = id;
			
			return this;
		}
		
		
		public ImageDataBuilder addName(String name)
		{
			this.name = name;
			
			return this;
			
		}
		
		public ImageDataBuilder addType(String type)
		{
			this.type = type;
			
			return this;
		}
		
		
		public ImageDataBuilder addImageData(byte[] bytes)
		{
			this.imageData = bytes;
			
			return this;
		}
		
		public ImageData build()
		{
			ImageData eData = new ImageData();
			
			eData.setId(id);
			eData.setName(name);
			eData.setType(type);
			eData.setImageData(imageData);
			
			return eData;
		}
		
		

}
