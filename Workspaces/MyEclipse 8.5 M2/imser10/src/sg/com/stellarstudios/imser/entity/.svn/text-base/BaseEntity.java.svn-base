package sg.com.stellarstudios.imser.entity;

public abstract class BaseEntity {
	public abstract Object getId();
	public abstract void setId(Object id);
	public boolean equals(Object obj) {
		if (getId() != null)
			return getId().equals(((BaseEntity)obj).getId());
		return false;
	}
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}
}
