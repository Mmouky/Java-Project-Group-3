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
	 * 			param i
	 * @return String
	 */
	String readFile(int i);

	/**
	 * Add elements to the level
	 * 
	 * @param o
	 * 			param o
	 * @throws SQLException
     *          exception
	 * @throws IOException
     *          exception
	 */
	void addElementToLevel(String o) throws SQLException, IOException;

	/**
	 * Get Level
	 * 
	 * @return ILevel
	 * 				  get the level
	 */
	ILevel getLevel();

	/**
	 * Set the level
	 * 
	 * @param level
	 * 				set the level
	 */
	void setLevel(ILevel level);

	/**
	 * Get the background sprite
	 * 
	 * @return Image
	 * 				get the Image	 */
	public Image getBackground();

	/**
	 * Set the background sprite
	 * 
	 * @param background
	 * 				set the Image
	 * */
	public void setBackground(Image background);

	/**
	 * Get the corner wall sprite
	 * 
	 * @return Image
	 * 				get the corner
	 */
	public Image getBone();

	/**
	 * Set the corner wall sprite
	 * 
	 * @param bone
	 * 					set the corner
	 */
	public void setBone(Image bone);

	/**
	 * Get the crystal ball sprite
	 * 
	 * @return Image
	 * 				get the crystal
	 */
	public Image getCrystal_ball();

	/**
	 * Set the crystal ball sprite
	 * 
	 * @param crystal_ball
	 *               set the crystal
	 */
	public void setCrystal_ball(Image crystal_ball);

	/**
	 * Get the fireball sprite 1
	 * 
	 * @return Image
	 * 				get the fireball 1
	 */
	public Image getFireball_1();

	/**
	 * Set the fireball sprite 1
	 * 
	 * @param fireball_1
	 *             set the fireball 1
	 */
	public void setFireball_1(Image fireball_1);

	/**
	 * Get the fireball sprite 2
	 * 
	 * @return Image
	 * 				get the fireball 2
	 */
	public Image getFireball_2();

	/**
	 * Set the fireball sprite 2
	 * 
	 * @param fireball_2
	 * 				set the fireball 2
	 */
	public void setFireball_2(Image fireball_2);

	/**
	 * Get the fireball sprite 3
	 * 
	 * @return Image
	 * 				get the fireball 3
	 */
	public Image getFireball_3();

	/**
	 * Set the fireball sprite 3
	 * 
	 * @param fireball_3
	 * 				set the fireball 3
	 */
	public void setFireball_3(Image fireball_3);

	/**
	 * Get the fireball sprite 4
	 * 
	 * @return Image
	 * 				get the fireball 4
	 */
	public Image getFireball_4();

	/**
	 * Set the fireball sprite 4
	 * 
	 * @param fireball_4
	 * 				set the fireball 4
	 */
	public void setFireball_4(Image fireball_4);

	/**
	 * Get the fireball sprite 5
	 * 
	 * @return Image
	 * 				 return the fireball 5
	 */
	public Image getFireball_5();

	/**
	 * Set the fireball sprite 5
	 * 
	 * @param fireball_5
	 * 				set the fireball 5
	 */
	public void setFireball_5(Image fireball_5);

	/**
	 * Get the closed gate sprite
	 * 
	 * @return Image
	 * 				Get the closed gate sprite
	 */
	public Image getGate_closed();

	/**
	 * Set the closed gate sprite
	 * 
	 * @param gate_closed
	 * 				Set the closed gate sprite
	 */
	public void setGate_closed(Image gate_closed);

	/**
	 * Get the opened gate sprite
	 * 
	 * @return Image
	 * 				Get the opened gate sprite
	 */
	public Image getGate_open();

	/**
	 * Set the opened gate sprite
	 * 
	 * @param gate_open
	 * 				Set the opened gate sprite
	 */
	public void setGate_open(Image gate_open);

	/**
	 * Get the horizontal wall sprite
	 * 
	 * @return Image
	 * 				 Get the horizontal sprite
	 */
	public Image getHorizontal_bone();

	/**
	 * Set the horizontal wall sprite
	 * 
	 * @param horizontal_bone
	 * 				Set the horizontal wall sprite
	 */
	public void setHorizontal_bone(Image horizontal_bone);

	/**
	 * Get the Lorann down sprite
	 * 
	 * @return Image
	 *     			 Get the Lorann down sprite
	 */
	public Image getLorann_b();

	/**
	 * Set the Lorann down sprite
	 * 
	 * @param lorann_b
	 * 				Set the Lorann down sprite
	 */
	public void setLorann_b(Image lorann_b);

	/**
	 * Get the Lorann down-left sprite
	 * 
	 * @return Image
	 * 				Get the Lorann down-left sprite
	 */
	public Image getLorann_bl();

	/**
	 * Set the Lorann down-left sprite
	 * 
	 * @param lorann_bl
	 * 				Set the Lorann down-left sprite
	 */
	public void setLorann_bl(Image lorann_bl);

	/**
	 * Get the Lorann down-right sprite
	 * 
	 * @return Image
	 *				Get the Lorann down-right sprite
	 */
	public Image getLorann_br();

	/**
	 * Set the Lorann down-right sprite
	 * 
	 * @param lorann_br
	 * 				Set the Lorann down-right sprite
	 */
	public void setLorann_br(Image lorann_br);

	/**
	 * Get the Lorann left sprite
	 * 
	 * @return Image
	 * 				Get the Lorann left sprite
	 */
	public Image getLorann_l();

	/**
	 * Set the Lorann left sprite
	 * 
	 * @param lorann_l
	 * 				Set the Lorann left sprite
	 */
	public void setLorann_l(Image lorann_l);

	/**
	 * Get the Lorann right sprite
	 * 
	 * @return Image
	 * 				 Get the Lorann right sprite
	 */
	public Image getLorann_r();

	/**
	 * Set the Lorann right sprite
	 * 
	 * @param lorann_r
	 * 				Set the Lorann right sprite
	 */
	public void setLorann_r(Image lorann_r);

	/**
	 * Get the Lorann up sprite
	 * 
	 * @return Image
	 * 				Get the Lorann up sprite
	 */
	public Image getLorann_u();

	/**
	 * Set the Lorann up sprite
	 * 
	 * @param lorann_u
	 * 				Set the Lorann up sprite
	 */
	public void setLorann_u(Image lorann_u);

	/**
	 * Get the Lorann up-left sprite
	 * 
	 * @return Image
	 * 				Get the Lorann up-left sprite
	 */
	public Image getLorann_ul();

	/**
	 * Set the Lorann up-left sprite
	 * 
	 * @param lorann_ul
	 * 				Set the Lorann up-left sprite
	 */
	public void setLorann_ul(Image lorann_ul);

	/**
	 * Get the Lorann up-right sprite
	 * 
	 * @return Image
	 * 				Get the Lorann up-right sprite
	 */
	public Image getLorann_ur();

	/**
	 * Set the Lorann up-right sprite
	 * 
	 * @param lorann_ur
	 * 				Set the Lorann up-right sprite
	 */
	public void setLorann_ur(Image lorann_ur);

	/**
	 * Get the Monster sprite 1
	 * 
	 * @return Image
	 * 				Get the Monster sprite 1
	 */
	public Image getMonster_1();

	/**
	 * Set the Monster sprite 1
	 * 
	 * @param monster_1
	 * 				Set the Monster sprite 1
	 */
	public void setMonster_1(Image monster_1);

	/**
	 * Get the Monster sprite 2
	 * 
	 * @return Image
	 * 				Get the Monster sprite 2
	 */
	public Image getMonster_2();

	/**
	 * Set the Monster sprite 2
	 * 
	 * @param monster_2
	 * 				Set the Monster sprite 2
	 */
	public void setMonster_2(Image monster_2);

	/**
	 * Get the Monster sprite 3
	 * 
	 * @return Image
	 * 				 Get the Monster sprite 3
	 */
	public Image getMonster_3();

	/**
	 * Set the Monster sprite 3
	 * 
	 * @param monster_3
	 * 				Set the Monster sprite 3
	 */
	public void setMonster_3(Image monster_3);

	/**
	 * Get the Monster sprite 4
	 * 
	 * @return Image
	 * 				Get the Monster sprite 4
	 */
	public Image getMonster_4();

	/**
	 * Set the Monster sprite 4
	 *
	 * @param monster_4
	 *  			Set the Monster sprite 4
	 */
	public void setMonster_4(Image monster_4);

	/**
	 * Get the money sprite
	 * 
	 * @return Image
	 * 				Get the money sprite
	 */
	public Image getPurse();

	/**
	 * Set the money sprite
	 * 
	 * @param purse
	 *				Set the money sprite
	 */
	public void setPurse(Image purse);

	/**
	 * Get the vertical wall sprite
	 * 
	 * @return Image
	 * 				Get the vertical wall sprite
	 */
	public Image getVertical_bone();

	/**
	 * Set the vertical wall sprite
	 * 
	 * @param vertical_bone
	 * 				Set the vertical wall sprite
	 */
	public void setVertical_bone(Image vertical_bone);

}
