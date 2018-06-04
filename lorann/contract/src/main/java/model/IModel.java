package model;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */
import java.awt.Image;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel extends KeyListener {

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
	 * Read the file of the level on the database
	 * 
	 * @param i
	 * @return String
	 */
	String readFile(int i);

	/**
	 * Add elements to the level
	 * 
	 * @param o
	 * @throws SQLException
	 * @throws IOException
	 */
	void addElementToLevel(String o) throws SQLException, IOException;

	/**
	 * Get Level
	 * 
	 * @return ILevel
	 */
	ILevel getLevel();

	/**
	 * Set the level
	 * 
	 * @param level
	 */
	void setLevel(ILevel level);

	/**
	 * Get the background sprite
	 * 
	 * @return Image
	 */
	public Image getBackground();

	/**
	 * Set the background sprite
	 * 
	 * @param background
	 */
	public void setBackground(Image background);

	/**
	 * Get the corner wall sprite
	 * 
	 * @return Image
	 */
	public Image getBone();

	/**
	 * Set the corner wall sprite
	 * 
	 * @param background
	 */
	public void setBone(Image bone);

	/**
	 * Get the crystal ball sprite
	 * 
	 * @return Image
	 */
	public Image getCrystal_ball();

	/**
	 * Set the crystal ball sprite
	 * 
	 * @param background
	 */
	public void setCrystal_ball(Image crystal_ball);

	/**
	 * Get the fireball sprite 1
	 * 
	 * @return Image
	 */
	public Image getFireball_1();

	/**
	 * Set the fireball sprite 1
	 * 
	 * @param background
	 */
	public void setFireball_1(Image fireball_1);

	/**
	 * Get the fireball sprite 2
	 * 
	 * @return Image
	 */
	public Image getFireball_2();

	/**
	 * Set the fireball sprite 2
	 * 
	 * @param background
	 */
	public void setFireball_2(Image fireball_2);

	/**
	 * Get the fireball sprite 3
	 * 
	 * @return Image
	 */
	public Image getFireball_3();

	/**
	 * Set the fireball sprite 3
	 * 
	 * @param background
	 */
	public void setFireball_3(Image fireball_3);

	/**
	 * Get the fireball sprite 4
	 * 
	 * @return Image
	 */
	public Image getFireball_4();

	/**
	 * Set the fireball sprite 4
	 * 
	 * @param background
	 */
	public void setFireball_4(Image fireball_4);

	/**
	 * Get the fireball sprite 5
	 * 
	 * @return Image
	 */
	public Image getFireball_5();

	/**
	 * Set the fireball sprite 5
	 * 
	 * @param background
	 */
	public void setFireball_5(Image fireball_5);

	/**
	 * Get the closed gate sprite
	 * 
	 * @return Image
	 */
	public Image getGate_closed();

	/**
	 * Set the closed gate sprite
	 * 
	 * @param background
	 */
	public void setGate_closed(Image gate_closed);

	/**
	 * Get the opened gate sprite
	 * 
	 * @return Image
	 */
	public Image getGate_open();

	/**
	 * Set the opened gate sprite
	 * 
	 * @param background
	 */
	public void setGate_open(Image gate_open);

	/**
	 * Get the horizontal wall sprite
	 * 
	 * @return Image
	 */
	public Image getHorizontal_bone();

	/**
	 * Set the horizontal wall sprite
	 * 
	 * @param background
	 */
	public void setHorizontal_bone(Image horizontal_bone);

	/**
	 * Get the Lorann down sprite
	 * 
	 * @return Image
	 */
	public Image getLorann_b();

	/**
	 * Set the Lorann down sprite
	 * 
	 * @param background
	 */
	public void setLorann_b(Image lorann_b);

	/**
	 * Get the Lorann down-left sprite
	 * 
	 * @return Image
	 */
	public Image getLorann_bl();

	/**
	 * Set the Lorann down-left sprite
	 * 
	 * @param background
	 */
	public void setLorann_bl(Image lorann_bl);

	/**
	 * Get the Lorann down-right sprite
	 * 
	 * @return Image
	 */
	public Image getLorann_br();

	/**
	 * Set the Lorann down-right sprite
	 * 
	 * @param background
	 */
	public void setLorann_br(Image lorann_br);

	/**
	 * Get the Lorann left sprite
	 * 
	 * @return Image
	 */
	public Image getLorann_l();

	/**
	 * Set the Lorann left sprite
	 * 
	 * @param background
	 */
	public void setLorann_l(Image lorann_l);

	/**
	 * Get the Lorann right sprite
	 * 
	 * @return Image
	 */
	public Image getLorann_r();

	/**
	 * Set the Lorann right sprite
	 * 
	 * @param background
	 */
	public void setLorann_r(Image lorann_r);

	/**
	 * Get the Lorann up sprite
	 * 
	 * @return Image
	 */
	public Image getLorann_u();

	/**
	 * Set the Lorann up sprite
	 * 
	 * @param background
	 */
	public void setLorann_u(Image lorann_u);

	/**
	 * Get the Lorann up-left sprite
	 * 
	 * @return Image
	 */
	public Image getLorann_ul();

	/**
	 * Set the Lorann up-left sprite
	 * 
	 * @param background
	 */
	public void setLorann_ul(Image lorann_ul);

	/**
	 * Get the Lorann up-right sprite
	 * 
	 * @return Image
	 */
	public Image getLorann_ur();

	/**
	 * Set the Lorann up-right sprite
	 * 
	 * @param background
	 */
	public void setLorann_ur(Image lorann_ur);

	/**
	 * Get the Monster sprite 1
	 * 
	 * @return Image
	 */
	public Image getMonster_1();

	/**
	 * Set the Monster sprite 1
	 * 
	 * @param background
	 */
	public void setMonster_1(Image monster_1);

	/**
	 * Get the Monster sprite 2
	 * 
	 * @return Image
	 */
	public Image getMonster_2();

	/**
	 * Set the Monster sprite 2
	 * 
	 * @param background
	 */
	public void setMonster_2(Image monster_2);

	/**
	 * Get the Monster sprite 3
	 * 
	 * @return Image
	 */
	public Image getMonster_3();

	/**
	 * Set the Monster sprite 3
	 * 
	 * @param background
	 */
	public void setMonster_3(Image monster_3);

	/**
	 * Get the Monster sprite 4
	 * 
	 * @return Image
	 */
	public Image getMonster_4();

	/**
	 * Set the Monster sprite 4
	 * 
	 * @param background
	 */
	public void setMonster_4(Image monster_4);

	/**
	 * Get the money sprite
	 * 
	 * @return Image
	 */
	public Image getPurse();

	/**
	 * Set the money sprite
	 * 
	 * @param background
	 */
	public void setPurse(Image purse);

	/**
	 * Get the vertical wall sprite
	 * 
	 * @return Image
	 */
	public Image getVertical_bone();

	/**
	 * Set the vertical wall sprite
	 * 
	 * @param background
	 */
	public void setVertical_bone(Image vertical_bone);

}
