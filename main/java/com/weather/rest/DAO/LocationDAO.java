package com.weather.rest.DAO;

import com.weather.rest.Config.singletonConnection;
import com.weather.rest.Domain.Atmosphere;
import com.weather.rest.Domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Leo on 20/10/2016.
 */
@Repository
public class LocationDAO implements DAI<Location>
{
    @Autowired
    singletonConnection conn;
    @Autowired
    Location location;
    private Connection connection = conn.getInstance().getConnection();

    private static final String INSERT = "INSERT INTO location (city,country,region) values(?,?,?,?) ";
    private static final String DELETE = "DELETE FROM location WHERE id_location = ";
    private static final String FIND_BY_ID = "SELECT * FROM location WHERE id_location = ";
    private static final String FIND_ALL = "SELECT * FROM location";

    @Override
    public Location getById(int id)
    {
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(FIND_BY_ID + id);

            while(rs.next())
            {
                return getLocation(rs);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{if (connection != null)
            {connection.close();}
                if (stmt != null){stmt.close();}
                if (rs != null){rs.close();}
            } catch (Exception exe){
                System.out.println(exe.getMessage());
                exe.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Location> getList()
    {
        List<Location> locationList = new LinkedList<>();
        try (PreparedStatement stmt = connection.prepareStatement(FIND_ALL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Location loc = getLocation(rs);
                locationList.add(loc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locationList;
    }

    @Override
    public String insert(Location entity)
    {
        String msg = "Location insertion succesfull";
        PreparedStatement stmnt = null;
        int result = 0;
        try {
            stmnt = connection.prepareStatement(INSERT);
            stmnt.setString(1,entity.getCity());
            stmnt.setString(2,entity.getCountry());
            stmnt.setString(3,entity.getRegion());
            result = stmnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        if(result==0)msg = "Fallo al insertar";
        return msg;
    }

    @Override
    public String delete(int id)
    {
        String msg = "Delete succesfull";
        PreparedStatement statement = null;
        int result=0;
        try {
            statement = connection.prepareStatement(DELETE + id);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(result==0)msg = "Fallo al borrar Location";
        }
        return msg;

    }

    public static Location getLocation(ResultSet resultSet) throws SQLException
    {
        Location.LocationBuilder locationBuilder = Location.LocationBuilder.aLocation()
                .withCity(resultSet.getString("city"))
                .withRegion(resultSet.getString("region"))
                .withCountry(resultSet.getString("country"));
        return locationBuilder.createLocation();
    }
}
