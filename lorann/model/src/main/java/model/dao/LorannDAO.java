package model.dao;

import java.awt.*;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class LorannDAO extends AbstractDAO {

    /** The sql example by id. */
    private static String sqlExampleById   = "{call findExampleById(?)}";

    /** The sql example by name. */
    private static String sqlExampleByName = "{call findExampleByName(?)}";

    /** The sql all examples. */
    private static String sqlAllExamples   = "{call findAllExamples()}";

    /** The sql add level. */
    private static String sqlAddLevel   = "{call newEntry(?)}";

    /** The sql entry by id. */
    private static String sqlEntryById   = "{call findEntryById(?)}";

    /** The sql entry by id. */
    private static String sqlSpriteByName   = "{call findSpriteByName(?)}";

    /** The sql entry by id. */
    private static String findLorannPosition   = "{call findLorannPosition(?)}";


    /** The id column index. */
    private static int    idColumnIndex    = 0;

    /** The name column index. */
    private static int    nameColumnIndex  = 1;

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
     * Gets the lorann's position
     *
     * @param level
     *            the level
     * @return the lorann's position by level
     * @throws SQLException
     *             the SQL exception
     */
    public static Point getLorannPosition(final int level) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlEntryById);
        Point position = new Point();
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
