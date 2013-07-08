package com.crispico.model {
	
	[Bindable]
	[RemoteClass(alias="com.crispico.model.Company")]
	public class Company {
	
		public var id:int;
		
		public var name:String;
		
		public var cui:String;
		
		public var address:String;
		
		public function Company () 	{
			this.name = "theName";
			this.cui = "thecui";
		}
		
	}
}