package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        Connection conn;
        CarDTO carDTOImplementation= new CarDTOImplementation();



        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql", "root", "");
            CarDaoImplementation carDaoImplementation = new CarDaoImplementation(conn);

            //Find by ID
            //System.out.println(carDaoImplementation.findById(1).toString());
           // System.out.println(String.valueOf(carDaoImplementation.findById(1)));

            //Find all
           // System.out.println(carDaoImplementation.findAll());

            //Car update
//            Car carUpdate = carDaoImplementation.findById(1);
//            System.out.println(carUpdate);
//            carUpdate.setColor("green");
//            System.out.println(carUpdate);


            //Car Insert
//            Car car=new Car(6,"Nissan","Murano",2015,"Brown",2112);
         //   carDaoImplementation.create(car);
          //  System.out.println(carDaoImplementation.findAll());


            //Car Delete
            carDaoImplementation.delete(5);

        } catch (SQLException e) {
            e.printStackTrace();

        }



    }
    }





