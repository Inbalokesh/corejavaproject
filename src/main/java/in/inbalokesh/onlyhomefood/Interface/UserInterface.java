package in.inbalokesh.onlyhomefood.Interface;

import in.inbalokesh.onlyhomefood.model.UserEntity;

public interface UserInterface extends Base<UserEntity> {

	public abstract UserEntity findByEmailId(String email);

	public abstract int count();

}
