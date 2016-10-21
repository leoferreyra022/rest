package com.weather.rest.DAO;

import com.weather.rest.Config.singletonConnection;
import com.weather.rest.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Leo on 18/10/2016.
 */
@Repository
public class AtmosphereDAO implements DAI<Atmosphere>
{
    @Autowired
    singletonConnection conn;
    @Autowired
    Atmosphere atmosphere;
    private Connection connection = conn.getInstance().getConnection();

    private static final String INSERT = "INSERT INTO atmosphere (humidity,pressure,visibility,rising) values(?,?,?,?) ";
    private static final String DELETE = "DELETE FROM atmosphere WHERE id_atmosphere = ";
    private static final String FIND_BY_ID = "SELECT * FROM atmosphere WHERE id_atmosphere = ";
    private static final String FIND_ALL = "SELECT * FROM atmosphere";

    @Override
    public Atmosphere getById(int id)
    {
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(FIND_BY_ID + id);

            while(rs.next())
            {
                return AtmosphereDAO.getAtmosphere(rs);
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
    public List<Atmosphere> getList()
    {
        List<Atmosphere> atmosphereList = new LinkedList<>();
        try (PreparedStatement stmt = connection.prepareStatement(FIND_ALL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Atmosphere atmos = AtmosphereDAO.getAtmosphere(rs);
                /* -------- mock items -------
                Atmosphere atmos = Atmosphere.AtmosphereBuilder.anAtmosphere().createDefaultAtmosphere();
                */
                atmosphereList.add(atmos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atmosphereList;
    }

    @Override
    public String insert(Atmosphere entity)
    {
        String msg = "Armosphere insertion succesfull";
        PreparedStatement stmnt = null;
        int result = 0;
        try {
            stmnt = connection.prepareStatement(INSERT);
            stmnt.setInt(1,entity.getHumidity());
            stmnt.setDouble(2,entity.getPressure());
            stmnt.setDouble(3,entity.getVisibility());
            stmnt.setDouble(4,entity.getRising());
            result = stmnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        } finally {
            if (stmnt != null) {
                try {
                    stmnt.close();
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
            if(result==0)msg = "Fallo al insertar Atmosphere";
        }
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
            if(result==0)msg = "Fallo al borrar Atmosphere";
        }
        return msg;
    }

    public static Atmosphere getAtmosphere(ResultSet resultSet) throws SQLException {
        Atmosphere.AtmosphereBuilder atmosphereBuilder = Atmosphere.AtmosphereBuilder.anAtmosphere()
                .withHumidity(resultSet.getInt("humidity"))
                .withPressure(resultSet.getDouble("pressure"))
                .withVisibility(resultSet.getDouble("visibility"))
                .withRising(resultSet.getDouble("rising"));
        return atmosphereBuilder.createAtmosphere();
    }
}
