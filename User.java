import java.io.Serializable;

public abstract class User implements HasMenu, Serializable {
	protected String userName;
	protected String PIN;


	public boolean login(String u, string p) {
		return (u.equals(this.userName) && p.equals(this.PIN));
	}

	public abstract String getReport();
