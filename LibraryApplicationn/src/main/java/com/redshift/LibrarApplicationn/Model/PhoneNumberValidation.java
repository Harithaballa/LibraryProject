//package com.redshift.LibrarApplicationn.Model;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class PhoneNumberValidation implements ConstraintValidator<MobileNumber, Member>{
//
//	@Override
//	public boolean isValid(Member member, ConstraintValidatorContext context) {
//		String no=member.getPhoneNo();
//		if(no.length()!=10)
//			return false;
//		 return (no.matches("^[0-9]*$"));
//	}
//
//}
