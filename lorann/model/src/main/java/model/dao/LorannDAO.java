package model.dao;

import java.awt.*;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */
public abstract class LorannDAO extends AbstractDAO {

	/** The sql add level. */
	private static String sqlAddLevel = "{call newEntry(?)}";

	/** The sql entry by id. */
	private static String sqlEntryById = "{call findEntryById(?)}";

	/** The sql sprite by name. */
	private static String sqlSpriteByName = "{call findSpriteByName(?)}";

	/** The sql lorann's position. */
	private static String findLorannPosition = "{call findLorannPosition(?)}";

	/** The sql monster1's position. */
	private static String findMonster1Position = "{call findMonster1Position(?)}";

	/** The sql monster2's position. */
	private static String findMonster2Position = "{call findMonster2Position(?)}";

	/** The sql monster3's position. */
	private static String findMonster3Position = "{call findMonster3Position(?)}";

	/** The sql monster4's position. */
	private static String findMonster4Position = "{call findMonster4Position(?)}";

	/** The id column index. */
	private static int idColumnIndex = 0;

	/** The name column index. */
	private static int nameColumnIndex = 1;

	/**
	 * Gets the entry by id.
	 *
	 * @param id
	 *            the id
	 * @return the entry by id
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static Blob getEntryById(final int id) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlEntryById);
		Blob file = null;
		callStatement.setInt(1, id);
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				file = result.getBlob(nameColumnIndex);
			}
			result.close();
		}
		return file;
	}

	/**
	 * Gets the monster1's position
	 *
	 * @param level
	 *            the level
	 * @return the lorann's position by level
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static Point getMonster1Position(final int level) throws SQLException {
		final CallableStatement callStatement = prepareCall(findMonster1Position);
		Point position = new Point(0, 0);
		callStatement.setInt(1, level);
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				position.x = result.getInt(1);
				position.y = result.getInt(2);
			}
			result.close();
		}
		return position;
	}

	/**
	 * Gets the monster2's position
	 *
	 * @param level
	 *            the level
	 * @return the lorann's position by level
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static Point getMonster2Position(final int level) throws SQLException {
		final CallableStatement callStatement = prepareCall(findMonster2Position);
		Point position = new Point(0, 0);
		callStatement.setInt(1, level);
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				position.x = result.getInt(1);
				position.y = result.getInt(2);
			}
			result.close();
		}
		return position;
	}

	/**
	 * Gets the monster3's position
	 *
	 * @param level
	 *            the level
	 * @return the lorann's position by level
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static Point getMonster3Position(final int level) throws SQLException {
		final CallableStatement callStatement = prepareCall(findMonster3Position);
		Point position = new Point(0, 0);
		callStatement.setInt(1, level);
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				position.x = result.getInt(1);
				position.y = result.getInt(2);
			}
			result.close();
		}
		return position;
	}

	/**
	 * Gets the monster4's position
	 *
	 * @param level
	 *            the level
	 * @return the lorann's position by level
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static Point getMonster4Position(final int level) throws SQLException {
		final CallableStatement callStatement = prepareCall(findMonster4Position);
		Point position = new Point(0, 0);
		callStatement.setInt(1, level);
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				position.x = result.getInt(1);
				position.y = result.getInt(2);
			}
			result.close();
		}
		return position;
	}

	/**
	 * Gets the lorann's position
	 *
	 * @param level
	 *            the level
	 * @return the lorann's position by level
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static Point getLorannPosition(final int level) throws SQLException {
		final CallableStatement callStatement = prepareCall(findLorannPosition);
		Point position = new Point(0, 0);
		callStatement.setInt(1, level);
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				position.x = result.getInt(1);
				position.y = result.getInt(2);
			}
			result.close();
		}
		return position;
	}

	/**
	 * Gets the sprite by name.
	 *
	 * @param def
	 *            the name
	 * @return the sprite by name
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static Blob getSpriteByName(final String def) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlSpriteByName);
		Blob file = null;
		callStatement.setNString(1, String.valueOf(def));
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				file = result.getBlob(nameColumnIndex);
			}
			result.close();
		}
		return file;
	}

}
