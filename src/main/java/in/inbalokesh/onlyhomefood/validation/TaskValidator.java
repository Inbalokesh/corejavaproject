package in.inbalokesh.onlyhomefood.validation;

import in.inbalokesh.onlyhomefood.exception.ValidationException;
import in.inbalokesh.onlyhomefood.model.TaskEntity;
import in.inbalokesh.onlyhomefood.util.StringUtil;

public class TaskValidator {

	public static void validate(TaskEntity task) throws ValidationException {

		if (task == null) {
			throw new ValidationException("Invalid Task Input");
		}

		StringUtil.rejectIfInvaildString(task.getName(), "Name");
		StringUtil.rejectIfInvalidDate(task.getDueDate(), "Date");
		
		
	}

}
