/*
 * package com.redshift.LibrarApplicationn.Model;
 * 
 * import java.time.LocalDate; import java.time.Period;
 * 
 * import javax.validation.ConstraintValidator; import
 * javax.validation.ConstraintValidatorContext;
 * 
 * public class AgeValidation implements ConstraintValidator<Age, Member>{
 * 
 * @Override public boolean isValid(Member member, ConstraintValidatorContext
 * context) { Period period=Period.between(member.getBirthdayDate(),
 * LocalDate.now()); if(period.getYears()!=member.getAge()) return false; return
 * member.getAge()>=18; }
 * 
 * }
 */