package in.inbalokesh.onlyhomefood.Interface;

import in.inbalokesh.onlyhomefood.model.User;

public interface UserInterface extends Base<User> {

	public abstract User findByEmailId(String email);

	public abstract int count();

}
