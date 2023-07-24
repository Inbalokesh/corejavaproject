package in.inbalokesh.onlyhomefood.validation;

import in.inbalokesh.onlyhomefood.exception.ValidationException;
import in.inbalokesh.onlyhomefood.model.User;
import in.inbalokesh.onlyhomefood.util.StringUtil;

public class UserValidator {

	public static void validate(User user) throws ValidationException {

		if (user == null) {

			throw new ValidationException("Invalid User Input");
		}

//		if (user.getEmail() == null || "".equals(user.getEmail().trim())) {
//
//			throw new ValidationException("Email cannot be null or empty");
//		}
//
//		if (user.getPassword() == null || "".equals(user.getPassword().trim())) {
//
//			throw new ValidationException("Password cannot be null or empty");
//		}
//
//		if (user.getFirstName() == null || "".equals(user.getFirstName().trim())) {
//
//			throw new ValidationException("First Name cannot be null or empty");
//		}
		
		StringUtil.rejectIfInvaildString(user.getEmail(), "Email");
		StringUtil.rejectIfInvaildString(user.getPassword(), "Password");
		StringUtil.rejectIfInvaildString(user.getFirstName(), "FirstName");
	}

}
