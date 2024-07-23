package simplemvc.command;

public class AgeCommand implements Command {

	@Override
	public Object returnModel() {
		return 30;
	}

	@Override
	public Object returnView() {
		return "/jsp/age.jsp";
	}

}
