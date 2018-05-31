package model;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

	/**
	 * Gets the entry by id.
	 *
	 * @param id
	 *            the id
	 * @return the example by id
	 * @throws SQLException
	 *             the SQL exception
	 */
	InputStream getEntryById(int id) throws SQLException;

	/**
	 * Gets the example by id.
	 *
	 * @param id
	 *            the id
	 * @return the example by id
	 * @throws SQLException
	 *             the SQL exception
	 */
	String readFile(int i);

	void getElement(String o) throws SQLException, IOException;

	ILevel getLevel();

	void setLevel(ILevel level);

	public Image getBackground();

	public void setBackground(Image background);

	public Image getBone();

	public void setBone(Image bone);

	public Image getCrystal_ball();

	public void setCrystal_ball(Image crystal_ball);

	public Image getFireball_1();

	public void setFireball_1(Image fireball_1);

	public Image getFireball_2();

	public void setFireball_2(Image fireball_2);

	public Image getFireball_3();

	public void setFireball_3(Image fireball_3);

	public Image getFireball_4();

	public void setFireball_4(Image fireball_4);

	public Image getFireball_5();

	public void setFireball_5(Image fireball_5);

	public Image getGate_closed();

	public void setGate_closed(Image gate_closed);

	public Image getGate_open();

	public void setGate_open(Image gate_open);

	public Image getHorizontal_bone();

	public void setHorizontal_bone(Image horizontal_bone);

	public Image getLorann_b();

	public void setLorann_b(Image lorann_b);

	public Image getLorann_bl();

	public void setLorann_bl(Image lorann_bl);

	public Image getLorann_br();

	public void setLorann_br(Image lorann_br);

	public Image getLorann_l();

	public void setLorann_l(Image lorann_l);

	public Image getLorann_u();

	public void setLorann_u(Image lorann_u);

	public Image getLorann_ul();

	public void setLorann_ul(Image lorann_ul);

	public Image getLorann_ur();

	public void setLorann_ur(Image lorann_ur);

	public Image getMonster_1();

	public void setMonster_1(Image monster_1);

	public Image getMonster_2();

	public void setMonster_2(Image monster_2);

	public Image getMonster_3();

	public void setMonster_3(Image monster_3);

	public Image getMonster_4();

	public void setMonster_4(Image monster_4);

	public Image getPurse();

	public void setPurse(Image purse);

	public Image getVertical_bone();

	public void setVertical_bone(Image vertical_bone);

}
