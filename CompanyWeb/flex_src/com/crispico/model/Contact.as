package com.crispico.model {
	
	[Bindable]
	[RemoteClass(alias="com.crispico.model.Contact")]
	public class Contact {
		
		public var id:int;
		
		public var name:String;
		
		public var address:String;
		
		public var company:int ;
		
		public function Contact():void{
			this.name="ceva";
		}
		
	}
}