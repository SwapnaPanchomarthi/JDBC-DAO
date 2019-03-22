package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CarDaoImplementation extends CarDao<Car> {

    private Connection connection;
    private static final String INSERT = "Insert into car.Car_Table" +
            "(id, make, model, year, color, vin)" + "values(?,?,?,?,?,?)";

    private static final String GET_ONE = "SELECT * FROM car.Car_Table WHERE id=?";
    private static final String GET_All = "SELECT * FROM car.Car_Table";
    private static final String UPDATE = "Update car.Car_Table set id=?, make=?, model=?, year=?, color=?, vin=? WHERE id=?";
    private static final String DELETE = "DELETE FROM car.Car_Table WHERE id=?";

    public CarDaoImplementation(Connection conn) {

        super(conn);

    }


    public Car findById(int id) {


        Car car = null;//new Car();;
    /*    try {
            PreparedStatement pstmt = this.connection.prepareStatement(GET_ONE);*/
    try(PreparedStatement pstmt = super.connection.prepareStatement(GET_ONE);){
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                car = new Car();
                car.setId(rs.getInt("id"));
                car.setColor(rs.getString("color"));
                car.setMake(rs.getString("make"));
                car.setModel(rs.getString("model"));
                car.setYear(rs.getInt("year"));
                car.setVin(rs.getInt("vin"));

            }
        } catch (SQLException e) {

        }
        return car;
    }


    public List findAll() {
        List<Car> carList = new ArrayList<>();

        Car car = null;
        int id=1;
        try (PreparedStatement pstmt = super.connection.prepareStatement(GET_All);) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                car=findById(id);
                id++;
                carList.add(car);
            }
        } catch (
                SQLException e) {
        }

            return carList;
        }


    public Car update(Car dto) {

        Car car = null;
        int id=0;
        try (PreparedStatement pstmt = super.connection.prepareStatement(UPDATE);) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                car = new Car();
                pstmt.setInt(1, dto.getId());
                pstmt.setString(2, dto.getMake());
                pstmt.setString(3, dto.getModel());
                pstmt.setInt(4, dto.getYear());
                pstmt.setString(5, dto.getColor());
                pstmt.setInt(6, dto.getVin());
                findById(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }




    public Car create(Car dto) {
        Car car = null;
        int id=4;
        try (PreparedStatement pstmt = super.connection.prepareStatement(INSERT);) {

                car = new Car();
                pstmt.setInt(1, dto.getId());
                pstmt.setString(2, dto.getMake());
                pstmt.setString(3, dto.getModel());
                pstmt.setInt(4, dto.getYear());
                pstmt.setString(5, dto.getColor());
                pstmt.setInt(6, dto.getVin());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public void delete(int id) {
        //Car car = null;

        try (PreparedStatement pstmt = super.connection.prepareStatement(DELETE);) {

            //car = new Car();
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
