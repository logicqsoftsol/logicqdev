package com.crm.logicq.test;

public class TestPolymorpisim {
	
	public static void main(String args[]){
    Abc b=new B();
    Abc a=new A();
		//B ba=(B) new A(); compilation issue as  child don't know parent
		System.out.println("Child "+b.arithmetic(4,5));
		System.out.println("Pattent "+a.arithmetic(4,5));
		//System.out.println("Child Parent "+ba.arithmetic(4,5));
	}

}
